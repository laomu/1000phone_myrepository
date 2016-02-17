<%@page import="com.lzcc.train.model.GoodsType"%>
<%@page import="java.util.List"%>
<%@page import="com.lzcc.train.service.GoodsService"%>
<%@page import="com.lzcc.train.model.ActivityType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 添加商品数据准备控制器
	GoodsService goodsService = new GoodsService();
	// 1. 查询所有的活动类型数据
	List<GoodsType> gtList = goodsService.findGoodsType();
	// 2.查询所有的商品类型数据
	List<ActivityType> atList = goodsService.findActivityType();
	// 3.将数据添加到request中
	request.setAttribute("gtList", gtList);
	request.setAttribute("atList", atList);
	
	String sid = (String) request.getParameter("sid");
	
	// 4.跳转到添加商品页面
	request.getRequestDispatcher("../goodsadd.jsp?sid=" + sid).forward(request, response);
%>