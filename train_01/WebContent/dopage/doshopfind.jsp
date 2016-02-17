<%@page import="com.lzcc.train.model.Shop"%>
<%@page import="java.util.List"%>
<%@page import="com.lzcc.train.service.ShopService"%>
<%@page import="com.lzcc.train.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 查询当前用户所有商店
	User user = (User) session.getAttribute("LOGINUSER");

	// 调用商店业务处理类查询当前用户商店
	ShopService shopService = new ShopService();
	
	List<Shop> shopList = shopService.findByUser(user); 
	
	// 判断当前用户是否拥有商店
	if(shopList == null || shopList.size() == 0) {
		// 跳转到添加商店页面
		request.setAttribute("ERROR_SHOP", "尊敬的用户，您还没有商店，请先开店！");
		// 跳转到商店页面展示商店
		request.getRequestDispatcher("../shopcreate.jsp").forward(request, response);
	} else {
		// 将商店数据添加到request中
		request.setAttribute("slist", shopList);
		// 跳转到商店页面展示商店
		request.getRequestDispatcher("../shop.jsp").forward(request, response);
	}
%> 