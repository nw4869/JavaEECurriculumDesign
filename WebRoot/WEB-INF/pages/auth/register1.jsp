<%@ page language="java" import="java.util.*" pageEncoding="US-ASCII"%>
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
    
    <title>Register</title>
    
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

	<form:form name='registerForm' modelAttribute="userForm"
		action="auth/register.do" method='POST'>
		<spring:bind path="username">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:label path="username">username</form:label>
				<form:input id="username" name="username" path="username" />
				<form:errors path="username" />
				<p/>
				<form:label path="password">password</form:label>
				<form:password id="password" name="password" path="password" />
				<form:errors path="password" />
				<p/>
				<label>password2</label>
				<input type="password" id="password2" name="password2"  />
				<br> <input type="submit" value="Submit" />
			</div>
		</spring:bind>
	</form:form>

  </body>
</html>
