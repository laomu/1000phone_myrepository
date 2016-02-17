<%@page import="com.lzcc.train.service.GoodsService"%>
<%@page import="com.lzcc.train.model.Goods"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 编码过滤
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");
	// 获取搜索关键字
	String keyword = request.getParameter("keyword");
	// 调用商品服务类进行搜索
	List<Goods> goodsList = new GoodsService().searchGoods(keyword); 
	
	// 添加搜索到的商品到reuqest中并请求转发
	request.setAttribute("glist", goodsList);
	request.getRequestDispatcher("../searchbox.jsp").forward(request, response);
%>