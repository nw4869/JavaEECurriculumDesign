<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <jsp:directive.include file="/WEB-INF/common/include.jsp" />

    <html>

    <head>
        <meta name="nav_index" content="0">
        <meta name="my_title" content="搜索">
        <meta name="my_description" content="帖子搜索">
        <title>帖子搜索</title>

    </head>

    <body>
        <div class="bolg-posts">
            <div class="container">
                <div class="blog">

                    <c:forEach var="topic" items="${topics }">

                        <div class="col-md-6 blog-top">
                            <div class="blog-in">
<!--                                 <a href="${topicBasePath }${topic.id}"><img src="images/b3.jpg" alt=" "></a> -->
                                <div class="blog-grid">
                                    <h3>
								<a href="${topicBasePath }${topic.id}">${topic.title }</a>
							</h3>
                                    <p>${fn:substring(topic.content, 0, 100) }</p>
                                    <a href="${topicBasePath }${topic.id}" class="more">更多</a>
                                    <div class="date">
                                        <span class="date-in"><i> </i> <fmt:formatDate
										pattern="yyyy-MM-dd HH:mm:ss" value="${topic.lastActiveTime }" /></span>
                                        <a href="${topicBasePath }${topic.id}" class="comments"><i></i>${fn:length(topic.replies) }</a>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                            <i class="black"> </i>
                        </div>

                    </c:forEach>


                    <div class="clearfix"></div>
                    <ul class="start">
                        <c:url value="topic/hot" var="prevPageurl">
                                <c:param name="page" value="${page - 1}"/>
                        </c:url>
                        <li><a href="${page > 1 ? prevPageurl : 'javascript:void(0);'}"><span class="prev">&lt;上一页</span></a></li>
                        <c:forEach var="i" begin="1" end="${pageCount }">
                            <c:url value="topic/hot" var="pageUrl">
                                <c:param name="page" value="${i}"/>
                            </c:url>
                            <li><a href="${pageUrl}">
                                <c:choose>
                                    <c:when test="${i == page}">
                                        <b>${i}</b>
                                    </c:when>
                                    <c:otherwise>
                                        ${i}
                                    </c:otherwise>
                                </c:choose>
                                </a></li>
                        </c:forEach>
                        
                        <c:url value="topic/hot" var="nextPageurl">
                                <c:param name="page" value="${page + 1}"/>
                        </c:url>
                        <li><a href="${page < pageCount ? nextPageurl : 'javascript:void(0);'}" class="next">下一页&gt;</a></li>
                    </ul>
                </div>
            </div>

        </div>



    </body>

    </html>