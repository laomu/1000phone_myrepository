<%@page import="com.luas.service.ToolsTypeService"%>
<%@page import="com.luas.model.ToolsType"%>
<%@page import="com.luas.service.DocTypeService"%>
<%@page import="com.luas.model.DocType"%>
<%@page import="java.util.List"%>
<%@ include file="../commons/verifylogin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 从软件工具列表界面，跳转到添加软件工具界面

	// 获取到所有的软件工具类型，并保存到request中，
	List<ToolsType> ttList = new ToolsTypeService().findAll();
	request.setAttribute("ttList", ttList);
	// 跳转
	request.getRequestDispatcher("../bill/bill_add.jsp").forward(request, response);
%>