<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 

<c:set var="homePath" value="${pageContext.request.contextPath }/" />
<c:set var="loginPath" value="${pageContext.request.contextPath }/auth/login"></c:set>
<c:set var="logoutPath" value="${pageContext.request.contextPath }/auth/logout"></c:set>
<c:set var="registerPath" value="${pageContext.request.contextPath }/auth/register"></c:set>
<c:set var="userBasePath" value="${pageContext.request.contextPath }/user/"></c:set>
<c:set var="forumBasePath" value="${pageContext.request.contextPath }/forum/"></c:set>
<c:set var="topicBasePath" value="${pageContext.request.contextPath }/topic/"></c:set>
<c:set var="replyBasePath" value="${pageContext.request.contextPath }/reply/"></c:set>
<c:set var="hotTopicPath" value="${pageContext.request.contextPath }/topic/hot"></c:set>
<c:set var="replyBasePath" value="${pageContext.request.contextPath }/reply/"></c:set>
<c:set var="mailBasePath" value="${pageContext.request.contextPath }/mail/"></c:set>
<c:set var="adminBasePath" value="${pageContext.request.contextPath }/admin/"></c:set>

<%-- <c:set var="title" value="My Title"/> --%>