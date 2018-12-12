//获得当前用户权限
comn.ajax({
    url: "flow/hasTelAuditInnerApprovalNotePermission",
    async: false,
    success: function(res) {
        if(res.data == '0'){
            $('#table').find('[data-field="innerApprovalNote"]').remove();
            $("#table").bootstrapTable({
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
        }else {
            $("#table").bootstrapTable({
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
        }
    }
});

function isNull(a) {
    if (a == "" || a == null || a == undefined) {
        return true;
    } else {
        return false;
    }
}

////通用流程意见获取
function dataLoad_opinion(params) {
    var p;
    p = params.data;
    if(args['businessTypeCode'] == 'DOCUMENT_TRANSMIT_FLOW'){
    	p['boId'] = args['businessId'];
    }else if(args['businessTypeCode']=="INSURANCE_DISPATCHN_FLOW"){
        p['boId'] = args['projectId']
    }else if((args['type']==2||args['type']==1)&&args['businessTypeCode'] == 'CREDIT_FLOW'){
    	p['boId']=args["businessId"];
    }else if(args['type']==3&&args['businessTypeCode'] == 'CREDIT_FLOW'){//征信开始
    	p['boId']=args["creditId"];
    }else if(args['businessTypeCode']=="LICENSE_FLOW"){
        p['boId'] = args['licensePlateInfoId']
    }else if(args['businessTypeCode']=="PLEDGE_FLOW"){
        p['boId'] = args['pledgeInfoId']
    } else {
	    p['boId'] = args['loanApplyId'];
    }
    p['businessType'] = args['businessTypeCode'];
    if(p['businessType'] == undefined){
        tableData(params,{'boId': args['projectId']},interUrl.loanDetail.flowLoan);
    }else{
        tableData(params, p, interUrl.mockList || interUrl.gr.flow);
    }
};
opinion=function(value){
	if(value=="(null)"){
		return "--";
	}else{
		return value
	}
}
innerApprovalNote = function(value) {
    if (value == "(null)") {
        return "--";
    } else {
        if (value != undefined && value.indexOf(';') != -1){
            var splitValue = value.split(';');
            value = '';
            $.each(splitValue,function (i,item) {
                if (i<splitValue.length-1){
                    value +=item+'</br>';
                } else{
                    value +=item;
                }

            });
        }
        return value;
    }
}
isNull()