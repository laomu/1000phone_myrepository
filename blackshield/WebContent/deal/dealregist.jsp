<%@page import="com.luas.service.RegistService"%>
<%@page import="com.luas.service.MemberService"%>
<%@page import="com.luas.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 处理注册的控制器
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	// 获取数据
	String un = request.getParameter("username");
	String pw = request.getParameter("password");
	String pw2 = request.getParameter("password2");
	String rn = request.getParameter("realName");
	
	// 非空判断
	if(un == null || pw == null || pw2 == null || rn == null) {
		response.sendRedirect("../regist.jsp");
		return;
	}
	
	// 判断数据
	if(!pw.equals(pw2)) {
		request.setAttribute("ERROR", "两次密码输入不一致，请重新注册");
		request.getRequestDispatcher("../regist.jsp").forward(request, response);
		return;
	}
	
	// 创建对象
	Member member = new Member(un, pw , rn);
	
	// 注册
	boolean isOk = new RegistService().regist(member); 
	
	if(isOk) {
		response.sendRedirect("../registsuccess.jsp");
	} else {
		request.setAttribute("ERROR", "当前账号已经注册，请使用其他账号重新注册");
		request.getRequestDispatcher("../regist.jsp").forward(request, response);
	}
%>