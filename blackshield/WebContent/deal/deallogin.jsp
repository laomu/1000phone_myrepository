<%@page import="com.luas.service.LoginService"%>
<%@page import="com.luas.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	// 处理登录的控制器
	// 设置编码
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");

	// 获取参数
	String un = request.getParameter("username");
	String pw = request.getParameter("password");

	// 创建对象
	Member member = new Member(un, pw);

	// 调用MemberService业务处理类登录
	member = (Member) new LoginService().login(member);

	// 判断登录是否成功
	if (member == null) {
		request.setAttribute("ERROR", "账号或者密码有误，请重新登录");
		request.getRequestDispatcher("../login.jsp").forward(request, response);
	} else {
		if (member.isLock()) {
			request.setAttribute("ERROR", "账号已经锁定，请联系管理员");
			request.getRequestDispatcher("../login.jsp").forward(request, response);
		} else {
			session.setAttribute("LOGIN", member);// 登录成功记录登录状态
			response.sendRedirect("../index.jsp");// 跳转到系统主页
		}
	}
%>