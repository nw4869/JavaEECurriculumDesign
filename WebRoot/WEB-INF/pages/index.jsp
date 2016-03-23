<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />

<!
DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Hosting Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!-- webfonts -->
<link href='http://fonts.useso.com/css?family=Ubuntu:300,400,500,700'
	rel='stylesheet' type='text/css'>
<!-- webfonts -->
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
<link href="css/nav.css" rel="stylesheet" type="text/css" media="all" />
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event) {
					event.preventDefault();
					$('html,body').animate({
						scrollTop : $(this.hash).offset().top
					}, 1000);
				});
			});
		</script>
<!-- end-smoth-scrolling -->
</head>
<!-- Header Starts Here -->
<div class="banner">
	<div class="header">
		<div class="container">
			<div class="logo"></div>
			<div class="search-bar">
				<input type="text" value="Search" onFocus="this.value = '';"
					onBlur="if (this.value == '') {this.value = 'Search';}"> <input
					type="submit" value="" />
			</div>
			<span class="menu"> Menu</span>

			<div class="banner-top">
				<ul class="nav banner-nav">
					<li><a class="active" href="${homePath }">主页</a></li>
					<li class="dropdown1"><a href="${userBasePath }">我的贴吧</a></li>
					<li class="dropdown1"><a href="${hotTopicPath }">最新热帖</a></li>
					<li class="dropdown1"><a href="${forumBasePath }">话题分类</a></li>
					<li class="dropdown1"><a href="">团队</a></li>
					<c:choose>
						<c:when test="${crtUser == null }">
							<li class="dropdown1"><a href="${ loginPath }">登录|注册</a></li>	
						</c:when>
						<c:otherwise>
							<li class="dropdown1"><a href="${ logoutPath }">登出</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
				<script>
									$("span.menu").click(
											function() {
												$(" ul.nav").slideToggle(
														"slow", function() {
														});
											});
								</script>
			</div>
			<div class="clearfix"></div>

		</div>
	</div>
	<div class="banner-info">
		<h1>We are your best choice</h1>
		<p>不用多久，你就会升值加薪，当上总经理，出任CEO，迎娶白富美，走上人生巅峰。想想是不是还有点小激动，嘿嘿~。现在就加入我们吧！</p>
	</div>
</div>
<div class="clearfix"></div>
<!-- Header Ends Here -->
<div class="best">
	<div class="container">
		<article>
			<figure class="float-left">
				<img src="images/470x240.jpg" alt="Placeholder">
			</figure>
			<h2>
				<span>IT贴</span> 为你而生
			</h2>
			<p>IT贴的使命是让志同道合的人相聚。贴吧的组建依靠搜索引擎关键词，不论是大众话题还是小众话题，都能精准地聚集大批同好网友，展示自我风采，结交知音，搭建别具特色的“IT兴趣主题“互动平台。</p>
		</article>
	</div>
</div>
<div class="copyrights">
	Collect from <a href="http://www.cssmoban.com/">免费网站模板</a>
</div>
<div class="plans"></div>
<div class="fullwidth-section semi-background">
	<div class="fullwidth-bg">
		<div class="overlay left-aligned">
			<div class="dt-sc-one-half column first">
				<div class="dt-support">
					<h2>
						<span>致力</span> 于 专用
					</h2>
					<p>作为一个会员，享受最强大的服务器，与大顶级大神直接交流沟通，学习强大的技术。</p>
					<span>(855) 503-0450</span>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="service-section" id="service"></div>
<!--services-->
<div class="services">
	<div class="container">
		<h3>
			We are no. 1...<span>WHY?</span>
		</h3>
		<div class="col-md-6 services-grids">
			<ul class="srevicesgrid_info">
				<li class="tick">世界上最好的服务器</li>
				<li class="tick">各路大神云集</li>
				<li class="tick">简单炫酷的界面</li>
			</ul>
		</div>
		<div class="col-md-6 services-grids">
			<ul class="srevicesgrid_info">
				<li class="tick">世界上最好的服务器</li>
				<li class="tick">各路大神云集</li>
				<li class="tick">简单炫酷的界面</li>
			</ul>
		</div>
	</div>
</div>
<div class="services-bottom">
	<p>
		我们论坛在全国拥有有超过<span>200.000 用户</span>!
	</p>
</div>
<!--/srvices-->
<!-- #Testimonials -->
<div id="testimonialWrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<div id="testimonialPicture"></div>
			</div>
			<div class="col-md-7 col-md-offset-1">
				<h2>我们的用户说...</h2>
				<h3>码农必备论坛，客服MM热情给力，论坛大牛多，很多问题都能得到解决。</h3>
				<h3>刚学习编程的时候，各种困难。身边没什么人可以请教，基本靠在这里请教大神，收获很多。</h3>
				<h3>
					<h3>对于搞IT的来说，CSDN就是个很好的去处，里面有很多大神帮热心的解决问题和分享自己的心得，学习了很多自己没见过或者遇到过的问题。</h3>
					<h3>
						<a href="#">Lorem ipsum - www.google.com</a>
					</h3>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- /#Testimonials -->
<!-- #Footer -->
<footer>
	<div class="container">
		<div class="row"></div>
		<div class="container">
			<div class="row" style="text-align:center">
				©版权所有：桂林电子科技大学 校址：中国广西桂林金鸡路1号 邮编：541004 传真：0773-2290083 <br>
				备案号：桂ICP备 05000961 号 前置审核编号：桂JS201012-003 <a
					href="http://www.gx.cyberpolice.cn/guilin/" target="_blank">广西网警</a><a
					href="http://www.gx.cyberpolice.cn/BaIcpRegister/toStockDocCue.do"
					target="_blank"> 网上备案</a><a
					href="http://www.gx.cyberpolice.cn/NewsCategory/lstNewCate.do"
					target="_blank">广西网络安全信息网</a>
			</div>
			<hr>
		</div>
	</div>
	<div class="copyrights">
		<div class="container">
			<p>
				Copyright &copy; 2015.Company name All rights reserved.More
				Templates <a href="http://www.cssmoban.com/" target="_blank"
					title="模板之家">模板之家</a> - Collect from <a
					href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
			</p>
		</div>
	</div>
</footer>
<!-- /#Footer -->
<!-- here stars scrolling icon -->
<script type="text/javascript">
		$(document).ready(function() {
			/*
			var defaults = {
				containerID: 'toTop', // fading element id
				containerHoverID: 'toTopHover', // fading element hover id
				scrollSpeed: 1200,
				easingType: 'linear' 
			};
			 */

			$().UItoTop({
				easingType : 'easeOutQuart'
			});

		});
	</script>
<!-- //here ends scrolling icon -->
</body>
</html>