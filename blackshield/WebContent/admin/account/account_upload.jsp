<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ include file="../commons/verifylogin2.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GB18030" />
        <title>���������缼������ƽ̨</title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global_color.css" />        
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
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealdoclist.jsp" class="account_on"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealvidiolist.jsp" class="fee_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealbilllist.jsp" class="bill_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/deal/dealquestionslist.jsp" class="service_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/report/report_list.jsp" class="report_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/user/user_info.jsp" class="information_off"></a></li>
                <li><a href="${pageContext.request.contextPath}/admin/user/user_modi_pwd.jsp" class="password_off"></a></li>
            </ul>
        </div>
        <!--�����������-->
        <div id="main">      
            <!--������������ʾ��Ϣ���ɹ�����ʧ��-->      
            <div id="save_result_info" class="save_success">����ɹ���</div><!--����ʧ�ܣ����������-->
            <form action="" method="" class="main_form">
                <div class="text_info clearfix"><span>�ļ����ƣ�</span></div>
                <div class="input_info">
                    <input type="text" class="width200"  /><span class="required">*</span>
                    <div class="validate_msg_medium">30�������ڵ���ĸ�����ֺ��»��ߵ����</div>
                </div>
                <div class="text_info clearfix"><span>�ļ���</span></div>
                <div class="input_info">
                    <input type="file" class="width200"  /><span class="required">*</span>
                    <div class="validate_msg_medium">��ѡ���ļ�</div>
                </div>
                <div class="text_info clearfix"><span>�ļ����ͣ�</span></div>
                <div class="input_info">
                    <select style="width:206px;" name="" id="">
                        <option>��Դ����</option>
                        <option>�ĵ��̳�</option>
                        <option>�������</option>
                    </select>
                    <div class="validate_msg_medium">��ѡ��Ҫ�ϴ����ļ�����</div>
                </div>

                <div class="text_info clearfix"><span>�ļ�������</span></div>
                <div class="" style="margin-bottom:12px;">
                    <textarea rows="6" cols="60" style="padding:10px;border:#ccc solid 1px;margin-left:10px;"></textarea>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="�ϴ��ļ�" class="btn_save" onclick="showResult();" />
                </div>
            </form>  
        </div>
        <!--��Ҫ�������-->
        <div id="footer">
            <p>[Դ�Ա����ļ������������ʦ�ʣ�����ʵ����ҵ�����������õ�ʵս��Ŀ]</p>
            <p>��Ȩ����(C)�����������ſƼ����޹�˾ </p>
        </div>
    </body>
</html>
