<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.1.min.js"></script>
<!--引入开始-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/service.css">
<script src="${pageContext.request.contextPath }/js/service.js"></script>
<script>
$(function(){
	$("#lrkfwarp").lrkf({
		kftop:'140',				//距离顶部距离
		btntext:'客服在线',			//默认为 客服在线 四个字，如果你了解css可以使用图片代替
		//defshow:false,			    //如果想默认折叠，将defshow:false,的注释打开，默认为展开
		position:'absolute',		//如果为absolute所有浏览器在拖动滚动条时均有动画效果，如果为空则只有IE6有动画效果，其他浏览器
		qqs:[
			{'name':'售前1号','qq':'412611348'},			//注意逗号是英文的逗号
			{'name':'客服2号','qq':'412611348'},
			{'name':'客服3号','qq':'412611348'},
			{'name':'客服4号','qq':'412611348'}			//注意最后一个{}不要英文逗号
		],
		tel:[
			{'name':'24小时热线','tel':'400-888-0888'},	//注意逗号是英文的逗号
			{'name':'售后','tel':'13554804241'}
		],
		more:"http://www.5imoban.net/"				//>>更多方式
	});
});

</script>

<style>
body{margin:0; padding:0; height:1000px;}
ul#wimoban_nav{padding-left:50px; margin-bottom:10px; border-bottom:2px solid #ccc; overflow:hidden; _zoom:1;}
ul#wimoban_nav li{float:left; display:inline; margin:10px;}
ul#wimoban_nav li a{display:block; font-size:16px;}
ul#wimoban_nav li a,#wimoban_p,#wimoban_p a{color:#000; font-family:"微软雅黑";}
ul#wimoban_nav li a:hover,#wimoban_p a:hover{color:red;}
#wimoban_p{text-align:center; font-size:14px; clear:both; margin-top:40px;}
</style>
<!--引入结束-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>兰文理网络技术共享平台</title>
</head>
<body>

</body>
</html>