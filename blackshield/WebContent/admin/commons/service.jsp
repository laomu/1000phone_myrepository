<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>兰文理网络技术共享平台</title>
<style>
body{margin:0; padding:0; height:2000px;}
ul#wimoban_nav{padding-left:50px; margin-bottom:10px; border-bottom:2px solid #ccc; overflow:hidden; _zoom:1;}
ul#wimoban_nav li{float:left; display:inline; margin:10px;}
ul#wimoban_nav li a{display:block; font-size:16px;}
ul#wimoban_nav li a,#wimoban_p,#wimoban_p a{color:#000; font-family:"微软雅黑";}
ul#wimoban_nav li a:hover,#wimoban_p a:hover{color:red;}
#wimoban_p{text-align:center; font-size:14px; clear:both;}
</style>
<!-- 引入开始 -->
<script src="${pageContext.request.contextPath }/admin/js/jquery-1.11.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/admin/js/jquery.KinSlideshow-1.2.1.min.js" type="text/javascript"></script>
<!-- 引入结束 -->
<!-- 代码开始 -->
<link href="${pageContext.request.contextPath }/admin/styles/online.css" rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/css/onlineservice.css" rel="stylesheet" type="text/css" />
</head>	
<body>
<script>
function changeOnline(num) {
	if (isNaN(num) && num == "")
		return;
	for (var i = 1; i <=6 ; i++)
	{
		if (i == num)
		{
			document.getElementById("onlineSort" + i).className = "online_bar expand";
			document.getElementById("onlineType" + i).style.display = "block";
		}
		else
		{
			document.getElementById("onlineSort" + i).className = "online_bar";
			document.getElementById("onlineType" + i).style.display = "none";
		}
	}
}

$(document).ready(function(){
  $("#floatShow").bind("click",function(){
    $('#onlineService').animate({width: 'show', opacity: 'show'}, 'normal',function(){ $('#onlineService').show(); });$('#floatShow').attr('style','display:none');$('#floatHide').attr('style','display:block');
	return false;
  });
  $("#floatHide").bind("click",function(){
	$('#onlineService').animate({width: 'hide', opacity: 'hide'}, 'normal',function(){ $('#onlineService').hide(); });$('#floatShow').attr('style','display:block');$('#floatHide').attr('style','display:none');
  });
  $(document).bind("click",function(event){
	if ($(event.target).isChildOf("#online_qq_layer") == false)
	{
	 $('#onlineService').animate({width: 'hide', opacity: 'hide'}, 'normal',function(){ $('#onlineService').hide(); });$('#floatShow').attr('style','display:block');$('#floatHide').attr('style','display:none');
	}
  });
jQuery.fn.isChildAndSelfOf = function(b){
    return (this.closest(b).length > 0);
};
jQuery.fn.isChildOf = function(b){
    return (this.parents(b).length > 0);
};
  //$(window).scroll(function(){ 
	//$('#online_qq_layer').stop().animate({top:$(document).scrollTop() + $("#online_qq_layer").height()}, 100) 
  //}); 
});
</script>
<div id="online_qq_layer">
	<div id="online_qq_tab">
		<div class="online_icon">
			<a title id="floatShow" style="display: block;" href="javascript:void(0);">&nbsp;</a>
			<a title id="floatHide" style="display: none;" href="javascript:void(0);">&nbsp;</a>
		</div>
	</div>
	<div id="onlineService">
		<div class="online_windows overz">
			<div class="online_w_top">
			</div>
			<div class="online_w_c overz">
				<div class="online_bar expand" id="onlineSort1">
					<h2><a onclick="changeOnline(1)">在线客服</a></h2>
					<div class="online_content overz" id="onlineType1">
						<ul class="overz">
							<li>
							<a onclick="javascript:window.open('http://b.qq.com/webc.htm?new=0&amp;sid=123456&amp;o=sc.admin5.com&amp;q=7', '_blank', 'height=544, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');" class="qq_icon">
							企业QQ交谈</a></li>
							<li>企业QQ： 
							<a onclick="javascript:window.open('http://b.qq.com/webc.htm?new=0&amp;sid=123456&amp;o=sc.admin5.com&amp;q=7', '_blank', 'height=544, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');">
							123456</a></li>
						</ul>
					</div>
				</div>
				<div class="online_bar" id="onlineSort2">
					<h2><a onclick="changeOnline(2)">在线答疑</a></h2>
					<div class="online_content overz" id="onlineType2">
						<ul class="overz">
							<li>
							<a onclick="javascript:window.open('http://b.qq.com/webc.htm?new=0&amp;sid=123456&amp;o=sc.admin5.com&amp;q=7', '_blank', 'height=544, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');" class="qq_icon">
							企业QQ交谈</a></li>
							<li>企业QQ： 
							<a onclick="javascript:window.open('http://b.qq.com/webc.htm?new=0&amp;sid=123456&amp;o=sc.admin5.com&amp;q=7', '_blank', 'height=544, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');">
							123456</a></li>
						</ul>
					</div>
				</div>
				<div class="online_bar" id="onlineSort3">
					<h2><a onclick="changeOnline(3)">联系我们</a></h2>
					<div class="online_content overz" id="onlineType3">
						<ul class="overz">
							<li>
							<a onclick="javascript:window.open('http://b.qq.com/webc.htm?new=0&amp;sid=123456&amp;o=sc.admin5.com&amp;q=7', '_blank', 'height=544, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');" class="qq_icon">
							企业QQ交谈</a></li>
							<li>企业QQ： 
							<a onclick="javascript:window.open('http://b.qq.com/webc.htm?new=0&amp;sid=123456&amp;o=sc.admin5.com&amp;q=7', '_blank', 'height=544, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');">
							123456</a></li>
						</ul>
					</div>
				</div>
				<div class="online_bar" id="onlineSort4">
					<h2><a onclick="changeOnline(4)">代理咨询</a></h2>
					<div class="online_content overz" id="onlineType4">
						<ul class="overz">
							<li>
							<a onclick="javascript:window.open('http://b.qq.com/webc.htm?new=0&amp;sid=123456&amp;o=sc.admin5.com&amp;q=7', '_blank', 'height=544, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');" class="qq_icon">
							企业QQ交谈</a></li>
							<li>企业QQ： 
							<a onclick="javascript:window.open('http://b.qq.com/webc.htm?new=0&amp;sid=123456&amp;o=sc.admin5.com&amp;q=7', '_blank', 'height=544, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');">
							123456</a></li>
						</ul>
					</div>
				</div>
				<div class="online_bar" id="onlineSort5">
					<h2><a onclick="changeOnline(5)">网站推广</a></h2>
					<div class="online_content overz" id="onlineType5">
						<ul class="overz">
							<li>
							<a onclick="javascript:window.open('http://b.qq.com/webc.htm?new=0&amp;sid=123456&amp;o=sc.admin5.com&amp;q=7', '_blank', 'height=544, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');" class="qq_icon">
							企业QQ交谈</a></li>
							<li>企业QQ： 
							<a onclick="javascript:window.open('http://b.qq.com/webc.htm?new=0&amp;sid=123456&amp;o=sc.admin5.com&amp;q=7', '_blank', 'height=544, width=644,toolbar=no,scrollbars=no,menubar=no,status=no');">
							123456</a></li>
						</ul>
					</div>
				</div>
				
			</div>
			<div class="online_w_bottom">
			</div>
		</div>
	</div>
</div>
<!-- 代码结束 -->
</body></html>