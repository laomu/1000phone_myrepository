<%@page import="com.lzcc.train.service.ShopService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 删除商店
	String sid = request.getParameter("sid");

	new ShopService().shopDelete(sid);
	 
	// 跳转到查询商店
	response.sendRedirect("doshopfind.jsp");
%>