<%@page import="com.luas.service.MemberService"%>
<%@page import="com.luas.model.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 查看所有的会员信息
	List<Member> memberList = new MemberService().findAll();  

	request.setAttribute("memberList", memberList);

	request.getRequestDispatcher("../role/role_list.jsp").forward(request, response);
%>