<%@page import="com.lzcc.train.service.AddressService"%>
<%@page import="com.lzcc.train.model.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 处理修改地址准备控制器
	// 获取要修改的地址编号
	String aid = request.getParameter("aid");

	// 查询编号对应的地址对象
	Address addr = new AddressService().findById(aid); 
	
	// 添加到request中
	request.setAttribute("addr", addr);
	
	// 跳转到修改地址页面
	request.getRequestDispatcher("../chgaddr.jsp").forward(request, response);
%>