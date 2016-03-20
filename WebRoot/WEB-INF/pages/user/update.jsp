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
    
    <title>My JSP 'update.jsp' starting page</title>
    
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
  
  
  Username: ${crtUser.username } <br>
  
	<form:form name='updateForm' modelAttribute="userForm"
		action="user/update.do" method='POST'>
		<spring:bind path="username">
			<div class="form-group ${status.error ? 'has-error' : ''}">
				<form:label path="email">email</form:label>
				<form:input id="email" name="email" path="email"  />
				<form:errors path="email" />
				<p/>
				<form:label path="signature">signature</form:label>
				<form:input id="signature" name="signature" path="signature"  />
				<form:errors path="signature" />
				<br> <input type="submit" value="Submit" />
			</div>
		</spring:bind>
	</form:form>


  </body>
</html>
