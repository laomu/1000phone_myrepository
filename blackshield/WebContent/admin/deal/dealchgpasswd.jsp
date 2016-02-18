<%@page import="com.luas.model.Manager"%>
<%@page import="com.luas.service.PasswordService"%>
<%@page import="com.luas.model.Users"%>
<%@page import="com.luas.model.Member"%>
<%@page import="com.luas.service.LoginService"%>
<%@page import="com.luas.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 修改管理员密码
	// 设置编码过滤
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	// 获取密码数据
	String old_pass = request.getParameter("pwd1");
	String new_pass1 = request.getParameter("pwd2");
	String new_pass2 = request.getParameter("pwd3");
	
	// 判断旧密码是否正确
	if(old_pass.trim().equals("")) {
		request.setAttribute("ERROR", "旧密码不能为空...");
		request.getRequestDispatcher("../user/user_modi_pwd.jsp").forward(request, response);
		return;
	}
	// 从session中获取当前登录用户
	Manager verifyManager = (Manager)session.getAttribute("ADMINLOGIN");
	// 将用户输入的旧密码设置给这个用户
	verifyManager.setPassword(old_pass);
	// 使用这个改变了密码的用户重新进行登录，如果返回的U不为null，说明旧密码正确
	Users u = new LoginService().login(verifyManager);
	if(u == null) {
		request.setAttribute("ERROR", "旧密码填写有误...");
		request.getRequestDispatcher("../user/user_modi_pwd.jsp").forward(request, response);
		return;
	}
	// 判断新密码是否合法
	if(new_pass1.trim().equals("") || new_pass1 == null) {
		request.setAttribute("ERROR", "新密码不能为空...");
		request.getRequestDispatcher("../user/user_modi_pwd.jsp").forward(request, response);
		return;
	}
	// 判断新密码是否合法
	if (new_pass2.trim().equals("") || new_pass2 == null) {
		request.setAttribute("ERROR", "确认密码不能为空...");
		request.getRequestDispatcher("../user/user_modi_pwd.jsp").forward(request, response);
		return;
	}
	// 判断密码输入是否一致。trim()方法表示去掉字符串两边的空格
	if (!new_pass1.trim().equals(new_pass2.trim())) {
		request.setAttribute("ERROR", "两次密码输入不一致...");
		request.getRequestDispatcher("../user/user_modi_pwd.jsp").forward(request, response);
		return;
	}
	// 修改密码
	verifyManager.setPassword(new_pass1);
	new PasswordService().chgPasswd(verifyManager); 
	// 重新登录
	response.sendRedirect("../user/user_modi_succ.jsp");
%>