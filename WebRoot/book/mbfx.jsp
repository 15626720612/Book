<%@page import="page.mbfx.Mbfx"%>
<%@page import="java.util.List"%>
<%@page import="page.mbfx.MbfxDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>好书分享</title>
<link href="css/base.css" rel="stylesheet">
<link href="css/share.css" rel="stylesheet">
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script src="js/scrollReveal.js"></script>
</head>
<body>
	<header>
	<div class="logo" data-scroll-reveal="enter right over 1s">
		<a href="/"><img src="images/logo.png">
		</a>
	</div>
	<nav class="topnav" data-scroll-reveal="enter bottom over 1s after 1s">
	<a href="index.jsp"><span>首页</span><span class="en">Home</span>
	</a> <a href="manshenghuo.jsp"><span>慢生活</span><span class="en">Life</span>
	</a> <a href="mbfx.jsp"><span>好书分享</span><span class="en">Share</span>
	</a> <a href="about.jsp"><span>关于我们</span><span class="en">About</span>
	</a> <a href="gbook.jsp?page=1&msg="><span>留言</span><span class="en">Saying</span>
	</a> <a href="../user/login.jsp"><span>登录</span><span class="en">login</span>
	</a> </nav> </header>
	<article>
	<div class="container">
		<h2 class="ctitle">
			<b>好书分享</b> <span>好咖啡要和朋友一起品尝，好书也要和同样喜欢它的人一起分享。</span>
		</h2>
		<div class="blog" data-scroll-reveal="enter top">
			<%
				MbfxDao dao = new MbfxDao();
			    String pageStr = "1";
				if(request.getParameter("page")!=null){
					pageStr=request.getParameter("page");
				}
				int pageInt = Integer.parseInt(pageStr);
				int size = 0;int pageSize = 9;
				size=dao.getSize();
				List<Mbfx> mbfxs = dao.query(pageInt,pageSize);
			%>

			<c:forEach items="<%=mbfxs %>" var="mbfx" begin="0">
				<figure>
				<ul>
					<a href="${mbfx.bookUrl }"><img src="${mbfx.imgUrl}"><span>查看更多</span>
					</a>
				</ul>
				<p>
					<a href="/">${mbfx.title }</a>
				</p>
				<figcaption>
				${mbfx.brief }</figcaption> </figure>
			</c:forEach>
		</div>
		<div class="page">
			<a href="mbfx.jsp?page=<%=pageInt-1%>">&lt;&lt;</a>
			<%
				int lab = size/pageSize;
				if(size%pageSize!=0){
					lab++;
				}
				for(int i=0;i<lab;i++){
			%>
			<a href="mbfx.jsp?page=<%=i+1%>"><%=i+1%></a>
			<%
				}
			%>
			<a href="mbfx.jsp?page=<%=pageInt+1%>">&gt;&gt;</a>
		</div>
	</div>
	</aside> </article>
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