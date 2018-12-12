var dataLoad_4, tableEvent_4, handle_4;

borrowerRelationship = function (value, row, index) {
    return [null, "本人", "夫妻", "父亲", "母亲", "兄弟", "姐妹", "儿子", "亲戚", "朋友", "合伙人", "同事", "女儿", "姐夫", "嫂子", "儿媳"][value] || null;
};

//贷款发起征信记录
dataLoad_4 = function(params) {
	if(args["pageStatus"]){
		tableData(params, {
			creditApplyId: args['creditApplyId'],
			loanApplyId: args["loanApplyId"],
			projectId: args["projectId"], 
			flowType: args['releventFlow'] || "",
			nodeKey: args['currentNodeKey'] || args['releventFlowNode'] ,
			conversion:true
		}, interUrl.credit.getCustomerCreditListByProjectId)
	}else{
		tableData(params, {
			creditApplyId: args['creditApplyId'],
			loanApplyId: args["loanApplyId"],
			projectId: args["projectId"], 
			flowType: args['releventFlow'] || "",
			nodeKey: args['currentNodeKey'] || args['releventFlowNode'] 
		}, interUrl.credit.getCustomerCreditListByProjectId)
	}
};

tableEvent_4 = {
	"click .loanStart1": function(e, a, item, index) {
	     comn.addTab({
			 title: '征信详情',
			 href: './Modal/loanManage/creditManage/creditInfo.html?type=1&businessId='+item.creditId+"&locationStatus=1&&businessTypeCode=CREDIT_FLOW" 
		 });
	}
};

handle_4 = function(value, row, index) {
	//记录征信调查日期
	/*if(typeof(fin_loan_credit_info_table) != "undefined"){
		var str = "";
		if(row.creditStatus == "有效" && (row.creditResult == "征信通过" || row.creditResult == "征信不通过") && $("#coBankName").val() == row.inquryBank){
			if(row.borrowerRelationship == 1){
				str = "【主借人-" + row.customerName + "】";
			}else if(row.borrowerRelationship == 2){
				str = "【配偶-" + row.customerName + "】";
			}else{
				str = "【担保人-" + row.customerName + "】";
			}
			if(fin_loan_credit_info_table.indexOf(str) == -1){
				fin_loan_credit_info_table = fin_loan_credit_info_table + row.checkDate + str + ";"
			}
		}
	}*/
	
	return ["<button type='button' class='btn btn-primary btn-xs loanStart1'>查看详情</button>"].join("");
};
//反欺诈
function riskLevel(value){
	if(value=="低"){
		return ""
	}
	if(value=="中"){
		return "style='color:blue'"
	}
	if(value=="高"){
		return "style='color:red'"
	}
	return "";
}
function showFanQi(cur,data){
	if(data==""||data==null||data==undefined){
		return;
	}
	var tbodyHtml="";
	var json=data
	for(var i=0;i<json.length;i++){
		tbodyHtml+="<tr "+riskLevel(json[i].riskLevel)+">"+
		"<td>"+json[i].fieldName+"</td>"+
		"<td>"+json[i].dataFrom+"</td>"+
		"<td>"+json[i].dataRule+"</td>"+
		"<td>"+json[i].result+"</td>"+
		//"<td>"+json[i].riskLevel+"</td>"+
				"</tr>";
	}
	cur.find("tbody").empty()
	cur.find("tbody").append(tbodyHtml);
}
var dataLoad_5, tableEvent_5, handle_5;
dataLoad_5 = function(params) {
	if(args["pageStatus"]){
		tableData(params, {
			creditApplyId: args['creditApplyId'],
			loanApplyId: args["loanApplyId"],
			projectId: args["projectId"], 
			flowType: args['releventFlow'] || "",
			nodeKey: args['currentNodeKey'] || args['releventFlowNode'] ,
			conversion:true
		}, "customer/credit/getAntiFraudHis")
	}else{
		tableData(params, {
			creditApplyId: args['creditApplyId'],
			loanApplyId: args["loanApplyId"],
			projectId: args["projectId"], 
			flowType: args['releventFlow'] || "",
			nodeKey: args['currentNodeKey'] || args['releventFlowNode'] 
		}, "customer/credit/getAntiFraudHis")
	}
};
//反欺诈权限
if(args['releventFlowNode']=='LOAN_LAUNCH'){
	$("#his").addClass("hide");
}
//反欺诈权限
$.ajax({
	url:"/customer/credit/hasFraudAccess",
	success:function(item){
		var antiFraud =item.data;
		if(antiFraud!=true){
			$("#his").addClass("hide")
		}	
	}
})

tableEvent_5 = {
	
		"click .info": function(e, a, item, index) {
			$.ajax({
				url:"/customer/credit/getAntiFraudHisByHisId",
				data:{
					"hisId":item.id
				},
				success:function(item){
					if(item.data){
						showFanQi($("#table_fanqi_model"),item.data);
					}
				}
			})
			$("#fqzModel").modal("show")
		}
};

handle_5 = function(value, row, index) {
	return ["<button type='button' class='btn btn-primary btn-xs info'>查看详情</button>"].join("");
};

$(function () {
	$("#table_4").bootstrapTable(comn.table); 
	$("#table_5").bootstrapTable(comn.table);
});

