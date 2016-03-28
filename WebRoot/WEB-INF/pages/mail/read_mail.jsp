<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <jsp:directive.include file="/WEB-INF/common/include.jsp" />

    <html>

    <head>
        <meta name="nav_index" content="4">
        <meta name="my_title" content="查看邮件邮件">
        <meta name="my_description" content="&nbsp;">
        <title><c:out value="${mail.title}"/> - 查看邮件</title>
    </head>

    <body>

        <div class="contact">
            <div class="container">
                <c:if test="${message != null}">
                    <c:out value="${message}"/>
                </c:if>
                <div class="map">
                    <div class="code-in">
                        <p class="smith"><c:out value="${mail.title }"/> <span><a href="${userBasePath}${mail.sender.id}"><c:out value="${mail.sender.username }"/></a></span><span><a href="${mailBasePath}${mail.id}/delete">删除</a></span></p>
                        <div class="clearfix"> </div>
                    </div>
                    <div class="comments-top-top">
                        <p class="men-it"><c:out value="${mail.content }"/> </p>
                        <div class="clearfix"> </div> 
                    </div>
                    <div class="contact-form">
                        <h4>快速回复</h4>
                        <form:form name='mailForm' modelAttribute="mailForm" action="mail/send" method='POST'> 
                            <form:hidden path="reciver.username" />
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