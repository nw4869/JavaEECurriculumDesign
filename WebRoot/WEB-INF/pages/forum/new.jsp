<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<fmt:setBundle basename="bundles.auth-resources"/>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'new.jsp' starting page</title>
    
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
  
  
  <c:if test="${message != null }">
  <div>
  message: ${message }
  </div>
  </c:if>
  
  
  new forum: <br>
  
	<form:form name='form' modelAttribute="forumForm"
		action="forum/new" method='POST'>
		<spring:bind path="title">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:label path="title">title</form:label>
				<form:input id="title" name="title" path="title"  />
				<form:errors path="title" />
				<p/>
				<form:label path="description">description</form:label>
				<form:input id="description" name="description" path="description"  />
				<form:errors path="description" />
				<br> <input type="submit" value="Submit" />
			</div>
		</spring:bind>
	</form:form>


  </body>
</html>
