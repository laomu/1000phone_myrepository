<%@page import="com.lzcc.train.model.Goods"%>
<%@page import="java.util.List"%>
<%@page import="com.lzcc.train.service.GoodsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 查看商店中所有的商品_获取要查询商品的商店编号
	String sid = request.getParameter("sid");

	// 调用业务处理类，根据编号查询所有商品
	GoodsService goodsService = new GoodsService();
	List<Goods> goodsList = goodsService.findByShop(sid); 
	
	if(goodsList == null || goodsList.size() == 0) {
		// 没有商品，跳转到添加商品页面	
		response.sendRedirect("dogoodsaddpre.jsp?sid=" + sid);
	} else {
		// 有商品，添加到request中并且跳转到商店详情页面展示商品
		request.setAttribute("goodsList", goodsList);
		request.getRequestDispatcher("../shopdetails.jsp").forward(request, response);
	}
%>