<%@page import="com.lzcc.train.service.UserService"%>
<%@page import="com.lzcc.train.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 处理注册业务控制器
	// 设置编码
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	
	// 获取数据
	String un = request.getParameter("username");
	String pw = request.getParameter("password");
	String repw = request.getParameter("repassword");
	String nn = request.getParameter("nickname");
	
	// 验证数据
	if(un == null || "".equals(un.trim())) {
		// 验证失败
		request.setAttribute("ERROR_REGIST", "请填写注册账号");
		request.getRequestDispatcher("../regist.jsp").forward(request, response);
		return;//如果页面跳转了，直接返回不允许向下执行
	}
	if(un.length() < 6 || un.length() > 15) {
		// 验证失败
		request.setAttribute("ERROR_REGIST", "注册账号长度必须是6~15位");
		request.getRequestDispatcher("../regist.jsp").forward(request, response);
		return;//如果页面跳转了，直接返回不允许向下执行
	}
	
	if(pw == null || "".equals(pw.trim())) {
		// 验证失败
		request.setAttribute("ERROR_REGIST", "请填写注册账号");
		request.getRequestDispatcher("../regist.jsp").forward(request, response);
		return;//如果页面跳转了，直接返回不允许向下执行
	}
	
	if(pw.length() < 6 || pw.length() > 15) {
		// 验证失败
		request.setAttribute("ERROR_REGIST", "密码设置长度必须是6~15位");
		request.getRequestDispatcher("../regist.jsp").forward(request, response);
		return;//如果页面跳转了，直接返回不允许向下执行
	}
	
	if(!pw.equals(repw)) {
		// 验证失败
		request.setAttribute("ERROR_REGIST", "两次密码输入不一致!");
		request.getRequestDispatcher("../regist.jsp").forward(request, response);
		return;//如果页面跳转了，直接返回不允许向下执行
	}
	
	if(nn == null || "".equals(nn.trim())) {
		// 验证失败
		request.setAttribute("ERROR_REGIST", "请填写昵称");
		request.getRequestDispatcher("../regist.jsp").forward(request, response);
		return;//如果页面跳转了，直接返回不允许向下执行
	}
	
	// 验证通过，包装对象
	User user = new User(un, pw, nn); 
	
	// 开始注册
	UserService service = new UserService();
	int result = service.regist(user);
	
	//判断
	if(result > 0) { 
		// 注册成功
		response.sendRedirect("../registsucc.jsp");
	} else if(result == -2) {
		// 验证失败
		request.setAttribute("ERROR_REGIST", "账号已经被注册，请使用其他账号重新注册");
		request.getRequestDispatcher("../regist.jsp").forward(request, response);
		return;//如果页面跳转了，直接返回不允许向下执行
	} else {
		// 验证失败
		request.setAttribute("ERROR_REGIST", "系统繁忙，请稍后再试...");
		request.getRequestDispatcher("../regist.jsp").forward(request, response);
		return;//如果页面跳转了，直接返回不允许向下执行
	}
	
%>