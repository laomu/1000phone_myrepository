<%@page import="com.luas.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
    <meta charset="UTF-8">
    <title>兰文理网络技术共享平台</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <!---- animated-css ---->
    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet" type="text/css" media="all">
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

            <div class="container">
                <div class="service-head">
                    <h3 style="color:#ddd;">黑盾网络信息平台新会员注册</h3>
                    <p style="color:#ddd;">这里是技术的殿堂，这里是艺术的海洋，在这里你将享受一场技术的SPA，在这里你将畅游艺术的海洋</p>
                    <p style="color:#ddd;">加入我们吧，我们一起为了理想奋斗</p>
                    <%
                    	String er = (String)request.getAttribute("ERROR");
                    	if(er != null) {
                    		out.print("<p style='color:#ddd;'>"+er+"</p>");
                    	}
                    %>
                </div>
                <div style="height:60px;width:100%"></div>
                <div class="col-md-6">
                    <div class="contact-right wow fadeInLeft" data-wow-delay="0.4s">
                        <form method="post" action="${pageContext.request.contextPath }/deal/dealregist.jsp">
                            <input type="text" name="username" class="text" placeholder="请输入注册账号..." onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '请输入注册账号...';}">
                            <input type="text" name="password" class="text" placeholder="请输入密码..." onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '请输入密码...';}">
                            <input type="text" name="password2" class="text" placeholder="请再次输入密码..." onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '请再次输入密码...';}">
                            <input type="text" name="realName" class="text" placeholder="请输入昵称..." onFocus="this.value = '';" onBlur="if (this.value == '') {this.value = '请输入昵称...';}">
                            <input class="wow shake" data-wow-delay="0.3s" type="submit" value="注册会员" />
                        </form>
                    </div>
                </div>

            </div>
        </div>
        <!---- team --->
        <!---- contact --->
        <div id="contact" class="contact">
            <div class="container">
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
        </div>
        <!---- contact --->
    </div>
    <div style="display:none">
    </div>
</body>
</html>