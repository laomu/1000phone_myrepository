<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("ADMINLOGIN");
	session.invalidate();
	response.sendRedirect(application.getContextPath() + "/admin/login.jsp");
%>