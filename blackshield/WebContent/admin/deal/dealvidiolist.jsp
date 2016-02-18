<%@page import="com.luas.service.CourseService"%>
<%@page import="com.luas.model.Course"%>
<%@page import="com.luas.service.CourseTypeService"%>
<%@page import="com.luas.model.CourseType"%>
<%@page import="com.luas.service.ToolsService"%>
<%@page import="com.luas.model.Tools"%>
<%@page import="com.luas.service.ToolsTypeService"%>
<%@page import="com.luas.model.ToolsType"%>
<%@page import="java.util.TreeMap"%>
<%@page import="com.luas.service.DocService"%>
<%@page import="com.luas.model.Doc"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.luas.model.DocType"%>
<%@page import="java.util.List"%>
<%@page import="com.luas.service.DocTypeService"%>
<%@ include file="../commons/verifylogin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//查询所有的视频课程
	// 1.查询所有的视频课程类型
	List<CourseType> courseTypeList = new CourseTypeService().findAll();

	// 2.查询每一种视频课程类型下的所有视频课程
	Map<CourseType, List<Course>> courseMap = new TreeMap<CourseType, List<Course>>();
	// 遍历视频课程类型，获取每一种类型下所有视频课程
	for(int i =0; i < courseTypeList.size(); i++) {
		// 获取当前的正在循环的视频课程类型
		CourseType dt = courseTypeList.get(i);
		// 根据视频课程类型查询这个类型下所有的视频课程
		List<Course> dlist = new CourseService().findByType(dt);   
		// 将查询到的数据保存到map中
		courseMap.put(dt, dlist);
	}
	// 3.将查询到的视频课程，保存到request中
	request.setAttribute("courseMap", courseMap);
	
	// 4.跳转到列表页面进行展示
	request.getRequestDispatcher("../fee/fee_list.jsp").forward(request,response);
%>