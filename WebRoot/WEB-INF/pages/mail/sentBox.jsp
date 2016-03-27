<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="/WEB-INF/common/include.jsp" />

<html>

<head>
<meta name="nav_index" content="4">
<meta name="my_title" content="发件箱">
<meta name="my_description" content="&nbsp;">
<title>inbox</title>
</head>

<body>

	<div class="hd-content">
		<div class="container">

			<!-- dedicated servers -->
			<div id="dedicated_servers">
				<div class="services-bottom">
					<div class="ds_ram">收件人</div>
					<div class="ds_processor">标题</div>
					<div class="ds_cores">&nbsp;</div>
					<div class="ds_diskspace">时间</div>
					<div class="ds_bandwidth">状态</div>
					<div class="ds_price">回复</div>
					<div class="ds_order">&nbsp;</div>
					<div class="clearfix"></div>
				</div>
				<c:forEach var="mail" items="${mails }">
					<div class="ds">
						<div class="ds_ram">${mail.reciver.username }</div>
						<div class="ds_processor">
							<a href="${mailBasePath }${mail.id}">${mail.title }</a>
						</div>
						<div class="ds_cores">&nbsp;</div>
						<div class="ds_diskspace">${mail.sendTime }</div>
						<div class="ds_bandwidth">${mail.read ? "已读" : "未读" }</div>
						<div class="ds_price">
							<a href="${mailBasePath }${mail.id}/reply" class="button">回复</a>
						</div>
						<div class="ds_order">
							<a href="${mailBasePath }${mail.id}/delete" class="button">删除</a>
						</div>
						<div class="clearfix"></div>
					</div>
				</c:forEach>

				<div class="clearfix"></div>
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
				<div class="leave">
					<form>
						<div class="text-top">
							<div class="clearfix"></div>
						</div>
					</form>

				</div>
			</div>



			<div class="space"></div>


		</div>
	</div>

</body>

</html>
