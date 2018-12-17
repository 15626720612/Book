<%@page import="page.manshenghuo.MshRead"%>
<%@page import="page.manshenghuo.MshReadDao"%>
<%@page import="page.manshenghuo.MshSentenceDao"%>
<%@page import="java.util.List"%>
<%@page import="page.manshenghuo.MshSentence"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>AIB书虫读书会</title>
<link href="css/base.css" rel="stylesheet">
<link href="css/msh.css" rel="stylesheet">
<script src="js/scrollReveal.js"></script>
</head>
<body>
	<header>
	<div class="logo" data-scroll-reveal="enter right over 1s">
		<a href="/"><img src="images/logo.png"> </a>
	</div>
	<nav class="topnav" data-scroll-reveal="enter bottom over 1s after 1s">
	<a href="index.jsp"><span>首页</span><span class="en">Home</span> </a> <a
		href="manshenghuo.jsp"><span>慢生活</span><span class="en">Life</span>
	</a> <a href="mbfx.jsp"><span>好书分享</span><span class="en">Share</span>
	</a> <a href="about.jsp"><span>关于我们</span><span class="en">About</span>
	</a> <a href="gbook.jsp?msg="><span>留言</span><span class="en">Saying</span>
	</a> <a href="../user/login.jsp"><span>登录</span><span class="en">login</span>
	</a> </nav> </header>
	<article>
	<div class="container">
		<h2 class="ctitle">
			<b>句子迷</b> <span>“慢生活”不是懒惰，放慢速度不是拖延时间，而是让我们在生活中寻找到平衡。 </span>
		</h2>
		<div class="photowall">
			<!-- 句子迷 -->
			<ul class="wall_a">
				<%
					MshSentenceDao dao = new MshSentenceDao();
					List<MshSentence> stns = dao.query();
					System.out.print("li");
				%>
				<c:forEach items="<%=stns %>" var="stn" varStatus="id" begin="0">
					<li><a href="/"><img src="${stn.imgUrl}"> <figcaption>
							<h2>${stn.sentence}</h2>
							</figcaption> </a>
					</li>
				</c:forEach>
			</ul>

		</div>
		<div>
			<h2 class="ctitle">
				<b>短篇阅读</b>
			</h2>

			<ul class="cbp_new">
				<%
					MshReadDao dao1 = new MshReadDao();
							String pageStr = "1";
							if(request.getParameter("page")!=null){
								pageStr=request.getParameter("page");
							}
							int pageInt = Integer.parseInt(pageStr);
							int size = 0;int pageSize = 3;
							size=dao1.getSize();
							List<MshRead> reads = dao1.query(pageInt,pageSize);
				%>
				<c:forEach items="<%=reads%>" var="read" begin="0">
					<li id="new_li">
						<div class="cbp_title" data-scroll-reveal="enter right over 1s">
							<h2>${read.title }</h2>
							<h5>作者/${read.author }</h5>
							<a href="/"><img id="new_img" src="${read.imgUrl }"> </a>
							<div id="new_txt">${read.brief }</div>
							</p>
							<a id="new_btn" href="${read.essayUrl}" target="_blank"
								class="readmore_1">阅读全文</a>
						</div>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="page">
			<!-- <a title="Total record"><b>107</b> </a><b>1</b><a
				href="/news/index_2.html">2</a><a href="/news/index_3.html">3</a><a
				href="/news/index_4.html">4</a><a href="/news/index_5.html">5</a><a
				href="/news/index_2.html">&gt;</a><a href="/news/index_5.html">&gt;&gt;</a> -->
			<a href="manshenghuo.jsp?page=<%=pageInt-1%>">&lt;&lt;</a>
			<%
				int lab = size/pageSize;
							if(size%pageSize!=0){
								lab++;
							}
							for(int i=0;i<lab;i++){
			%>
			<a href="manshenghuo.jsp?page=<%=i+1%>"><%=i+1%></a>
			<%
				}
			%>
			<a href="manshenghuo.jsp?page=<%=pageInt+1%>">&gt;&gt;</a>
		</div>
		<!-- </div> -->
		</aside>
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