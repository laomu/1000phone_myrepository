<%@page import="com.luas.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 删除会员账号
	String memberId = request.getParameter("mid");
	
	// 删除会员账号
	new MemberService().deleteById(memberId); 
	
	// 跳转回去查看所有会员
	request.getRequestDispatcher("./dealchkmember.jsp").forward(request, response);
%>