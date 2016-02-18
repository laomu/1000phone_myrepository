<%@page import="com.luas.model.Member"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="com.luas.model.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.luas.model.CourseType"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>黑盾网络在线信息交互平台</title>
		<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' />
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
		 <!-- Custom Theme files -->
		 <!---- animated-css ---->
		<link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet" type="text/css" media="all">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/vidio.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/service_menus.css">
		<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
		<script>
		 new WOW().init();
		</script>
		<!---- animated-css ---->
		  <!---- start-smoth-scrolling---->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/move-top.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/easing.js"></script>
		<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
				});
				$(".vidioitem").mouseover(function() {
					$(".vidioitem").css({ "border":"#bbb solid 1px"});
					$(this).css({"border":"#3D8CC9 solid 1px"});
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
		 <!---- start-smoth-scrolling---->
		<link href="${pageContext.request.contextPath}/css/style.css" rel='stylesheet' type='text/css' />
   		 <!-- Custom Theme files -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

		<!---//webfonts--->
		<!----start-top-nav-script---->
		<script>
			$(function() {
				var pull 		= $('#pull');
					menu 		= $('nav ul');
					menuHeight	= menu.height();
				$(pull).on('click', function(e) {
					e.preventDefault();
					menu.slideToggle();
				});
				$(window).resize(function(){
	        		var w = $(window).width();
	        		if(w > 320 && menu.is(':hidden')) {
	        			menu.removeAttr('style');
	        		}
	    		});
				$("moreinfo").hide();
				$(".more").click(function() {
					$(this).parent().parent().next().slideToggle("slow");
				});
				
				//$(".vidiolist").hide();
				//$(".vidiolist:first").show();
				$(".vidiotitle").mouseover(function() {
					$(this).css({"background-color":"#069"});
				});
				$(".vidiotitle").mouseleave(function() {
					$(this).css({"background-color":"#3D8CC9"});
				});
				/*$(".vidiotitle").click(function() {
					var list = $(".vidiolist");
					$.each(list, function() {
						if($(this).is(":visible")) {
							$(this).slideUp("slow");
						}
					});
					$(this).next().slideToggle("slow");
				});*/
			});
		</script>
		<!----//End-top-nav-script---->
	</head>
	<body>
		<div class="bg">
		<!----- start-header---->
			<div id="home" class="header wow bounceInDown" data-wow-delay="0.4s">
					<div class="top-header">
						<div class="container">
						<div class="logo">
							<a href="#"><img src="${pageContext.request.contextPath}/images/logo.png" title="dreams" /></a>
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
							<a href="#" id="pull"><img src="${pageContext.request.contextPath}/images/menu-icon.png" title="menu" /></a>
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
						<h1>视频课程下载</h1><br />
						<span> </span>
						<p>这里给您提供了可以下载各种技术的课程视频资料<br />
							在这里，你可以选择自己有兴趣的技术的视频课程进载学习<br />
							跟着我们，一起开始学习吧....<br />
						</p>
					</div>
				</div>
			</div>
		</div>
			<!---- banner ---->

			<div class="clearfix"> </div>

			<!--- portfolio ---->
			<div class="portfolio">
				<div class="portfolio-top">

					<div class="clearfix"> </div>
					<div class="tm-head">
						<h3>视频课程库</h3>
						<p>超越自我，追求卓越，勇创一流，勇创新高</p>
					</div>
					
					<%
						Map<CourseType, List<Course>> courseMap =(Map<CourseType, List<Course>>) request.getAttribute("courseMap");
						
						Set<Entry<CourseType, List<Course>>> courseType = courseMap.entrySet();
						
						Iterator it = courseType.iterator();
						
						while(it.hasNext()) {
							Entry<CourseType, List<Course>> entry = (Entry<CourseType, List<Course>>)it.next();
							CourseType ct = entry.getKey();
							List<Course> list = entry.getValue();
					%>
					<div class="vidiotitle">
						<span>[课程类型]&nbsp;&nbsp;<%=ct.getCtName() %></span>
						<span class="showbtn" style="float:right;margin-right:50px;font-size:12px;line-height:50px;">点击展开</span>
					</div>
					<!---- portfolio-works ---->
					<div class="vidiolist">
						<%
							if(list != null && list.size() > 0) {
								for(int i = 0; i < list.size(); i ++ ) {
									Course course = list.get(i);
						%>
						<div class="vidioitem">
							<div class="vidioimg">
								<img src="${pageContext.request.contextPath}/images/projectimg/HTML5.png"/>
							</div>
							<div class="vidioinfo">
								<div class="infotitle">
									<%=course.getCourseName() %>
								</div>
								<div class="infomsg">
									上传于：<%=course.getPublishTime() %><br />
									<%if(course.getCdesc().length() > 10){
										out.print(course.getCdesc().substring(0,10) + "...");
									} else {out.print(course.getCdesc());} %>...<br />
									<a href="${pageContext.request.contextPath}/deal/dealplayer.jsp?courseid=<%=course.getCourseId()%>">立即点播</a>
								</div>
							</div>
						</div>
						<%} }else { %>
							<div class="vidioitem" style="padding:20px;line-height:30px;">当前类型中没有课程视频<br />敬请期待...</div>
						<%} %>
						<div style="clear:both"></div>
					</div>
					<%} %>
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
								<img src="${pageContext.request.contextPath}/images/team-member1.jpg" alt="">
								<h4>李兴儒</h4>
								<h5>技术总监</h5>
								<ul class="top-social-icons">
									<li><a class="twitter" href="#"> </a></li>
									<li><a class="facebook" href="#"> </a></li>
									<li><a class="pin" href="#"> </a></li>
									<div class="clear"> </div>
								</ul>
							</div>
							<div class="tm-head-grid wow fadeInUp" data-wow-delay="0.4s">
								<img src="${pageContext.request.contextPath}/images/team-member2.jpg" alt="">
								<h4>Rico Massimo</h4>
								<h5>Coder</h5>
								<ul class="top-social-icons">
									<li><a class="twitter" href="#"> </a></li>
									<li><a class="facebook" href="#"> </a></li>
									<li><a class="pin" href="#"> </a></li>
									<div class="clear"> </div>
								</ul>
							</div>
							<div class="tm-head-grid wow fadeInRight" data-wow-delay="0.4s">
								<img src="${pageContext.request.contextPath}/images/team-member3.jpg" alt="">
								<h4>Uku Mason</h4>
								<h5>Graphic Designer</h5>
								<ul class="top-social-icons">
									<li><a class="twitter" href="#"> </a></li>
									<li><a class="facebook" href="#"> </a></li>
									<li><a class="pin" href="#"> </a></li>
									<div class="clear"> </div>
								</ul>
							</div>
							<div class="clearfix"> </div>
						</div>
						<p class="team-info">
							你否定我的现在，
							我决定我的未来，
							你嘲笑我一无所有，
							我可怜你总是等待，
							你可以轻视我们的年轻，
							我们会证明，
							这是谁的时代，
							梦想是注定孤独的旅行，
							路上少不了质疑和嘲笑，
							但那又怎样，
							哪怕遍体鳞伤，
							也要活的漂亮。
						</p>
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
										<p><span class="c-mobi"> </span>15294157465</p>
										<p><span class="c-twitter"> </span><a href="#">QQ:1007821300</a></p>
										<p><span class="c-pluse"> </span><a href="#">www.blackshield.com</a></p>
									</div>
								</div>
								<div class="col-md-6">
									<div class="contact-right-grid">
										<p><span class="c-msg"> </span><a href="mailto:hello@dreams.com">QQ:1007821300</a></p>
										<p><span class="c-face"> </span><a href="#">facebook.com/laomu</a></p>
										<p><span class="c-pin"> </span><a href="#">pinterest.com/laomu</a></p>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
					<div class="col-md-6">
						<div class="contact-right wow fadeInLeft" data-wow-delay="0.4s">
							<form>
								<input type="text" class="text" value="账号..." onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '账号...';}">
					 			<input type="text" class="text" value="邮箱地址..." onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '邮箱地址...';}">
					 	 		<textarea value="Message" onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '消息';}">消息..</textarea>
								<input class="wow shake" data-wow-delay="0.3s" type="submit" value="发送消息" />
							</form>
						</div>
					</div>
					<div class="clearfix"> </div>
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
										
										$().UItoTop({ easingType: 'easeOutQuart' });
										
									});
								</script>
									<a href="#" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
				</div>
				<!--- copy-right ---->
			</div>
			<!---- contact --->
		</div>
<div style="display:none"></div>
</body>
</html>