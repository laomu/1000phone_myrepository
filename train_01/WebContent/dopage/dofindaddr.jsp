<%@page import="com.lzcc.train.model.Address"%>
<%@page import="java.util.List"%>
<%@page import="com.lzcc.train.service.AddressService"%>
<%@page import="com.lzcc.train.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 处理查询地址控制器
	// 获取当前登录用户
	User user = (User)session.getAttribute("LOGINUSER");

	// 创建地址业务处理类对象
	AddressService service = new AddressService();
	List<Address> addrList = service.findAllByUser(user); 
	
	// 添加到request空间中
	request.setAttribute("addrList", addrList);
	// 页面跳转到地址页面
	request.getRequestDispatcher("../address.jsp").forward(request, response);
%>