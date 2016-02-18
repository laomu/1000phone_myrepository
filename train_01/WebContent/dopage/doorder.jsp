<%@page import="com.lzcc.train.service.OrderItemService"%>
<%@page import="com.lzcc.train.model.Shopcart"%>
<%@page import="com.lzcc.train.service.ShopcartService"%>
<%@page import="com.lzcc.train.model.OrderItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.lzcc.train.service.OrderService"%>
<%@page import="java.util.Date"%>
<%@page import="com.lzcc.train.model.Address"%>
<%@page import="com.lzcc.train.service.AddressService"%>
<%@page import="com.lzcc.train.model.User"%>
<%@page import="com.lzcc.train.model.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 生成订单控制器
	// 获取参数
	String [] scids = request.getParameterValues("shopid");// 获取购买的购物对象编号
	String aid = request.getParameter("addr");// 获取地址编号
	String totalPrice = request.getParameter("totalPrice");
	String pay = request.getParameter("pay");// 获取付款方式
	if("1".equals(pay)) {
		pay = "货到付款";
	} else if ("2".equals(pay)) {
		pay= "已经付款";
	} else {
		// 没有选择付款方式，跳回去.
	}
	
	// 生成一个订单
	User user = (User) session.getAttribute("LOGINUSER");
	
	Address addr = new AddressService().findById(aid);
	String address = addr.getAnation().concat(addr.getProvince())
						.concat(addr.getCity()).concat(addr.getCountry())
						.concat(addr.getStreet()).concat(addr.getAdesc());
	String contact = addr.getContact();
	String phone = addr.getPhone(); 
	
	Order order = new Order(user, pay, new Date(), Double.parseDouble(totalPrice), address, contact, phone);
	
	// 保存到数据库，生成主键，用主键封装每个订单项
	int oid = new OrderService().saveOrder(order); 
	order.setOid(oid);
	
	// 组装订单的每一个商品项
	List<OrderItem> oilist = new ArrayList<OrderItem>();
	ShopcartService shopcartService = new ShopcartService();
	OrderItemService oiService = new OrderItemService();
	for(int i = 0; i < scids.length; i++) {
		// 获取购物对象
		Shopcart sc = shopcartService.findById(scids[i]); 
		// 创建订单项对象
		OrderItem oi = new OrderItem(order, sc.getGoods(), sc.getShoppingCount(), sc.getGoods().getPrice(), sc.getSubTotal());
		// 保存订单项到数据库
		oiService.saveOrderItem(oi); 
		// 将订单项添加到列表中
		oilist.add(oi);
	}
	
	order.setOiList(oilist);
	
	// 将订单保存到request中，跳转到下一个页面
	request.setAttribute("order", order);
	request.getRequestDispatcher("../orderdetals.jsp").forward(request, response);
	
	// 保存到数据库
	
	
%>