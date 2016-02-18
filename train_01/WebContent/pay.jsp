<%@page import="com.lzcc.train.model.Address"%>
<%@page import="com.lzcc.train.model.Shopcart"%>
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
	<form method="post" action="${pageContext.request.contextPath }/dopage/doorder.jsp">
		<h1>用户付款页面</h1>
		<h2>用户购买的商品</h2>
		<ul>
		<%
			List<Shopcart> sclist = (List<Shopcart>)request.getAttribute("sclist");
			Address addr = (Address) request.getAttribute("addr");
			double total = 0;
			for(int i = 0; i < sclist.size(); i++) {
				Shopcart sc = sclist.get(i);
				total += sc.getSubTotal();
		%>
			<input type="hidden" name="shopid" value="<%=sc.getScId()%>"/>
			<li>商品名称：<%=sc.getGoods().getGname() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			购买数量：<%=sc.getShoppingCount() %>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			小计金额：<%=sc.getSubTotal() %></li>
		<%} %>
		</ul>
		<input type="hidden" name="totalPrice" value="<%=total %>"/>
		<h3>总计金额：<%=total %></h3>
		<h2>收货地址</h2>
		<input type="hidden" value="<%=addr.getAid() %>" name="addr"/>
		<address><%=addr %></address>
		<h2>选择付款方式</h2>
		<input type="radio" name="pay" value="1" />货到付款<br />
		<input type="radio" name="pay" value="2"/>立即付款
		
		<input type="submit" value="立即购买" class="orange-btn"/>
	</form>
</body>
</html>