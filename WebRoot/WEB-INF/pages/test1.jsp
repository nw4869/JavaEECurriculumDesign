<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />
<c:set var="title" value="热帖" />
<c:set var="description" value="热热热" />
<c:set var="footer_info" value="My footer" />

<html>
<head>
<meta name="nav_index" content="1">
<meta name="my_title" content="${title}">
<meta name="my_description" content="${description }">
<title>test title</title>
</head>
<body>
${title == '热帖' }
	Hello World
    crtUser: ${crtUser.username}
    service: ${AuthService}
    <%-- isAdmin: ${AuthService.isAdmin(crtUser.id) } --%>
    isAdmin1: ${isAdmin }
    testBean: ${myTestBean }
    UserDAO: ${UserDAO }
    
    
                        <div class="alert alert-success alert-dismissible" role="alert">
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                            <span aria-hidden="true">&times;</span>
                        </button>
                        message
                    </div>
</body>
</html>