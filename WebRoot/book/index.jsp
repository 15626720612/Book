<%@page import="page.index.PageIndexDao"%>
<%@page import="page.index.PageIndex"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>AIB书虫读书会</title>
<link href="css/base.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
<link href="css/jquery.slideBox.css" rel="stylesheet" type="text/css" />
<!--[if lt IE 9]>
<script src="js/modernizr.js"></script>
<![endif]-->
<script src="js/scrollReveal.js"></script>
<script src="js/jquery-1.7.1.min.js"></script>
<script src="js/jquery.slideBox.js"></script>
<script src="js/myjquery.js"></script>
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
		<div id="banner">
			<div class="slideBox" id="banner_pic">
				<ul class="items">
					<li><a href="#" title="夜雨寄北"><img src="images/01.jpg">
					</a></li>
					<li><a href="#" title="红豆"><img src="images/02.jpg">
					</a></li>
					<li><a href="#" title="江雪"><img src="images/03.jpg">
					</a></li>
					<li><a href="#" title="别思"><img src="images/04.jpg">
					</a></li>
					<li><a href="#" title="论语"><img src="images/05.jpg">
					</a></li>
				</ul>
			</div>
		</div>
		<ul class="cbp_tmtimeline">
			<%
				PageIndexDao dao = new PageIndexDao(); 
				List<PageIndex> pids = dao.query();
				for(PageIndex pid: pids){
				String date = pid.getDate();
				String[] strs=date.split("-");
				String year=null;
				String day=null;
					for(int i=0;i<strs.length;i++){
						year=strs[0];
						day=strs[1]+"-"+strs[2];
					}
			%>
			<li><time class="cbp_tmtime"> <span><%=day%></span> <span><%=year%></span></time>
				<div class="cbp_tmicon"></div>
				<div class="cbp_tmlabel" data-scroll-reveal="enter right over 1s">
					<h2><%=pid.getTitle()%></h2>
					<p>
						<span class="blogpic"><a href="/"><img
								src="<%=pid.getImgURL()%>"> </a> </span>
						<%=pid.getExplain()%>
					</p>
					<a href="<%=pid.getBtnURL()%>" target="_blank" class="readmore">阅读全文&gt;&gt;</a>
				</div></li>
			<%
				}
			%>
		</ul>
	</div>
	</article>
	<footer> </footer>
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
