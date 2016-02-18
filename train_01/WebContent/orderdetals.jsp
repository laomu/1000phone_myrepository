<%@page import="com.lzcc.train.model.OrderItem"%>
<%@page import="java.util.List"%>
<%@page import="com.lzcc.train.model.Order"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>查看订单</h1>
	<%
		// 获取订单
		Order order = (Order) request.getAttribute("order");
		// 获取订单项
		List<OrderItem> oilist = order.getOiList();
	%>
	<h2>订单编号：<%=order.getOid() %>&nbsp;&nbsp;&nbsp;&nbsp;下单时间：<%=order.getOrderTime() %>
		&nbsp;&nbsp;&nbsp;&nbsp;订单中共有<%=oilist.size() %>件商品成交
	</h2>
	<ul>
	<%
		for(int i = 0; i < oilist.size(); i ++) {
			OrderItem oi = oilist.get(i);
	%>
		<li>商品名称：<%=oi.getGoods().getGname() %>&nbsp;&nbsp;&nbsp;&nbsp;
			商品类型：<%=oi.getGoods().getGoodsType().getGtName() %>&nbsp;&nbsp;&nbsp;&nbsp;
			成交价格：<%=oi.getDealPrice() %>&nbsp;&nbsp;&nbsp;&nbsp;
			购买数量：<%=oi.getBuyCount() %>&nbsp;&nbsp;&nbsp;&nbsp;
			小计金额：<%=oi.getSubTotal() %>&nbsp;&nbsp;&nbsp;&nbsp;
		</li>
	<%} %>
	</ul>
	<h2>收货地址：<%=order.getAddress() %></h2>
	<h2>收货人：<%=order.getContact() %></h2>
	<h2>联系方式：<%=order.getPhone() %></h2>
	<h2>订单状态：<%=order.getStatus() %></h2>
	<h2>总计金额：<%=order.getTotalPrice() %></h2>
</body>
</html>