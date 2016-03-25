<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>


<html>
<head>
<title>Blog</title>
<base href="<%=basePath%>">
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
					<li class="dropdown1"><a class="active"
						href="${hotTopicPath }">最新热帖</a></li>
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

			<h3>热帖</h3>
			<h6>万千网友相聚，终有一贴钟情</h6>

			<div class="clearfix"></div>
		</div>
	</div>
</div>
<div class="clearfix"></div>
<!-- Header Ends Here -->
<div class="bolg-posts">
	<div class="container">
		<div class="blog">

			<c:forEach var="topic" items="${topics }">

				<div class="col-md-6 blog-top">
					<div class="blog-in">
						<a href="${topicBasePath }${topic.id}"><img
							src="images/b3.jpg" alt=" "></a>
						<div class="blog-grid">
							<h3>
								<a href="${topicBasePath }${topic.id}">${topic.title }</a>
							</h3>
							<p>${fn:substring(topic.content, 0, 100) }</p>
							<a href="${topicBasePath }${topic.id}" class="more">更多</a>
							<div class="date">
								<span class="date-in"><i> </i> <fmt:formatDate
										pattern="yyyy-MM-dd HH:mm:ss" value="${topic.lastActiveTime }" /></span>
								<a href="${topicBasePath }${topic.id}" class="comments"><i></i>${fn:length(topic.replies) }</a>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
					<i class="black"> </i>
				</div>

			</c:forEach>


			<div class="clearfix"></div>
			<ul class="start">
				<li><span class="prev">&lt;上一页</span></li>
				<li><span>1</span></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">6</a></li>
				<li><a href="#">7</a></li>
				<li><a href="#">8</a></li>
				<li><span>.....</span></li>
				<li><a href="#">12</a></li>
				<li><a href="#" class="next">下一页&gt;</a></li>
			</ul>
		</div>
	</div>

</div>



<!-- #SendMessage -->
<div class="container">
	<div class="register">
		<form:form name='topicForm' modelAttribute="topicForm"
			action="topic/save" method='POST'>
			<div class="register-top-grid">
				<h3>发帖</h3>
				<div class="wow fadeInLeft" data-wow-delay="0.4s">
					<span>标题 <label>*</label></span>
					<form:input id="title" name="title" path="title" />
					<form:errors path="title" />

				</div>
				<div class="wow fadeInRight" data-wow-delay="0.4s">
					<span>类别 <label>*</label></span>
					 <form:select path="forum.id" items="${forumMap }" class="form-control">
					</form:select>
				</div>
				<div class="clearfix"></div>

				<div class="register-bottom-grid">

					<div class="wow fadeInLeft" data-wow-delay="0.4s">
						<div class="liuyan-box">
							<form:textarea path="content" class="liuyan-content" name="board.msg"/>
							<form:errors path="content" />
							<input type="submit" value="发 帖" />
						</div>
					</div>
				</div>
			</div>
		</form:form>

	</div>
</div>
<!-- #SendMessage -->

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