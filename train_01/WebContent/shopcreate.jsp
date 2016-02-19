<%@ page language="java" contentType="text/html; charset=GBK"
    pageEncoding="GBK"%>
<!doctype html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Megashop</title>

<!--js-->
<script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
<script src="${pageContext.request.contextPath}/js/common.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easing.1.3.js"></script>
<script src="${pageContext.request.contextPath}/js/ddsmoothmenu.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.flexslider.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.elastislide.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.jcarousel.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.accordion.js"></script>
<script src="${pageContext.request.contextPath}/js/light_box.js"></script>
<script type="text/javascript">$(document).ready(function(){$(".inline").colorbox({inline:true, width:"50%"});});</script>
<!--end js-->

<!-- Mobile Specific Metas ================================================== -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS ================================================== -->

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/orange.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/skeleton.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/layout.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/ddsmoothmenu.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/elastislide.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/home_flexslider.css"/>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/light_box.css"/>
<script src="${pageContext.request.contextPath}/js/html5.js"></script>

<!--[if IE]><script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->

<!--[if lt IE 9]>
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->

</head>
<body>
	<div class="mainContainer sixteen container">
            <!--Header Block-->
            <div class="header-wrapper">
              <header class="container">
                <div class="head-right">
                      <ul class="top-nav">
                            <li class=""><a href="404_error.html" title="My Account">�ҵ��˻�</a></li><li class=""><a href="${pageContext.request.contextPath }/dopage/doorderfind.jsp" title="My Account">�Ѿ�����ı���</a></li>
                            <li class="my-wishlist"><a href="404_error.html" title="My Wishlist">�ҵ��ղ�</a></li>
                            <li class="contact-us"><a href="contact_us.html" title="Contact Us">��ϵ����</a></li>
                            <li class="checkout"><a href="${pageContext.request.contextPath}/dopage/dofindcart.jsp" title="Checkout">���ﳵ</a></li>
                            <li class="log-in"><a href="${pageContext.request.contextPath}/login.jsp" title="Log In">��¼</a></li>
                      </ul>
                    <ul class="currencyBox">
                        <li id="header_currancy" class="currency"> <a class="mainCurrency" href="#">�ҵĸ�������&nbsp;&nbsp;</a>
                          <div id="currancyBox" class="currency_detial"> 
						  <a href="${pageContext.request.contextPath}/userchgpasswd.jsp">�޸ĵ�¼����</a><br /> 
						  <a href="${pageContext.request.contextPath}/userperfectinfo.jsp">���Ƹ�������</a><br /> 
						  <a href="${pageContext.request.contextPath }/dopage/dofindaddr.jsp">�����ջ���ַ</a></div>
                        </li>
                    </ul>
                  <section class="header-bottom">
                    <div class="cart-block">
					<ul>
						<li><a href="cart.html" title="Cart"><img title="Item" alt="Item" src="${pageContext.request.contextPath}/images/item_icon.png" /></a></li>
						<li>��</li>
						<li>(2)</li>
					</ul>
					<div id="minicart" class="remain_cart" style="display: none;">
						 <p class="empty">���Ĺ��ﳵ����������Ʒ</p>
						 <ol>
						 	<li>
								<div class="img-block"><img src="${pageContext.request.contextPath}/images/small_img.png" title="" alt="" /></div>
								<div class="detail-block">
									<h4><a href="#" title="Htc Mobile 1120">Htc Mobile 1120</a></h4>
									<p>
										<strong>1</strong> x $900.00
									</p>
									<a href="#" title="Details">�鿴��ϸ</a>
								</div>
								<div class="edit-delete-block">
									<a href="#" title="Edit"><img src="${pageContext.request.contextPath}/images/edit_icon.png" alt="Edit" title="Edit" /></a>
									<a href="#" title="Remove"><img src="${pageContext.request.contextPath}/images/delete_item_btn.png" alt="Remove" title="Remove" /></a>
								</div>
							</li>
							<li>
								<div class="img-block"><img src="${pageContext.request.contextPath}/images/small_img.png" title="" alt="" /></div>
								<div class="detail-block">
									<h4><a href="#" title="Htc Mobile 1120">Htc Mobile 1120</a></h4>
									<p>
										<strong>1</strong> x $900.00
									</p>
									<a href="#" title="Details">�鿴��ϸ</a>
								</div>
								<div class="edit-delete-block">
									<a href="#" title="Edit"><img src="${pageContext.request.contextPath}/images/edit_icon.png" alt="Edit" title="Edit" /></a>
									<a href="#" title="Remove"><img src="${pageContext.request.contextPath}/images/delete_item_btn.png" alt="Remove" title="Remove" /></a>
								</div>
							</li>
							<li>
								<div class="total-block">�ܼۣ�<span>$1,900.00</span></div>
								<a href="cart.html" title="Checkout" class="orange-btn">��������</a>
								<div class="clear"></div>
							</li>
						 </ol>
					</div>
				</div>
                    <div class="search-block">
                      <input type="text" value="��������������Ҫ����Ʒ" />
                      <input type="submit" value="������Ʒ" title="������Ʒ" />
                    </div>
                  </section>
                </div>
                <h1 class="logo"><a href="index-2.html" title="Logo">
                  <img title="Logo" alt="Logo" src="${pageContext.request.contextPath}/images/logo.jpg" />
                  </a></h1>
                <nav id="smoothmenu1" class="ddsmoothmenu mainMenu">
                  <ul id="nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/index.jsp" title="Home">��ҳ</a></li>
                    <li class=""><a href="category.html" title="Shop by">�ҵ��̵�</a>
                      <ul>
						<li><a href="${pageContext.request.contextPath }/shopcreate.jsp">��Ҫ����</a></li>
						<li><a href="${pageContext.request.contextPath }/dopage/doshopfind.jsp">�ҵ��̵�</a></li>
                        <li><a href="category.html">�����̵���Ϣ</a></li>
                        <li><a href="category.html">�鿴�̵���Ʒ</a></li>
                        <li><a href="category.html">��Ӵ����</a></li>
                      </ul>
                    </li>
                    <li class=""><a href="blog.html" title="Blog">���»</a></li>
                    <li class=""><a href="category.html" title="Shop by">�ҵ�����</a>
                      <ul>
                        <li><a href="category.html">�޸ĵ�¼����</a></li>
                        <li><a href="category.html">���Ƹ�������</a></li>
                        <li><a href="category.html">ɾ�������˺�</a></li>
                        <li><a href="category.html">�鿴�������</a></li>
                      </ul>
                    </li>
                    <li class=""><a href="about_us.html" title="About us">��������</a></li>
                    <li class=""><a href="contact_us.html" title="Footwear">��ϵ����</a></li>
                  </ul>
                </nav>
                
                <div class="mobMenu">
            <h1>
            <span>Menu</span>
            <a class="menuBox highlight" href="javascript:void(0);">ccc</a>
            <span class="clearfix"></span>
            </h1>
            <div id="menuInnner" style="display:none;">
                   <ul class="accordion">
                       <li class=""><a href="index-2.html" title="Home">Home</a></li>
                    <li class="parent"><a href="category.html" title="Shop by">Shop by</a>
                      <ul>
                        <li><a href="category.html">Woman Collection</a></li>
                        <li><a href="category.html">Men Collection</a></li>
                        <li><a href="category.html">Accessories</a></li>
                        <li><a href="category.html">Mobile</a>
                        	<ul>
                                <li><a href="category.html">Second level</a></li>
                                <li><a href="category.html">Second level</a></li>
                                <li><a href="category.html">Second level</a></li>
                                <li><a href="category.html">Second level</a></li>
                                <li><a href="category.html">Second level</a></li>
                                <li><a href="category.html">Second level</a></li>
                              </ul>
                        </li>
                        <li><a href="category.html">Shoes</a></li>
                        <li><a href="category.html">Others</a></li>
                      </ul>
                    </li>
                    <li class=""><a href="blog.html" title="Blog">Blog</a></li>
                    <li class=""><a href="faq.html" title="Faq">Faq</a></li>
                    <li class=""><a href="about_us.html" title="About us">About us</a></li>
                    <li class=""><a href="404_error.html" title="Pages">Pages</a></li>
                    <li class=""><a href="contact_us.html" title="Footwear">Contact us</a></li>
                      <span class="clearfix"></span>
                   </ul>
                  
             </div>      
            </div>
                
              </header>
            </div>
<!--Content Block-->
<section class="content-wrapper">
	<div class="content-container container">
		<div class="col-left">
			<div class="block compare-block">
				<div class="block-title">�����̵�</div>
				<ul>
					<li><a href="#">��������</a></li>
					<li><a href="#">��������</a></li>
					<li><a href="#">��������</a></li>
					<li><a href="#">��������</a></li>
				</ul>
			</div>
			<div class="block community-block">
				<div class="block-title">������Ʒ</div>
				<ul>
					<li class="question-row">��������ϲ������Ʒ��</li>
					<li><a href="#" title="Green">��������</a></li>
					<li><a href="#" title="Red">alienware r3</a></li>
					<li><a href="#" title="Black">ThinkPad newX</a></li>
					<li><a href="#" title="Magenta">Lenove E430</a></li>
				</ul>
			</div>
		</div>
		<div  class="col-main">
			<h1 class="page-title">��˰ٻ��̳ǡ�����Ҫ����</h1>
			<div class="contact-form-container">
				<%
				String error = (String) request.getAttribute("ERROR_SHOP");
				if(error!= null) {%>
					<div  class="form-title" style="color:red"><%=error %></div>
					<%
				} else {
					%>
				<div  class="form-title">���Ƶ�����Ϣ</div>
					<%
				}
				request.removeAttribute("ERROR_SHOP");
				%>
				<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath }/dopage/doshopcreate.jsp">
				<ul class="form-fields">
					<li class="left">
						<label>��������<em>*</em></label>
						<input type="text" name="shopname" />
					</li>
					<li class="left">
						<label>����ͼƬ<em>*</em></label>
						<input type="file" name="file"/>
					</li>
					<li class="full-row">
						<label>��������<em>*</em></label>
						<textarea name="shopdesc"></textarea>
					</li>
				</ul>
				<div class="button-set">
					<p class="required">* Ϊ������д�ֶ�</p>
					<button type="submit" class="form-button"><span>����</span></button>
				</div>
				</form>
			</div>
		</div>
		<div class="clearfix"></div>
		<div class="news-letter-container">
			<div class="free-shipping-block">
				<h1>�������������ĸ���</h1>
				<p>������ν����ң�������ô��������ѹ�!</p>
			  </div>
			  <div class="news-letter-block">
				<h2>��������������Ҫ����Ʒ</h2>
				<input type="text" value="������Ʒ�ؼ���" title="" />
				<input type="submit" value="����" title="Submit" />
			  </div>
		</div>	
	</div>
</section>
</div>
<!--Footer Block-->
            <section class="footer-wrapper">
              <footer class="container">
                <div class="link-block">
                  <ul>
                    <li class="link-title"><a href="about_us.html" title="ABOUT US">��������</a></li>
                    <li><a href="about_us.html" title="About Us">��������</a></li>
                    <li><a href="#" title="Customer Service">�ͻ�����</a></li>
                    <li><a href="#" title="Privacy Policy">���ѽ��</a></li>
                  </ul>
                  <ul>
                    <li class="link-title"><a href="#" title="CUSTOMER SERVICES">�ͻ�����</a></li>
                    <li><a href="#" title="Shipping & Returns">���߿ͷ�</a></li>
                    <li><a href="#" title="Secure Shopping">��������</a></li>
                    <li><a href="contact_us.html" title="Contact Us">��ϵ����</a></li>
                  </ul>
                  <ul>
                    <li class="link-title"><a href="#" title="TERMS & CONDITIONS">���ǵ��Ŷ�</a></li>
                    <li><a href="#" title="Press Room">XXX����Ŀ����</a></li>
                    <li><a href="#" title="Help">XXX�������ܼ�</a></li>
                    <li><a href="#" title="Terms & Conditions">XXX��ҵ���ܼ�</a></li>
                  </ul>
                  <ul>
                    <li class="link-title"><a href="#" title="ABOUTUS">��������</a></li>
                    <li class="aboutus-block">����ҵ����ڣ� �Ҿ����ҵ�δ���� �㳰Ц��һ�����У� �ҿ��������ǵȴ��� ������������ǵ����ᣬ ���ǻ�֤���� ����˭��ʱ���� ������ע���¶������У� ·���ٲ������ɺͳ�Ц�� ������������ ���±������ˣ� ҲҪ���Ư���� <br /><a href="about_us.html" title="read more">�鿴����</a> </li>
                  </ul>
                  <ul class="stay-connected-blcok">
                    <li class="link-title"><a href="#" title="STAY CONNECTED...">����</a></li>
                    <li>
                         <ul class="social-links">
                            <li><a data-tooltip="Like us on facebook" href="#"><img alt="facebook" src="${pageContext.request.contextPath}/images/facebook.png"></a></li>
                            <li><a data-tooltip="Subscribe to RSS feed" href="#"><img alt="RSS" src="${pageContext.request.contextPath}/images/rss.png"></a></li>
                            <li><a data-tooltip="Follow us on twitter" href="#"><img alt="twitter" src="${pageContext.request.contextPath}/images/twitter.png"></a></li>
                            <li><a data-tooltip="Follow us on Dribbble" href="#"><img alt="dribbble" src="${pageContext.request.contextPath}/images/dribbble.png"></a></li>
                            <li><a data-tooltip="Follow us on Youtube" href="#"><img alt="youtube" src="${pageContext.request.contextPath}/images/youtube.png"></a></li>
                            <li><a data-tooltip="Follow us on skype" href="#"><img alt="skype" src="${pageContext.request.contextPath}/images/skype.png"></a></li>
                         </ul>
                         <div class="payment-block"><img src="${pageContext.request.contextPath}/images/payment.png" alt="payment"></div>
                    </li>
                  </ul>
                </div>
                <div class="footer-bottom-block">
                  <ul class="bottom-links">
                    <li><a href="index-2.html" title="Home">��ҳ</a></li>
                    <li><a href="#" title="Pages">�̵�</a></li>
                    <li><a href="about_us.html" title="About">��������</a></li>
                    <li><a href="contact_us.html" title="Contact">���⽨��</a></li>
                  </ul>
                  <p class="copyright-block"> 2016 LZCC Company from <a href="" title="DACHENG" target="_blank">DACHENG</a></p>
                </div>
              </footer>
            </section>
</body>
</html>