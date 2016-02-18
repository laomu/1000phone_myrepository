<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Object obj = session.getAttribute("ADMINLOGIN");
	if(obj == null) {
		String url = application.getContextPath();
		response.sendRedirect(url + "/admin/mopower.jsp");
		return;
	}
%>