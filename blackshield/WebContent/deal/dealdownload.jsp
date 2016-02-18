<%@page import="com.jspsmart.upload.SmartUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 处理用户下载文件的页面
	// 接受下载的文件路径
	String urlPath = request.getParameter("urlpath");
	// 初始化下载对象
	SmartUpload upload = new SmartUpload();
	upload.initialize(pageContext);
	
	// 设置打开方式
	// 设定contentdisposition为null以禁止浏览器自动打开文件， 
	//保证点击链接后是下载文件。若不设定，则下载的文件扩展名为 
	//doc时，浏览器将自动用word打开它。扩展名为pdf时， 
	//浏览器将用acrobat打开。 
	upload.setContentDisposition(null);
	
	// 下载文件
	upload.downloadFile(application.getRealPath(urlPath));

	out.clear();
	out = pageContext.pushBody();
%>