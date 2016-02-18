<%@page import="com.luas.model.Manager"%>
<%@page import="java.util.List"%>
<%@page import="com.luas.service.ManagerService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 查询所有的管理员信息 
	List<Manager> managerList = new ManagerService().findAll(); 

	request.setAttribute("managerList", managerList);
	
	request.getRequestDispatcher("../admin/admin_list.jsp").forward(request, response);
%>