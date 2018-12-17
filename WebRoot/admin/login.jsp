<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>登录</title>
    <link href="../book/css/base.css" rel="stylesheet">
    <link href="../book/css/login.css" rel="stylesheet">
  </head>
<body>
<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_form">
				<div class="title"><h3>登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录</h3></div>
				<form action="/Book/servlet/admin/login" id="login_form" method="post">
					<div class="form-group">
						<span for="j_username" class="t">管理员：</span> 
						<input id="email" name="id" class="form-control x319 in" autocomplete="off" type="text">
					</div>
					<div class="form-group">
						<span for="j_password" class="t">密　码：</span>
						<input id="password" name="pwd" class="password form-control x319 in" type="password">
					</div>
					<div class="form-group" id="code">
						<span for="j_captcha" class="t">&nbsp;验证码：</span>
						<input id="j_captcha" name="code" class="form-control x164 in" type="text">
						<img id="captcha_img" alt="点击更换" title="点击更换" src="/Book/servlet/code/authCode" class="m">
					</div>
					<div class="form-group space">
						<span class="t"></span>　　　
						<a href="#"><input type="submit" value="登录"></a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
</body>
</html>
