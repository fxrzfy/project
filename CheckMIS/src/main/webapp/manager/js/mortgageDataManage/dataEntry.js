var args,table_1;
args = comn.getArgs();
$(function(){
	//加载当前用户信息
	comn.ajax({
		url: "getSessionUser",
	    async: false,
	    success: function (res) {
	    	var user = res.data;
	    	if(user != "" || user != undefined || user != null){
	    		nodeNames = user.realname;
	    		$("#userName").val(user.realname);
	    		$("#userId").val(user.uid);
	    	}
	    }
	});
	
	$("#province_1").getProvince();
	$("#table_1").bootstrapTable();
	var mydata = args['idList'];
	comn.ajax({
		url: interUrl.documentManagement.getInformationEntryData,
        async: false,
        data: {
        	idList: mydata
        },
        success: function (res) {
        	$("#table_1").bootstrapTable('load', res.data);
		}
	})
});

$("#table_1").bootstrapTable({
    "clickToSelect": false,
    "undefinedText": "--",
    "classes": "table-striped table-hover table",
    "pagination": true,
    "paginationFirstText": "第一页",
    "paginationPreText": "上一页",
    "paginationNextText": "下一页",
    "paginationLastText": "最后一页",
});

handle_1 = function (value, row, index) {
	return "<div class='btn btn-xs btn-primary delete'>移除</div>";
};

loanTerm = function (value, row, index) {
    if (typeof value === "string") {
        value = parseInt(value);
    }
    return (value === 1 && "12期") || (value === 2 && "24期")|| (value === 3 && "18期")|| (value === 4 && "36期") || "未知";
};

//模态框的移除事件
tableEvent_1 = {
    "click .delete": function(e, a, item, index) {
    	$(this).parent().parent().remove();
    }
};

$("#checkCancel").click(function(){
	return window.parent.toUrl({
		url:'./Modal/mortgageDataManage/index.html'
    });
})

//合同寄送提交到后台保存
$("#checkSure").click(function(){
	
	var idList = "";
	var dataList = $("#table_1").children("tbody").children("tr");
	var size = dataList.length;
	for (var i=0;i<size;i++) {
		idList =idList+ dataList.eq(i).find("td").eq(1).html();
		if (i+1!=size) {
			idList=idList+",";
		}
	}
	
	if($("#searchForm").valid() == true) {
		$.ajax({
			type: 'POST',
			url:"/deliver/saveSendContractData",
			data:$.extend($("#searchForm").values(), {idList:idList,sendStatus:2}),
			async:false,
			success:function(res){
				if (res.code==10000) {
					return window.parent.toUrl({
						url:'./Modal/mortgageDataManage/index.html'
			        });
				}else {
					tip({
			            content: res.message
			        });
				}
			}
		})
	}
});

//校验手机号是否为11位
$("#phone").blur(function(){
	var mobile = $("input[name=phone]").val()
	if (mobile) {
			if (!$("input[name=phone]").valid()) {
					return false;
			};
	}
});

//获取快递公司列表
$("#expressCompanyCode").getExpressCompanyCode();

//获取省市区
$("#province_1").change(function () {
    if (this.value) {
        $("#area_1").val("");
        return $("#city_1").getCity(this.value).unbind("change").change(function () {
            if (this.value) {
                return $("#area_1").getArea(this.value);
            }
        });
    }
});
$("#city_1").getCity(this.value).unbind("change").change(function () {
    if (this.value) {
        return $("#area_1").getArea(this.value);
    }
});
$(document).on("change", "#province_1", function () {
    var provinceName = $(this).find("option:selected").html();
    $("input[name='provinceName']").val(provinceName);
})
$(document).on("change", "#city_1", function () {
    var cityName = $(this).find("option:selected").html();
    $("input[name='cityName']").val(cityName);
});
$(document).on("change", "#area_1", function () {
    var areaName = $(this).find("option:selected").html();
    $("input[name='areaName']").val(areaName);
});