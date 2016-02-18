<%@page import="com.luas.model.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/verifylogin.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>兰文理网络技术共享平台</title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global_color.css" />
        <script src="${pageContext.request.contextPath}/admin/js/jquery-1.11.1.min.js"></script> 
        <script language="javascript" type="text/javascript">
        	// 解锁用户的方法代码——JavaScript技术
	        function unlockedRole(mid) {
	            var r = window.confirm("确定要解锁此角色吗？");
	            document.getElementById("memberopra").action="${pageContext.request.contextPath}/admin/deal/dealmemberunlock.jsp?mid=" + mid;
	            document.forms['memberopra'].submit();
	        }    
        	// 锁定用户的方法代码
	        function lockedRole(mid) {
	            var r = window.confirm("确定要锁定此角色吗？");
	            document.getElementById("memberopra").action="${pageContext.request.contextPath}/admin/deal/dealmemberlock.jsp?mid=" + mid;
	            document.forms['memberopra'].submit();
	        }
        	// 删除用户的方法代码
            function deleteRole(mid) {
                var r = window.confirm("确定要删除此角色吗？");
                //document.getElementById("operate_result_info").style.display = "block";
                document.getElementById("memberopra").action="${pageContext.request.contextPath}/admin/deal/dealmemberdelete.jsp?mid=" + mid;
                document.forms['memberopra'].submit();
            }
        </script>
    </head>
    <body>
        <!--Logo区域开始-->
        <div id="header">
            <img src="${pageContext.request.contextPath}/admin/images/logo.png" alt="logo" class="left"/>
            <a href="${pageContext.request.contextPath}/admin/commons/logout.jsp">[退出]</a>            
        </div>
        <!--Logo区域结束-->
        <!--导航区域开始-->
        <div id="navi">
            <ul id="menu">
                <li><a href="${pageContext.request.contextPath}/admin/index.jsp" class="index_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealchkadmin.jsp" class="admin_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealchkmember.jsp" class="role_on"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealdoclist.jsp" class="account_off"></a></li>
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
            <form action="" method="post" id="memberopra" name="memberopra">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='role_add.jsp';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="${pageContext.request.contextPath}/admin/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr>
                            <th class="th_select_all">
                                <input type="checkbox" onclick="selectAdmins(this);" />
                                <span>全选</span>
                            </th>
                            <th>会员ID</th>
                            <th class="width100">头像</th>
                            <th>姓名</th>
                            <th>登录名</th>
                            <th>电话</th>
                            <th>电子邮件</th>
                            <th>授权日期</th>
                            <th>管理操作</th>
                        </tr>          
                        <%
                        List<Member> list = ( List<Member>)request.getAttribute("memberList");
                        if(list != null && list.size() > 0) {
                        for(int i = 0; i < list.size(); i ++) {
                        	Member m = list.get(i);
                        %>              
                        <tr class="islock">
                            <td><input type="checkbox" /></td>
                            <td><%=m.getId() %></td>
							<td><img src="${pageContext.request.contextPath }/<%=m.getHeaderImg() %>" style="width:100px;height:100px;" /></td>
                            <td><%=m.getRealName() %></td>
                            <td><%=m.getUsername() %></td>
                            <td><%=m.getPhone() %></td>
                            <td><%=m.getEmail() %></td>
                            <td><%=m.getRegistTime() %></td>
                            <td class="td_modi">
                                <%if(m.isLock()) { %>
                                <input type="button" value="解锁" class="btn_modify" onclick="unlockedRole(<%=m.getId() %>);;" />
                                <%}else{ %>
                                <input type="button" value="锁定" class="btn_modify" onclick="lockedRole(<%=m.getId() %>);" />
                                <%} %>
                                <input type="button" value="删除" class="btn_delete" onclick="deleteRole(<%=m.getId() %>);" />
                            </td>
                        </tr>
                        <%}} else { %>
                        <tr>
                        	<td colspan="8">当前系统中没有已经注册的会员</td>
                        </tr>
                        <%} %>
                    </table>
                </div> 
                <!--分页-->
                <div id="pages">
        	        <a href="${pageContext.request.contextPath}/admin/#">上一页</a>
                    <a href="${pageContext.request.contextPath}/admin/#" class="current_page">1</a>
                    <a href="${pageContext.request.contextPath}/admin/#">2</a>
                    <a href="${pageContext.request.contextPath}/admin/#">3</a>
                    <a href="${pageContext.request.contextPath}/admin/#">4</a>
                    <a href="${pageContext.request.contextPath}/admin/#">5</a>
                    <a href="${pageContext.request.contextPath}/admin/#">下一页</a>
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <p>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</p>
            <p>版权所有(C)北京华创恒信科技有限公司 </p>
        </div>
    </body>
</html>