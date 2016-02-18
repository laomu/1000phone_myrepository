<%@page import="com.luas.model.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 验证会员登录
	Users u = (Users) session.getAttribute("LOGIN");
	if(u == null) {
		response.sendRedirect("login.jsp");
		return;
	}
%>