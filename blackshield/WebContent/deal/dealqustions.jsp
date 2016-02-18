<%@page import="com.luas.service.QuestionsService"%>
<%@page import="java.util.Date"%>
<%@page import="com.luas.model.Questions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 处理联系我们的业务
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	// 获取数据
	String name = request.getParameter("realName");
	String email = request.getParameter("email");
	String msg = request.getParameter("message");
	
	// 创建问题对象
	Questions questions = new Questions(name, email, msg, false, new Date());
	
	// 处理用户发送的问题信息
	new QuestionsService().saveQuestions(questions);
	
	// 跳转页面
	response.sendRedirect("../qustions_success.jsp");
%>