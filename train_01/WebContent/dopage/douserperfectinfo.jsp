<%@page import="com.lzcc.train.service.UserService"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression"%>
<%@page import="com.lzcc.train.utils.RegNoUtils"%>
<%@page import="com.lzcc.train.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 完善个人资料
	// 设置编码
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=utf-8");
	
	// 获取可修改数据
	String nickname = request.getParameter("nickname");
	String regNo = request.getParameter("regno");
	String email = request.getParameter("email");
	String phone = request.getParameter("phone");

	// 验证数据
	if(nickname.trim() == null || "".equals(nickname.trim())) {
		request.setAttribute("ERROR_USER", "昵称必须填写");
		request.getRequestDispatcher("../userperfectinfo.jsp").forward(request, response);
		return;
	}
	if(!RegNoUtils.validRegNo(regNo)) {
		request.setAttribute("ERROR_USER", "身份证号码不合法，请重新填写");
		request.getRequestDispatcher("../userperfectinfo.jsp").forward(request, response);
		return;
	}
	if(email.trim() == null || "".equals(email.trim())) {
		request.setAttribute("ERROR_USER", "邮箱必须填写");
		request.getRequestDispatcher("../userperfectinfo.jsp").forward(request, response);
		return;
	}
	if(phone.trim() == null || "".equals(phone.trim())) {
		request.setAttribute("ERROR_USER", "联系方式必须填写");
		request.getRequestDispatcher("../userperfectinfo.jsp").forward(request, response);
		return;
	}
	
	// 获取当前登录用户
	User user = (User) session.getAttribute("LOGINUSER");
	
	// 根据身份证号码计算年龄和性别 并赋值修改数据
	user.setGender(RegNoUtils.getGender(regNo));
	user.setAge(RegNoUtils.getAge(regNo));
	user.setRegNo(regNo);
	user.setEmail(email);
	user.setPhone(phone);
	
	// 更新资料到数据库
	new UserService().perfectInfo(user);
	// 更新session中的数据
	session.setAttribute("LOGINUSER", user);
	
	// 跳转到更新资料页面
	request.setAttribute("ERROR_USER", "恭喜您，资料完善成功。");
	request.getRequestDispatcher("../userperfectinfo.jsp").forward(request, response);
	return;
%>