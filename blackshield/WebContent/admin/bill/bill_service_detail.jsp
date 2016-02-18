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
    </head>
    <body onload="initialYearAndMonth();">
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
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealbilllist.jsp" class="bill_on"></a></li>
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
                    <div>账务账号：<span class="readonly width70">admin1</span></div>                            
                    <div>OS 账号：<span class="readonly width100">openlab1</span></div>
                    <div>服务器 IP：<span class="readonly width100">192.168.0.20</span></div>
                    <div>计费时间：<span class="readonly width70">2013年8月</span></div>
                    <div>费用：<span class="readonly width70">34.78</span></div>
                    <input type="button" value="返回" class="btn_add" onclick="location.href='bill_item.jsp';" />
                </div>  
                <!--数据区域：用表格展示数据-->     
                <div id="data">            
                    <table id="datalist">
                        <tr>
                            <th class="width150">客户登录 IP</th>
                            <th class="width150">登入时刻</th>
                            <th class="width150">登出时刻</th>
                            <th class="width100">时长（秒）</th>
                            <th class="width150">费用</th>
                            <th>资费</th>
                        </tr>
                        <tr>
                            <td>192.168.100.100</td>
                            <td>2013/01/01 12:12:12</td>
                            <td>2013/01/01 12:12:22</td>
                            <td>10</td>
                            <td>0</td>
                            <td>包 20 小时</td>
                        </tr>
                        <tr>
                            <td>192.168.100.100</td>
                            <td>2013/01/01 12:12:12</td>
                            <td>2013/01/01 12:12:22</td>
                            <td>10</td>
                            <td>0</td>
                            <td>包 20 小时</td>
                        </tr>
                        <tr>
                            <td>192.168.100.100</td>
                            <td>2013/01/01 12:12:12</td>
                            <td>2013/01/01 12:12:22</td>
                            <td>10</td>
                            <td>0</td>
                            <td>包 20 小时</td>
                        </tr>
                        <tr>
                            <td>192.168.100.100</td>
                            <td>2013/01/01 12:12:12</td>
                            <td>2013/01/01 12:12:22</td>
                            <td>10</td>
                            <td>0.45</td>
                            <td>包 20 小时</td>
                        </tr>
                    </table>
                </div>
                <!--分页-->
                <div id="pages">
        	        <a href="#">上一页</a>
                    <a href="#" class="current_page">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">4</a>
                    <a href="#">5</a>
                    <a href="#">下一页</a>
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
