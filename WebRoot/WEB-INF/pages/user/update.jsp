<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>${crtUser.username } - 个人信息</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Hosting Store Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />

<style type="text/css">
#preview {
	width: 260px;
	height: 190px;
	border: 1px solid #000;
	overflow: hidden;
}

#imghead {
	filter: progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);
}

.form input[type="file"] {
	background: #1BBC9B;
	color: #FFF;
	font-size: 1.2em;
	padding: 0.6em 2em;
	transition: 0.5s all;
	-webkit-transition: 0.5s all;
	-moz-transition: 0.5s all;
	-o-transition: 0.5s all;
	display: inline-block;
	text-transform: uppercase;
	border: none;
	outline: none;
}
</style>

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


<script type="text/javascript">
	//图片上传预览    IE是用了滤镜。
	function previewImage(file) {
		var MAXWIDTH = 260;
		var MAXHEIGHT = 180;
		var div = document.getElementById('preview');
		if (file.files && file.files[0]) {
			div.innerHTML = '<img id=imghead>';
			var img = document.getElementById('imghead');
			img.onload = function() {
				var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT,
						img.offsetWidth, img.offsetHeight);
				img.width = rect.width;
				img.height = rect.height;
				//                 img.style.marginLeft = rect.left+'px';
				img.style.marginTop = rect.top + 'px';
			}
			var reader = new FileReader();
			reader.onload = function(evt) {
				img.src = evt.target.result;
			}
			reader.readAsDataURL(file.files[0]);
		} else //兼容IE
		{
			var sFilter = 'filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src="';
			file.select();
			var src = document.selection.createRange().text;
			div.innerHTML = '<img id=imghead>';
			var img = document.getElementById('imghead');
			img.filters.item('DXImageTransform.Microsoft.AlphaImageLoader').src = src;
			var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth,
					img.offsetHeight);
			status = ('rect:' + rect.top + ',' + rect.left + ',' + rect.width
					+ ',' + rect.height);
			div.innerHTML = "<div id=divhead style='width:"+rect.width+"px;height:"+rect.height+"px;margin-top:"+rect.top+"px;"+sFilter+src+"\"'></div>";
		}
	}
	function clacImgZoomParam(maxWidth, maxHeight, width, height) {
		var param = {
			top : 0,
			left : 0,
			width : width,
			height : height
		};
		if (width > maxWidth || height > maxHeight) {
			rateWidth = width / maxWidth;
			rateHeight = height / maxHeight;

			if (rateWidth > rateHeight) {
				param.width = maxWidth;
				param.height = Math.round(height / rateWidth);
			} else {
				param.width = Math.round(width / rateHeight);
				param.height = maxHeight;
			}
		}

		param.left = Math.round((maxWidth - param.width) / 2);
		param.top = Math.round((maxHeight - param.height) / 2);
		return param;
	}
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
					<ul class="nav banner-nav">
						<li><a href="${homePath }">主页</a></li>
						<li class="dropdown1"><a class="down-scroll active"
							href="${userBasePath }">我的贴吧</a></li>
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

			<h3>我的贴吧</h3>
			<h6>我的地盘，我做主</h6>

			<div class="clearfix"></div>
		</div>
	</div>
</div>
<div class="clearfix"></div>
<!-- Header Ends Here -->


<div class="container">
	<div class="register">
		<form:form name='updateForm' modelAttribute="userForm"
			action="user/update" method='POST'>
			<div class="register-top-grid">
				<h3>${crtUser.username } - 个人信息</h3>

				<div class="wow fadeInLeft" data-wow-delay="0.4s">
					<span>更换头像 </span>

					<div id="preview">
						<img id="imghead" border=0 src="images/head_180.jpg" width="180"
							height="180" />
					
					</div>
<!-- 					<span class="register-but">
							<input type="submit" value="上 传">
					</span> -->
					
				</div>

				<div class="wow fadeInLeft" data-wow-delay="0.4s"></div>

				<div class="wow fadeInLeft" data-wow-delay="0.4s">
					<span><form:label path="memberTitle">昵称</form:label></span>
					<form:input id="memberTitle" name="memberTitle" path="memberTitle" />
					<form:errors path="memberTitle" />
				</div>
				<div class="wow fadeInRight" data-wow-delay="0.4s">
					<span><form:label path="signature">个性签名</form:label></span>
					<form:input id="signature" name="signature" path="signature" />
					<form:errors path="signature" />
				</div>
				<div class="wow fadeInRight" data-wow-delay="0.4s">
					<span><form:label path="email">邮箱地址</form:label></span>
					<form:input id="email" name="email" path="email" />
					<form:errors path="email" />
				</div>

				<div class="wow fadeInLeft" data-wow-delay="0.4s">

					<input type="file" onchange="previewImage(this)" />

				</div>
				<div class="clearfix"></div>
				<div class="register-but">
						<input type="submit" value="完 成">
				</div>
			</div>
		</form:form>
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
<div class="copyrights">
	<div class="container">
		<p>
			Copyright &copy; 2015.Company name All rights reserved.More Templates
			<a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a>
			- Collect from <a href="http://www.cssmoban.com/" title="网页模板"
				target="_blank">网页模板</a>
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
