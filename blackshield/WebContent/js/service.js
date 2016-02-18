(function($) {
	$.fn.lrkf = function(options) {
		var opts = {
			position : "fixed",
			btntext : "\u5ba2\u670d\u5728\u7ebf",
			qqs : [ {
				name : "\u61d2\u4eba\u5efa\u7ad9",
				qq : "191221838"
			} ],
			tel : "",
			more : null,
			kftop : "120",
			z : "99999",
			defshow : true,
			Event : "",
			callback : function() {
			}
		}, $body = $("body"), $url = "";
		$.extend(opts, options);
		if (!$("#lrkfwarp").length > 0) {
			$body
			.append("<div id='lrkfwarp' class='lrkf lrkfshow' style="
					+ opts.position
					+ "><a href='#' class='lrkf_btn lrkf_btn_hide' id='lrkf_btn' onfocus='this.blur()'>"
					+ opts.btntext
					+ "</a><div class='lrkf_box'>" +
							"<div class='lrkf_header'>" +
							"<a href='#' title='\u5173\u95ed' class='x' id='lrkf_x'></a>" +
							"</div>" +
							"<div class='lrkf_con' id='lrkf_con'>" +
							"<ul class='kflist'>" +
							"</ul>" +
							"</div>" +
							"<div class='lrkf_foot'>" +
							"</div>" +
							"</div>" +
							"</div>" +
							"<style type='text/css'>" +
							"html{overflow-x:hidden;}" +
							"#lrkfwarp ul{padding-left:0; " +
							"margin:0;list-style-type: none;}" +
							".lrkf{font-size:13px;position:fixed;}" +
							".lrkf a{ display:block; color:#666; text-decoration:none; font-size:13px;}#lrkfwarp img{ border:none;vertical-align:middle; margin-right:4px; margin-top:-2px;display:inline;}.lrkf_con{padding:6px 8px;}.lrkf_con li.qq{padding:5px 0;}.lrkf_con li.tel{ line-height:1.35; padding-bottom:4px;}.lrkf_con li.more{ padding:2px 0;}.lrkf_con li.tel b{ display:block; color:#C00;}.lrkf_tool a{ display:block; padding:8px 10px; text-align:center;}.lrkf_con .hr{padding:0;height:0;font-size:0;line-height:0;clear:both;margin:4px 0;border-bottom:#fff solid 1px;border-top:#CFCFCF solid 1px;border-left:none;border-right:none;}.lrkf_btn{position:absolute; top:20px;width:22px;left:-22px;display:block;text-align:center;padding:10px 0;}.lrkf .lrkf_xc{ position:absolute; bottom:-14px; right:6px;font-size:10px;display:none;}</style>")
		}
		var $lrkfwarp = $("#lrkfwarp"), $lrkf_con = $("#lrkf_con"), $kflist = $lrkf_con
				.children("ul"), $lrkf_x = $("#lrkf_x"), $lrkf_btn = $("#lrkf_btn"), $lrkfwarp_w = $lrkfwarp
				.outerWidth() * 1 + 1;
		$lrkfwarp.css({
			top : opts.kftop + "px",
			"z-index" : opts.z
		});
		if (!opts.defshow) {
			$lrkfwarp.removeClass("lrkfshow").css({
				right : -$lrkfwarp_w
			})
		}
		var json = {
			options : opts.qqs
		};
		json = eval(json.options);
		$
				.each(
						json,
						function(i, o) {
							$kflist
									.append("<li class=qq><a target=_blank href=http://wpa.qq.com/msgrd?v=3&uin="
											+ o.qq
											+ "&site=qq&menu=yes><img src=http://wpa.qq.com/pa?p=2:"
											+ o.qq
											+ ":45>"
											+ o.name
											+ "</a></li>")
						});
		if (opts.tel) {
			$kflist.append("<li class=hr></li>");
			var json_tel = {
				options : opts.tel
			};
			json_tel = eval(json_tel.options);
			$.each(json_tel, function(i, o) {
				$kflist.append("<li class=tel>" + o.name + ":<b>" + o.tel
						+ "</b></li>")
			})
		}
		if (opts.more) {
			$kflist.append("<li class=hr></li><li class=more><a href='"
					+ opts.more + "'>>>\u66f4\u591a\u65b9\u5f0f</a></li>")
		}
		var $lrkfwarptop = $lrkfwarp.offset().top;
		if ($.browser.msie && $.browser.version == 6
				|| opts.position == "absolute") {
			$(window).scroll(function() {
				var offsetTop = $lrkfwarptop + $(window).scrollTop() + "px";
				$lrkfwarp.animate({
					top : offsetTop
				}, {
					duration : 600,
					queue : false
				})
			})
		}
		$lrkf_x.click(function() {
			$lrkfwarp.hide();
			return false
		});
		if (opts.Event == "") {
			$lrkfwarp.mouseenter(function() {
				$(this).stop().animate({
					right : 0
				})
			}).mouseleave(function() {
				$(this).stop().animate({
					right : -$lrkfwarp_w
				})
			})
		} else {
			$lrkf_btn.on("click", function() {
				if ($lrkfwarp.hasClass("lrkfshow")) {
					$lrkfwarp.animate({
						right : -$lrkfwarp_w
					}, function() {
						$lrkfwarp.removeClass("lrkfshow")
					})
				} else {
					$lrkfwarp.addClass("lrkfshow").animate({
						right : 0
					})
				}
				return false
			})
		}
	}
})(jQuery);
$(function() {
	$("#lrkfwarp").lrkf({
		kftop : '140', // ���붥������
		btntext : '在线客服', // Ĭ��Ϊ �ͷ����� �ĸ��֣�������˽�css����ʹ��ͼƬ����
		// defshow:false, //�����Ĭ���۵�����defshow:false,��ע�ʹ򿪣�Ĭ��Ϊչ��
		position : 'absolute', // ���Ϊabsolute������������϶�������ʱ���ж���Ч�������Ϊ����ֻ��IE6�ж���Ч�������������
		qqs : [ {
			'name' : '客服1号',
			'qq' : '1007821300'
		}, // ע�ⶺ����Ӣ�ĵĶ���
		{
			'name' : '客服2号',
			'qq' : '1007821300'
		}, {
			'name' : '客服3号',
			'qq' : '1007821300'
		}, {
			'name' : '客服4号',
			'qq' : '1007821300'
		} // ע�����һ��{}��ҪӢ�Ķ���
		],
		tel : [ {
			'name' : '前台电话',
			'tel' : '400-888-0888'
		}, // ע�ⶺ����Ӣ�ĵĶ���
		{
			'name' : '联系我们',
			'tel' : '13554804241'
		} ],
		more : "" // >>���෽ʽ
	});
});
