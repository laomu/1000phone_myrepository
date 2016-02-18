<%@page import="com.luas.service.ManagerService"%>
<%@page import="com.luas.model.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 完善管理员个人信息页面
	// 1. 设置编码
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("UTF-8");
	
	// 2.获取数据
	String rn = request.getParameter("realName");
	String em = request.getParameter("email");
	String ph = request.getParameter("phone");
	
	// 3. 获取管理员
	Manager manager = (Manager)session.getAttribute("ADMINLOGIN");
	
	// 4. 修改管理员信息
	manager.setRealName(rn);
	manager.setEmail(em);
	manager.setPhone(ph);
	
	// 5. 保存新的管理员信息到数据库
	new ManagerService().perfect(manager); 
	
	// 6. 更新session中保存的管理员
	session.setAttribute("ADMINLOGIN", manager);
	
	// 7. 返回到user_info.jsp修改页面
	request.setAttribute("INFO", "信息更新成功！");
	request.getRequestDispatcher("../user/user_info.jsp").forward(request, response);
%>