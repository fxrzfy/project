args = comn.getArgs();
var table_1, table_2,handle_0,handle_1;
var projectId_arg = args['projectId'] || null;
var loanApplyId_arg = args['loanApplyId'] || null;


$("#table1").bootstrapTable({
    "undefinedText": "--",
    "classes": "table-striped table-hover table",
    "pagination": true,
    "sidePagination": "server",
    "queryParams": "queryParams",
    "paginationFirstText": "第一页",
    "paginationPreText": "上一页",
    "paginationNextText": "下一页",
    "paginationLastText": "最后一页",
    "clickToSelect": true
});

$("#table2").bootstrapTable({
    "undefinedText": "--",
    "classes": "table-striped table-hover table",
    "pagination": true,
    "sidePagination": "server",
    "queryParams": "queryParams",
    "paginationFirstText": "第一页",
    "paginationPreText": "上一页",
    "paginationNextText": "下一页",
    "paginationLastText": "最后一页",
    "clickToSelect": true
});


table_1 = function (params) {
    tableData(params,{projectId: projectId_arg, loanApplyId: loanApplyId_arg}, interUrl.callcenter.getLoanRelationship);
};
table_2 = function (params) {
    tableData(params, $.extend($("#searchForm").values(), {projectId: projectId_arg, loanApplyId: loanApplyId_arg}), interUrl.callcenter.getLoanCallLog);
};

if(typeof(args['businessTypeCode']) != "undefined" && typeof(args['currentNodeKey']) != "undefined"){
	if(args['businessTypeCode'] == "LOAN_APPLY_FLOW" && args['currentNodeKey'] == "LOAN_TELEPHONE_AUDIT"){
		$("#addButton").show();
	}
}

handle_0 = function (value, row, index) {
	if(typeof(args['businessTypeCode']) != "undefined" && typeof(args['currentNodeKey']) != "undefined"){
		if(args['businessTypeCode'] == "LOAN_APPLY_FLOW" && args['currentNodeKey'] == "LOAN_TELEPHONE_AUDIT"){
			return '<a href="javascript:void(0)" class="lookUp">' + value+'</a><a href="javascript:void(0)" class="callOut"> <i class="icon-earphones-alt text"></i></a>';
		}else if(args['businessTypeCode'] == "LOAN_APPLY_FLOW" && args['currentNodeKey'] == "LOAN_CAR_FINANCE"){
			return '<a href="javascript:void(0)" class="lookUp">' + value+'</a>';
		}
	}
	return value; 
};

tableEvent = {
		
		"click .callOut": function (field, value, row, td) {
			$.ajax({
				url: "/callcenter/callOut",
				type: "POST",
				data:$.extend(row, {callType: 1,terminatingCallId:row.id,terminatingCallName:row.mobileOwner,id:null}),
				dataType: "json",
				success: function(res) {
					if(res.code == "10000"){
						tip({content: "外呼成功!"});
					}else{
						var back = res.message*1;
						var s = "";
						switch(back){
						case -1: s = "外呼接口出错"; break;
						case -2: s = "您没有配置邮箱等信息!"; break;
						case -3: s = "通话参数错误，请核对是否存在技能组!"; break;
						case -4: s = "坐席状态设置失败!"; break;
						case -5: s = "坐席状态设置出错!"; break;
						case -6: s = "坐席登陆失败!"; break;
						}
						tip({content: s});
					}
					
				}
			});
		},
		
		"click .lookUp": function (field, value, row, td) {
			return comn.addTab({
				title:"通讯记录",
				href: "./Modal/callCenter/callRecords/index.html?mobilePhone=" + row.mobilePhone
			});
		}
};

tableEvent1 = {
		
		"click .info": function (field, value, row, td) {
			//配置信息
			window.mode = 'modify';
	
			$('#Dialog_call_connect').modal('show');
			//初始化数据
	        $('#Dialog_call_connect .callConnect-form').values(row);
			
	        resetDialog();
		}
};

tableEvent2 = {
		"click .downLoad": function(e, a, item, index) {
			var downLink = interUrl.basic + interUrl.callcenter.downLoadRecording + "?id=" + item.id;
			//console.log(downLink);
			window.open(downLink, "_blank");
		}
};

function resetDialog() {
    if (window.mode == 'new') {
        $('#Dialog_call_connect .modal-header .modal-title').html('新增外呼联系人');
    }else if (window.mode == 'modify') {
        $('#Dialog_call_connect .modal-header .modal-title').html('修改外呼联系人');
    }
};

handle_1 = function (value, row, index) {
    if (value === 0 ){
        return '';
    } else{
    	if(typeof(args['businessTypeCode']) != "undefined" && typeof(args['currentNodeKey']) != "undefined"){
    		if(args['businessTypeCode'] == "LOAN_APPLY_FLOW" && args['currentNodeKey'] == "LOAN_TELEPHONE_AUDIT"){
    			return "<div class='btn btn-xs btn-primary info'>修改</div>";
    		}
    	}
    	return ''; 
    }
};

handle_2 = function (value, row, index) {
	if(value != "" && typeof(value) != "undefined"){
		return "<div class='text-center'>" +
        "<a href='#' class='jp-play-fun text-md' data-url='"+ value +"'> <i class='icon-control-play text'></i><i class='icon-control-pause text-active'></i> &nbsp;&nbsp; </a>" +
        "<a href='javacript:void(0);' class='text-md downLoad'><i class='icon-cloud-download text'></i></i> </a> </div>";	
	}else{
		return "";
	}
    
};

$("select[name='relationship']").getExpressCompanyCode("RelationShipType");

$("#btn-search").click(function () {
    $("#table2").bootstrapTable("refresh", {url: "..."});
});

//保存外呼联系人
$(".saveConnect").click(function() {
	if(validValue() == false){
		tip({content: "请填写全信息!"});
		return;
	}
	
	if(!regMobilePhone.test($("#mobilePhone").val())){
		tip({content: "手机格式不正确!"});
		return;
	}
	var url = "";
	if (window.mode == 'new') {
		url = interUrl.callcenter.OutcryContactCreate;
    }else if (window.mode == 'modify') {
    	url = interUrl.callcenter.OutcryContactModify;
    }
	comn.ajax({
	    url: url,
	    data: $.extend($(".callConnect-form").values(), {projectId: projectId_arg, loanApplyId: loanApplyId_arg}),
	    async: false,
	    success: function (res) {
	    	if(res.data == "success"){
	    		$('#id').val("");
	    		$('#Dialog_call_connect').modal('hide');
	    		$("#table1").bootstrapTable("refresh", {url: "..."});
	    	}else if(res.data == "hasSamePhone"){
	    		tip({content: "已有相同手机号的贷款关系人!"});
	    	}else{
	    		tip({content: "保存失败!"});
	    	}
	    }
	});
});

function validValue(){
	var list = ["mobileOwner","mobilePhone","loanRelationship","relationship","remark"];
	for(i = 0; i < list.length; i++){
		if($("#" + list[i]).val() == ""){
			return false;
		}
	}
	return true;
}

var regMobilePhone = /^[1][3,4,5,7,8][0-9]{9}$/; //验证规则


$(function() {
	$("#addButton").click(function() {
		//配置信息
		window.mode = 'new';
		
		$('#Dialog_call_connect').modal('show');
		$('#Dialog_call_connect .callConnect-form #id').val("");
		$('#Dialog_call_connect .callConnect-form')[0].reset();
        resetDialog();
	});
	
	$("#table1").bootstrapTable("refresh", {url: "..."});
	$("#table2").bootstrapTable("refresh", {url: "..."});
});