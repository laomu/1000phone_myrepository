<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
	Object obj = session.getAttribute("ADMINLOGIN");
	if(obj == null) {
		String url = application.getContextPath();
		response.sendRedirect(url + "/admin/mopower.jsp");
		return;
	}
%>