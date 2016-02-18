<%@page import="com.luas.service.CourseService"%>
<%@page import="com.luas.model.Course"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 处理播放视频
	String cid = request.getParameter("courseid");
 
	Course course = new CourseService().findById(cid);

	request.setAttribute("course", course);
	request.setAttribute("path", course.getPath());
	
	request.getRequestDispatcher("../player.jsp").forward(request,response);
%>