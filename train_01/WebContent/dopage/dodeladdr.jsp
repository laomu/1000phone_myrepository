<%@page import="com.lzcc.train.service.AddressService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 处理删除地址控制器
	// 获取要删除的地址编号
	String aid = request.getParameter("aid");

	// 调用业务处理类删除对应的地址
	new AddressService().deleteAddr(aid); 
	
	// 跳转到查询地址页面
	response.sendRedirect("dofindaddr.jsp");
%>