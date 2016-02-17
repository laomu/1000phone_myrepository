<%@page import="com.lzcc.train.service.GoodsImageService"%>
<%@page import="com.lzcc.train.model.GoodsImage"%>
<%@page import="com.lzcc.train.service.GoodsService"%>
<%@page import="com.lzcc.train.model.Shop"%>
<%@page import="com.lzcc.train.service.ShopService"%>
<%@page import="com.lzcc.train.service.GoodsTypeService"%>
<%@page import="com.lzcc.train.model.GoodsType"%>
<%@page import="com.lzcc.train.model.ActivityType"%>
<%@page import="com.lzcc.train.service.ActivityTypeService"%>
<%@page import="com.lzcc.train.model.Goods"%>
<%@page import="java.util.UUID"%>
<%@page import="com.jspsmart.upload.SmartUpload"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 增加商品页面
	SmartUpload upload = new SmartUpload();

	upload.initialize(pageContext);
	
	upload.upload();
	
	String newName = UUID.randomUUID().toString();
	
	String ext = upload.getFiles().getFile(0).getFileExt();
	
	String path = application.getRealPath("/goodsimg/");
	
	upload.getFiles().getFile(0).saveAs(path + newName + "." + ext);
	
	// 保存商品
	// 获取商品信息
	String sid = upload.getRequest().getParameter("sid");
	String gname = upload.getRequest().getParameter("gname");
	String gtype = upload.getRequest().getParameter("gtype");
	String atype = upload.getRequest().getParameter("atype");
	String orignalcost = upload.getRequest().getParameter("orignalcost");
	String price = upload.getRequest().getParameter("price");
	String stock = upload.getRequest().getParameter("stock");
	String gdesc = upload.getRequest().getParameter("gdesc");
	
	ActivityType at = new ActivityTypeService().findById(atype);
	GoodsType gt = new GoodsTypeService().findById(gtype);
	Shop shop = new ShopService().findById(sid); 
	 
	Goods goods = new Goods(gt, at, shop, 
			gname, Double.parseDouble(orignalcost),
			Double.parseDouble(price), Integer.parseInt(stock),gdesc);
	
	GoodsService goodsService = new GoodsService();
	int gid = goodsService.saveGoods(goods);
	
	goods = goodsService.findById(String.valueOf(gid)); 
	
	// 保存图片 
	GoodsImage goodsImage = new GoodsImage(goods, "/goodsimg/" + newName + "." + ext);
	
	new GoodsImageService().saveGoodsImage(goodsImage); 
	
	// 跳转到查询商品页面
	response.sendRedirect("dogoodsfindbyshop.jsp?sid=" + sid);
%>