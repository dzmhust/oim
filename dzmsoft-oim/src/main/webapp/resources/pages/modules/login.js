/**
 * 初始加载
 */
$(function(){
	getCookie();
	initActions();
});

function login(){
	formValidate();
}
/**
 * 绑定事件
 */
function initActions(){
	// 回车事件
	$("#loginForm input").each(function(){
		$(this).bind('keypress',function(event){
	        if(event.keyCode == "13") {
	        	login();
	        }
	    });
	});
}
/**
 * 登录校验
 */
function formValidate(){
	$("#loginForm").validate({
		focusInvalid: false,onkeyup: false,
		submitHandler:function(form){
			var md5Pass = hex_md5(hex_md5($("#password").val()));
			$("#password").val(md5Pass);
			setCookie();
			form.submit();
		},
		errorPlacement: function(error, element) {
        	error.appendTo( element.parent() );
        },
        rules:{
        	username:{required:true,minlength:5,maxlength:16}
        	,password:{required:true,minlength:6,maxlength:32}
        	,captcha:{required:true}
        },
        messages:{
        	username:{required:"帐号不能为空",minlength : $.validator.format("帐号不能少于{0}位"),maxlength : $.validator.format("帐号不能超过{0}位")}
        	,password:{required: "密码不能为空",minlength : $.validator.format("密码不能少于{0}位"),maxlength : $.validator.format("密码不能超过{0}位")}
        	,captcha:{required: "验证码不能为空"}
        }
	});
}

function getCookie(){
	if ($.cookie("rememberMe") == "true") { 
		var b = new Base64()
		$("#rememberMe").attr("checked", true); 
		$("#username").val(b.decode($.cookie("username"))); 
		$("#password").val(b.decode($.cookie("password"))); 
	} 
}

function setCookie(){
	if($("#rememberMe").is(':checked')){
		var a = new Base64(); 
		var username = a.encode($("#username").val());
		var password = a.encode($("#password").val());
		$.cookie("rememberMe","true",{expires:7,raw:false,});
		$.cookie("username",username,{expires:7,raw:false});
		$.cookie("password",password,{expires:7,raw:false});
	}else{
		$.cookie("rememberMe","false");
		$.cookie("username",'')
		$.cookie("password",'')
	}
}