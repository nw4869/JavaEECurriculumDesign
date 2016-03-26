<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<jsp:directive.include file="/WEB-INF/common/include.jsp" />

<html>
<head>
<meta name="nav_index" content="5">
<meta name="my_title" content="注册">
<meta name="my_description" content="菜鸟起飞从这里开始">
<title>Register</title>

</head>
<body>
<div class="register-content">
	<div class="container">
		<div class="register">
			<form:form name='registerForm' modelAttribute="userForm"
		action="auth/register.do" method='POST'>
				<div class="register-top-grid">
					<h3>个人信息</h3>
					<div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>用户名 <label>*</label></span> <form:input id="username" name="username" path="username" />
				<form:errors path="username" />
					</div>
					<div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>邮箱<label>*</label></span> <form:input id="email" name="email" path="email" />
				<form:errors path="email" />
					</div>
<!-- 					<div class="wow fadeInRight" data-wow-delay="0.4s"> -->
<!-- 						<span>邮箱地址 <label>*</label></span> <input type="text"> -->
<!-- 					</div> -->
					<div class="clearfix"></div>
					<a class="news-letter" href="#"> <!-- <label class="checkbox"><input
							type="checkbox" name="checkbox" checked=""> <i> </i>注册通讯</label> -->
					</a>
				</div>
				<div class="register-bottom-grid">
					<h3>登 陆 信 息</h3>
					<div class="wow fadeInLeft" data-wow-delay="0.4s">
						<span>密 码 <label>*</label></span> <form:password id="password" name="password" path="password" />
				<form:errors path="password" />
					</div>
					<div class="wow fadeInRight" data-wow-delay="0.4s">
						<span>密码校验 <label>*</label></span> <input type="password">
					</div>
				</div>
			<div class="clearfix"></div>
			<!-- <div class="register-but"> -->
				<!-- <form> -->
					<input type="submit" value="注 册">
					<div class="clearfix"></div>
				<!-- </form> -->
			<!-- </div> -->
			</form:form>
		</div>
	</div>
</div>

<!-- #Testimonials -->
<div id="testimonialWrapper">
	<div class="container">
		<div class="row">
			<div class="col-md-2 col-md-offset-1">
				<div id="testimonialPicture"></div>
			</div>
			<div class="col-md-7 col-md-offset-1">
				<h2>我们的用户说...</h2>
				<h3>码农必备论坛，客服MM热情给力，论坛大牛多，很多问题都能得到解决。</h3>
				<h3>刚学习编程的时候，各种困难。身边没什么人可以请教，基本靠在这里请教大神，收获很多。</h3>
				<h3>
					<h3>对于搞IT的来说，CSDN就是个很好的去处，里面有很多大神帮热心的解决问题和分享自己的心得，学习了很多自己没见过或者遇到过的问题。</h3>
					<a href="#">Lorem ipsum - www.google.com</a>
			</div>
			<div class="clearfix"></div>
		</div>
	</div>
</div>
<!-- /#Testimonials -->
</body>
</html>