<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />
<html>
<head>

<meta name="nav_index" content="3">
<meta name="my_title" content="趣帖">
<meta name="my_description" content="莫愁前路无知己，贴贴相逢终有遇">
<title>Single</title>
</head>
<body>
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
								<c:if test="${isForumAdmin || crtUser.id == reply.user.id }">
									<p class="reply">
										<a href="${replyBasePath }${reply.id}/delete"><i> </i>删除</a>
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
<!-- //here ends scrolling icon -->
</body>
</html>