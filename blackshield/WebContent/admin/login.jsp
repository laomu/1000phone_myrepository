<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>兰文理网络技术共享平台</title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath }/admin/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath }/admin/styles/global_color.css" />
        <script type="text/javascript">
        	function chgsafecode() {
        		var img = document.getElementById("safecode");
        		img.src = "${pageContext.request.contextPath }/verifyimage?x=" + new Date();
        	}
        </script> 
    </head>
    <body class="index">
        <div class="login_box">
            <form name="myform" action="${pageContext.request.contextPath }/admin/deal/deallogin.jsp" method="post">
            	<table>
	                <tr>
	                    <td class="login_info">账号：</td>
	                    <td colspan="2"><input name="username" type="text" class="width150" /></td>
	                    <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td>
	                </tr>
	                <tr>
	                    <td class="login_info">密码：</td>
	                    <td colspan="2"><input name="password" type="password" class="width150" /></td>
	                    <td><span class="required">30长度的字母、数字和下划线</span></td>
	                </tr>
	                <tr>
	                    <td class="login_info">验证码：</td>
	                    <td class="width70"><input name="safecode"  type="text" class="width70" /></td>
	                    <td><img src="${pageContext.request.contextPath }/verifyimage" onclick="chgsafecode()" alt="验证码" id="safecode" title="点击更换" /></td>  
	                    <%
	                    	String ec = (String)request.getAttribute("ERRORSC");
	                    	if(ec != null) {
	                    %>           
	                    <td><span class="required">验证码错误</span></td>
	                    <%} else {%>
	                    <td>请输入验证码</td>
	                    <%} %>   
	                </tr>            
	                <tr>
	                    <td></td>
	                    <td class="login_button" colspan="2">
	                        <input type="image" src="${pageContext.request.contextPath }/admin/images/login_btn.png"/>
	                    </td>    
	                    <td>
	                    	<%
	                    		String er = (String)request.getAttribute("ERROR");
	                    		if(er != null) {
	                    			%>
	                    			<span class="required" style="color:#eee">用户名或密码错误，请重试</span>
	                    			<%
	                    		}
	                    	%>
	                    </td>                
	                </tr>
	            </table>
            </form>
        </div>
    </body>
</html>
