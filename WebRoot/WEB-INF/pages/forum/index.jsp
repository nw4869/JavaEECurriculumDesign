<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

    <jsp:directive.include file="/WEB-INF/common/include.jsp" />

    <html>

    <head>
        
<meta name="nav_index" content="3">
<meta name="my_title" content="话题分类">
<meta name="my_description" content="&nbsp;">
        <title>话题分类</title>
    </head>
    <!-- Header Starts Here -->

    <body>

        <div class="hd-content">
            <div class="container">

                <!-- dedicated servers -->
                <div id="dedicated_servers">
                    <div class="services-bottom">
                        <div class="ds_processor">论坛</div>
                        <div class="ds_ram">主题</div>
                        <div class="ds_cores">|</div>
                        <div class="ds_diskspace">回复</div>
                        <div class="ds_bandwidth">|</div>
                        <div class="ds_price">最后张贴信息</div>
                        <div class="ds_order"></div>
                        <div class="clearfix"></div>
                    </div>
                    <c:forEach var="forum" items="${forums}" varStatus="status">
                        <div class="ds">
                            <div class="ds_processor"><a href="${forumBasePath }${forum.id}">${forum.title }</a></div>
                            <div class="ds_ram">${fn:length(forum.topics)}</div>
                            <div class="ds_cores">|</div>
                            <div class="ds_diskspace">${repliesCountList[status.index]}</div>
                            <div class="ds_bandwidth">|</div>
                            <div class="ds_price">
                                <c:choose>
                                    <c:when test="${lastActiveTimeList[status.index] != null}">
                                        <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${lastActiveTimeList[status.index]}" />
                                    </c:when>
                                    <c:otherwise>
                                        -
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="ds_order">
                                <a href="${forumBasePath }${forum.id}" class="button">发帖</a>
                                <c:if test="${isAdmin }">
                                    <a href="${forumBasePath }${forum.id}/delete" class="button">删除</a>
                                </c:if>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </c:forEach>
                </div>

                <div class="clearfix"></div>



                <div class="clearfix"> </div>

                <c:if test="${message != null }">
                    <div>
                        message: ${message }
                    </div>
                </c:if>

                <c:if test="${isAdmin }">

                    <div class="leave">
                        <h3>新建论坛</h3>
                        <form:form name='form' modelAttribute="forumForm" action="forum/new" method='POST'>
                            <div class="single-grid">
                                <div class="col-md-6 single-us">
                                    <form:input id="title" name="title" path="title" />
                                    <form:errors path="title" />
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="single-grid">
                                <div class="col-md-6 single-us">
                                    描述
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                            <div class="text-top">
                                <div class="col-md-8 text-in">
                                    <form:textarea id="description" name="description" path="description" />
                                    <form:errors path="description" />
                                </div>
                                <div class="col-md-4 text-in">
                                    <input type="submit" value="提交">
                                </div>
                                <div class="clearfix"> </div>
                            </div>
                        </form:form>

                    </div>
                </c:if>

            </div>



            <div class="space"></div>


        </div>

    </body>

    </html>