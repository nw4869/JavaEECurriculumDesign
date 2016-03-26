<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />

<html>
<head>
<meta name="nav_index" content="2">
<meta name="my_title" content="热帖">
<meta name="my_description" content="万千网友相聚，终有一贴钟情">
<title>最新热帖</title>

</head>
<body>
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

</body>
</html>