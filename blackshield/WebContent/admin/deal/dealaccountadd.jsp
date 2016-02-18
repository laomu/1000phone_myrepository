<%@page import="com.luas.service.DocTypeService"%>
<%@page import="com.luas.model.DocType"%>
<%@page import="java.util.List"%>
<%@ include file="../commons/verifylogin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 从文档列表界面，跳转到增加文档界面

	// 获取到所有的文档类型，并保存到request中，
	List<DocType> dtList = new DocTypeService().findAll();
	request.setAttribute("dtlist", dtList);
	// 跳转
	request.getRequestDispatcher("../account/account_add.jsp").forward(request, response);
%>