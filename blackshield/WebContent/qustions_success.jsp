<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>兰文理网络技术共享平台</title>
<link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/admin/styles/global_color.css" />
        <script language="javascript" type="text/javascript">
            var timer;
            //启动跳转的定时器
            function startTimes() {
                timer = window.setInterval(showSecondes,1000);
            }

            var i = 5;
            function showSecondes() {
                if (i > 0) {
                    i--;
                    document.getElementById("secondes").innerHTML = i;
                }
                else {
                    window.clearInterval(timer);
                    location.href = "${pageContext.request.contextPath}/index.jsp";
                }
            }

            //取消跳转
            function resetTimer() {
                if (timer != null && timer != undefined) {
                    window.clearInterval(timer);
                    location.href = "${pageContext.request.contextPath}/index.jsp";
                }
            }
        </script> 
    </head>
    <body class="qustions_success" onload="startTimes();">
        <h1 id="error">
	        恭喜恭喜，您的信息提交成功！&nbsp;<span id="secondes">5</span>&nbsp;秒后将自动跳转，立即跳转请点击&nbsp;
            <a href="${pageContext.request.contextPath}/index.jsp">返回</a>
        </h1>
    </body>
</html>
