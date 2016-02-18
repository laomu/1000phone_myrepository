<%@page import="com.luas.service.QuestionsService"%>
<%@page import="com.luas.model.Questions"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 查看所有问题列表
	List<Questions> qlist = new QuestionsService().findAll(); 

	request.setAttribute("qlist", qlist);
	
	request.getRequestDispatcher("../service/service_list.jsp").forward(request, response);
%>