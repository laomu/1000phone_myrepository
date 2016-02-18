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
	// 按照软件工具类型查询所有的软件工具对象
	//查询所有的文档
	// 1.查询所有的软件工具
	List<ToolsType> toolsTypeList = new ToolsTypeService().findAll();

	// 2.查询每一种软件工具下的所有文档
	Map<ToolsType, List<Tools>> toolsMap = new TreeMap<ToolsType, List<Tools>>();
	// 遍历软件工具，获取每一种类型下所有文档
	for(int i =0; i < toolsTypeList.size(); i++) {
		// 获取当前的正在循环的软件工具
		ToolsType tt = toolsTypeList.get(i);
		// 根据软件工具查询这个类型下所有的文档
		List<Tools> tlist = new ToolsService().findByType(tt);  
		// 将查询到的数据保存到map中
		toolsMap.put(tt, tlist);
	}
	// 3.将查询到的文档，保存到request中
	request.setAttribute("toolsMap", toolsMap);
	
	// 4.跳转到列表页面进行展示
	request.getRequestDispatcher("../toolslist.jsp").forward(request,response);
%>