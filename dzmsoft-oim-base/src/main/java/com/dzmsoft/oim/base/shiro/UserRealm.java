package com.dzmsoft.oim.base.shiro;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.dzmsoft.framework.base.common.BaseConstant;
import com.dzmsoft.framework.base.util.CheckEmptyUtil;
import com.dzmsoft.framework.base.web.exception.CaptchaException;
import com.dzmsoft.framework.base.web.mvc.pojo.ShiroUser;
import com.dzmsoft.framework.base.web.shiro.UsernamePasswordCaptchaToken;
import com.dzmsoft.ucs.base.pojo.UcsUser;
import com.dzmsoft.ucs.base.service.UcsPermissionService;
import com.dzmsoft.ucs.base.service.UcsUserService;

/**
 * 用户登录授权service(shrioRealm)
 * 
 * @author dzm
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UcsPermissionService ucsPermissionService;
    @Autowired
    private UcsUserService ucsUserService;
    @Value("${hashAlgorithmName}")
    private String hashAlgorithmName;
    @Value("${hashIterations}")
    private int hashIterations;

    /**
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用.
     * 
     * @see org.apache.shiro.realm.AuthorizingRealm#doGetAuthorizationInfo(org.apache.shiro.subject.PrincipalCollection)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
        List<String> ucsPermissions = ucsPermissionService.selectPermissions(shiroUser.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        if (!CheckEmptyUtil.isEmpty(ucsPermissions)){
        	for(String permission:ucsPermissions){
                info.addStringPermission(permission);
            }
        }
        return info;
    }

    /**
     * 认证回调函数,登录时调用.
     * 
     * @see org.apache.shiro.realm.AuthenticatingRealm#doGetAuthenticationInfo(org.apache.shiro.authc.AuthenticationToken)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        UsernamePasswordCaptchaToken authcToken = null;
        try{
            authcToken =  (UsernamePasswordCaptchaToken) token;
        } catch(Exception e){
            throw new IllegalArgumentException("参数异常");
        }
        // 根据用户名获取账号信息
        UcsUser ucsUser = ucsUserService.selectByUsername(authcToken.getUsername());
        // 验证码校验
        if (null == ucsUser){
            throw new UnknownAccountException();//没找到帐号
        }
        String ciphertextPassword = new SimpleHash(hashAlgorithmName,authcToken.getPassword(),ByteSource.Util.bytes(ucsUser.getSalt()),hashIterations).toHex();
        if (!ciphertextPassword.equals(ucsUser.getPassword())){
            throw new UnknownAccountException();//没找到帐号
        }
        // 验证用户状态的合法性
        if (!BaseConstant.Status.ENABLE.equals(ucsUser.getStatus())){
            throw new IncorrectCredentialsException("授权失败");
        }
        // 验证码校验
        if (doCaptchaValidate(authcToken)) {
            ShiroUser shiroUser = new ShiroUser(ucsUser.getId(), ucsUser.getUsername(),
                    ucsUser.getName());
            return new SimpleAuthenticationInfo(shiroUser, ucsUser.getPassword(),
                    ByteSource.Util.bytes(ucsUser.getSalt()), getName());
        }
        return null;
    }
    

    /**
     * 验证码校验
     * 
     * @param token
     * @return boolean
     */
    protected boolean doCaptchaValidate(UsernamePasswordCaptchaToken token) {
        String captcha = (String) SecurityUtils.getSubject().getSession()
                .getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
        if (captcha != null && !captcha.equalsIgnoreCase(token.getCaptcha())) {
            throw new CaptchaException("验证码错误！");
        }
        return true;
    }
    
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
        clearAllCache();
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}
