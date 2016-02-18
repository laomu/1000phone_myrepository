<%@page import="java.io.File"%>
<%@page import="com.luas.model.Doc"%>
<%@page import="com.luas.service.DocService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 删除文档资料
	// 1.获取要删除的文档资料编号
	String id = request.getParameter("deid");

	// 2.删除文档资料
	Doc doc = new DocService().deleteDoc(id); 
	
	// 3. 获取删除文件的路径，删除文件
	String path = doc.getPath();
	String realPath = application.getRealPath(path);
	File file = new File(realPath);
	if(file.exists()) file.delete();
	
	// 4.跳转会文档列表
	response.sendRedirect("dealdoclist.jsp");
%>