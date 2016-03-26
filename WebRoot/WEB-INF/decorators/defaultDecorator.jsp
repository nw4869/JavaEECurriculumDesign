<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title><decorator:title/> - BBS</title>
<base href="${homePath } ">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Hello World" />
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<!-- webfonts -->
<link href='http://fonts.useso.com/css?family=Ubuntu:300,400,500,700'
	rel='stylesheet' type='text/css'>
<!-- webfonts -->
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
<link href="css/nav.css" rel="stylesheet" type="text/css" media="all" />
<!-- start-smoth-scrolling -->
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
	});
</script>
<!-- end-smoth-scrolling -->
<decorator:head />
</head>

<body>
	<%-- <jsp:directive.include file="/WEB-INF/decorators/header.jsp" /> --%>
	<jsp:directive.include file="/WEB-INF/decorators/header.jsp"/>
	<%-- <decorator:getProperty property='body' /> --%>
	<decorator:body/>
	<jsp:directive.include file="/WEB-INF/decorators/footer.jsp" />
</body>

</html>