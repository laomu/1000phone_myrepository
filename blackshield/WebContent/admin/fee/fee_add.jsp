<%@page import="com.luas.model.CourseType"%>
<%@page import="com.luas.model.ToolsType"%>
<%@page import="java.util.List"%>
<%@ include file="../commons/verifylogin2.jsp" %>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
        <title>兰文理网络技术共享平台</title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //保存成功的提示信息
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

            //显示选填的信息项
            function showOptionalInfo(imgObj) {
                var div = document.getElementById("optionalInfo");
                if (div.className == "hide") {
                    div.className = "show";
                    imgObj.src = "${pageContext.request.contextPath}/admin/images/hide.png";
                }
                else {
                    div.className = "hide";
                    imgObj.src = "${pageContext.request.contextPath}/admin/images/show.png";
                }
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
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealvidiolist.jsp" class="fee_on"></a></li>
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
            <!--保存成功或者失败的提示消息-->     
            <div id="save_result_info" class="save_fail">保存失败，文件不合法！</div>
            <form enctype="multipart/form-data" action="${pageContext.request.contextPath }/admin/deal/dealvidioupload.jsp" method="post" class="main_form">
                <div class="text_info clearfix"><span>课程名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width300" name="courseName" value=""/>
                    <span class="required">*</span>
                    <div class="validate_msg_short">50长度的字母、数字、汉字和下划线的组合</div>
                </div>
                <div class="text_info clearfix"><span>课程类型：</span></div>
                <div class="input_info fee_type">
                    <select style="width:206px;" name="courseType" id="">
                       <%
                		List<CourseType> ctList = (List<CourseType>)request.getAttribute("ctList");
                		if(ctList != null && ctList.size() > 0){
                        for(int i =0; i < ctList.size(); i++) {
                			%> 
                			<option value="<%=ctList.get(i).getCtId()%>"><%=ctList.get(i).getCtName() %></option>
                			<%
                		}
                		}else{
                	%>
                			<option>--当前没有类型--</option>
                	<%} %>
                    </select>
                </div>
                <div class="text_info clearfix"><span>封面图片：</span></div>
                <div class="input_info">
                    <input type="file" value="" name="file1" class="width300" />
                    <span class="required">*</span>
                    <div class="validate_msg_short">建议100*100分辨率的图片</div>
                </div>
                <div class="text_info clearfix"><span>视频文件：</span></div>
                <div class="input_info">
                    <input type="file" value="" name="file2" class="width300" />
                    <span class="required">*</span>
                    <div class="validate_msg_short">请选择软件文件</div>
                </div>
                <div class="text_info clearfix"><span>课程描述：</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70" name="courseDesc"></textarea>
                    <div class="validate_msg_short error_msg">10长度的字母、数字、汉字和下划线的组合</div>
                </div>                    
                <div class="button_info clearfix">
                    <input type="submit" value="上传文件" class="btn_save"  onclick="showResult();" />
                    <input type="reset" value="重置" class="btn_save" />
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
