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
            //保存成功的提示消息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
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
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealchkadmin.jsp" class="admin_on"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealchkmember.jsp" class="role_off"></a></li>
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
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="" method="" class="main_form">
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" value="张三" />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">20长度以内的汉字、字母、数字的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="admin1"  /></div>
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" value="13111111111"  />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">正确的电话号码格式：手机或固话</div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200" value="aa@aa.com"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">50长度以内，正确的 email 格式</div>
                    </div>
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul>
                                <li><input type="checkbox" />超级管理员</li>
                                <li><input type="checkbox" />账务账号管理员</li>
                                <li><input type="checkbox" />业务账号管理员</li>
                                <li><input type="checkbox" />账务账号管理员</li>
                                <li><input type="checkbox" />业务账号管理员</li>
                                <li><input type="checkbox" />账务账号管理员</li>
                                <li><input type="checkbox" />业务账号管理员</li>
                            </ul>
                        </div>
                        <span class="required">*</span>
                        <div class="validate_msg_tiny error_msg">至少选择一个</div>
                    </div>
                    <div class="button_info clearfix">
                        <input type="button" value="保存" class="btn_save" onclick="showResult();" />
                        <input type="button" value="取消" class="btn_save" />
                    </div>
                </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
            <span>[源自北美的技术，最优秀的师资，最真实的企业环境，最适用的实战项目]</span>
            <br />
            <span>版权所有(C)北京华创恒信科技有限公司 </span>
        </div>
    </body>
</html>
