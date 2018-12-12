var angle, cache,  imgArrString, initMenu, swp, swpImage, user, recordDocQuery, allImg, imgIds, toVal;

recordDocQuery = null;

imgIds = [];

swp = null;

user = null;

imgArrString = "";

angle = 0;

allImg = [];

retprotUrl = [];

cache = {}; 



$.fn.nameValues = function() {
	var arg;
	arg = arguments[0];
	return $(this).find("[data-name]").each(function(index, item) {
		var key, keySwitch, value;
		key = $(this).data("name");
		keySwitch = $(this).data("formatter");
		if (keySwitch) {
			value = window[keySwitch](arg[key]) || "";
		}
		if (key) {
			return $(item).html(value || arg[key] || "");
		}
	});
};

var a = function toggle() {
	var flag = true;
	function get() {
		return flag = !flag; 
	}
	return get; 
}();

toggleTopNav = function(){
	$("#topNav").toggleClass("hide")
	var o = {};
	if(a()){
		o['height'] = "calc(100% - 110px)";
	}else{
		o['height'] = "calc(100% - 0px)";
	}
	$("#content-main").css(o); 
}







initMenu = function(data) {
	var itemLi, menu, ulNav;
	ulNav = ['second', 'third'];
	itemLi = function(o, level, k) {
		var ref;
		if (! ((ref = o.sysMenuList) != null ? ref.length: void 0) > 0) {
			
			return ["<li><a class='J_menuItem' href='" + o.url + "' data-index='" + o.id + "'><span style='font-size: xx-small;height: 1px;color:#25b7c6;' class=\" smallplay glyphicon glyphicon-play\"></span>" + o.menuName + "</a>"].join("");
			
		} else {
			return ["<li class='parentMenu lists'>" + "<a>" + ("<i class='icons'></i>") + ("<span class='nav-label'>" + o.menuName + "</span>") + "<span style='display:none;' class='fa arrow'></span>" + "</a>" + menu(o.sysMenuList, level + 1, k) + "</li>"].join("");
		}
	};
	menu = function(arr, level) {
		var a, i, k, len, o;
		a = [];

		if(arr[arr.length-1]['sysMenuList']){
			$.each(arr[arr.length-1]['sysMenuList'], function(i, item){
				if(item.url.indexOf("?") != -1){
					url = item.url.split("?")[0];
				}else{
					url = item.url;
				}
				retprotUrl.push(url); 
			});
		}
		if (level !== 0) {
			a.push("<ul class='nav nav-" + ulNav[level - 1] + "-level collapse'>");
		}
		if (arr.length > 0) {
			for (k = i = 0, len = arr.length; i < len; k = ++i) {
				o = arr[k];
				a.push(itemLi(o, level, k));
			}
		}
		if (level !== 0) {
			a.push("</ul>");
		}
		return a.join("");
	};	
	$("#side-menu").append(menu(data, 0));
	$("#side-menu").metisMenu();
	return $(".sidebar-collapse").slimScroll({
		height: "100%",
		railOpacity: .9,
		alwaysVisible: ! 1
	});
};

//V1.4.4新增获取密码复杂度结果 add by 徐凌锋 at 20180810
function getPasswordComplex(){
	$.ajax({
		url: interUrl.basic + interUrl.user.getPasswordComplex,
		type: "POST",
		dataType: "json",
		success: function(res) {
			if(typeof(res.data) != "undefined"){
				var sp = res.data.split("#");
				if(sp.length == 2){
					if(sp[1] == 0){
						$('#modifyPWD input[name=uid]').val(sp[0]);
						$('#Dialog_modify_password').modal('show');
						alert("为保护账号安全，请先修改登陆密码！");
					}
				}
				
			}
		}
	});
}

function ExistsData(){
	if($.trim($("input[name=oriPassword]").val()) == ""){
		$("#modifyPwdSubmit").attr("disabled","disabled");
		return;
	}
	if($.trim($("input[name=password]").val()) == ""){
		$("#modifyPwdSubmit").attr("disabled","disabled");
		return;
	}
	if($.trim($("input[name=password_again]").val()) == ""){
		$("#modifyPwdSubmit").attr("disabled","disabled");
		return;
	}
	$("#modifyPwdSubmit").removeAttr("disabled");
}



$(function() {
	//V1.4.3新增查询坐席状态
	//getAgentSatus();
	
	//V1.4.4简单密码强制修改
	//getPasswordComplex();
	
	$("#modifyPwdSubmit").click(function(){
		//console.log($("#modifyPWD").values());
		//$("#modifyPWD").validate();
	    $("#modifyPWD").validate({  
		  rules: {  
		    password: "required",  
		    password_again: {  
		      equalTo: "#password"  
		    }
		  }  
		});
	    if($("#modifyPWD").valid() == true){
	    	var uid = $("input[name=uid]").val();
	    	var password = $("input[name=password]").val();
	    	var oriPassword = $("input[name=oriPassword]").val();
	    	$.ajax({
	    		url: interUrl.basic + interUrl.personal.modifyPWD,
	    		type: "POST",
	    		dataType: "json",
	    		data: {"uid":uid,"password":password,"oriPassword":oriPassword},
	    		success: function(res) {
	    			if(res.code == "20000"){
	    				alert(res.message);
	    			}else{
	    				location.reload();
	    			}
					
				}
	    	});
	    }
	})


	$("#imageSwitch").on("hide.bs.modal", function(){ 
		if(imgIds && imgIds.length > 0){
			recordDocQuery(imgIds.join(",")); 
		}
	});

	$.ajax({
		url: interUrl.basic + interUrl.user.getUser,
		type: "POST",
		dataType: "json",
		success: function(data, textStatus, jqXHR) {
			if (typeof data === "string") {
				data = JSON.parse(data);
			}
			if (data.code === 30000) {
				return location.href = "./index.html";
			} else if (data.code === 20000) {
				$("#dialogTip").nameValues({
					content: data.message
				});
				return $("#dialogTip").modal("show");
			} else {
				user = data.data;
                return $("#userTxt").text(data.data.name);
			}
		}
	});
	$.ajax({
		url: interUrl.basic + interUrl.user.menu,
		data: {
			st: "CLS_WEB_BEFORE"
		},
		type: "POST",
		data: {
			st: 'CLS_WEB_BEFORE'
		},
		dataType: "json",
		success: function(data, textStatus, jqXHR) {
			if (typeof data === "string") {
				data = JSON.parse(data);
			}
			if (data.code === 30000) {
				return location.href = "./index.html";
			} else if (data.code === 20000) {
				$("#dialogTip").nameValues({
					content: data.message
				});urls
				return $("#dialogTip").modal("show");
			} else {
				initMenu(data.data);
			}
		}
	});

	$(".J_tabExit").click(function() {
		return $("#logOut").modal("show");
	});
	return $("#exitSure").click(function() {
		$.ajax({
			url: interUrl.basic + interUrl.user.logOut,
			type: "POST",
			dataType: "json",
			success: function(data, textStatus, jqXHR) {
			  if (typeof data === "string") {
				data = JSON.parse(data);
			  }
			  if(data.code == 10000 || data.code == 30000){
					location.href = "./index.html";
			  }
			}
		  }); 
	});
	// 报表菜单加载
	//var hrefs = $("#side-menu").find("li"); console.log(hrefs);
	// for (var i = hrefs.length - 1; i >= 0; i--) {
	// 	var href= hrefs[i].sysMenuList('a').attr('href');
	// 	console.log(href+"<br>");
	// };
	// $("#side-menu .nav-header").attr('href', './Modal/main/index/index.html?methods='+href);
	
});

