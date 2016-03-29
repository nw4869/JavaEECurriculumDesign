<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
    <jsp:directive.include file="/WEB-INF/common/include.jsp" />

    <html>

    <head>
        <meta name="nav_index" content="5">
        <meta name="my_title" content="UserAdmin">
        <meta name="my_description" content="用户管理">
        <title>UserAdmin</title>

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
        	$(function(){
        		var currentPage = parseInt($("nav > ul > li.active > a").text());
        		var currentIndex = -1;
        		var count = $("nav > ul.pagination > li").size() - 2;
        		
        		$("nav > ul > li").each(function(i){
        			if ($(this).is("nav > ul > li.active")) {
        				currentIndex = i;
        				return false;
        			}
        		});
        		
        		console.log("currentIndex: " + currentIndex + " currentPage: " + currentPage + " count: " + count);
        		
        		var pageInput = $("#searchForm  input[name='page']");
        		
        		if (currentIndex > 1) {
        			var previousBtn = $("nav > ul > li > a").first();
        			previousBtn.parent().removeClass("disabled");
        			previousBtn.click(function(){
	        			pageInput.val(currentPage-1);
	        			$("#searchForm").submit();
        			});
       			}
       			if (currentIndex < count) {
       				var nextBtn = $("nav > ul > li > a").last();
        			nextBtn.parent().removeClass("disabled");
        			nextBtn.click(function() {
	        			pageInput.val(currentPage+1);
	        			$("#searchForm").submit();
        			});
       			}
        		
        		$("nav > ul > li > a").each(function(i) {
	        		if (i > 0 && i <= count) {
	        			$(this).click(function() {
		        			pageInput.val($(this).text());
			        		console.log("to page: " + pageInput.val());
			        	 	$("#searchForm").submit();
	        			});
	        		}
        		});
        	});
        
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
                <div class="panel-heading">用户管理</div>
                <div class="panel-body">
                    <form:form id="searchForm" class="form-inline" action="admin/user" modelAttribute="userForm" method="get">
                        <div class="form-group">
                            <label for="id">序号</label>
                            <form:input type="text" class="form-control" name="id" path="id" placeholder="id"/>
                        </div>
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <form:input type="text" class="form-control" name="username" path="username" placeholder="username"/>
                        </div>
                        <div class="form-group">
	                        <label for="page">页码</label>
	                        <input type="text" class="form-control" name="page" value="${page }">
                        </div>
                        <input type="hidden" name="maxRows" value="${maxRows }"/>
                        <button type="submit" class="btn btn-default">Search</button>
                    </form:form>

                </div>

                <!-- Table -->
                <table class="adminTable table table-striped">
                    <thead>
                        <tr>
                            <th style='text-align: center;'>序号</th>
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
                                <td style="text-align: center;">${user.id}</td>
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