<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <jsp:directive.include file="/WEB-INF/common/include.jsp" />

    <html>

    <head>

        <meta name="nav_index" content="3">
        <meta name="my_title" content="${forum.title}">
        <meta name="my_description" content="${forum.description}">
        <title>${forum.title}</title>
    </head>

    <body>


        <div class="hd-content">
            <div class="container">

                <!-- dedicated servers -->
                <div id="dedicated_servers">
                    <div class="services-bottom">
                        <div class="ds_processor">全部主题</div>
                        <div class="ds_ram">作者</div>
                        <div class="ds_cores">发帖时间</div>
                        <div class="ds_diskspace">回复/查看</div>
                        <div class="ds_bandwidth">最后发表</div>
                        <div class="ds_price">发表时间</div>
                        <div class="ds_order"></div>
                        <div class="clearfix"></div>
                    </div>
                    <c:forEach var="topic" items="${forum.topics }" varStatus="status">
                        <div class="ds">
                            <div class="ds_processor"><a href="${topicBasePath }${topic.id}">${topic.title }</a></div>
                            <div class="ds_ram"><a href="${userBasePath }${topic.user.id}">${topic.user.username }</a></div>
                            <div class="ds_cores">
                                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${topic.createTime }" />
                            </div>
                            <div class="ds_diskspace">${fn:length(topic.replies) }/${topic.clicks }</div>
                            <div class="ds_bandwidth">${topic.lastActiveUser.username }</div>
                            <div class="ds_price">
                                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${topic.lastActiveTime }" />
                            </div>
                            <div class="ds_order">
                                <a href="${topicBasePath }${topic.id}" class="button">回复</a>
                                <c:if test="${isForumAdmin }">
                                    <a href="${topicBasePath }${topic.id}/delete" class="button">删除</a>
                                </c:if>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </c:forEach>

                </div>

                <div class="clearfix"></div>



                <div class="clearfix"> </div>
                <ul class="start">
                    <li><span class="prev">上一页</span></li>
                    <li><span>1</span></li>
                    <li><a href="#">2</a></li>
                    <li><a href="#">3</a></li>
                    <li><a href="#">4</a></li>
                    <li><a href="#">5</a></li>
                    <li><a href="#">6</a></li>
                    <li><a href="#">7</a></li>
                    <li><a href="#">8</a></li>
                    <li><span>.....</span></li>
                    <li><a href="#">12</a></li>
                    <li><a href="#" class="next">下一页</a></li>
                </ul>

                <c:if test="${crtUser != null}">

                    <div class="leave">
                        <h3>发表话题</h3>
                        <form:form name='topicForm' modelAttribute="topicForm" action="topic/save" method='POST'>
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