<%@page import="com.luas.service.MemberService"%>
<%@page import="com.luas.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 会员完善个人资料页面
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	// 获取数据
	String realName = request.getParameter("realName");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	
	// 获取当前登录会员
	Member member = (Member) session.getAttribute("LOGIN");
	member.setRealName(realName);
	member.setPhone(phone);
	member.setEmail(email);
	
	// 更新数据 
	new MemberService().perfectInfo(member);
	
	// 更新session
	session.setAttribute("LOGIN", member);
	
	// 跳转回更改信息页面
	response.sendRedirect("../perfectinfo.jsp");
%>