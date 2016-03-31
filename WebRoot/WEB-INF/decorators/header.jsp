<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />
<c:set var="nav_index" ><decorator:getProperty property='meta.nav_index' /></c:set>

<div class="banner inner-banner">
	<div class="header">
		<div class="container">
			<div class="logo"></div>
			<div class="search-bar">
                <form action="search" method="POST">
				<input type="text" name="search" value="Search" onFocus="this.value = '';"
					onBlur="if (this.value == '') {this.value = 'Search';}"> 
                    <input type="submit" value="" />
                </form>
			</div>
			<span class="menu"> Menu</span>

			<div class="banner-top">
				<ul class="nav banner-nav">
					<li><a class='${nav_index == 0 ? "active" :""}'  href="${homePath }">主页</a></li>
					<li class="dropdown1"><a class='${nav_index == 1 ? "active" :""}' href="${userBasePath }">我的贴吧</a></li>
					<li class="dropdown1"><a class='${nav_index == 2 ? "active" :""}'	href="${hotTopicPath }">最新热帖</a></li>
					<li class="dropdown1"><a class='${nav_index == 3 ? "active" :""}' href="${forumBasePath }">话题分类</a></li>
					<li class="dropdown1"><a class='${nav_index == 4 ? "active" :""}' href="${mailBasePath }">邮件</a>
                        <ul class="dropdown2">
							<li><a href="${mailBasePath }">收件箱</a></li>
							<li><a href="${mailBasePath }sent">发件箱</a></li>
							<li><a href="${mailBasePath }send">发邮件</a></li>
						</ul>
                    </li> 
					<c:choose>
						<c:when test="${crtUser == null }">
							<li class="dropdown1"><a class='${nav_index == 5 ? "active" :""}' href="${ loginPath }">登录|注册</a></li>
						</c:when>
						<c:otherwise>
							<li class="dropdown1">
                                <a href="javascript:void(0)">${crtUser.username}</a>
                                <ul class="dropdown2">
                                    <c:if test="${isAdmin }">
                                        <li><a href="${adminBasePath}user">用户管理</a></li>
                                        <li><a href="${adminBasePath}topic">话题管理</a></li>
                                    </c:if>
                                    <li><a href="${userBasePath}">个人信息</a></li>
                                    <li><a href="${mailBasePath}">邮件</a></li>
                                    <li><a href="${ logoutPath }">登出</a></li>
                                </ul>
                            </li>
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

			<h3><decorator:getProperty property='meta.my_title' /></h3>
			<h6><decorator:getProperty property='meta.my_description' /></h6>

			<div class="clearfix"></div>
		</div>
	</div>
</div>