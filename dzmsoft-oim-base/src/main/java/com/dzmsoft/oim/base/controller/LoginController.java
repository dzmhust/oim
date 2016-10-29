package com.dzmsoft.oim.base.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dzmsoft.framework.base.web.exception.CaptchaException;
import com.dzmsoft.framework.base.web.mvc.pojo.Menu;
import com.dzmsoft.framework.base.web.mvc.shiro.UserUtil;
import com.dzmsoft.framework.base.web.mvc.view.BaseResponse;
import com.dzmsoft.ucs.api.service.UcsPermissionApiService;
import com.dzmsoft.ucs.api.service.UcsUserApiService;

@Controller
public class LoginController {
    @Autowired
    private UcsUserApiService ucsUserApiService;
    @Autowired
    private UcsPermissionApiService ucsPermissionApiService;
    @Value("${domain}")
    private String domain;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		Subject subject = SecurityUtils.getSubject();
		if(subject.isAuthenticated()||subject.isRemembered()){
			return "system/index";
		} 
		return "login";
	}
	
	@RequestMapping(value = "/index")
    public String index(){
        return "system/index";
    }
	
	@RequestMapping(value = "/ueditor")
	public String ueditor(){
	    return "system/ueditor";
	}
	
	/**
	 * 登录失败
	 * @param userName
	 * @param model
	 * @return
	 */
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String fail(@RequestParam(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM) String userName, Model model,HttpServletRequest request) {
		model.addAttribute(FormAuthenticationFilter.DEFAULT_USERNAME_PARAM, userName);
		String error = (String) request.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		String errorMsg = "";
		if (CaptchaException.class.getName().equals(error)){
			errorMsg = "验证码错误";
		} else if (UnknownAccountException.class.getName().equals(error)){
			errorMsg = "帐号或密码错误，请重试";
		} else if (IncorrectCredentialsException.class.getName().equals(error)){
			errorMsg = "用户名不存在，请重试";
		} else if (ExcessiveAttemptsException.class.getName().equals(error)){
		    errorMsg = "密码错误次数过多，请15分钟后再试";
		} else if (AuthenticationException.class.getName().equals(error)){
		    errorMsg = "帐号或密码错误，请重试";
		}
		model.addAttribute("errorMsg", errorMsg);
		return "login";
	}
	
	/**
     * 打开修改密码页面
     * @param model
     * @return
     */
    @RequestMapping(value = "updatePwd", method = RequestMethod.GET)
    public String updatePwdForm(Model model) {
        model.addAttribute("ucsUser", UserUtil.getCurrentShiroUser());
        return "system/updatePwdForm";
    }
    
    /**
     * 修改密码
     * @param password
     * @return
     */
    @RequestMapping(value = "updatePwd", method = RequestMethod.POST)
    @ResponseBody
    public BaseResponse updatePwd(String password){
        String id = UserUtil.getCurrentShiroUser().getId();
        int flag = ucsUserApiService.updatePwd(id, password);
        BaseResponse baseResponse = flag > 0 ? new BaseResponse(true, "密码更新成功") : new BaseResponse(
                false, "密码更新失败");
        return baseResponse;
    }
    
    @RequestMapping(value="getMenus", method=RequestMethod.GET)  
    @ResponseBody
    public List<Menu> getMenus(){
        return ucsPermissionApiService.getMenus(UserUtil.getCurrentShiroUser().getId(), domain);
    }
	
}
