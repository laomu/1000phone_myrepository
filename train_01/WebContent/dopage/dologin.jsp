<%@page import="com.lzcc.train.service.UserService"%>
<%@page import="com.lzcc.train.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 处理登录业务控制器
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	
	// 获取数据
	String un = request.getParameter("username");
	String pw = request.getParameter("password"); 
	
	// 验证合法性
	if(un == null || "".equals(un)) {
		// 验证失败
		request.setAttribute("ERROR_LOGIN", "请填写登录账号");
		request.getRequestDispatcher("../login.jsp").forward(request, response);
		return;//如果页面跳转了，直接返回不允许向下执行
	}
	if(pw == null || "".equals(pw)) {
		// 验证失败
		request.setAttribute("ERROR_LOGIN", "请填写登录密码");
		request.getRequestDispatcher("../login.jsp").forward(request, response);
		return;//如果页面跳转了，直接返回不允许向下执行
	}
	
	// 包装对象
	User loginUser = new User(un , pw); 
	
	// 登录处理
	UserService service = new UserService();
	loginUser = service.login(loginUser);
	
	// 判断
	if(loginUser != null) {
		// 登录成功
		session.setAttribute("LOGINUSER",loginUser);
		response.sendRedirect("../index.jsp");
	} else {
		// 登录失败
		request.setAttribute("ERROR_LOGIN", "账号或者密码有误，请重新登录...");
		request.getRequestDispatcher("../login.jsp").forward(request, response);
	}
%>