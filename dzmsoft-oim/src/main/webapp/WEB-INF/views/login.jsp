<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<%@ include file="/WEB-INF/views/include/meta.jsp"%>
	<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
    <meta charset="UTF-8">
	<title>运营管理系统</title>
    <link rel="stylesheet" href="${ctxResources}/css/login.css">
    <link rel="stylesheet" href="${ctxResources}/css/jquery.fullPage.css">
    <link rel="stylesheet" href="${ctxResources}/css/bootstrap.min.css">
</head>
<body>
    <div id="dowebok">
        <div class="section section1">
            <div class="login-content">
                <div class="row">
                    <div class="col-md-12 text-center login-title">运营管理系统登录</div>
                    <div class="clearfix reg-form  col-md-8 col-md-offset-2">
                        <form action="${ctx}/login" method="post" class="" id="loginForm">
                            <div class="col-md-12">
                                <span id="backTip" class="back-tip">&nbsp;${errorMsg }</span>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group has-feedback">
                                    <input type="text" class="form-control input-lg login-ipt" placeholder="请输入账号"
                                           name="username" id="username" autocomplete="off"/ value="<shiro:principal/>"> <i
                                        class="green-font glyphicon glyphicon-user form-control-feedback has-feedback-left"></i>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group has-feedback">
                                    <input type="password" class="form-control input-lg login-ipt" placeholder="请输入密码"
                                           name="password" id="password"/> <i
                                        class="green-font glyphicon glyphicon-lock form-control-feedback has-feedback-left"></i>
                                </div>
                            </div>
                            <div class="col-md-7">
								<div class="form-group has-feedback">
									<input type="text" class="form-control input-lg" placeholder="请输入验证码"
										name="captcha" maxlength="5" id="captcha" autocomplete="off"/>
								</div>
							</div>
							<div class="col-md-offset-1">
								<img alt="验证码" src="${ctx}/resources/images/kaptcha.jpg" title="点击更换" id="img_captcha" onclick="javascript:refreshCaptcha();" />
							</div>
                            <div class="col-md-12">
                                <div class="form-group has-feedback checkbox">
                                    <div class="checkbox">
                                        <label> <input type="checkbox" name="rememberMe" id="rememberMe">记住我</a>
                                        </label> <span class="pull-right"><a href="${ctx }/resetPwd/step1">忘记密码</a></span>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-12">
                                <div class="form-group">
                                    <button type="submit" class="btn btn-success btn-lg btn-block"
                                            id="loginSubmit" onclick="login()">登录</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="${ctxResources}/plugins/udf/md5.gzjs"></script>
<script src="${ctxResources}/plugins/jquery/jquery.validate.min.gzjs"></script>
<script src="${ctxResources}/plugins/bootstrap/bootstrap.min.js"></script>
<script src="${ctxResources}/plugins/jquery/jquery.fullPage.min.js"></script>
<script src="${ctxResources}/pages/modules/login.js"></script>
<script src="${ctxResources}/plugins/jquery/jquery-cookie.js"></script>
<script src="${ctxResources}/plugins/jquery/jquery-base64.js"></script>
<script>
    $(function(){
        $('#dowebok').fullpage();
        var captcha;
    });
   	function refreshCaptcha(){  
   	    document.getElementById("img_captcha").src="${ctx}/resources/images/kaptcha.jpg?t=" + Math.random();  
   	} 
   	function register(){
   		var url = 'http://localhost:8093/portal/joinAbs';
   		window.open(url);
   	}
</script>
</body>
</html>