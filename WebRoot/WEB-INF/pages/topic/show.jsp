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

<title>Single</title>
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
					<li class="dropdown1"><a href="${userBasePath }">我的贴吧</a></li>
					<li class="dropdown1"><a href="${hotTopicPath }">最新热帖</a></li>
					<li class="dropdown1"><a class="down-scroll active"
						href="${forumBasePath }">话题分类</a></li>
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

			<h3>趣帖</h3>
			<h6>莫愁前路无知己，贴贴相逢终有遇</h6>

			<div class="clearfix"></div>
		</div>
	</div>
</div>
<div class="clearfix"></div>
<!-- Header Ends Here -->
<div class="bolg-posts">
	<div class="container">
		<div class="single">
			<div class="single-top">
				<img src="images/single-post-img.jpg" alt="" />
			</div>
			<div class="top-single">
				<h2>${topic.title }</h2>
				<div class="grid-single">
					<div class="single-one">
						<span><i></i>${topic.createTime }</span>
					</div>
					</li>
					<div class="single-one">
						<span><i class="com"> </i>${fn:length(topic.replies) }</span>
					</div>
					<div class="single-one">
						<span><i class="four"> </i> </span>
					</div>
					<div class="clearfix"></div>
				</div>
				<p class="eget">${topic.content }</p>

				<div class="single-middle">
					<ul class="social-share">
						<li><span>分享至</span></li>
						<li><a href="#"><i> </i></a></li>
						<li><a href="#"><i class="tin"> </i></a></li>
						<li><a href="#"><i class="message"> </i></a></li>
					</ul>
					<i class="arrow"> </i>
					<div class="clearfix"></div>
				</div>
				<div class="top-comments">
					<h3>${fn:length(topic.replies)  }评论</h3>

					<c:forEach var="reply" items="${topic.replies }">

						<div class="met">
							<div class="code-in">
								<p class="smith">
									<a href="${userBasePath }${reply.user.id}">${reply.user.username }</a>
									<span><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
											value="${reply.createTime }" /></span>
								</p>
								<c:if test="${crtUser.id == reply.user.id }">
									<p class="reply">
										<a href="${replyBasePath }${reply.id}/delete"><i> </i>撤销</a>
									</p>
								</c:if>
								<div class="clearfix"></div>
							</div>
							<div class="comments-top-top">
								<div class="men">
									<img src="images/men.png" alt="">
								</div>
								<p class="men-it">${reply.content }</p>
								<div class="clearfix"></div>
							</div>
						</div>

					</c:forEach>

					<div class="leave">
						<h3>回复</h3>
						<form:form name='replyForm' modelAttribute="replyForm"
							action="topic/${topic.id }/reply" method='POST'>
							<div class="single-grid">
								<div class="clearfix"></div>
							</div>
							<div class="single-grid">
								<div class="col-md-6 single-us">工具栏</div>
								<div class="clearfix"></div>
							</div>
							<div class="text-top">
								<div class="col-md-8 text-in">
									<!--  <textarea value=" " onfocus="this.value='';"
										onblur="if (this.value == '') {this.value = 'Comment';}">评价</textarea> -->
									<form:textarea id="content" name="content" path="content" />
									<form:errors path="content" />
									<form:hidden path="topic.id" />
								</div>
								<div class="col-md-4 text-in">
									<input type="submit" value="发 送">
								</div>
								<div class="clearfix"></div>
							</div>
						</form:form>

					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- #Footer -->
<footer>
<div class="container">
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