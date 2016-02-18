<%@page import="com.luas.service.CourseTypeService"%>
<%@page import="com.luas.model.CourseType"%>
<%@page import="com.luas.service.ToolsTypeService"%>
<%@page import="com.luas.model.ToolsType"%>
<%@page import="com.luas.service.DocTypeService"%>
<%@page import="com.luas.model.DocType"%>
<%@page import="java.util.List"%>
<%@ include file="../commons/verifylogin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 从视频教程列表界面，跳转到增加视频教程界面

	// 获取到所有的视频教程类型，并保存到request中，
	List<CourseType> ctList = new CourseTypeService().findAll(); 
	request.setAttribute("ctList", ctList);
	// 跳转
	request.getRequestDispatcher("../fee/fee_add.jsp").forward(request, response);
%>