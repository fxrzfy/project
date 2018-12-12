$(function() {
	$.ajax({
		url: interUrl.basic + interUrl.user.getUser,
		type: "POST",
		dataType: "json",
		success: function(data, textStatus, jqXHR) {
			if (typeof data === "string") {
				data = JSON.parse(data);
			}
			if (data.code === 10000) {
				return location.href = "./main.html";
			}
		}
	});
    var name = '';
    var password = '';
	if ($.cookie('userName') == 'null') {
        name=''
	} else {
		name = $.cookie('userName');
        $('.check i').addClass('checked').attr('index',1);
	}
    if ($.cookie('password') == 'null') {
        password=''
    } else {
    	password = $.cookie('password');
    }
	$("input[name=userName]").val(name);
	$("input[name=password]").val(password);
	var addCookie, delCookie;

	function addCookie(a,b) {
		$.cookie(a, b, {
			expires: 1
		});
	};

	function delCookie(a) {
		$.cookie(a, null);
	};
	$("body").keydown(function(event) {//对页面添加回车登录事件
		  if (event.keyCode == "13") {//keyCode=13是回车键
			  $("#loginBtn").click();
		  }
		});  
	$("#loginBtn").click(function() {
		$.ajax({
			url: interUrl.basic + interUrl.user.login,
			type: "POST",
			data: $("#loginForm").values(),
			success: function(res) {
				var code = $('.check i').attr('index');
				var userName = $("input[name=userName]").val();
                var password = $("input[name=password]").val();
				if (code == 0) {
					delCookie('userName');
					delCookie('password');
				} else if (code == 1) {
					addCookie('userName',userName);
					addCookie('password',password);
				};
				var o;
				if (typeof res === "string") {
					o = JSON.parse(res);
				} else {
					o = res;
				}
				if (o["code"] === 10000) {
					location.href = "main.html";
				} else if (o['code'] === 20000) {
					//$('#errInfo').html(res['message']);
					//$("#loginError").modal("show");
					let data=JSON.parse(res);
					layer.msg(data.msg)
				}
			}
		});
	});

	$("#switch").click(function() { //登录二维码切换
		$(this).toggleClass('code');
		var code = $(this).attr('class');
		if (code == 'code') {
			$(".login_box").addClass('hide').next(".codeBox").removeClass('hide');
		} else {
			$(".login_box").removeClass('hide').next(".codeBox").addClass('hide');
		}
	});
	$(".check i").click(function() {
		var code = $(this).attr('class');
		if (code == null || code == '') {
			$(this).addClass('checked').attr('index', '1');
		} else if (code == 'checked') {
			$(this).removeClass('checked').attr('index', '0');
		}
	});
});
