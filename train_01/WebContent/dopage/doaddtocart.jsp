<%@page import="com.lzcc.train.service.ShopcartService"%>
<%@page import="java.util.Date"%>
<%@page import="com.lzcc.train.model.Shopcart"%>
<%@page import="com.lzcc.train.model.User"%>
<%@page import="com.lzcc.train.service.UserService"%>
<%@page import="com.lzcc.train.service.GoodsService"%>
<%@page import="com.lzcc.train.model.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 增加商品到购物车控制器
	
	// 获取要添加数量和商品编号
	int shoppingCount = 1;
	Goods goods = null;
	// 获取购买数量
	String sc = request.getParameter("shoppingCount");
	if(sc != null) {
		shoppingCount = Integer.parseInt(sc);
	}
	// 获取商品编号
	String gid = request.getParameter("gid");
	// 查询商品
	goods = new GoodsService().findById(gid); 
	// 获取当前登录用户
	User user = (User) session.getAttribute("LOGINUSER");
	
	double subtotal = goods.getPrice()*shoppingCount;
	
	// 包装购物车对象
	Shopcart shopcart = new Shopcart(user, goods, new Date(),shoppingCount, subtotal);
	
	// 添加到购物车
	new ShopcartService().addToCart(shopcart);
	
	// 跳转到查询购物车所有商品控制器
	response.sendRedirect("dofindcart.jsp");
%>