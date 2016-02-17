<%@page import="com.lzcc.train.service.UserService"%>
<%@page import="com.lzcc.train.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 修改用户登录密码
	// 获取用户数据
	String oldPasswd = request.getParameter("oldpassword");
	String newPasswd = request.getParameter("newpassword");
	String confirmPassword = request.getParameter("confirmpassword");
	
	// 验证数据
	if(oldPasswd.trim() == null || "".equals(oldPasswd.trim())) {
		request.setAttribute("ERROR_USER", "旧密码必须填写");
		request.getRequestDispatcher("../userchgpasswd.jsp").forward(request, response);
		return;
	}
	if(newPasswd == null || "".equals(newPasswd.trim())) {
		request.setAttribute("ERROR_USER", "新密码必须填写");
		request.getRequestDispatcher("../userchgpasswd.jsp").forward(request, response);
		return;
	}
	if(!newPasswd.trim().equals(confirmPassword.trim())) {
		request.setAttribute("ERROR_USER", "两次密码输入不一致");
		request.getRequestDispatcher("../userchgpasswd.jsp").forward(request, response);
		return;
	}
	
	UserService userService = new UserService();
	// 验证旧密码
	// 获取当前登录用户
	User user = (User) session.getAttribute("LOGINUSER");
	user.setPassword(oldPasswd);
	user = userService.login(user);
	if(user == null) {
		request.setAttribute("ERROR_USER", "旧密码输入错误");
		request.getRequestDispatcher("../userchgpasswd.jsp").forward(request, response);
		return;
	}
	
	// 修改密码
	user.setPassword(newPasswd);
	userService.chgPasswd(user); 
	
	// 修改完成跳转到登录页面
	request.setAttribute("ERROR_LOGIN", "密码修改完成，请重新登录");
	request.getRequestDispatcher("../login.jsp").forward(request, response);
%>