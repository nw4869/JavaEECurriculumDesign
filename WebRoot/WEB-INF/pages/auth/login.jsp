<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />

<html>
<head>
<title>Login</title>

<meta name="nav_index" content="5">
<meta name="my_title" content="登录">
<meta name="my_description" content="成为大神从此刻开始">
</head>

<body>
	<div class="login-content">
		<div class="container">
		<div class="login-page">
			   <div class="account_grid">
			   <div class="col-md-6 login-left wow fadeInLeft" data-wow-delay="0.4s">
			  	 <h3>新 用 户</h3>
				 <p>通过创建一个帐户加入IT交流，与大神们直接沟通。</p>
				 <a class="acount-btn" href="${registerPath }">注                册</a>
			   </div>
			   <div class="col-md-6 login-right wow fadeInRight" data-wow-delay="0.4s">
			  	<h3>已 注 册 客 户</h3>
				<p>如果你已拥有一个账号，欢迎登陆</p>
				<form:form name='loginForm' modelAttribute="userForm"
		action="auth/login.do" method='POST'>
				  <div>
					<span>账  号<label>*</label></span>
					<form:input id="username" name="username" path="username" />
					<form:errors path="username" />
				  </div>
				  <div>
					<span>密  码<label>*</label></span>		
					<form:password id="password" name="password" path="password" />
					<form:errors path="password" />
				  </div>
				  <a class="forgot" href="#">忘记密码?</a>
				  <input type="submit" value="登 陆">
				  <input type="hidden" value="${referer }" name="referer">
			    </form:form>
			   </div>	
			   <div class="clearfix"> </div>
			 </div>
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