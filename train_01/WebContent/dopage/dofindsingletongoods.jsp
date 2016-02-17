<%@page import="com.lzcc.train.service.GoodsService"%>
<%@page import="com.lzcc.train.model.Goods"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 获取要查看的商品编号
	String gid = request.getParameter("gid");

	// 根据商品编号，查询对应的商品
	Goods goods = new GoodsService().findById(gid);
	
	// 将商品添加到request中
	request.setAttribute("goods", goods);
	
	// 跳转到商品详细信息页面
	request.getRequestDispatcher("../goodsdetails.jsp").forward(request, response);
%>