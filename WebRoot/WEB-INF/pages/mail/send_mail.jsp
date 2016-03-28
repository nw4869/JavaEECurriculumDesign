<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />

<html>

<head>
<meta name="nav_index" content="4">
<meta name="my_title" content="发送邮件">
<meta name="my_description" content="&nbsp;">
<title>inbox</title>
</head>

<body>

	<div class="contact">
		<div class="container">
			<div class="map">

				<div class="contact-form">
					<h4>发送邮件</h4>
					<c:if test="${message != null}">
							<c:out value="${message }" />
					</c:if>
					<form:form name='mailForm' modelAttribute="mailForm" action="mail/send" method='POST'>
						<form:label path="reciver.username">收件人</form:label><form:errors path="reciver.username" /><br/>
						<form:input id="reciver.username" name="reciver.username" path="reciver.username" />
                        <br>
                        <form:label path="title">标题</form:label><form:errors path="title" /><br/>
						<form:input id="title" name="title" path="title" />
                        <br/>
                        <form:label path="content">内容</form:label><form:errors path="content" /><br/>
    					<form:textarea id="content" name="content" path="content" />
						<input type="submit" value="发送">
					</form:form>
				</div>

			</div>
		</div>
	</div>
</body>

</html>
