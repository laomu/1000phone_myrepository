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
        <title>���������缼������ƽ̨</title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            //����ɹ�����ʾ��Ϣ
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

            //��ʾѡ�����Ϣ��
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
        <!--Logo����ʼ-->
        <div id="header">
            <img src="${pageContext.request.contextPath}/admin/images/logo.png" alt="logo" class="left"/>
            <a href="${pageContext.request.contextPath}/admin/commons/logout.jsp">[�˳�]</a>            
        </div>
        <!--Logo�������-->
        <!--��������ʼ-->
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
        <!--�����������-->
        <!--��Ҫ����ʼ-->
        <div id="main">       
            <!--����ɹ�����ʧ�ܵ���ʾ��Ϣ-->     
            <div id="save_result_info" class="save_fail">����ʧ�ܣ��ļ����Ϸ���</div>
            <form enctype="multipart/form-data" action="${pageContext.request.contextPath }/admin/deal/dealvidioupload.jsp" method="post" class="main_form">
                <div class="text_info clearfix"><span>�γ����ƣ�</span></div>
                <div class="input_info">
                    <input type="text" class="width300" name="courseName" value=""/>
                    <span class="required">*</span>
                    <div class="validate_msg_short">50���ȵ���ĸ�����֡����ֺ��»��ߵ����</div>
                </div>
                <div class="text_info clearfix"><span>�γ����ͣ�</span></div>
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
                			<option>--��ǰû������--</option>
                	<%} %>
                    </select>
                </div>
                <div class="text_info clearfix"><span>����ͼƬ��</span></div>
                <div class="input_info">
                    <input type="file" value="" name="file1" class="width300" />
                    <span class="required">*</span>
                    <div class="validate_msg_short">����100*100�ֱ��ʵ�ͼƬ</div>
                </div>
                <div class="text_info clearfix"><span>��Ƶ�ļ���</span></div>
                <div class="input_info">
                    <input type="file" value="" name="file2" class="width300" />
                    <span class="required">*</span>
                    <div class="validate_msg_short">��ѡ������ļ�</div>
                </div>
                <div class="text_info clearfix"><span>�γ�������</span></div>
                <div class="input_info_high">
                    <textarea class="width300 height70" name="courseDesc"></textarea>
                    <div class="validate_msg_short error_msg">10���ȵ���ĸ�����֡����ֺ��»��ߵ����</div>
                </div>                    
                <div class="button_info clearfix">
                    <input type="submit" value="�ϴ��ļ�" class="btn_save"  onclick="showResult();" />
                    <input type="reset" value="����" class="btn_save" />
                </div>
            </form>  
        </div>
        <!--��Ҫ�������-->
        <div id="footer">
            <span>[Դ�Ա����ļ������������ʦ�ʣ�����ʵ����ҵ�����������õ�ʵս��Ŀ]</span>
            <br />
            <span>��Ȩ����(C)�����������ſƼ����޹�˾ </span>
        </div>
    </body>
</html>
