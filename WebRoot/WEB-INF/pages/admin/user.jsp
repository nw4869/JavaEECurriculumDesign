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
        	
        	function setupRoleModal(userId, role, forumIds) {
        		/* console.log('userid: ' + userId + ' role: ' + role + ' forumIds: ' + forumIds); */
        		// 初始化表单userid
        		$("#roleAdminForm input[name='userId']").val(userId);
        		// 初始化权限
        		switch (role) {
        		case 1:
        			$("#roleAdmin").prop("checked", true);
        			break;
        		case 2:
        			$("#roleForumAdmin").prop("checked", true);
        			
        			break;
        		default:
        			$("#roleUser").prop("checked", true);
        			break;
        		}
        		
        		// 初始化论坛选项
        		var forumIdsArray = forumIds.trim().split(" ");  
        		$("#roleForumSelect option").each(function(i, item) {
        			for (var j = 0; j < forumIdsArray.length; j++) {
        				if ($(item).val() == forumIdsArray[j]) {
        					$(item).prop("selected", true);
        					break;
        				} else {
        					$(item).prop("selected", false);
        				}
        			}
        		});
        		
        		// 设置表单提交地址
        		$("#roleAdminForm").prop("action", "admin/user/" + userId + "/role");
        	}
        	
        	function submitRoleForm() {
        		var userId = $("#roleAdminForm input[name='userId']").val();
        		var role = $("#roles :checked").val();
        		var forumIds = $("#roleForumSelect").val() || [];
	        	$.ajax({
	        		method:	"POST",
	        		url:	"admin/user/" + userId + "/role",
	        		data:	{userId: userId, role: role, forumIds: forumIds},
	        		async:	false,
	        	})
		        	.done(function(html) {
		        		if (html === 'success') {
		        			$("#myModal").modal('toggle');
		        			$("#message").append('<div class="alert alert-success alert-dismissible" role="alert"> <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button> 修改权限成功 </div>');
		        			
		        			var roleDisplay = role;
		        			if (role === 'ROLE_ADMIN') {
		        				roleDisplay = '系统管理员';
		        			} else if (role === 'ROLE_USER') {
		        				roleDisplay = '普通用户';
		        			} else if (role === 'ROLE_FORUM_ADMIN') {
		        				roleDisplay = '论坛管理员 ' + forumIds.toString();
		        			}
		        			$("#adminTable td[name='idDisplay']").filter(function(i){ return $(this).text() == userId; } ).parent().find("td[name='roleDisplay']").text(roleDisplay);
		        		} else {
		        			$("#myModal div.modal-body").append("failed");	        		
		        		}
		        	})
		        	.fail(function(html) {
	        			$("#myModal div.modal-body").append("failed");
		        	})
        	}
        </script>

    </head>


    <body>


            <!-- 模态框（Modal） -->
            <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel">
                      修改权限
                    </h4>
                        </div>
                        <div class="modal-body">
                            <form id="roleAdminForm" >
                            	<div class="row">
                            		<div id="roles" class="col-lg-4">
		                                <div class="radio">
		                                    <label>
		                                        <input type="radio" name="role" id="roleUser" value="ROLE_USER" checked> 普通用户
		                                    </label>
		                                </div>
		                                <div class="radio">
		                                    <label>
		                                        <input type="radio" name="role" id="roleAdmin" value="ROLE_ADMIN"> 系统管理员
		                                    </label>
		                                </div>
		                                <div class="radio">
		                                    <label>
		                                        <input type="radio" name="role" id="roleForumAdmin" value="ROLE_FORUM_ADMIN"> 论坛管理员
		                                    </label>
		                                </div>
                            		</div>
                            		<div class="col-lg-8">
	                                    <select id="roleForumSelect" multiple class="form-control" style="width: 100%;">
	                                    	<c:forEach var="forum" items="${forums }">
	                                    		<option value="${forum.id }">${forum.title }</option>
	                                    	</c:forEach>
	                                    </select>
                            		</div>
                            	</div>
								<input type="hidden" name="userId" id="userId">
                            </form>


                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                            </button>
                            <button type="button" class="btn btn-primary" onclick="submitRoleForm()">
                                提交更改
                            </button>
                        </div>
                    </div>
                    <!-- /.modal-content -->
                </div>
                <!-- /.modal -->
            </div>

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
                    <form:form id="searchForm" class="form-inline" action="admin/user" modelAttribute="userForm" method="post">
                        <div class="form-group">
                            <label for="id">序号</label>
                            <form:input type="text" class="form-control" name="id" path="id" placeholder="id" />
                        </div>
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <form:input type="text" class="form-control" name="username" path="username" placeholder="username" />
                        </div>
                        <div class="form-group">
                            <label for="page">页码</label>
                            <input type="text" class="form-control" name="page" value="${page }">
                        </div>
                        <input type="hidden" name="maxRows" value="${maxRows }" />
                        <button type="submit" class="btn btn-default">Search</button>
                        <label>总记录数：${totalRows }</label>
                    </form:form>

                </div>

                <!-- Table -->
                <table id="adminTable" class="adminTable table table-striped">
                    <thead>
                        <tr>
                            <th style='text-align: center;'>序号</th>
                            <th>用户名</th>
                            <th>昵称</th>
                            <th>邮箱</th>
                            <th>启用</th>
                            <th>权限</th>
                            <th>创建时间</th>
                            <th>操作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td name="idDisplay" style="text-align: center;">${user.id}</td>
                                <td><a href="${userBasePath}${user.id}">${user.username}</a></td>
                                <td>${user.memberTitle}</td>
                                <td>${user.email}</td>
                                <td>${user.enabled}</td>
                                <td name="roleDisplay">
                                	<c:set var="role" value="0"/>
                                	<c:set var="forumIds" value=""/>
                               		<c:set var="forums" value="${AuthService.getAdminForums(user.id) }"/>
                                	<c:choose>
                                		<c:when test="${AuthService.isAdmin(user.id)}">
                                			系统管理员
                                			<c:set var="role" value="1"/>
                                		</c:when>
                                		<c:when test="${fn:length(forums) > 0 }">
                                			论坛管理员: 
                                			<c:forEach var="forum" items="${forums }">
                                				<c:set var="forumIds" value="${forumIds } ${forum.id }"/>
                                				<a href="${forumBasePath }${forum.id}">${forum.id }</a>
                                			</c:forEach>
                                			<c:set var="role" value="2"/>
                                		</c:when>
                                		<c:otherwise>
                                			普通用户
                                			<c:set var="role" value="0"/>
                                		</c:otherwise>
                                	</c:choose>
                                </td>
                                <td>${user.createTime}</td>
                                <td>
                                    <a href="${userBasePath}${user.id}/delete">
                                        <button type="button" class="btn btn-default">删除</button>
                                    </a>
                                    <a href="${adminBasePath}user/${user.id}/setStatus?enable=${user.enabled ? 'false' : 'true'}">
                                        <button type="button" class="btn btn-default">${user.enabled ? "停用" : "启用"}</button>
                                    </a>
                                    <button class="btn btn-default" data-toggle="modal" data-target="#myModal" 
                                    	onclick="setupRoleModal(${user.id}, ${role}, '${forumIds }')">权限</button>
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