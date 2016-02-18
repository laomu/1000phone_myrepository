<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="com.luas.model.Tools"%>
<%@page import="java.util.List"%>
<%@page import="com.luas.model.ToolsType"%>
<%@page import="java.util.Map"%>
<%@page import="com.luas.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>兰文理网络技术共享平台</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!---- animated-css ---->
<link href="${pageContext.request.contextPath}/css/animate.css"
	rel="stylesheet" type="text/css" media="all">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/doclist.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/service_menus.css">
<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
<script>
	new WOW().init();
</script>
<!---- animated-css ---->
<!---- start-smoth-scrolling---->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/move-top.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/easing.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function($) {
		$(".scroll").click(function(event) {
			event.preventDefault();
			$('html,body').animate({
				scrollTop : $(this.hash).offset().top
			}, 1000);
		});
		$(".info").hide();
		$(".info:first").show();
		$(".doclisttitle").click(function() {
			//$(this+".info").slideToggle(slow);
			var ulinfos = $(".info");
			$.each(ulinfos, function() {
				if ($(this).is(":visible")) {
					$(this).slideUp("slow");
				}
			})
			$(this).next().slideToggle("slow");
		});
		$(".service_menus").hide();
		$(".service").click(function () {
			$(".service_menus").show("slow");
		});
		$(".service_menus").mouseleave(function () {
			$(".service_menus").hide("slow");
		});
	});
</script>
<script type="text/javascript">
	$(function() {
		var pull = $('#pull');
		menu = $('nav ul');
		menuHeight = menu.height();
		$(pull).on('click', function(e) {
			e.preventDefault();
			menu.slideToggle();
		});
		$(window).resize(function() {
			var w = $(window).width();
			if (w > 320 && menu.is(':hidden')) {
				menu.removeAttr('style');
			}
		});

	});
</script>
<!---- start-smoth-scrolling---->
<link href="${pageContext.request.contextPath}/css/style.css"
	rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script type="application/x-javascript">
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>

<!---//webfonts--->
<!----start-top-nav-script---->

<!----//End-top-nav-script---->
</head>
<body>
	<div class="bg">
		<!----- start-header---->
			<div id="home" class="header wow bounceInDown" data-wow-delay="0.4s">
					<div class="top-header">
						<div class="container">
						<div class="logo">
							<a href="${pageContext.request.contextPath}/player.jsp"><img src="${pageContext.request.contextPath}/images/logo.png" title="dreams" /></a>
						</div>
						<!----start-top-nav---->
						 <nav class="top-nav">
							<ul class="top-nav">
								<li><a href="${pageContext.request.contextPath}/index.jsp">首页</a></li>
								<li class="service"><a href="#" class="scroll">服务</a></li>
								<ul class="service_menus">
									<li><a href="${pageContext.request.contextPath}/deal/dealtoolslist.jsp">软件工具库</a></li>
									<li><a href="${pageContext.request.contextPath}/deal/dealdoclist.jsp">文档资料库</a></li>
									<li><a href="${pageContext.request.contextPath}/deal/dealvidiolist.jsp">视频教程库</a></li>
								</ul>
								<li><a href="#port" class="scroll">技术展望</a></li>
								<%
									Member member = (Member)session.getAttribute("LOGIN");
									if(member == null) {
								%>
								<li><a href="${pageContext.request.contextPath }/login.jsp">登录</a></li>
								<li><a href="${pageContext.request.contextPath }/regist.jsp">新用户注册</a></li>
								<%} else { %>
								<li><a href="#team" class="scroll"><%=member.getRealName() %>,欢迎您！</a></li>
								<li>[<a href="${pageContext.request.contextPath }/chgpasswd.jsp">修改登录密码</a>|<a href="${pageContext.request.contextPath }/perfectinfo.jsp">完善个人资料</a>]</li>
								<%} %>
							</ul>
							<a href="${pageContext.request.contextPath}/player.jsp" id="pull"><img src="${pageContext.request.contextPath}/images/menu-icon.png" title="menu" /></a>
						</nav>
						<div class="clearfix"> </div>
					</div>
				</div>
			</div>
			<!----- //End-header---->
		<!---- banner ---->
		<div class="banner wow fadeIn" data-wow-delay="0.5s">
			<div class="container">
				<div class="banner-info text-center">
					<h1>软件工具下载</h1>
					<br /> <span> </span>
					<p>
						这里给您提供了可以下载各种技术的软件工具资料<br /> 在这里，你可以选择适合自己开发的软件工具进行下载<br />
						跟着我们，一起开始学习吧....<br />
					</p>
				</div>
			</div>
		</div>
	</div>
	<!---- banner ---->

	<div class="clearfix"></div>

	<!--- portfolio ---->
	<div class="portfolio">
		<div class="portfolio-top">
			<div class="clearfix"></div>
			<div class="doclistbox">
				<div class="doclist">
					<%
						Map<ToolsType, List<Tools>> map = (Map<ToolsType, List<Tools>>) request.getAttribute("toolsMap");
						Set<Entry<ToolsType, List<Tools>>> entry = map.entrySet();

						Iterator it = entry.iterator();

						while (it.hasNext()) {
							Entry<ToolsType, List<Tools>> e = (Entry<ToolsType, List<Tools>>) it.next();

							ToolsType tt = e.getKey();
					%>
					<div class="doclisttitle">
						[文档类型]&nbsp;&nbsp;<%=tt.getTtName()%><span>点击展开列表</span>
					</div>
					<ul class="info">
						<%
							List<Tools> tlist = e.getValue();
								if (tlist != null && tlist.size() > 0) {
									for (int i = 0; i < tlist.size(); i++) {
										Tools tools = tlist.get(i);
						%>
						<li><%=tools.getTname()%><a
							href="${pageContext.request.contextPath }/deal/dealdownload.jsp?urlpath=<%=tools.getPath()%>">下载</a><span><%=tools.getPublishTime()%></span><span><%=tools.getManager().getRealName() %></span></li>
						<%
							}
								} else {
						%>
						<li>当前类型没有提供下载的文档，敬请期待...</li>
						<%} %>
					</ul>
					<%
						
						}
					%>
				</div>
			</div>
			<!---- portfolio-works ---->
		</div>
	</div>
	<!--- portfolio ---->
	<!---- team --->
	<div id="team" class="team-members">
		<div class="wrap">
			<div class="tm-head">
				<h3>我们强大的开发团队</h3>
				<p>超越自我，追求卓越，勇创一流，勇创新高</p>
			</div>
			<div class="tm-head-grids">
				<div class="tm-head-grid wow fadeInLeft" data-wow-delay="0.4s">
					<img
						src="${pageContext.request.contextPath}/images/ruhe.png"
						alt="">
					<h4>樊如贺</h4>
					<h5>需求总监</h5>
					<ul class="top-social-icons">
						<li><a class="twitter"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<li><a class="facebook"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<li><a class="pin"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="tm-head-grid wow fadeInLeft" data-wow-delay="0.4s">
					<img
						src="${pageContext.request.contextPath}/images/team-member1.jpg"
						alt="">
					<h4>李兴儒</h4>
					<h5>技术总监</h5>
					<ul class="top-social-icons">
						<li><a class="twitter"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<li><a class="facebook"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<li><a class="pin"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="tm-head-grid wow fadeInUp" data-wow-delay="0.4s">
					<img
						src="${pageContext.request.contextPath}/images/team-member2.jpg"
						alt="">
					<h4>李能燕</h4>
					<h5>项目经理</h5>
					<ul class="top-social-icons">
						<li><a class="twitter"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<li><a class="facebook"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<li><a class="pin"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="tm-head-grid wow fadeInRight" data-wow-delay="0.4s">
					<img
						src="${pageContext.request.contextPath}/images/team-member3.jpg"
						alt="">
					<h4>张凯峰</h4>
					<h5>业务经理</h5>
					<ul class="top-social-icons">
						<li><a class="twitter"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<li><a class="facebook"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<li><a class="pin"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<div class="clear"></div>
					</ul>
				</div>
				<div class="clearfix"></div>
			</div>
			<p class="team-info">你否定我的现在， 我决定我的未来， 你嘲笑我一无所有， 我可怜你总是等待，
				你可以轻视我们的年轻， 我们会证明， 这是谁的时代， 梦想是注定孤独的旅行， 路上少不了质疑和嘲笑， 但那又怎样， 哪怕遍体鳞伤，
				也要活的漂亮。</p>
		</div>
	</div>
	<!---- team --->
	<!---- contact --->
	<div id="contact" class="contact">
		<div class="container">
			<div class="contact-grids">
				<div class="col-md-6">
					<div class="contact-left wow fadeInRight" data-wow-delay="0.4s">
						<h3>联系我们</h3>
						<label>不要害羞, 给我们发送邮件! 我们会给你一个惊喜 :)</label>
						<div class="contact-left-grids">
							<div class="col-md-6">
								<div class="contact-left-grid">
									<p>
										<span class="c-mobi"> </span>15294157465
									</p>
									<p>
										<span class="c-twitter"> </span><a href="#">QQ:1007821300</a>
									</p>
									<p>
										<span class="c-pluse"> </span><a href="#">www.blackshield.com</a>
									</p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="contact-right-grid">
									<p>
										<span class="c-msg"> </span><a href="mailto:hello@dreams.com">QQ:1007821300</a>
									</p>
									<p>
										<span class="c-face"> </span><a href="#">facebook.com/laomu</a>
									</p>
									<p>
										<span class="c-pin"> </span><a href="#">pinterest.com/laomu</a>
									</p>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="contact-right wow fadeInLeft" data-wow-delay="0.4s">
						<form>
							<input type="text" class="text" value="账号..."
								onFocus="this.value = '';"
								onBlur="if (this.value == '') {this.value = '账号...';}">
							<input type="text" class="text" value="邮箱地址..."
								onFocus="this.value = '';"
								onBlur="if (this.value == '') {this.value = '邮箱地址...';}">
							<textarea value="Message" onFocus="this.value = '';"
								onBlur="if (this.value == '') {this.value = '消息';}">消息..</textarea>
							<input class="wow shake" data-wow-delay="0.3s" type="submit"
								value="发送消息" />
						</form>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!--- copy-right ---->
			<div class="copy-right text-center">
				<p>Copyright &copy; 2015.大乘集团 All rights reserved.</p>
				<script type="text/javascript">
					$(document).ready(function() {
						/*
						var defaults = {
							containerID: 'toTop', // fading element id
							containerHoverID: 'toTopHover', // fading element hover id
							scrollSpeed: 1200,
							easingType: 'linear' 
						};
						 */

						/* $().UItoTop({
							easingType : 'easeOutQuart'
						}); */

					});
				</script>
				<a href="#" id="toTop" style="display: block;"> <span
					id="toTopHover" style="opacity: 1;"> </span></a>
			</div>
			<!--- copy-right ---->
		</div>
	</div>
	<!---- contact --->
	<div style="display: none"></div>
</body>
</html>