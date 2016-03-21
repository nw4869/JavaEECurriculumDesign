<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp" />
<fmt:setBundle basename="bundles.auth-resources" />

<!DOCTYPE HTML>
<html>
<head>
<base href="<%=basePath%>">
<title>Register</title>
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
<div class="banner inner-banner">
	<div class="header">
		<div class="container">
			<div class="logo"></div>
			<div class="search-bar">
				<input type="text" value="Search" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Search';}"> <input
					type="submit" value="" />
			</div>
			<span class="menu"> Menu</span>

			<div class="banner-top">
				<ul class="nav banner-nav">
					<li><a href="${homePath }">主页</a></li>
					<li class="dropdown1"><a href="">最新热帖</a></li>
					<li class="dropdown1"><a href="${forumBasePath }">话题分类</a></li>
					<li class="dropdown1"><a href="">求职招聘</a></li>
					<li class="dropdown1"><a href="">团队</a></li>
					<li class="dropdown1"><a class="down-scroll active" href="${loginPath }">登录|注册</a></li>
				</ul>
				<script>
					$("span.menu").click(function() {
						$(" ul.nav").slideToggle("slow", function() {
						});
					});
				</script>
			</div>
			<div class="clearfix"></div>

		</div>
	</div>
	<!-- page heading -->
	<div id="breadcrumb_wrapper">
		<div class="container">

			<h3>注册</h3>
			<h6>菜鸟起飞从这里开始</h6>

			<div class="clearfix"></div>
		</div>
	</div>
</div>
<div class="clearfix"></div>
<!-- Header Ends Here -->
<div class="register-content">
	<div class="container">
		<div class="register">
			<form:form name='registerForm' modelAttribute="userForm"
		action="auth/register.do" method='POST'>
				<div class="register-top-grid">
					<h3>个人信息</h3>
					<div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>用户名 <label>*</label></span> <form:input id="username" name="username" path="username" />
				<form:errors path="username" />
					</div>
					<div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>邮箱<label>*</label></span> <form:input id="email" name="email" path="email" />
				<form:errors path="email" />
					</div>
<!-- 					<div class="wow fadeInRight" data-wow-delay="0.4s"> -->
<!-- 						<span>邮箱地址 <label>*</label></span> <input type="text"> -->
<!-- 					</div> -->
					<div class="clearfix"></div>
					<a class="news-letter" href="#"> <!-- <label class="checkbox"><input
							type="checkbox" name="checkbox" checked=""> <i> </i>注册通讯</label> -->
					</a>
				</div>
				<div class="register-bottom-grid">
					<h3>登 陆 信 息</h3>
					<div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>密 码 <label>*</label></span> <form:password id="password" name="password" path="password" />
				<form:errors path="password" />
					</div>
					<div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>密码校验 <label>*</label></span> <input type="password">
					</div>
				</div>
			<div class="clearfix"></div>
			<!-- <div class="register-but"> -->
				<!-- <form> -->
					<input type="submit" value="注 册">
					<div class="clearfix"></div>
				<!-- </form> -->
			<!-- </div> -->
			</form:form>
		</div>
	</div>
</div>

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
					<a href="#">Lorem ipsum - www.google.com</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- /#Testimonials -->
<!-- #Footer -->
<footer>
	<div class="container">
		<div class="row">
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
		<hr>
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