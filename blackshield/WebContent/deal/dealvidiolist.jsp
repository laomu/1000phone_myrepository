<%@page import="com.luas.service.CourseService"%>
<%@page import="com.luas.model.Course"%>
<%@page import="com.luas.service.CourseTypeService"%>
<%@page import="com.luas.model.CourseType"%>
<%@page import="com.luas.service.ToolsService"%>
<%@page import="java.util.TreeMap"%>
<%@page import="com.luas.model.Tools"%>
<%@page import="java.util.Map"%>
<%@page import="com.luas.service.ToolsTypeService"%>
<%@page import="com.luas.model.ToolsType"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 按照视频课程类型查询所有的软件工具对象
	//查询所有的视频
	// 1.查询所有的视频课程
	List<CourseType> courseTypeList = new CourseTypeService().findAll();

	// 2.查询每一种视频课程下的所有视频
	Map<CourseType, List<Course>> courseMap = new TreeMap<CourseType, List<Course>>();
	// 遍历视频课程，获取每一种类型下所有视频
	for(int i =0; i < courseTypeList.size(); i++) {
		// 获取当前的正在循环的视频课程
		CourseType ct = courseTypeList.get(i);
		// 根据视频课程查询这个类型下所有的视频
		List<Course> clist = new CourseService().findByType(ct);  
		// 将查询到的数据保存到map中
		courseMap.put(ct, clist);
	}
	// 3.将查询到的视频，保存到request中
	request.setAttribute("courseMap", courseMap);
	
	// 4.跳转到列表页面进行展示
	request.getRequestDispatcher("../vidiolist.jsp").forward(request,response);
%>