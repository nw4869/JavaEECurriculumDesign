<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <jsp:directive.include file="/WEB-INF/common/include.jsp" />

    <html>

    <head>

        <meta name="nav_index" content="3">
        <meta name="my_title" content="${topic.title} - 修改话题">
        <meta name="my_description" content="&nbsp;">
        <title>${topic.title} - 修改话题</title>
    </head>

    <body>


        <div class="hd-content">
            <div class="container">

                <c:if test="${crtUser != null}">

                    <div class="leave">
                        <h3>修改话题</h3>
                        <form:form name='topicForm' modelAttribute="topicForm" action="topic/${topicForm.id}/update" method='POST'>
                            <div class="single-grid">
                                <div class="col-md-6 single-us">
                                    <form:input id="title" name="title" path="title" />
                                    <form:errors path="title" />
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="single-grid">
                                <div class="col-md-6 single-us">
                                    内容
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="text-top">
                                <div class="col-md-8 text-in">
                                    <form:textarea id="content" name="content" path="content" />
                                    <form:errors path="content" />
                                </div>
                                <div class="col-md-4 text-in">
                                    <input type="submit" value="提交">
                                </div>
                                <div class="clearfix"> </div>
                            </div>

                            <form:hidden path="forum.id" />
                        </form:form>

                    </div>
                </c:if>


            </div>



            <div class="space"></div>


        </div>
    </body>

    </html>