<%@page import="com.luas.model.Questions"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../commons/verifylogin.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>兰文理网络技术共享平台</title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global_color.css" /> 
        <script language="javascript" type="text/javascript">
            //显示角色详细信息
            function showDetail(flag, a) {
                var detailDiv = a.parentNode.getElementsByTagName("div")[0];
                if (flag) {
                    detailDiv.style.display = "block";
                }
                else
                    detailDiv.style.display = "none";
            }
            //删除
            function deleteAccount() {
                var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
                document.getElementById("operate_result_info").style.display = "block";
            }
            //开通或暂停
            function setState() {
                var r = window.confirm("确定要开通此业务账号吗？");
                document.getElementById("operate_result_info").style.display = "block";
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
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealchkmember.jsp" class="role_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealdoclist.jsp" class="account_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealvidiolist.jsp" class="fee_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealbilllist.jsp" class="bill_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealquestionslist.jsp" class="service_on"></a></li>
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
                    <div>OS 账号：<input type="text" value="" class="width100 text_search" /></div>                            
                    <div>服务器 IP：<input type="text" value="" class="width100 text_search" /></div>
                    <div>身份证：<input type="text"  value="" class="text_search" /></div>
                    <div>状态：
                        <select class="select_search">
                            <option>全部</option>
                            <option>开通</option>
                            <option>暂停</option>
                            <option>删除</option>
                        </select>
                    </div>
                    <div><input type="button" value="搜索" class="btn_search" /></div>
                    <input type="button" value="增加" class="btn_add" onclick="location.href='service_add.jsp';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="${pageContext.request.contextPath}/admin/images/close.png" onclick="this.parentNode.style.display='none';" />
                    删除成功！
                </div>   
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                    <tr>
                        <th class="width50">业务编号</th>
                        <th class="width70">发起人</th>
                        <th class="width50">邮箱</th>
                        <th class="width200">问题</th>
                        <th class="width50">状态</th>                                                      
                        <th class="width200"></th>
                    </tr>
                    <%
                    	List<Questions> list = (List<Questions>)request.getAttribute("qlist");
                    	if(list != null && list.size() > 0) {
                    		for(int i = 0; i < list.size(); i++) {
                    			Questions questions = list.get(i);
                    %>
                    <tr>
                        <td><a href="service_detail.jsp" title="查看明细"><%=questions.getQtId() %></a></td>
                        <td><%=questions.getQtUsername() %></td>
                        <td><%=questions.getQtEmail() %></td>
                        <%
                        	String desc = questions.getQtDesc() ;
                        	if(desc.length() > 18) {
                        		desc = desc.substring(0, 18);
                        	}
                        %>
                        <td><%=desc%>...</td>
                        <%
                        	if(questions.isQtDeal()) {
                        %>
                        <td>已经解决</td>
                        <%} else { %>
                        <td>待解决！！</td>
                        <%} %>
                        <td class="td_modi">
                            <input type="button" value="标记解决" class="btn_modify" onclick="window.location='${pageContext.request.contextPath}/admin/deal/dealqustionsdeal.jsp?qid=<%=questions.getQtId() %>'" />
                            <input type="button" value="删除条目" class="btn_delete" onclick="window.location='${pageContext.request.contextPath}/admin/deal/dealquestionsdelete.jsp?qid=<%=questions.getQtId() %>'" />
                        </td>
                        
                    </tr>
                    <%}} else { %>
                    <tr>
                    	<td colspan="6">没有新的建议问题...</td>
                    </tr>           
                    <%} %>                                                  
                </table>                
                <p>业务说明：<br />
                1、创建即开通，记载创建时间；<br />
                2、暂停后，记载暂停时间；<br />
                3、重新开通后，删除暂停时间；<br />
                4、删除后，记载删除时间，标示为删除，不能再开通、修改、删除；<br />
                5、业务账号不设计修改密码功能，由用户自服务功能实现；<br />
                6、暂停和删除状态的账务账号下属的业务账号不能被开通。</p>
                </div>                    
                <!--分页-->
                <div id="pages">
                    <a href="#">首页</a>
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
                    <a href="#">末页</a>
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
