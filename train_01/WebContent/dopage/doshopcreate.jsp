<%@page import="com.lzcc.train.service.ShopService"%>
<%@page import="com.lzcc.train.model.User"%>
<%@page import="com.lzcc.train.model.Shop"%>
<%@page import="java.util.UUID"%>
<%@page import="com.jspsmart.upload.SmartUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 开店控制器
	// 创建文件上传对象
	SmartUpload upload = new SmartUpload(); 

	// 初始化
	upload.initialize(pageContext);
	
	// 上传到内存
	upload.upload();
	
	// 保存文件
	// 1.获取保存文件的路径
	String shopPath = application.getRealPath("/shop/");
	
	// 2.重命名
	String newName = UUID.randomUUID().toString();
	
	// 3.获取文件后缀名
	String ext = upload.getFiles().getFile(0).getFileExt();
	
	// 4.保存文件
	upload.getFiles().getFile(0).saveAs(shopPath + newName + "." + ext);
	
	// 数据保存到数据库
	// 1.门面图片路径 
	String shopImg = "/shop/" + newName + "." + ext;
	// 2.获取店名称和描述
	String shopName = upload.getRequest().getParameter("shopname");
	String shopDesc = upload.getRequest().getParameter("shopdesc");
	
	
	// 包装对象
	User user = (User) session.getAttribute("LOGINUSER");
	Shop shop = new Shop(user, shopName, shopDesc, shopImg);
	
	// 保存商店
	ShopService service = new ShopService();
	service.openShop(shop); 
	
	// 跳转到查询所有商店
	response.sendRedirect("doshopfind.jsp");
%>