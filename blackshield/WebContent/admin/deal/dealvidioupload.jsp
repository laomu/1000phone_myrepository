<%@page import="com.luas.model.Course"%>
<%@page import="com.luas.service.CourseService"%>
<%@page import="com.luas.service.CourseTypeService"%>
<%@page import="com.luas.model.CourseType"%>
<%@page import="com.luas.service.ToolsService"%>
<%@page import="com.luas.model.Tools"%>
<%@page import="com.luas.service.ToolsTypeService"%>
<%@page import="com.luas.model.ToolsType"%>
<%@page import="com.luas.service.DocService"%>
<%@page import="java.util.Date"%>
<%@page import="com.luas.service.DocTypeService"%>
<%@page import="com.luas.model.DocType"%>
<%@page import="com.luas.model.Manager"%>
<%@page import="com.luas.model.Doc"%>
<%@page import="java.io.File"%>
<%@page import="java.util.UUID"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
<%@page import="com.sun.org.apache.xalan.internal.xsltc.trax.SmartTransformerFactoryImpl"%>
<%@include file="../commons/verifylogin.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	 * 1. 上传文件
	 */
	// 创建文件上传下载对象
	SmartUpload upload = new SmartUpload();

	// 初始化上传对象
	upload.initialize(pageContext);
	
	// 上传对象-->程序的内存中
	upload.upload();

	// 获取要保存文件的真实路径
	String basePath = "/resource/vidio/";
	String path = application.getRealPath(basePath);
	System.out.println(path);

	// 获取并保存工具封面图片
	String pageName = UUID.randomUUID().toString();
	String extName = upload.getFiles().getFile(0).getFileExt();
	pageName += "." + extName;
	upload.getFiles().getFile(0).saveAs(path + "/" + pageName);

	// 获取文件名称
	String fileName = upload.getFiles().getFile(1).getFileName();
	// 获取文件后缀名
	extName = upload.getFiles().getFile(1).getFileExt();	
	fileName += "." + extName;
	// 给文件生成新的名称
	String newFileName = UUID.randomUUID().toString();
	newFileName += "." + extName;
	// 保存文件
	upload.getFiles().getFile(1).saveAs(path + "/" + newFileName);
	/*
	 * 2.数据库中记录文档
	 */
	String cname = upload.getRequest().getParameter("courseName");// 视频课程名称
	String cTypeId = upload.getRequest().getParameter("courseType");// 视频课程类型
	String cdesc = upload.getRequest().getParameter("courseDesc");// 视频课程描述
	Manager manager = (Manager)session.getAttribute("ADMINLOGIN");//上传文件的管理员
	
	// 根据文档编号获取文档类型对象
	CourseType courseType = new CourseTypeService().findById(cTypeId);    
	Course course = new Course(manager, courseType, basePath+pageName, cname, cdesc, 0, new Date(), basePath + newFileName) ;
	
	
	// 将文档对象保存到数据库中
	new CourseService().save(course); 
	
	// 跳转到下一个页面，查询所有的文档对象
	// TODO 查询所有对象
	response.sendRedirect("./dealvidiolist.jsp");
%>