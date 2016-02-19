<%@page import="com.lzcc.train.model.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%
Goods goods = (Goods)request.getAttribute("goods");
%>
	<div class="mainContainer sixteen container">
            <!--Header Block-->
            <div class="header-wrapper">
              <header class="container">
                <div class="head-right">
                      <ul class="top-nav">
                            <li class=""><a href="404_error.html" title="My Account">我的账户</a></li><li class=""><a href="${pageContext.request.contextPath }/dopage/doorderfind.jsp" title="My Account">已经购买的宝贝</a></li>
                            <li class="my-wishlist"><a href="404_error.html" title="My Wishlist">我的收藏</a></li>
                            <li class="contact-us"><a href="contact_us.html" title="Contact Us">联系我们</a></li>
                            <li class="checkout"><a href="${pageContext.request.contextPath}/dopage/dofindcart.jsp" title="Checkout">购物车</a></li>
                            <li class="log-in"><a href="${pageContext.request.contextPath}/login.jsp" title="Log In">登录</a></li>
                      </ul>
                    <ul class="currencyBox">
                        <li id="header_currancy" class="currency"> <a class="mainCurrency" href="#">我的个人资料&nbsp;&nbsp;</a>
                          <div id="currancyBox" class="currency_detial"> 
						  <a href="${pageContext.request.contextPath}/userchgpasswd.jsp">修改登录密码</a><br /> 
						  <a href="${pageContext.request.contextPath}/userperfectinfo.jsp">完善个人资料</a><br /> 
						  <a href="${pageContext.request.contextPath }/dopage/dofindaddr.jsp">完善收货地址</a></div>
                        </li>
                    </ul>
                  <section class="header-bottom">
                    <div class="cart-block">
					<ul>
						<li><a href="cart.html" title="Cart"><img title="Item" alt="Item" src="${pageContext.request.contextPath}/images/item_icon.png" /></a></li>
						<li>购</li>
						<li>(2)</li>
					</ul>
					<div id="minicart" class="remain_cart" style="display: none;">
						 <p class="empty">您的购物车中有两件商品</p>
						 <ol>
						 	<li>
								<div class="img-block"><img src="${pageContext.request.contextPath}/images/small_img.png" title="" alt="" /></div>
								<div class="detail-block">
									<h4><a href="#" title="Htc Mobile 1120">Htc Mobile 1120</a></h4>
									<p>
										<strong>1</strong> x $900.00
									</p>
									<a href="#" title="Details">查看详细</a>
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
									<a href="#" title="Details">查看详细</a>
								</div>
								<div class="edit-delete-block">
									<a href="#" title="Edit"><img src="${pageContext.request.contextPath}/images/edit_icon.png" alt="Edit" title="Edit" /></a>
									<a href="#" title="Remove"><img src="${pageContext.request.contextPath}/images/delete_item_btn.png" alt="Remove" title="Remove" /></a>
								</div>
							</li>
							<li>
								<div class="total-block">总价：<span>$1,900.00</span></div>
								<a href="cart.html" title="Checkout" class="orange-btn">立即购买</a>
								<div class="clear"></div>
							</li>
						 </ol>
					</div>
				</div>
                    <div class="search-block">
                      <input type="text" value="在这里搜索您想要的商品" />
                      <input type="submit" value="搜索商品" title="搜索商品" />
                    </div>
                  </section>
                </div>
                <h1 class="logo"><a href="index-2.html" title="Logo">
                  <img title="Logo" alt="Logo" src="${pageContext.request.contextPath}/images/logo.jpg" />
                  </a></h1>
                <nav id="smoothmenu1" class="ddsmoothmenu mainMenu">
                  <ul id="nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/index.jsp" title="Home">主页</a></li>
                    <li class=""><a href="category.html" title="Shop by">我的商店</a>
                      <ul>
						<li><a href="${pageContext.request.contextPath }/shopcreate.jsp">我要开店</a></li>
						<li><a href="${pageContext.request.contextPath }/dopage/doshopfind.jsp">我的商店</a></li>
                        <li><a href="category.html">完善商店信息</a></li>
                        <li><a href="category.html">查看商店商品</a></li>
                        <li><a href="category.html">添加促销活动</a></li>
                      </ul>
                    </li>
                    <li class=""><a href="blog.html" title="Blog">最新活动</a></li>
                    <li class=""><a href="category.html" title="Shop by">我的资料</a>
                      <ul>
                        <li><a href="category.html">修改登录密码</a></li>
                        <li><a href="category.html">完善个人资料</a></li>
                        <li><a href="category.html">删除个人账号</a></li>
                        <li><a href="category.html">查看最近购买</a></li>
                      </ul>
                    </li>
                    <li class=""><a href="about_us.html" title="About us">关于我们</a></li>
                    <li class=""><a href="contact_us.html" title="Footwear">联系我们</a></li>
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
                       <li class="active"><a href="index-2.html" title="Home">Home</a></li>
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
		<div class="breadcrum-container">
			<ul>
				<li><a href="${pageContext.request.contextPath }/index.jsp" title="Home">首页</a></li>
				<li><a href="${pageContext.request.contextPath }/dopage/dogoodsfindbyshop.jsp?sid=<%=goods.getShop().getSid()%>">商店</a></li>
				<li>查看单个商品</li>
			</ul>
		</div>
		<div class="main">
			
			<div class="product-info-box">
				<div class="product-essential">
					<div class="product-img-box">
						<p class="product-image-zoom">
							<img style="width:300px;height:300px;" src="${pageContext.request.contextPath}/<%=goods.getGiList().get(0).getPath() %>"  alt="Image" title="Image" />
						</p>
						<p>
							Click on above image to view full picture
						</p>
						<div class="img-slider">
							<a href="#" title="Prev" class="prev slider-btn"><img src="${pageContext.request.contextPath}/images/prev_img_btn.png" title="Prev" alt="Prev" /></a>
							<a href="#" title="Next" class="next slider-btn"><img src="${pageContext.request.contextPath}/images/next_img_btn.png" title="Next" alt="Next" /></a>
							<ul id="moreView">
								<li><a class="ajax" href="${pageContext.request.contextPath}/images/view_img.png"><img src="${pageContext.request.contextPath}/images/small_img.png" alt="" title="" /></a></li>
                                <li><a class="ajax" href="${pageContext.request.contextPath}/images/view_img.png"><img src="${pageContext.request.contextPath}/images/small_img.png" alt="" title="" /></a></li>
		                        <li><a class="ajax" href="${pageContext.request.contextPath}/images/view_img.png"><img src="${pageContext.request.contextPath}/images/small_img.png" alt="" title="" /></a></li>
                                <li><a class="ajax" href="${pageContext.request.contextPath}/images/view_img.png"><img src="${pageContext.request.contextPath}/images/small_img.png" alt="" title="" /></a></li>
                                <li><a class="ajax" href="${pageContext.request.contextPath}/images/view_img.png"><img src="${pageContext.request.contextPath}/images/small_img.png" alt="" title="" /></a></li>
		                        <li><a class="ajax" href="${pageContext.request.contextPath}/images/view_img.png"><img src="${pageContext.request.contextPath}/images/small_img.png" alt="" title="" /></a></li>				
							</ul>
						</div>
					</div>
					<div class="product-shop">
						<h3 class="product-name"><%=goods.getGname() %></h3>
						<div class="price-box">
                		    <span class="price">商品现价：<%=goods.getPrice() %></span>
							<span class="availability"><del style="font-size:12px;color:#888">原价：<%=goods.getOriginalCost() %></del></span>
				        </div>
				        <div class="model-block">
							<p>
								<span>店主:</span><%=goods.getShop().getUser().getNickName() %>
							</p>
						</div>
						<div class="model-block">
							<p>
								<span>店铺:</span><%=goods.getShop().getSname()%>
							</p>
						</div>
						<div class="model-block">
							<p>
								<span>联系方式:</span><%=goods.getShop().getUser().getPhone() %>
							</p>
						</div>
						<div class="model-block">
							<p>
								<span>商品类型:</span><%=goods.getGoodsType().getGtName() %>
							</p>
						</div>
						<div class="model-block">
							<p>
								<span>活动类型:</span><%=goods.getActivityType().getAtName() %>
							</p>
						</div>
						<div class="model-block">
							<p>
								<span>商品库存:</span><%=goods.getStock() %>
							</p>
						</div>
						<!-- <div class="color-size-block">
							<div class="label-row">
								<label><em>*</em> color</label>
								<span class="required">* Required Fields</span>
							</div>
							<div class="select-row">
								<select><option>-- Please Select --</option></select>
							</div>
							<div class="label-row">
								<label><em>*</em> size</label>
							</div>
							<div class="select-row">
								<select><option>-- Please Select --</option></select>
							</div>
						</div> -->
						<form action="${pageContext.request.contextPath }/dopage/doaddtocart.jsp" method="post">
						<input type="hidden" name="gid" value="<%=goods.getGid()%>"/>
						<div class="add-to-cart-box">
							<span class="qty-box">
								<label for="qty">数量:</label>
								<a href="javascript:void(0)" title="" class="prev add"><img src="${pageContext.request.contextPath}/images/qty_prev.png" title="" alt="add" /></a>
								<input type="text" value="1" maxlength="12" id="qty" class="input-text qty" name="shoppingCount">
								<a href="javascript:void(0)" title="" class="next dec add"><img src="${pageContext.request.contextPath}/images/qty_next.png" title="" alt="" /></a>
							</span>
                            <script type="text/javascript">
								jQuery(document).ready(function(){
									jQuery(".ajax").colorbox();
								});	
                            	jQuery(function() {
									jQuery(".add").click(function() {
										var jQueryadd = jQuery(this);
										var oldValue = jQueryadd.parent().find("input").val();
										var newVal = 0;
									
										if (jQueryadd.text() == "") {
										   newVal = parseFloat(oldValue) + 1;
										  // AJAX save would go here
										} else {
										  // Don't allow decrementing below zero
										  if (oldValue >= 1) {
											  newVal = parseFloat(oldValue) - 1;
											  // AJAX save would go here
										  }
										  if(oldValue == 0){
											  newVal = parseFloat(oldValue);
											  }
										}
										jQueryadd.parent().find("input").val(newVal);
									});
									
								
								});
                            </script>
							<!-- <button class="form-button" title="Add to Cart"><span>加入购物车</span></button> -->
							<input class="form-button" type="submit" value="加入购物车"/>
						</div>
						</form>
					</div>
				</div>
			</div>
            <aside class="right">
				<ol class="pro-slider-btn">
					<li><a href="#" title="Prev"><img src="${pageContext.request.contextPath}/images/pro_prev_btn.png" title="Prev" alt="Prev" /></a></li>
					<li><a href="#" title="Next"><img src="${pageContext.request.contextPath}/images/pro_next_btn.png" title="Next" alt="Next" /></a></li>
				</ol>
				<ul class="right-img">
					<li><a href="#" title="Image"><img src="${pageContext.request.contextPath}/images/view_right_img01.png" title="Image" alt="Image" /></a></li>
					<li><a href="#" title="Image"><img src="${pageContext.request.contextPath}/images/view_right_img02.png" title="Image" alt="Image" /></a></li>
					<li><a href="#" title="Image"><img src="${pageContext.request.contextPath}/images/view_right_img03.png" title="Image" alt="Image" /></a></li>
				</ul>
			</aside>
			<section  class="product-collateral">
            	<script type="text/javascript">
					$(function(){
						var tabContainers=$('section.product-collateral > div.commonContent');
						tabContainers.hide().filter(':first').show();
						$('section.product-collateral ul.tab-block a').click(function(){
							tabContainers.hide();
							tabContainers.filter(this.hash).show();
							$('section.product-collateral ul.tab-block a').removeClass('active');
							$(this).addClass('active');
							return false;
							}).filter(':first').click();
						});
					</script>
				<ul class="tab-block">
					<li><a href="#pro-detail" title="Description" class="active">商品描述</a></li>
					<!-- <li><a href="#pro-review" title="Reviews">Reviews</a></li>
					<li><a href="#pro-tags" title="Product Tags">Product Tags</a></li>
					<li class="video-box"><a href="#pro-video" title="Video Box">Video Box</a></li> -->
				</ul>
				<div id="pro-detail" class="pro-detail commonContent">
					<p>
						<%=goods.getGdesc() %> 
					</p>
				</div>
                
                <!-- <div id="pro-review" class="pro-detail commonContent">
					<p>
						Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset
                        Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset 
					</p>
				</div>
                
                <div id="pro-tags" class="pro-detail commonContent">
					<p>
						Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset
					</p>
				</div>
                <div id="pro-video" class="pro-detail commonContent">
					<p>
						Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum. to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset 
					</p>
				</div> -->
                
                
                
                
			</section>
			<%-- <div class="like-pro-block">
				<div class="title-block">
					<h2>You may also like</h2>
				</div>
				<div class="like-pro">
					<ul id="like-pro" class="product-grid">
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
                        <li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
                        <li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
					</ul>
				</div>
			</div> 
			<div class="related-pro-block">
				<div class="title-block">
					<h2>Related Products</h2>
				</div>
				<div class="related-pro">
					<ul id="related-pro" class="product-grid">
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
                        <li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
                        <li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
						<li>
							<div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
							<div class="pro-detail-block">
								<h4 class="pro-name">Sunglass RB3186</h4>
								<div class="pro-price">$600.00</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>--%>
		<div class="clearfix"></div>
		<div class="news-letter-container">
                  <div class="free-shipping-block">
                    <h1>我们致力于做的更好</h1>
                    <p>你把信任交给我，我们怎么舍得让你难过!</p>
                  </div>
                  <div class="news-letter-block">
                    <h2>在这里搜索您需要的商品</h2>
                    <input type="text" value="输入商品关键字" title="" />
                    <input type="submit" value="搜索" title="Submit" />
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
                    <li class="link-title"><a href="about_us.html" title="ABOUT US">关于我们</a></li>
                    <li><a href="about_us.html" title="About Us">关于我们</a></li>
                    <li><a href="#" title="Customer Service">客户服务</a></li>
                    <li><a href="#" title="Privacy Policy">疑难解答</a></li>
                  </ul>
                  <ul>
                    <li class="link-title"><a href="#" title="CUSTOMER SERVICES">客户服务</a></li>
                    <li><a href="#" title="Shipping & Returns">在线客服</a></li>
                    <li><a href="#" title="Secure Shopping">购物流程</a></li>
                    <li><a href="contact_us.html" title="Contact Us">联系我们</a></li>
                  </ul>
                  <ul>
                    <li class="link-title"><a href="#" title="TERMS & CONDITIONS">我们的团队</a></li>
                    <li><a href="#" title="Press Room">XXX：项目经理</a></li>
                    <li><a href="#" title="Help">XXX：技术总监</a></li>
                    <li><a href="#" title="Terms & Conditions">XXX：业务总监</a></li>
                  </ul>
                  <ul>
                    <li class="link-title"><a href="#" title="ABOUTUS">关于我们</a></li>
                    <li class="aboutus-block">你否定我的现在， 我决定我的未来， 你嘲笑我一无所有， 我可怜你总是等待， 你可以轻视我们的年轻， 我们会证明， 这是谁的时代， 梦想是注定孤独的旅行， 路上少不了质疑和嘲笑， 但那又怎样， 哪怕遍体鳞伤， 也要活的漂亮。 <br /><a href="about_us.html" title="read more">查看更多</a> </li>
                  </ul>
                  <ul class="stay-connected-blcok">
                    <li class="link-title"><a href="#" title="STAY CONNECTED...">分享</a></li>
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
                    <li><a href="index-2.html" title="Home">主页</a></li>
                    <li><a href="#" title="Pages">商店</a></li>
                    <li><a href="about_us.html" title="About">关于我们</a></li>
                    <li><a href="contact_us.html" title="Contact">问题建议</a></li>
                  </ul>
                  <p class="copyright-block"> 2016 LZCC Company from <a href="" title="DACHENG" target="_blank">DACHENG</a></p>
                </div>
              </footer>
            </section>
</body>
</html>