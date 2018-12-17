<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head> 
    <title>注册</title>
     <link href="../book/css/base.css" rel="stylesheet">
     <link href="../book/css/register.css" rel="stylesheet">
  </head>
  <body>
  	<div class="page-container">
	<div class="main_box">
		<div class="login_box">
			<div class="login_form">
				<div class="title"><h3>注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册</h3></div>
				<form action="/Book/servlet/user/register" id="login_form" method="post">
					<div class="form-group">
						<span for="j_username" class="t">学     号：</span> 
						<input id="email" name="sid" class="form-control x319 in" autocomplete="off" type="text">
					</div>
					<div class="form-group">
						<span for="j_password" class="t">密　码：</span>
						<input id="password" name="pwd" class="password form-control x319 in" type="password">
					</div>
					<div class="form-group">
						<span for="j_password" class="t">名&nbsp;&nbsp;&nbsp;&nbsp;称：</span>
						<input id="name" name="name" class="form-control x319 in" type="text">
					</div>
					<div class="form-group">
						<span for="j_password" class="t">性   别：</span>
						<select name="sex">
								<option value="男">男</option>
								<option value="女">女</option>
						</select><br>
					</div>
					<div class="form-group" id="code">
						<span for="j_captcha" class="t">验证码：</span>
						<input id="j_captcha" name="code" class="form-control x164 in" type="text">
						<img id="captcha_img" alt="点击更换" title="点击更换" src="/Book/servlet/code/authCode" class="m">
					</div>
					<div class="form-group space">
						<span class="t"></span>　　　
						<a href="#"><input type="submit" value="注册"></a>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
  
	<!-- <form action="/Book/servlet/user/register" method="post">
		账号:<input name="sid"/><br>
		密码:<input type="password" name="pwd"/><br>
		名称:<input name="name"/><br>
		性别：<select name="sex">
			<option value="男">男</option>
			<option value="女">女</option>
		</select><br>
		验证码:<input name="code"/><br><img src="/Book/servlet/code/authCode" width="100px" /><br>
		<input type="submit" value="注册"/> 
	</form> -->
  </body>
</html>
