var table_1, table_2,handle_1,tableEvent_1;
var exportRight,dataList,idValue;

//判断是否有导出报表功能
$.ajax({
	url:"/carDealer/access.html",
	async:false, 
	data:{
		"flow":"REPORT_EXPORT_RIGHT",
		"flowNode":"ALLOW"
	},
	success:function(item){
		exportRight = item.data.success
	}
});


//待寄送
table_1 = function (params) {
	tableData(params, $.extend($("#searchForm").values(), {
		isProcessed: false
	}), interUrl.documentManagement.getMortgageData);
};

//已寄送
table_2 = function (params) {
	tableData(params, $.extend($("#searchForm").values(), {
		isProcessed: true
	}), interUrl.documentManagement.getMortgageData);
};


$("#table_7").bootstrapTable({
    "clickToSelect": false,
    "undefinedText": "--",
    "classes": "table-striped table-hover table",
    "pagination": true,
    "paginationFirstText": "第一页",
    "paginationPreText": "上一页",
    "paginationNextText": "下一页",
    "paginationLastText": "最后一页",
    "height": "500"
});

$(function (){
	$("#coBankId").getBank();//合作银行取值
	//合作机构和业务组取值
	$("#businessOrgId").getOrg();
	$("#businessOrgId").off('change').on("change", function() {
	      var code = $(this).find("option:selected").attr('value');
	      $("#businessGroupId").getGroup(code);
	    });
    $("#businessGroupId").off('change');
    
    $('a[data-toggle="tab"]').on('shown.bs.tab', function (e) {
        if($("[href='#done']").parent().hasClass('active')&& exportRight){
        	$('#exportBtn').removeClass('hide');
		}else{
			$('#exportBtn').addClass('hide');
		}
    })
})


//导出
$('#exportBtn').click(function(){
  var search=$("#searchForm").serialize()
  var downLink = interUrl.basic + interUrl.documentManagement.contractExport + "?"+search;
  window.open(downLink, "_blank");
});


//根据待寄送和已寄送的tab，隐藏和显示相关的条件框
$("#tabUl").click(function(){
	$(".finshedSend").toggle();
});


$(".contractClass").click(function () {
	
	$("#contractModal").modal("show");
	idValue = $(this).attr("id");
	var contentStr;
	console.log(idValue);
	console.log(idValue=="sendContract");
	if (idValue=="sendContract") {
		contentStr = "请核对待寄送抵押合同的客户信息";
	}else {
		contentStr = "请核对合同已前置的客户信息";
	}
	$("#textContentP").text(contentStr);
})

//初始化模态框的表格
$("#contractModal").on("shown.bs.modal", function () {
	var message = "";
    var getSelectRows = $("#table_7").bootstrapTable("load", $("#table1").bootstrapTable('getSelections', function (row) {return row;}));
    var content = $("#table_7").children("tbody").children("tr").attr("class");
    dataList = $("#table_7").children("tbody").children("tr");
    var size = dataList.length;
    if (size==1 && content=="no-records-found") {
    	$("#checkSure").attr('disabled',"true");
    	return tip({
    		content: "请选择数据"
    	});
    }
    if (idValue=="sendContract") {
    	$("#sendType").val(2);
    	message = "请核对待寄送抵押合同的客户信息";
    }else {
    	$("#sendType").val(1);
    	message = "请核对合同已前置的客户信息";
    }
    //是否需要检验业务组
    var msg = checkIsSameGroup();
    if (msg!="") {
    	message = msg;
	}
	tip({
        content: message
    });
});

function checkIsSameGroup(){
	var t = new Array(); 
	dataList = $("#table_7").children("tbody").children("tr");
	var size = dataList.length;
	var groupIdList = new Array(size);
	for (var i=0;i<size;i++) {
		groupIdList[i] = dataList.eq(i).find("td").eq(8).html();
	}
	t =  arrayUnique(groupIdList);
	if (t.length>1 && idValue=="sendContract") {
		$("#checkSure").attr('disabled',"true");
		return "请选择同一业务组寄送抵押合同";
	}else {
		$("#checkSure").removeAttr('disabled');
		return "";
	}
}

handle_1 = function (value, row, index) {
	return "<div class='btn btn-xs btn-primary delete'>移除</div>";
};

//模态框的移除事件
tableEvent_1 = {
    "click .delete": function(e, a, item, index) {
    	$(this).parent().parent().remove();
    	checkIsSameGroup();
    }
}

//查询按钮
$("#btn-search").click(function () {
    var activeTab = $(".tab-content").find(".tab-pane.active").attr("id");
    if (activeTab == "todo") {
        $("#table1").bootstrapTable("refresh", {url: "..."});
    } else if (activeTab == "done") {
        $("#table2").bootstrapTable("refresh", {url: "..."});
    }
});

//抵押合同状态
$(document).on("change", "#signStatus", function () {
    var sendStatus = $(this).find("option:selected").val();
    $("input[name='sendStatus']").val(sendStatus);
})

//寄送状态
sendStatus = function (value, row, index) {
    if (typeof value === "string") {
        value = parseInt(value);
    }
    return (value === 1 && "合同前置") || (value === 2 && "合同寄送") || "未寄送";
};

loanTerm = function (value, row, index) {
    if (typeof value === "string") {
        value = parseInt(value);
    }
    return (value === 1 && "12期") || (value === 2 && "24期")|| (value === 3 && "18期")|| (value === 4 && "36期") || "未知";
};

//模态框的确认按钮
$("#checkSure").click(function(){
	var size = dataList.length;
	if(size<1){
		return tip({
            content: "请至少选择一条数据！"
        });
	}
	var idList = "";
	var groupIdList = new Array(size);
	for (var i=0;i<size;i++) {
		idList =idList+ dataList.eq(i).find("td").eq(1).html();
		groupIdList[i] = dataList.eq(i).find("td").eq(8).html();
		if (i+1!=size) {
			idList=idList+",";
		}
	}
	var url = "";
	var sendStatus = $("#sendType").val();
	if (sendStatus==2) {//合同寄送跳转到信息录入页面
		var t = new Array(); 
		t =  arrayUnique(groupIdList);
		if (t.length>1) {
			tip({
	            content: "存在不同的业务组！"
	        });
		}else{
			return window.parent.toUrl({
				url:'./Modal/mortgageDataManage/dataEntry.html?idList='+idList
	        });
		}
	}else {//添加合同前置到数据库中
		comn.ajax({
			url:interUrl.documentManagement.savePreContractData,
			data:{idList:idList,sendStatus:sendStatus},
			success: function (res) {
				if (res.code==10000) {
					tip({
			            content: "操作成功"
			        });
					$("#contractModal").modal("hide");
					$("#table1").bootstrapTable("refresh", {url: "..."});
				}else {
					tip({
			            content: res.message
			        });
				}
			}
		})
	}
});
