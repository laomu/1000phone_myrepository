<%@page import="com.luas.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="admin/commons/service.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="gb2312" />
<title>兰文理网络技术共享平台</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- Custom Theme files -->
<!---- animated-css ---->
<link href="${pageContext.request.contextPath}/css/animate.css"
	rel="stylesheet" type="text/css" media="all">
<%-- <link href="${pageContext.request.contextPath}/css/service.css" rel="stylesheet" type="text/css" media="all"> --%>
<script src="${pageContext.request.contextPath}/js/wow.min.js"></script>
<%-- <script src="${pageContext.request.contextPath}/js/service.js"></script> --%>
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
	});
</script>
<!---- start-smoth-scrolling---->
<link href="${pageContext.request.contextPath}/css/style.css"
	rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/service_menus.css">
<!-- Custom Theme files -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	
	
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 


</script>
<!---//webfonts--->
<!----start-top-nav-script---->
<script>
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
		$(".service_menus").hide();
		$(".service").click(function () {
			$(".service_menus").show("slow");
		});
		$(".service_menus").mouseleave(function () {
			$(".service_menus").hide("slow");
		});
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
						<a href="${pageContext.request.contextPath}/player.jsp"><img
							src="${pageContext.request.contextPath}/images/logo.png"
							title="dreams" /></a>
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
								Member member = (Member) session.getAttribute("LOGIN");
								if (member == null) {
							%>
							<li><a href="${pageContext.request.contextPath }/login.jsp">登录</a></li>
							<li><a href="${pageContext.request.contextPath }/regist.jsp">新用户注册</a></li>
							<%
								} else {
							%>
							<li><a href="#team" class="scroll"><%=member.getRealName()%>,欢迎您！</a></li>
							<li>[<a
								href="${pageContext.request.contextPath }/chgpasswd.jsp">修改登录密码</a>|<a
								href="${pageContext.request.contextPath }/perfectinfo.jsp">完善个人资料</a>]
							</li>
							<%
								}
							%>
						</ul>
						<a href="${pageContext.request.contextPath}/player.jsp" id="pull"><img
							src="${pageContext.request.contextPath}/images/menu-icon.png"
							title="menu" /></a>
					</nav>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!----- //End-header---->
		<!---- banner ---->
		<div class="banner wow fadeIn" data-wow-delay="0.5s">
			<div class="container">
				<div class="banner-info text-center">
					<h1>把握人生，沟通未来</h1>
					<br /> <span> </span>
					<p>
						兰州文理学院第一个网络在线信息分享平台<br />拥有海量信息供您学习，加入我们吧！
					</p>
				</div>
			</div>
		</div>
	</div>
	<!---- banner ---->
	<!--- services --->
	<div id="services" class="services">
		<div class="container">
			<div class="service-head text-center">
				<h2>我们的服务</h2>
				<span> </span>
			</div>
			<!--- services-grids --->
			<div class="services-grids text-center">
				<div class="col-md-4">
					<div class="service-grid wow bounceIn" data-wow-delay="0.4s">
						<span class="service-icon1"> </span>
						<h3>
							<a href="${pageContext.request.contextPath}/deal/dealtoolslist.jsp">软件工具库</a>
						</h3>
						<p>专业团队打造适合各个阶段、不同受众的人群的学习计划，并由公司一线技术团队以及技术专家
							收集各方资料，充分实现您的学习计划私人订制！</p>
					</div>
				</div>
				<div class="col-md-4">
					<div class="service-grid wow bounceIn" data-wow-delay="0.4s">
						<span class="service-icon2"> </span>
						<h3>
							<a href="${pageContext.request.contextPath}/deal/dealdoclist.jsp">文档资料库</a>
						</h3>
						<p>找文档，找资料，找教程，你还在犯愁吗？这里有权威的一线工程师整理的各项最完善的、常用
							最流行技术的指导教程、文档、视频等，给您提供最贴心的服务！</p>
					</div>
				</div>
				<div class="col-md-4">
					<div class="service-grid wow bounceIn" data-wow-delay="0.4s">
						<span class="service-icon3"> </span>
						<h3>
							<a href="${pageContext.request.contextPath}/deal/dealvidiolist.jsp">视频教程库</a>
						</h3>
						<p>您在学习过程中，遇到任何疑问，可以在这里联系我们的专家帮您进行分析解答，
							第一时间给您回馈最完善的解决问题的思路和答案，充分享受学习的乐趣！</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!--- services-grids --->
		</div>
	</div>
	<!--- services --->
	<div class="clearfix"></div>
	<!--- Other Expertise ---->
	<div id="port" class="expertise">
		<div class="expertice-grids">
			<div class="col-md-8 expertice-left-grid wow fadeInLeft"
				data-wow-delay="0.4s">
				<div class="expertise-head">
					<h3>技术平台</h3>
					<p>这里是技术的殿堂，这里是艺术的海洋，在这里你将享受一场技术的SPA，在这里你将畅游艺术的海洋</p>
				</div>
				<div class="expertise-left-inner-grids">
					<div class="e-left-inner-grid">
						<div class="e-left-inner-grid-left">
							<span class="e-icon1"> </span>
						</div>
						<div class="e-left-inner-grid-right">
							<h4>Java WEB</h4>
							<p>Java
								Web，是用Java技术来解决相关web互联网领域的技术总和。web包括：web服务器和web客户端两部分。</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="e-left-inner-grid">
						<div class="e-left-inner-grid-left">
							<span class="e-icon2"> </span>
						</div>
						<div class="e-left-inner-grid-right">
							<h4>C#</h4>
							<p>C#是微软公司发布的一种面向对象的、运行于.NET
								Framework之上的高级程序设计语言。并定于在微软职业开发者论坛(PDC)上登台亮相。C#是微软公司研究员Anders
								Hejlsberg的最新成果。</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="e-left-inner-grid">
						<div class="e-left-inner-grid-left">
							<span class="e-icon3"> </span>
						</div>
						<div class="e-left-inner-grid-right">
							<h4>Python</h4>
							<p>Python的创始人为Guido van
								Rossum。1989年圣诞节期间，在阿姆斯特丹，Guido为了打发圣诞节的无趣，决心开发一个新的脚本解释程序，做为ABC
								语言的一种继承。</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="e-left-inner-grid">
						<div class="e-left-inner-grid-left">
							<span class="e-icon4"> </span>
						</div>
						<div class="e-left-inner-grid-right">
							<h4>C/C++</h4>
							<p>C++是在C语言的基础上开发的一种面向对象编程语言，应用广泛。C++支持多种编程范式
								－－面向对象编程、泛型编程和过程化编程。</p>
						</div>
						<div class="clearfix"></div>
					</div>
					<div class="clearfix"></div>
				</div>
				<a class="leran-more"
					href="${pageContext.request.contextPath}/player.jsp">查看更多</a>
			</div>
			<div class="col-md-4 expertice-right-grid wow fadeInRight"
				data-wow-delay="0.4s"></div>
			<div class="clearfix"></div>
		</div>
	</div>
	<!--- Other Expertise ---->
	<!--- portfolio ---->
	<div class="portfolio">
		<div class="portfolio-top">
			<div class="col-md-8">
				<div class="portfolio-top-left wow fadeInLeft" data-wow-delay="0.4s">
					<h3>前沿技术初窥</h3>
					<p>大数据的处理已经步入我们的生活中，云计算更是让每个人之间的距离变的更短，未来几年大数据和云计算将会是井喷式的发展。</p>
					<p>手机的实用已经进入我们的日常生活中，2015年年初统计，中国平均下来人手一部手机，所以手机端的开发将会是一个庞大的市场</p>
					<div class="portfolio-top-left-grids">
						<div class="portfolio-top-left-grid">
							<div class="portfolio-top-left-grid-left">
								<span class="p-icon1"> </span>
							</div>
							<div class="portfolio-top-left-grid-right">
								<h5>大数据——关于Hadoop那些事儿</h5>
								<p>大数据？数据有多大？多大的数据才算是大数据？</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="portfolio-top-left-grid">
							<div class="portfolio-top-left-grid-left">
								<span class="p-icon2"> </span>
							</div>
							<div class="portfolio-top-left-grid-right">
								<h5>苹果——还是苹果！apple!</h5>
								<p>从乔布斯第一次发布被咬了一个缺口的苹果开始，苹果被赋予了新的含义，在信息高速发展的今天，苹果系统中应用的开发又被赋予了新的意义——swift开发</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="portfolio-top-left-grid">
							<div class="portfolio-top-left-grid-left">
								<span class="p-icon3"> </span>
							</div>
							<div class="portfolio-top-left-grid-right">
								<h5>分布式云计算</h5>
								<p>双十一结束了，双十二还会远吗？淘宝以接近一千亿的销售额顺利度过双十一，那这些数据的背后，都蕴含着什么样的数据计算呢？</p>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4 portfolio-top-right-inner wow fadeInRight"
				data-wow-delay="0.4s">
				<div class="portfolio-top-right"></div>
			</div>
			<div class="clearfix"></div>
			<!---- portfolio-works ---->
			<div class="portfolio-works">
				<div class="col-md-4 portfolio-work-grid wow bounceIn"
					data-wow-delay="0.4s">
					<div class="portfolio-work-grid-pic">
						<img
							src="${pageContext.request.contextPath}/images/projectimg/MYSQL.png"
							title="name" />
					</div>
					<div class="portfolio-work-grid-caption">
						<h4>MySQL</h4>
						<p>MySQL[1] 是一个关系型数据库管理系统，由瑞典 MySQL AB 公司开发，目前属于 Oracle
							旗下公司。MySQL 最流行的关系型数据库管理系统，在 WEB 应用方面 MySQL 是最好的 RDBMS (Relational
							Database Management System，关系数据库管理系统) 应用软件之一。</p>
					</div>
				</div>
				<div class="col-md-4 portfolio-work-grid wow bounceIn"
					data-wow-delay="0.4s">
					<div class="portfolio-work-grid-pic">
						<img
							src="${pageContext.request.contextPath}/images/projectimg/HTML5.png"
							title="name" />
					</div>
					<div class="portfolio-work-grid-caption">
						<h4>HTML5</h4>
						<p>标准通用标记语言下的一个应用HTML标准自1999年12月发布的HTML4.01后，后继的HTML5和其它标准被束之高阁，为了推动Web标准化运动的发展，一些公司联合起来，成立了一个叫做
							Web Hypertext Application Technology Working Group （Web超文本应用技术工作组
							-WHATWG） 的组织。</p>
					</div>
				</div>
				<div class="col-md-4 portfolio-work-grid wow bounceIn"
					data-wow-delay="0.4s">
					<div class="portfolio-work-grid-pic">
						<img
							src="${pageContext.request.contextPath}/images/projectimg/JavaScript.png"
							title="name" />
					</div>
					<div class="portfolio-work-grid-caption">
						<h4>JavaScript</h4>
						<p>JavaScript一种直译式脚本语言，是一种动态类型、弱类型、基于原型的语言，内置支持类型。它的解释器被称为JavaScript引擎，为浏览器的一部分，广泛用于客户端的脚本语言，最早是在HTML（标准通用标记语言下的一个应用）网页上使用，用来给HTML网页增加动态功能。</p>
					</div>
				</div>
				<div class="col-md-4 portfolio-work-grid wow bounceIn"
					data-wow-delay="0.4s">
					<div class="portfolio-work-grid-pic">
						<img
							src="${pageContext.request.contextPath}/images/projectimg/Ajax.png"
							title="name" />
					</div>
					<div class="portfolio-work-grid-caption">
						<h4>Ajax</h4>
						<p>AJAX即“Asynchronous Javascript And
							XML”（异步JavaScript和XML），是指一种创建交互式网页应用的网页开发技术。通过在后台与服务器进行少量数据交换，AJAX
							可以使网页实现异步更新。这意味着可以在不重新加载整个网页的情况下，对网页的某部分进行更新。</p>
					</div>
				</div>
				<div class="col-md-4 portfolio-work-grid wow bounceIn"
					data-wow-delay="0.4s">
					<div class="portfolio-work-grid-pic">
						<img
							src="${pageContext.request.contextPath}/images/projectimg/Java%20WEB.png"
							title="name" />
					</div>
					<div class="portfolio-work-grid-caption">
						<h4>Java Web</h4>
						<p>用Java技术来解决相关web互联网领域的技术总和。web包括：web服务器和web客户端两部分。Java在客户端的应用有java
							applet，不过使用得很少，Java在服务器端的应用非常的丰富，比如Servlet，JSP和第三方框架等等。Java技术对Web领域的发展注入了强大的动力。</p>
					</div>
				</div>
				<div class="col-md-4 portfolio-work-grid wow bounceIn"
					data-wow-delay="0.4s">
					<div class="portfolio-work-grid-pic">
						<img
							src="${pageContext.request.contextPath}/images/projectimg/Java.png"
							title="name" />
					</div>
					<div class="portfolio-work-grid-caption">
						<h4>Java SE</h4>
						<p>Java SE 以前称为 J2SE。它允许开发和部署在桌面、服务器、嵌入式环境和实时环境中使用的 Java
							应用程序。Java SE 包含了支持 Java Web 服务开发的类，并为 Java Platform，Enterprise
							Edition（Java EE）提供基础</p>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
			<!---- portfolio-works ---->
		</div>
	</div>
	<!--- portfolio ---->
	<!---- about ---->
	<!---start-about---->
	<div class="about">
		<div class="wrap">
			<div class="about-head">
				<h1>关于我们</h1>
				<span> </span>
			</div>
			<!---start-about-time-line---->
			<div class="about-time-line">
				<li>
					<div class="cbp_tmicon img1"></div>
					<div class="cbp_tmlabel wow fadeInLeft" data-wow-delay="0.4s">
						<h2>党委书记 史百战</h2>
						<p>
							黑盾网络在线信息交流平台，于2015-12-01日启动，开发文理学院第一个网络在线信息共享平台<br />
							这里是你的地盘，这里是你的空间，这里有你的未来<br /> 我们的口号：良心做事，共享未来
						</p>
					</div>
				</li>
				<li>
					<div class="cbp_tmicon1 img2"></div>
					<div class="cbp_tmlabel cbp_tmlabel1 wow fadeInRight"
						data-wow-delay="0.4s">
						<h2>校长、党委副书记 汪建华</h2>
						<p>
							今天，我们的项目正式发布第一个版本<br /> 感谢支持我们的学院和同学<br /> 加入我们吧，我们携手将会做的更好
						</p>
					</div>
				</li>
				<br />
				<li>
					<div class="cbp_tmicon2 img3"></div>
					<div class="cbp_tmlabel wow fadeInLeft" data-wow-delay="0.4s">
						<h2>数字媒体学院院长 李恒杰</h2>
						<p>
							当智者拿起杖，当勇气拿起枪<br /> 异能者浅吟低唱，键盘上轻盈的舞蹈<br /> 我们将为自己的目标奋斗，直至彼岸他乡！<br />
							我们为自己代言，我们是黑盾成员！
						</p>
					</div>
				</li>
				<li>
					<div class="cbp_tmicon3 img4"></div>
					<div class="cbp_tmlabel cbp_tmlabel1 wow fadeInRight"
						data-wow-delay="0.4s">
						<h2>黑盾召集令</h2>
						<p>
							你还在因为没有目标而迷茫吗？<br /> 你还在为空负一身才学而无用武之地而烦恼吗？<br /> 来这里吧！<br />
							我们一起从这里腾飞！我们为自己代言
						</p>
					</div>
				</li>
				<li>
					<div class="cbp_tmicon4 img5"></div>
				</li>
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
		</div>
		<!---//End-about-time-line---->
		<!---- about ---->
	</div>
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
					<h5>技术经理</h5>
					<ul class="top-social-icons">
						<li><a class="twitter"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<li><a class="facebook"
							href="${pageContext.request.contextPath}/player.jsp"> </a></li>
						<li><a class="pin"
							href="http://wpa.qq.com/msgrd?v=3&uin=1158313953&site=qq&menu=yes"> </a></li>
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
										<span class="c-twitter"> </span><a
											href="${pageContext.request.contextPath}/player.jsp">QQ:1007821300</a>
									</p>
									<p>
										<span class="c-pluse"> </span><a
											href="${pageContext.request.contextPath}/player.jsp">www.blackshield.com</a>
									</p>
								</div>
							</div>
							<div class="col-md-6">
								<div class="contact-right-grid">
									<p>
										<span class="c-msg"> </span>
										<a href="mailto:hello@dreams.com">QQ:1007821300</a>
									</p>
									<p>
										<span class="c-face"> </span>
										<a href="${pageContext.request.contextPath}/player.jsp">facebook.com/laomu</a>
									</p>
									<p>
										<span class="c-pin"> </span>
										<a href="${pageContext.request.contextPath}/player.jsp">pinterest.com/laomu</a>
									</p>
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<div class="col-md-6">
					<div class="contact-right wow fadeInLeft" data-wow-delay="0.4s">
						<form method="post" action="${pageContext.request.contextPath }/deal/dealqustions.jsp">
							<input type="text" name="realName" class="text" placeholder="XXX（先生/女士）">
							<input type="text" class="text" name="email" placeholder="邮箱地址...">
							<textarea value="Message" name="message"
								onFocus="if(this.value=='请将您宝贵的意见或者建议发送给我们吧..')this.value = '';"
								onBlur="if (this.value == '') {this.value = '请将您宝贵的意见或者建议发送给我们吧..';}">请将您宝贵的意见或者建议发送给我们吧..</textarea>
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

						$().UItoTop({
							easingType : 'easeOutQuart'
						});

					});
				</script>
				<a href="${pageContext.request.contextPath}/player.jsp" id="toTop"
					style="display: block;"> <span id="toTopHover"
					style="opacity: 1;"> </span></a>
			</div>
			<!--- copy-right ---->
		</div>
	</div>
	<!---- contact --->
	<div style="display: none"></div>
</body>
</html>
