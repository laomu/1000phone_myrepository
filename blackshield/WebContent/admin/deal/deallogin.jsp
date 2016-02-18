<%@page import="com.luas.service.LoginService"%>
<%@page import="com.luas.service.ManagerService"%>
<%@page import="com.luas.model.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 设置编码
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	// 获取参数
	String un = request.getParameter("username");
	String pw = request.getParameter("password");
	String sc = request.getParameter("safecode");
	
	// 判断验证码是否正确
	String safecode = (String)session.getAttribute("safecode");
	System.out.println(sc);
	System.out.println(safecode);
	if(!safecode.equalsIgnoreCase(sc)){
		request.setAttribute("ERRORSC", "验证码有误");
		request.getRequestDispatcher("../login.jsp").forward(request, response);
		return;
	}
	
	// 创建管理员对象
	Manager manager = new Manager(un, pw);
	
	// 调用管理员服务类进行登陆 
	manager = (Manager)new LoginService().login(manager);
	
	// 判断登录是否成功
	if(manager != null) {
		// 登录成功
		session.setAttribute("ADMINLOGIN", manager);
		response.sendRedirect("../index.jsp");
	} else {
		request.setAttribute("ERROR", "账号或者密码有误，请重新登录...");
		request.getRequestDispatcher("../login.jsp").forward(request, response);
	}
	
%>