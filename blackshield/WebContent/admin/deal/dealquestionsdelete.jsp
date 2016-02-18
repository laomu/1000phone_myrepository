<%@page import="com.luas.service.QuestionsService"%>
<%@page import="com.luas.model.Questions"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 删除问题记录
	String qid = request.getParameter("qid");
 
	new QuestionsService().deleteQuestions(qid); 
	
	response.sendRedirect("dealquestionslist.jsp");
%>