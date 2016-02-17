<%@page import="com.lzcc.train.model.Goods"%>
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
	<%
		List<Goods> glist = (List<Goods>) request.getAttribute("glist");
		if(glist!=null && glist.size() > 0) {
		for(int i = 0; i < glist.size(); i++) {
			Goods g = glist.get(i);
	%>
	<h2>商品名称：<%=g.getGname() %>&nbsp;&nbsp;&nbsp;&nbsp;商品单价：<%=g.getPrice() %></h2>
	<%} }else{ %>
	<h2>没有搜索到的商品</h2>
	<%} %>
</body>
</html>