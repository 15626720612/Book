<%@page import="user.User"%>
<%@page import="msg.MessageDao"%>
<%@page import="java.util.List"%>
<%@page import="msg.Message"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>留言</title>
<link href="css/base.css" rel="stylesheet">
<link href="css/book.css" rel="stylesheet">
<script src="js/scrollReveal.js"></script>
</head>
<body>
	<header>
	<div class="logo" data-scroll-reveal="enter right over 1s">
		<a href="/"><img src="images/logo.png"> </a>
	</div>
	<nav class="topnav" data-scroll-reveal="enter bottom over 1s after 1s">
	<a href="index.jsp"><span>首页</span><span class="en">Home</span> </a> <a
		href="manshenghuo.jsp?page=1"><span>慢生活</span><span class="en">Life</span>
	</a> <a href="mbfx.jsp?page=1"><span>好书分享</span><span class="en">Share</span>
	</a> <a href="about.jsp"><span>关于我们</span><span class="en">About</span>
	</a> <a href="gbook.jsp?page=1&msg="><span>留言</span><span class="en">Saying</span>
	<a href="../user/login.jsp"><span>登录</span><span class="en">login</span></a>
	</a> </nav> </header>
	<article>
	<div class="container">
		<h2 class="ctitle">
			<b>留言板</b> <span>你，生命中最重要的过客，之所以是过客，因为你未曾为我停留。</span>
		</h2>
		<div class="gbook">
			<div class="about">
			<%boolean flag;
			  User user=(User)session.getAttribute("loginUser");
			  if(user!=null){
			  	flag=true;
			  }else{
			  	flag=false;
			  }
			 %>
				<form action=<%=flag?"/Book/servlet/MsgServlet":"/Book/user/login.jsp"%> method="get">
					<textarea name="msg" id="input" cols="105" rows="8"></textarea>
					<input id="msg_btn" type="submit" value="留言">
				</form>
			</div>
		</div>
	</div>
	</aside>
	<div class="speak">
	<h3>最近留言</h3>
		<%
/* 			String pStr="1";
			pStr=request.getParameter("p");
			int p=Integer.parseInt(pStr); */
			
			MessageDao dao = new MessageDao();
			String pageStr = "1";
			if(request.getParameter("page")!=null){
				pageStr=request.getParameter("page");
			}
			int pageInt = Integer.parseInt(pageStr);
			int size = 0;int pageSize = 20;
			size=dao.getSize();
			
			List<Message> msgs = dao.query(pageSize, pageInt);
			
			
			for(Message m :msgs){
		%>
		<div id="persion">
			<span id="name"><%=m.getName()%>:<%=m.getDate()%></span><br> <span>
				<%=m.getSpeak()%> </span><br>
		</div>
		<%
			}
		%>

	</div>
	
	<div class="page">
			<a href="gbook.jsp?page=<%=pageInt-1%>&msg=">&lt;&lt;</a>
			<%
				int lab = size/pageSize;
				if(size%pageSize!=0){
					lab++;
				}
				for(int i=0;i<lab;i++){
			%>
			<a href="gbook.jsp?page=<%=i+1%>&msg="><%=i+1%></a>
			<%
				}
			%>
			<a href="gbook.jsp?page=<%=pageInt+1%>&msg=">&gt;&gt;</a>
		</div>
	
	</article>
	<script>
		if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))) {
			(function() {
				window.scrollReveal = new scrollReveal({
					reset : true
				});
			})();
		};
	</script>
</body>
</html>