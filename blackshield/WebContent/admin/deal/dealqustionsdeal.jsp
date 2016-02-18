<%@page import="com.luas.service.QuestionsService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 标记问题解决
	String qid = request.getParameter("qid");
 
	new QuestionsService().dealQuestions(qid);
	
	response.sendRedirect("dealquestionslist.jsp");
%>