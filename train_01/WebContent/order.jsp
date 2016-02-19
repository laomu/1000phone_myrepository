<%@page import="com.lzcc.train.model.OrderItem"%>
<%@page import="com.lzcc.train.model.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>查看用户历史订单</h1>
	<%
		List<Order> olist = (List<Order>)request.getAttribute("olist");
		if(olist !=null && olist.size() > 0) {
			for(int i = 0; i < olist.size(); i++) {
				Order order = olist.get(i);
				List<OrderItem> oiList = order.getOiList();
	%>
		<div>
		订单编号：<%=order.getOid() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		下单时间：<%=order.getOrderTime() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		总金额：<%=order.getTotalPrice() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<ul>
			<%
				for(int j = 0; j < oiList.size(); j++) {
					OrderItem oi = oiList.get(i);
			%>
				<li>
				<img style="width:100px;height:100px;" src="${pageContext.request.contextPath }/<%=oi.getGoods().getGiList().get(0).getPath()%>"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				商品名称:<%=oi.getGoods().getGname() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				成交价格:<%=oi.getDealPrice() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				购买数量:<%=oi.getBuyCount() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				小计金额:<%=oi.getSubTotal() %>
				</li>
			<%}%> 
			</ul>
		<%}} else { %>
		<div>当前用户还没有购买过商品</div>
	<%} %>
</body>
</html>