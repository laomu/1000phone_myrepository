<%@page import="java.util.TreeMap"%>
<%@page import="com.luas.service.DocService"%>
<%@page import="com.luas.model.Doc"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.luas.model.DocType"%>
<%@page import="java.util.List"%>
<%@page import="com.luas.service.DocTypeService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//查询所有的文档
	// 1.查询所有的文档类型
	List<DocType> docTypeList = new DocTypeService().findAll();

	// 2.查询每一种文档类型下的所有文档
	Map<DocType, List<Doc>> docMap = new TreeMap<DocType, List<Doc>>();
	// 遍历文档类型，获取每一种类型下所有文档
	for(int i =0; i < docTypeList.size(); i++) {
		// 获取当前的正在循环的文档类型
		DocType dt = docTypeList.get(i);
		// 根据文档类型查询这个类型下所有的文档
		List<Doc> dlist = new DocService().findByType(dt);  
		// 将查询到的数据保存到map中
		docMap.put(dt, dlist);
	}
	// 3.将查询到的文档，保存到request中
	request.setAttribute("docMap", docMap);
	
	// 4.跳转到列表页面进行展示
	request.getRequestDispatcher("../doclist.jsp").forward(request,response);
%>