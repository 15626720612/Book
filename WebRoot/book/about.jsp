<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>AIB书虫读书会</title>
<link href="css/base.css" rel="stylesheet">
<link href="css/about.css" rel="stylesheet">
<script src="js/scrollReveal.js"></script>
</head>
<body>
<header>
  <div class="logo" data-scroll-reveal="enter right over 1s"><a href="/"><img src="images/logo.png"></a></div>
  
  <nav class="topnav" data-scroll-reveal="enter bottom over 1s after 1s">
    <a href="index.jsp"><span>首页</span><span class="en">Home</span></a>
    <a href="manshenghuo.jsp"><span>慢生活</span><span class="en">Life</span></a>
    <a href="mbfx.jsp"><span>好书分享</span><span class="en">Share</span></a>
    <a href="about.jsp"><span>关于我们</span><span class="en">About</span></a>
    <a href="gbook.jsp?msg="><span>留言</span><span class="en">Saying</span></a>
    <a href="../user/login.jsp"><span>登录</span><span class="en">login</span></a>
  </nav>

</header>
<article>
  <div class="container">
    <div class="banner">
      <p data-scroll-reveal="enter top over 2s">我们不停的翻弄着回忆，却再也找不回那时的自己</p>
      <p data-scroll-reveal="enter left over 2s after 1s">人生，是一场盛大的遇见。若你懂得，就请珍惜。</p>
      <p data-scroll-reveal="enter bottom over 2s after 2s">无论下多久的雨，最后都会有彩虹；无论你多么悲伤，要相信幸福在前方等候.</p>
    </div>
    <div class="memorial_day">
      <div class="time_axis"></div>
      <ul>
        <li class="n1"><a href="/">读书会成立</a>
          <div class="dateview">2016年11月</div>
        </li>
        <li class="n2"><a href="/">第一次活动</a>
          <div class="dateview">2016-12-16</div>
        </li>
        <li class="n3"><a href="/">加入广州阅读联盟</a>
          <div class="dateview">2017-07-08</div>
        </li>
        <li class="n4"><a href="/">招新|涌进新血液</a>
          <div class="dateview">2017-10-19</div>
        </li>
        <li class="n5"><a href="/">挂牌|AIB阅读推广基地</a>
          <div class="dateview">2017-12-07</div>
        </li>
        
      </ul>
    </div>
    <div class="about left">
      <h2>简介</h2>
        <ul> 
         <p>AIB书虫读书会成立于2017年9月11日，是广州阅读联盟的一员，指导老师为黄辉老师，协办单位为AIB火鸟文学社、AIB北区图管队。地标位于农工商北区图书馆七楼教工之家，于2017年12月7日正式挂牌为“阅读推广基地”，得到了校方领导的大力支持。</p>
        <p>
        AIB读书会是一个阅读爱好者的聚集地，会定期举办读书分享会、专家座谈会等活动，为阅读爱好者提供一个分享、交流、学习的温馨之家。</p>
        <p>AIB书虫读书会致力于成为农工商的阅读推广基地，为“文化农工商”的建设舔砖加瓦。带领大家多读书，读好书，将好读书的风气传递出去，像可燎原的星星之火。</p>
        <p>
          
        </p>
        </ul>
        <h2>活动形式</h2>
        <ul>
          <li>读书分享：<p>最常见的分享形式，分享者提前准备好PPT，分享他们的读书心得以及感受，结束之后由老师点评或者与同学交流想法。</p></li>
          <li>好书共读：<p>大家一起看一本书，交流想法与收获</p></li>
          <li>名家讲坛：<p>请一些在某些领域有成就的专家过来分享</p></li>
          <li>分享访谈：<p>边说边谈</p></li>
          <li>诗歌分享会：<p>围绕诗歌展开讨论，古今中外不限</p></li>
          <li>好书推荐：<p>定时在微信公众号上推荐一些好书供同学们阅读。</p></li>
        </ul>


    </div>
  </div>
  </aside>
</article>
<script>
	if (!(/msie [6|7|8|9]/i.test(navigator.userAgent))){
		(function(){
			window.scrollReveal = new scrollReveal({reset: true});
		})();
	};
</script>
</body>
</html>