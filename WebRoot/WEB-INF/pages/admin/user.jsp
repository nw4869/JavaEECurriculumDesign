<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <jsp:directive.include file="/WEB-INF/common/include.jsp" />

    <html>

    <head>
        <meta name="nav_index" content="5">
        <meta name="my_title" content="UserAdmin">
        <meta name="my_description" content="用户管理">
        <title>UserAdmin</title>
        <style>

        </style>
    </head>

    <body>

        <div class="container">
            <div id="message" style="margin-top: 20px;">   
                <c:if test="${ message != null}">
                    <div class="alert alert-success alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                        ${message}
                    </div>
                </c:if>
            </div>

            <div class="panel panel-default" style="margin-top: 20px;">
                <!-- Default panel contents -->
                <div class="panel-heading">用户管理</div>
                <div class="panel-body">
                    <form class="form-inline">
                        <div class="form-group">
                            <label for="id">id</label>
                            <input type="text" class="form-control" id="id" placeholder="id">
                        </div>
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input type="text" class="form-control" id="username" placeholder="username">
                        </div>
                        <button type="submit" class="btn btn-default">Search</button>
                    </form>

                </div>

                <!-- Table -->
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>序号</th>
                            <th>用户名</th>
                            <th>昵称</th>
                            <th>邮箱</th>
                            <th>可用</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td scope="row">${user.id}</td>
                                <td><a href="${userBasePath}${user.id}">${user.username}</a></td>
                                <td>${user.memberTitle}</td>
                                <td>${user.email}</td>
                                <td>${user.enabled}</td>
                                <td>${user.createTime}</td>
                                <td>
                                    <a href="${userBasePath}${user.id}/delete">
                                        <button type="button" class="btn btn-default">删除</button>
                                    </a>
                                    <a href="${userBasePath}${user.id}/setStatus?enable=${user.enabled ? 'false' : 'true'}">
                                        <button type="button" class="btn btn-default">${user.enabled ? "停用" : "启用"}</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

    </body>

    </html>