<%@page import="com.lzcc.train.service.AddressService"%>
<%@page import="com.lzcc.train.model.Address"%>
<%@page import="com.lzcc.train.service.ShopcartService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lzcc.train.model.Shopcart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 付款页面
	String [] scids = request.getParameterValues("shopid");// 获取要购买的商品编号数组
	String aid = request.getParameter("addr");// 获取收货地址编号
	// 验证
	if(scids == null) {
		request.setAttribute("ERROR_SHOP", "您还没有选择要购买的商品，请选择后进行购买");
		request.getRequestDispatcher("dofindcart.jsp").forward(request, response);
		return;
	}
	if(aid == null) {
		request.setAttribute("ERROR_SHOP", "您还没有选择收货地址，请选择后进行购买");
		request.getRequestDispatcher("dofindcart.jsp").forward(request, response);
		return;
	}
	// 查询数据
	// 查询购物对象
	List<Shopcart> sclist = new ArrayList<Shopcart>();
	ShopcartService ss = new ShopcartService();
	for(int i = 0; i < scids.length; i++) {
		Shopcart sc = ss.findById(scids[i]); 
		sclist.add(sc);
	}
	// 查询地址
	Address addr = new AddressService().findById(aid);
	
	// 添加到request中，并跳转到下一个页面
	request.setAttribute("sclist", sclist);
	request.setAttribute("addr", addr);
	
	request.getRequestDispatcher("../pay.jsp").forward(request, response);
	
%>