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
	all forums:<br/>
	<ul>
		<c:forEach var="forum" items="${forums }">
			<li> 
			<a href="${forumBasePath }${forum.id}">${forum.title }</a> 
			${fn:length(forum.topics)} topic(s) 
			<a href="${forumBasePath }${forum.id}/delete">delete</a>
			
			</li>
		</c:forEach>
	</ul>
	<c:if test="${crtUser != null }">
		<jsp:include page="/WEB-INF/pages/forum/new.jsp" />
	</c:if>
</body>
</html>
