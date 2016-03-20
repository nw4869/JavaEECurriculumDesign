<%@ page language="java" isELIgnored="false" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/sitemesh-decorators/include.jsp"/>
<%-- <fmt:setBundle basename="bundles.application-resources"/> --%>
<fmt:setBundle basename="bundles.auth-resources"/>
    
<c:choose>
	<c:when test="${crtUser == null }">
		<div class="right"><a class="button" href="auth/login.do"><span><fmt:message key="navigation.login"/></span></a></div>
		<div class="right"><a class="button" href="auth/register.do"><span><fmt:message key="navigation.register"/></span></a></div>
	</c:when>
	<c:otherwise>
		<div class="right"><a class="button" href="auth/logout.do"><span><fmt:message key="navigation.logout"/></span></a></div>
	</c:otherwise>
</c:choose>
