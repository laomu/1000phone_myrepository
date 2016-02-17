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
<title>凤凰百货——首页</title>

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
                            <li class=""><a href="404_error.html" title="My Account">我的账户</a></li>
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
					<form method="post" action="${pageContext.request.contextPath}/dopage/dosearch.jsp">
                      <input type="text" name="keyword" value="在这里搜索您想要的商品" />
                      <input type="submit" value="搜索商品" title="搜索商品" />
                    </form>
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
            <!--Banner Block-->
            <section class="banner-wrapper">
              <div class="banner-block container">
                <div class="flexslider">
                  <ul class="slides">
                    <li><img title="Banner" alt="Banner" src="${pageContext.request.contextPath}/images/banner1.jpg" /></li>
                    <li><img title="Banner" alt="Banner" src="${pageContext.request.contextPath}/images/banner2.jpg" /></li>
                    <li><img title="Banner" alt="Banner" src="${pageContext.request.contextPath}/images/banner3.jpg" /></li>
                    <li><img title="Banner" alt="Banner" src="${pageContext.request.contextPath}/images/banner4.jpg" /></li>
                  </ul>
                </div>
                <ul class="banner-add">
                  <li class="add1"><a href="#" title=""><img title="add1" alt="add1" src="${pageContext.request.contextPath}/images/banner_add1.png" /></a></li>
                  <li class="add2"><a href="#" title=""><img title="add2" alt="add2" src="${pageContext.request.contextPath}/images/banner_add2.png" /></a></li>
                </ul>
              </div>
            </section>
            <div class="copyrights">Collect from <a href="http://www.mycodes.net/" title="源码之家">源码之家</a></div>
            <!--Content Block-->
            <section class="content-wrapper">
              <div class="content-container container">
                <div class="heading-block">
                  <h1>最新商家</h1>
                  <ul class="pagination">
                    <li class="grid"><a href="#" title="Grid">Grid</a></li>
                  </ul>
                </div>
                <div class="feature-block">
                  <ul id="mix" class="product-grid">
                    <li>
                      <div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
                      <div class="pro-hover-block">
                        <h4 class="pro-name">韩都衣舍</h4>
                        <div class="link-block"> 
                        <a href="#quick-view-container" class="quickllook inline" title="查看详细">查看详细</a> 
                        <a href="view.html" class="quickproLink" title="联系店家">联系店家</a></div>
                        <div class="pro-price">我们致力于做的更好</div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
                      <div class="pro-hover-block">
                        <h4 class="pro-name">韩都衣舍</h4>
                        <div class="link-block"> 
                        <a href="#quick-view-container" class="quickllook inline" title="查看详细">查看详细</a> 
                        <a href="view.html" class="quickproLink" title="联系店家">联系店家</a></div>
                        <div class="pro-price">我们致力于做的更好</div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
                      <div class="pro-hover-block">
                        <h4 class="pro-name">韩都衣舍</h4>
                        <div class="link-block"> 
                        <a href="#quick-view-container" class="quickllook inline" title="查看详细">查看详细</a> 
                        <a href="view.html" class="quickproLink" title="联系店家">联系店家</a></div>
                        <div class="pro-price">我们致力于做的更好</div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
                      <div class="pro-hover-block">
                        <h4 class="pro-name">韩都衣舍</h4>
                        <div class="link-block"> 
                        <a href="#quick-view-container" class="quickllook inline" title="查看详细">查看详细</a> 
                        <a href="view.html" class="quickproLink" title="联系店家">联系店家</a></div>
                        <div class="pro-price">我们致力于做的更好</div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
                      <div class="pro-hover-block">
                        <h4 class="pro-name">韩都衣舍</h4>
                        <div class="link-block"> 
                        <a href="#quick-view-container" class="quickllook inline" title="查看详细">查看详细</a> 
                        <a href="view.html" class="quickproLink" title="联系店家">联系店家</a></div>
                        <div class="pro-price">我们致力于做的更好</div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
                      <div class="pro-hover-block">
                        <h4 class="pro-name">韩都衣舍</h4>
                        <div class="link-block"> 
                        <a href="#quick-view-container" class="quickllook inline" title="查看详细">查看详细</a> 
                        <a href="view.html" class="quickproLink" title="联系店家">联系店家</a></div>
                        <div class="pro-price">我们致力于做的更好</div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
                      <div class="pro-hover-block">
                        <h4 class="pro-name">韩都衣舍</h4>
                        <div class="link-block"> 
                        <a href="#quick-view-container" class="quickllook inline" title="查看详细">查看详细</a> 
                        <a href="view.html" class="quickproLink" title="联系店家">联系店家</a></div>
                        <div class="pro-price">我们致力于做的更好</div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
                      <div class="pro-hover-block">
                        <h4 class="pro-name">韩都衣舍</h4>
                        <div class="link-block"> 
                        <a href="#quick-view-container" class="quickllook inline" title="查看详细">查看详细</a> 
                        <a href="view.html" class="quickproLink" title="联系店家">联系店家</a></div>
                        <div class="pro-price">我们致力于做的更好</div>
                      </div>
                    </li>
      				<li>
                      <div class="pro-img"><img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" /></div>
                      <div class="pro-hover-block">
                        <h4 class="pro-name">韩都衣舍</h4>
                        <div class="link-block"> 
                        <a href="#quick-view-container" class="quickllook inline" title="查看详细">查看详细</a> 
                        <a href="view.html" class="quickproLink" title="联系店家">联系店家</a></div>
                        <div class="pro-price">我们致力于做的更好</div>
                      </div>
                    </li>
                  </ul>
                </div>
                <div class="heading-block">
                  <h1>最新上架商品</h1>
                </div>
                <div class="new-product-block">
                  <ul class="product-grid">
                    <li>
                      <div class="pro-img">
                        <img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" />
                      </div>
                      <div class="pro-content">
                        <p>White Round Neck T-Shirt</p>
                      </div>
                      <div class="pro-price">$600.00</div>
                      <div class="pro-btn-block"> 
                      <a class="add-cart left" href="#" title="Add to Cart">Add to Cart</a> 
                      <a class="add-cart right quickCart inline" href="#quick-view-container" title="Quick View">Quick View</a> </div>
                      <div class="pro-link-block"> <a class="add-wishlist left" href="#" title="Add to wishlist">Add to wishlist</a> <a class="add-compare right" href="#" title="Add to Compare">Add to Compare</a>
                        <div class="clearfix"></div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img">
                        <img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" />
                      </div>
                      <div class="pro-content">
                        <p>White Round Neck T-Shirt</p>
                      </div>
                      <div class="pro-price">$600.00</div>
                      <div class="pro-btn-block"> <a class="add-cart left" href="#" title="Add to Cart">Add to Cart</a> <a class="add-cart right quickCart inline" href="#quick-view-container" title="Quick View">Quick View</a> </div>
                      <div class="pro-link-block"> <a class="add-wishlist left" href="#" title="Add to wishlist">Add to wishlist</a> <a class="add-compare right" href="#" title="Add to Compare">Add to Compare</a>
                        <div class="clearfix"></div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img">
                        <img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" />
                      </div>
                      <div class="pro-content">
                        <p>White Round Neck T-Shirt</p>
                      </div>
                      <div class="pro-price">$600.00</div>
                      <div class="pro-btn-block"> <a class="add-cart left" href="#" title="Add to Cart">Add to Cart</a> <a class="add-cart right quickCart inline" href="#quick-view-container" title="Quick View">Quick View</a> </div>
                      <div class="pro-link-block"> <a class="add-wishlist left" href="#" title="Add to wishlist">Add to wishlist</a> <a class="add-compare right" href="#" title="Add to Compare">Add to Compare</a>
                        <div class="clearfix"></div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img">
                        <img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" />
                      </div>
                      <div class="pro-content">
                        <p>White Round Neck T-Shirt</p>
                      </div>
                      <div class="pro-price">$600.00</div>
                      <div class="pro-btn-block"> <a class="add-cart left" href="#" title="Add to Cart">Add to Cart</a> <a class="add-cart right quickCart inline" href="#quick-view-container" title="Quick View">Quick View</a> </div>
                      <div class="pro-link-block"> <a class="add-wishlist left" href="#" title="Add to wishlist">Add to wishlist</a> <a class="add-compare right" href="#" title="Add to Compare">Add to Compare</a>
                        <div class="clearfix"></div>
                      </div>
                    </li>
                  </ul>
                  <ul class="product-grid">
                    <li>
                      <div class="pro-img">
                        <img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" />
                      </div>
                      <div class="pro-content">
                        <p>White Round Neck T-Shirt</p>
                      </div>
                      <div class="pro-price">$600.00</div>
                      <div class="pro-btn-block"> <a class="add-cart left" href="#" title="Add to Cart">Add to Cart</a> <a class="add-cart right quickCart inline" href="#quick-view-container" title="Quick View">Quick View</a> </div>
                      <div class="pro-link-block"> <a class="add-wishlist left" href="#" title="Add to wishlist">Add to wishlist</a> <a class="add-compare right" href="#" title="Add to Compare">Add to Compare</a>
                        <div class="clearfix"></div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img">
                        <img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" />
                      </div>
                      <div class="pro-content">
                        <p>White Round Neck T-Shirt</p>
                      </div>
                      <div class="pro-price">$600.00</div>
                      <div class="pro-btn-block"> <a class="add-cart left" href="#" title="Add to Cart">Add to Cart</a> <a class="add-cart right quickCart inline" href="#quick-view-container" title="Quick View">Quick View</a> </div>
                      <div class="pro-link-block"> <a class="add-wishlist left" href="#" title="Add to wishlist">Add to wishlist</a> <a class="add-compare right" href="#" title="Add to Compare">Add to Compare</a>
                        <div class="clearfix"></div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img">
                        <img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" />
                      </div>
                      <div class="pro-content">
                        <p>White Round Neck T-Shirt</p>
                      </div>
                      <div class="pro-price">$600.00</div>
                      <div class="pro-btn-block"> <a class="add-cart left" href="#" title="Add to Cart">Add to Cart</a> <a class="add-cart right quickCart inline" href="#quick-view-container" title="Quick View">Quick View</a> </div>
                      <div class="pro-link-block"> <a class="add-wishlist left" href="#" title="Add to wishlist">Add to wishlist</a> <a class="add-compare right" href="#" title="Add to Compare">Add to Compare</a>
                        <div class="clearfix"></div>
                      </div>
                    </li>
                    <li>
                      <div class="pro-img">
                        <img title="Freature Product" alt="Freature Product" src="${pageContext.request.contextPath}/images/default_img.png" />
                      </div>
                      <div class="pro-content">
                        <p>White Round Neck T-Shirt</p>
                      </div>
                      <div class="pro-price">$600.00</div>
                      <div class="pro-btn-block"> <a class="add-cart left" href="#" title="Add to Cart">Add to Cart</a> <a class="add-cart right quickCart inline" href="#quick-view-container" title="Quick View">Quick View</a> </div>
                      <div class="pro-link-block"> <a class="add-wishlist left" href="#" title="Add to wishlist">Add to wishlist</a> <a class="add-compare right" href="#" title="Add to Compare">Add to Compare</a>
                        <div class="clearfix"></div>
                      </div>
                    </li>
                  </ul>
                </div>
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
    <!--Quick view Block-->
<script type="text/javascript">
jQuery (function(){
	var tabContainers=jQuery('div.tabs > div');
	tabContainers.hide().filter(':first').show();
	jQuery('div.tabs ul.tabNavigation a').click(function(){
		tabContainers.hide();
		tabContainers.filter(this.hash).show();
		jQuery('div.tabs ul.tabNavigation a').removeClass('selected');
		jQuery(this).addClass('selected');
		return false;
		}).filter(':first').click();
	});
</script>
<article style="display:none;">
	<section id="quick-view-container" class="quick-view-wrapper">
	<div class="quick-view-container">
		<div class="quick-view-left">
			<h2>Sunglass RB3184</h2>
			<div class="product-img-box">
				<p class="product-image">
					<img src="${pageContext.request.contextPath}/images/sale_icon_img.png" title="Sale" alt="Sale" class="sale-img" />
					<a href="view.html" title="Image"><img src="${pageContext.request.contextPath}/images/quick_view_img.png" title="Image" alt="Image" /></a>				</p>
				<ul class="thum-img">
					<li><img  src="${pageContext.request.contextPath}/images/quick_thum_img.png" title="" alt="" /></li>
					<li><img  src="${pageContext.request.contextPath}/images/quick_thum_img.png" title="" alt="" /></li>
				</ul>
			</div>
		</div>
		<div class="quick-view-right tabs">
			<ul class="tab-block tabNavigation">
				<li><a class="selected" title="Overview" href="#tabDetail">Overview</a></li>
				<li><a title="Description" href="#tabDes">Description</a></li>
			</ul>
			<div id="tabDetail" class="tabDetail">
            	<div class="first-review">Be the first to review this product</div>
			<div class="price-box">
				<span class="price">$600.00</span>			</div>
			<div class="availability">In stock</div>
			<div class="color-size-block">
				<div class="label-row">
					<label><em>*</em> color</label>
					<span class="required">* Required Fields</span>				</div>
				<div class="select-row">
					<select><option>-- Please Select --</option></select>
				</div>
				<div class="label-row">
					<label><em>*</em> size</label>
				</div>
				<div class="select-row">
					<select><option>-- Please Select --</option></select>
				</div>
			</div>
			<div class="add-to-cart-box">
				<span class="qty-box">
					<label for="qty">Qty:</label>
					<a class="prev" title="" href="#"><img alt="" title="" src="${pageContext.request.contextPath}/images/qty_prev.png"></a>
					<input type="text" name="qty" class="input-text qty" id="qty" maxlength="12" value="1">
					<a class="next" title="" href="#"><img alt="" title="" src="${pageContext.request.contextPath}/images/qty_next.png"></a>				</span>
				<button title="Add to Cart" class="form-button"><span>Add to Cart</span></button>
			</div>
            </div>
            <div id="tabDes" class="tabDes">
            	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas erat odio, suscipit eu porta et, ultricies id sapien. Quisque posuere odio eget lectus suscipit sodales. Sed consequat, leo ut varius scelerisque, augue massa tincidunt est, et tincidunt enim tortor a metus. In sit amet diam in tellus tincidunt mollis. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Morbi hendrerit eleifend tortor, a dapibus tellus suscipit porta. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. In mollis adipiscing mi et volutpat. Aliquam vitae dui nunc. Nulla ac ante eu massa dictum volutpat. Sed mauris sem, posuere sit amet pretium consectetur, ullamcorper vel orci. Aenean feugiat luctus lectus ac hendrerit. Fusce pulvinar, mauris eget sodales suscipit, diam neque condimentum lectus, id imperdiet felis turpis egestas neque. In aliquet orci eget nisl sollicitudin sed gravida tortor commodo</p>
            </div>
		</div>
		<div class="clearfix"></div>
	</div>
</section>
</article>     
    <!--Quick view Block-->  
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