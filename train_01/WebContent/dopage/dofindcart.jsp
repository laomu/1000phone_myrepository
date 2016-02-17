<%@page import="com.lzcc.train.service.AddressService"%>
<%@page import="com.lzcc.train.model.Address"%>
<%@page import="com.lzcc.train.service.ShopcartService"%>
<%@page import="com.lzcc.train.model.Shopcart"%>
<%@page import="java.util.List"%>
<%@page import="com.lzcc.train.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 查询用户所有购物车商品
	// 1.获取当前登录用户
	User user = (User) session.getAttribute("LOGINUSER");
	// 2.查询当前用户所有购物对象
	List<Shopcart> sclist = new ShopcartService().findAllByUser(user); 
	
	// 2.1.查询当前用户所有地址
	List<Address> addrlist = new AddressService().findAllByUser(user);
	
	// 3.将购物车对象添加到request中，并跳转到购物车页面展示
	request.setAttribute("sclist", sclist);
	request.setAttribute("addrlist", addrlist);
	request.getRequestDispatcher("../cart.jsp").forward(request, response);
%>