<%@page import="com.luas.service.MemberService"%>
<%@page import="com.luas.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 锁定会员账号
	String mid = request.getParameter("mid");

	// 修改用户
	new MemberService().lockMember(mid, false); 
	
	// 跳转到会员列表页面
	request.getRequestDispatcher("./dealchkmember.jsp").forward(request, response);
	
%>