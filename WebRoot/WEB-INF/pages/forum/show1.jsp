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

<title>My JSP 'info.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<h2>${forum.title }</h2>
	description: ${forum.description }
	<br />
	<br /> all topics:
	<br />
	<%-- <form:form action="${topicBasePath }" method="DELETE" modelAttribute="topicsForm"> --%>
	<ul>
		<c:forEach var="topic" items="${forum.topics }" varStatus="status">
			<li>
			<%-- <form:checkbox path="[${status.index }].selected"/> --%>
			<a href="${topicBasePath }${topic.id}">${topic.title }</a>
			<a href="${userBasePath }${topic.user.id}">${topic.user.username }</a>
			<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${topic.createTime }" />
			<span>(${topic.clicks } clicks, ${fn:length(topic.replies)  } replies)</span>  
			<a href="${topicBasePath }${topic.id}/delete">delete</a>
			</li>
		</c:forEach>
	</ul>
	<%-- </form:form> --%>
	<c:if test="${crtUser != null }">
		<jsp:include page="/WEB-INF/pages/topic/new.jsp" />
	</c:if>
</body>
</html>
