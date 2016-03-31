<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <jsp:directive.include file="/WEB-INF/common/include.jsp" />

    <html>

    <head>
        <meta name="nav_index" content="5">
        <meta name="my_title" content="TopicAdmin">
        <meta name="my_description" content="话题管理">
        <title>TopicAdmin</title>

        <style>
            .adminTable>thead>tr>th,
            .adminTable>tbody>tr>th,
            .adminTable>tfoot>tr>th,
            .adminTable>thead>tr>td,
            .adminTable>tbody>tr>td,
            .adminTable>tfoot>tr>td {
                vertical-align: middle;
            }
        </style>

        <script type="text/javascript">
        </script>

    </head>


    <body>


        <div class="container">
            <div id="message" style="margin-top: 20px;">
                <c:if test="${ message != null}">
                    <div class="alert alert-success alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        ${message}
                    </div>
                </c:if>
            </div>

            <div class="panel panel-default" style="margin-top: 20px;">
                <!-- Default panel contents -->
                <div class="panel-heading">话题管理</div>
                <div class="panel-body">
                    <form:form id="searchForm" class="form-inline" action="admin/topic" modelAttribute="topicForm" method="get">
                        <div class="form-group">
                            <label for="id">序号</label>
                            <form:input type="text" class="form-control" name="id" path="id" placeholder="id" />
                        </div>
                        <div class="form-group">
                            <label for="title">标题</label>
                            <form:input type="text" class="form-control" name="title" path="title" placeholder="title" />
                        </div>
                        <div class="form-group">
                            <label for="page">页码</label>
                            <input type="text" class="form-control" name="page" value="${page }">
                        </div>
                        <input type="hidden" name="maxRows" value="${maxRows }" />
                        <button type="submit" class="btn btn-default">Search</button>
                    </form:form>

                </div>

                <!-- Table -->
                <table id="adminTable" class="adminTable table table-striped">
                    <thead>
                        <tr>
                            <th style='text-align: center;'>序号</th>
                            <th>标题</th>
                            <th>作者</th>
                            <th>内容摘要</th>
                            <th>发帖时间</th>
                            <th>回复/查看</th>
                            <th>最后发表</th>
                            <th>发表时间</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="topic" items="${topics}">
                            <tr>
                                <td name="idDisplay" style="text-align: center;">${topic.id}</td>
                                <td><a href="${topicBasePath }${topic.id}">${fn:substring(topic.title, 0, 20) }</a></td>
                                <td><a href="${userBasePath }${topic.user.id}">${topic.user.username }</a></td>
                                <td class="col-xs-3">${fn:substring(topic.content, 0, 30) }</td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${topic.createTime }" /></td>
                                <td>${fn:length(topic.replies) }/${topic.clicks }</td>
                                <td>${topic.lastActiveUser.username }</td>
                                <td><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${topic.lastActiveTime }" /></td>
                                <td> <a href="${topicBasePath }${topic.id}/delete"><button type="button" class="btn btn-default">删除</button></a> </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <div class="panel-footer text-center">
                    <nav>
                        <ul class="pagination">
                            <li id="previous" class="disabled">
                                <a href="javascript:void(0);" aria-label="Previous"> <span aria-hidden="true">&laquo;</span> <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            <c:forEach var="i" begin="1" end="${pageCount }">
                                <li class="${page == i ? 'active' : ''}"><a href="javascript:void(0);">${i }</a></li>
                            </c:forEach>
                            <li id="next" class="disabled">
                                <a href="javascript:void(0);" aria-label="Next"> <span aria-hidden="true">&raquo;</span> <span class="sr-only">Next</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>


        </div>
    </body>

    </html>