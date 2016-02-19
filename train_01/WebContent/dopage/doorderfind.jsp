<%@page import="com.lzcc.train.service.OrderService"%>
<%@page import="com.lzcc.train.model.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.lzcc.train.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 查询当前用户所有订单控制器
	User user = (User) session.getAttribute("LOGINUSER");

	// 查询
	List<Order> olist = new OrderService().findByUser(user); 
	
	// 添加到request中
	request.setAttribute("olist", olist);
	
	request.getRequestDispatcher("../order.jsp").forward(request, response);
%>