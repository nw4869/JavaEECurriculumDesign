<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />

<div id="new_topic">

	<c:if test="${message != null }">
		<div>message: ${message }</div>
	</c:if>


	<div>new topic:</div>

	<div id="new_topic_form">
		<form:form name='replyForm' modelAttribute="replyForm"
			action="topic/${topic.id }/reply" method='POST'>
			<spring:bind path="title">
				<div class="form-group ${status.error ? 'has-error' : ''}">
					<form:label path="title">title</form:label>
					<form:input id="title" name="title" path="title" />
					<form:errors path="title" />
					<br />
					<form:label path="content">content</form:label>
					<form:input id="content" name="content" path="content" />
					<form:errors path="content" />
					<form:hidden path="topic.id" />
					<form:hidden path="user.id" />
					<br> <input type="submit" value="Submit" />
				</div>
			</spring:bind>
		</form:form>
	</div>
</div>
