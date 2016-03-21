<%@taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator"  %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%-- <% --%>
<%-- 	String __path = request.getContextPath(); --%>
<%-- 	String __basePath = request.getScheme() + "://" --%>
<%-- 			+ request.getServerName() + ":" + request.getServerPort() --%>
<%-- 			+ __path + "/"; --%>
<%-- %> --%>
<%-- <c:set var="_req" value="${pageContext.request }"/> --%>
<%-- <c:set var="_basePath" value="${_req.scheme}://${_req.serverName}:${_req.serverPort}${_req.contextPath}/" /> --%>
<c:set var="homePath" value="${pageContext.request.contextPath }/" />
<c:set var="loginPath" value="${pageContext.request.contextPath }/auth/login"></c:set>
<c:set var="logoutPath" value="${pageContext.request.contextPath }/auth/logout"></c:set>
<c:set var="registerPath" value="${pageContext.request.contextPath }/auth/register"></c:set>