<%@page import="java.util.List"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map,com.luas.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>兰文理网络技术共享平台</title>
</head>
<body>
	<%
		Map<DocType, List<Doc>> map = (Map<DocType, List<Doc>>)request.getAttribute("docMap");
		Set<Entry<DocType, List<Doc>>> entry = map.entrySet();
		
		Iterator it = entry.iterator();
		
		while(it.hasNext()) {
			Entry<DocType, List<Doc>> e = (Entry<DocType, List<Doc>>)it.next();
			
			DocType dt = e.getKey();
			out.print("【类型】" + dt.getDeName() + "<br />");
			out.print(" - - - -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  - <br />");
			List<Doc> dlist = e.getValue();
			for(int i = 0; i < dlist.size(); i++) {
				Doc doc = dlist.get(i);
				out.print("[文件：]" + doc.getDname() + "-----<a href='"+application.getContextPath() + doc.getPath()+"'>下载</a>" + "<br />");
			}
			out.print("<hr/>");
		}
	%>
</body>
</html>