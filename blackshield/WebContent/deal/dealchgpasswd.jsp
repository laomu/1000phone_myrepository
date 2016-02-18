<%@page import="com.luas.model.Users"%>
<%@page import="com.luas.service.LoginService"%>
<%@page import="com.luas.model.Member"%>
<%@page import="com.luas.service.PasswordService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 修改会员登录密码
	// 设置编码
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	// 获取数据
	String oldPasswd = request.getParameter("old_passwd");
	String newPasswd1 = request.getParameter("new_pwd1");
	String newPasswd2 = request.getParameter("new_pwd2");
	
	// 判断逻辑合法性
	if(oldPasswd == null || oldPasswd.trim() == "" ){
		request.setAttribute("ERROR", "旧密码不能为空...");
		request.getRequestDispatcher("../chgpasswd.jsp").forward(request, response);
		return ;
	}
	if(newPasswd1 == null || newPasswd1.trim() == "" ){
		request.setAttribute("ERROR", "新密码不能为空...");
		request.getRequestDispatcher("../chgpasswd.jsp").forward(request, response);
		return ;
	}
	if(!newPasswd1.trim().equals(newPasswd2)){
		request.setAttribute("ERROR", "新密码两次输入不一致...");
		request.getRequestDispatcher("../chgpasswd.jsp").forward(request, response);
		return ;
	}
	// 获取当前登录用户
	Member member = (Member)session.getAttribute("LOGIN");
	// 验证旧密码是否正确
	member.setPassword(oldPasswd);
	Users u = new LoginService().login(member);
	if(u == null) {
		request.setAttribute("ERROR", "旧密码输入有误...");
		request.getRequestDispatcher("../chgpasswd.jsp").forward(request, response);
		return ;
	}
	
	member.setPassword(newPasswd1);
	// 修改密码
	new PasswordService().chgPasswd(member);
	
	// 移除session中的数据
	session.removeAttribute("LOGIN");
	session.invalidate();
	
	// 跳转到登录页面
	response.sendRedirect("../chgpasswdsuccess.jsp");	
%>