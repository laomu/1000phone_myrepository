<%@page import="java.util.Iterator"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.Set"%>
<%@page import="com.luas.model.Doc"%>
<%@page import="java.util.List"%>
<%@page import="com.luas.model.DocType"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../commons/verifylogin.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>兰文理网络技术共享平台</title>
<link type="text/css" rel="stylesheet" media="all"
	href="${pageContext.request.contextPath}/admin/styles/global.css" />
<link type="text/css" rel="stylesheet" media="all"
	href="${pageContext.request.contextPath}/admin/styles/global_color.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/styles/list.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/admin/styles/jquery-ui.theme.css">
<script src="${pageContext.request.contextPath}/admin/js/jquery-1.11.1.min.js"></script>
<script src="${pageContext.request.contextPath}/admin/js/jquery-ui.min.js"></script>
<script language="javascript" type="text/javascript">
	//删除
	function deleteAccount() {
		var r = window.confirm("确定要删除此文档资料吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
		if(r) {
			
		}
	}
	//开通或暂停
	function setState() {
		var r = window.confirm("确定要开通此账务账号吗？");
		document.getElementById("operate_result_info").style.display = "block";
	}
	$(function() {
		$("#data").accordion();
	});
</script>
</head>
<body>
	<!--Logo区域开始-->
	<div id="header">
		<img src="${pageContext.request.contextPath}/admin/images/logo.png"
			alt="logo" class="left" /> <a
			href="${pageContext.request.contextPath}/admin/commons/logout.jsp">[退出]</a>
	</div>
	<!--Logo区域结束-->
	<!--导航区域开始-->
	<div id="navi">
            <ul id="menu">
                <li><a href="${pageContext.request.contextPath}/admin/index.jsp" class="index_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealchkadmin.jsp" class="admin_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealchkmember.jsp" class="role_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealdoclist.jsp" class="account_on"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealvidiolist.jsp" class="fee_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealbilllist.jsp" class="bill_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealquestionslist.jsp" class="service_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/report/report_list.jsp" class="report_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/user/user_info.jsp" class="information_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/user/user_modi_pwd.jsp" class="password_off"></a></li>
            </ul>
        </div>
	<!--导航区域结束-->
	<!--主要区域开始-->
	<div id="main">
		<form action="" method="">
			<!--查询-->
			<div class="search_add">
				<div>
					身份证：<input type="text" value="不验证" class="text_search" />
				</div>
				<div>
					姓名：<input type="text" class="width70 text_search" value="不验证" />
				</div>
				<div>
					登录名：<input type="text" value="不验证" class="text_search" />
				</div>
				<div>
					状态： <select class="select_search">
						<option>全部</option>
						<option>开通</option>
						<option>暂停</option>
						<option>删除</option>
					</select>
				</div>
				<div>
					<input type="button" value="搜索" class="btn_search" />
				</div>
				<input type="button" value="增加" class="btn_add"
					onclick="location.href='${pageContext.request.contextPath}/admin/deal/dealaccountadd.jsp'" />
			</div>
			<!--删除等的操作提示-->
			<div id="operate_result_info" class="operate_success">
				<img src="../images/close.png"
					onclick="this.parentNode.style.display='none';" />
				删除成功，且已删除其下属的业务账号！
			</div>
			<!--数据区域：用表格展示数据-->
			<div id="data">
				<%
					Map<DocType, List<Doc>> map = (Map<DocType, List<Doc>>) request.getAttribute("docMap");
					Set<Entry<DocType, List<Doc>>> entry = map.entrySet();

					Iterator it = entry.iterator();

					while (it.hasNext()) {
						Entry<DocType, List<Doc>> e = (Entry<DocType, List<Doc>>) it.next();

						DocType dt = e.getKey();
				%>
				<h3>
					[文档类型]&nbsp;&nbsp;&nbsp;&nbsp;<%=dt.getDeName()%>
				</h3>
				<div class="datainfo">
					<table id="datalist">
						<%
							List<Doc> dlist = e.getValue();
								if (dlist != null && dlist.size() > 0) {
									for (int i = 0; i < dlist.size(); i++) {
										Doc doc = dlist.get(i);
						%>
						<tr class="datalistinfo">
							<td><%=doc.getDocId()%></td>
							<td><img
								src="${pageContext.request.contextPath}/<%=doc.getManager().getHeaderImg() %>"
								style="width: 50px; height: 50px;" /></td>
							<td><%=doc.getDname()%></td>
							<td><%=doc.getManager().getUsername()%></td>
							<td><%=doc.getManager().getRealName()%></td>
							<td><%=doc.getPublishTime()%></td>
							<td><%=doc.getManager().getPhone()%></td>
							<td class="td_modi">
								<!-- <input type="button" value="暂停"
												class="btn_pause" onclick="setState();" /> 
												<input type="button"
												value="修改" class="btn_modify"
												onclick="location.href='account_modi.jsp';" />  --> <input
								type="button" value="删除" class="btn_delete"
								onclick="deleteAccount(<%=doc.getDocId() %>);" />
							</td>
						</tr>
						<%
								}
							} else {
						%>
						<tr class="datalistinfo">
							<td colspan="8">当前没有文档数据，敬请期待管理员完善！</td>
						</tr>
						<%
							}
						%>
						</table>
				</div>
				<%
					}
				%>

			</div>
			<p>
				业务说明：<br /> 1、创建则开通，记载创建时间；<br /> 2、暂停后，记载暂停时间；<br />
				3、重新开通后，删除暂停时间；<br /> 4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
				5、暂停账务账号，同时暂停下属的所有业务账号；<br />
				6、暂停后重新开通账务账号，并不同时开启下属的所有业务账号，需要在业务账号管理中单独开启；<br />
				7、删除账务账号，同时删除下属的所有业务账号。
			</p>
			<!--分页-->
			<div id="pages">
				<a href="#">首页</a> <a href="#">上一页</a> <a href="#"
					class="current_page">1</a> <a href="#">2</a> <a href="#">3</a> <a
					href="#">4</a> <a href="#">5</a> <a href="#">下一页</a> <a href="#">末页</a>
			</div>
		</form>
	</div>
	<!--主要区域结束-->
	<div id="footer">
		<p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
		<p>版权所有(C)北京华创恒信科技有限公司</p>
	</div>
</body>
</html>