var creditId;
var dataLoad_fanqi;
var riskLevel

function showCreditModel(param){
	//1：工行模板/2：温州银行模板
	if(param == 2){
		return true;
	}else{
		return false;
	}
}

/**
 * 反欺诈数据获取
 * @param creditId
 * @param creditRelavantId
 * @param fanqiId
 */
function getfanqiClick(creditId, creditRelavantId, fanqiId){
	$.ajax({
		url:"/customer/credit/getAntiFraud",
		data:{
			"creditId":creditId,
			"creditRelavantId":creditRelavantId
		},
		beforeSend:function(){
			$("#getfanqi_"+fanqiId+"").html("获取中...");
			$("#getfanqi_"+fanqiId+"").attr("disabled",true);
		},
		success:function(item){
			if(item.data){
				showFanQi($("#table_fanqi_"+fanqiId+""), item.data);
			}
		},
		complete:function(){
			$("#getfanqi_"+fanqiId+"").html("获取反欺诈数据")
			$("#getfanqi_"+fanqiId+"").attr("disabled",false);
			$("#table_5").bootstrapTable("refresh", {url: "..."});
		}
	})
}

function getfahaiClick(creditId, creditRelavantId, borrowerRelationship, fullName, cardId){
    var fahai = $("#getfahai_" + borrowerRelationship);
    $.ajax({
        url:"/customer/credit/getFhSfEntry",
        data:{
            "creditId":creditId,
            "creditRelavantId":creditRelavantId,
            "fullName":fullName,
            "cardId":cardId
            //"fullName":"陈海林",
            //"cardId":"330225198012045814"
        },
        beforeSend:function(){
            fahai.html("获取中...");
            fahai.attr("disabled", true);
        },
        success:function(item){
            if(!isNull(item.data)){
                //填充法海数据
                entryList = JSON.parse(item.data);
                //调用通用函数
                bootstrapFaHai(borrowerRelationship, entryList);
            }
        },
        complete:function(){
            fahai.html("获取法海数据");
            fahai.attr("disabled", false);
        }
    })
}

(function(){
    var pictures = document.querySelector('#documentList_credit');
    var viewer;
    var options = {
        url: 'data-original',
        title: true,
        transition: false,
        build: function (e) {},
        built: function(e){},
        show:  function (e) {
            imgIds = {};
            window.parent.toggleTopNav();
        },
        viewed: function(e){},
        hide: function(e){
            window.parent.toggleTopNav();
        }
    };

getValue = function (o, key) { //处理undefine
    return o[key] ? o[key] : "";
} 

function showFahai(res) {
	if(res.fahaiId >= 0){
		$("#fahaiDiv_"+res.borrowerRelationship).removeClass("hide");
	}
	if(res.fahaiId == 0){
		$("#getfahai_"+res.borrowerRelationship).removeClass("hide");
	}
}
loanVal = function (a, b, c) {
	var guaranteeOrder=0;//担保人次序
    for (var i = 0; i < a.length; i++) {
		var imgHtml = "";
		if(a[i]['creditFiles'] && a[i]['creditFiles'].length){
			imgHtml += '<div>';
			for (var j = 0, len = a[i]['creditFiles'].length; j < len; j++) {
				var o =  a[i]['creditFiles'][j];
				var type = o['creditFile'].substr(o['creditFile'].length - 4).toLocaleLowerCase();
				if(type == ".gif" || type == ".png" || type == ".jpg"){
					imgHtml += "<img class='img-thumbnail' src= '" + o['creditFile'] + "@80h' data-original='" + o['creditFile'] + "' style='margin-right:10px;height:200px;width:200px'/>";
				}
				
			} 
			imgHtml += "</div>";
		}
        setTimeout(function () {
            viewer = new Viewer(pictures, options);
        }, 500);
        
        var bankHtmlStr = '',checkResultTypeStr = '',netArrHtml = '',entryList = [];
        var htmlArr = [
            '<div class="panel panel-default partyList party_List">',
            '<div class="panel-heading">',
            '<h3 class="panel-title">借款人 - ' + a[i].fullName + '</h3>',
            '</div>',
            '<div class="panel-body" style="padding-bottom:0;" id="accordion_'+ i +'" role="tablist" aria-multiselectable="true">',
            '<div class="panel panel-default collapseFlex">' +
            '<div class="panel-heading">' +
            '<div class="col-md-8">' +
            '<h3 class="panel-title">银行征信信息</h3>' +
            '</div>' +
            '<div class="col-md-16 text-right">' +
            '<a href="javascript:;" class="btn flexBtn" data-status="0"><span class="glyphicon glyphicon-chevron-right"></span></a>' +
            '</div>' +
            '</div>' +
            '<div class="panel-body">' ,
            // 银行信息
            bankHtmlStr,
            '<div class="borrowUser">' +
            '</div>' +
            '<div class="revalantForm">' ,
            checkResultTypeStr,
            '</div>' +
            '<div class="input-tip"><label class="col-md-3 col-xs-3 col-sm-3 control-label"></label>' +
			imgHtml +
			'</div>' +
            '</div>' +

            '</div>',
            //---网络征信信息开始
            '<div class="panel panel-default collapseFlex">',
            '<div class="panel-heading">',
            '<div class="col-md-8">',
            '<h3 class="panel-title">网络征信信息</h3>',
            '</div>',
            '<div class="col-md-16 text-right">',
            //'<a href="javascript:;" class="btn flexBtn" data-status="1"><span class="glyphicon glyphicon-chevron-right"></span></a>',
            '<button class="btn btn-primary getNet" type="button" style="margin-right:5px;">获取网络征信</button><a href="javascript:;" class="btn flexBtn" data-status="1"><span class="glyphicon glyphicon-chevron-right"></span></a>' +
            '</div>',
            '</div>',
            '<div class="panel-body">' ,
                netArrHtml ,
            '<div class="panel panel-default">' +
            '<div class="panel-heading">' +
            '<h3 class="panel-title">其他网络征信信息</h3>' +
            '</div>' +
            '<div class="panel-body">' +
            '<fieldset class="disabled1Class">'+
            '<div class="form-group form-group-sm"><div class="input-tip"><label class="col-md-3 col-xs-3 col-sm-3 control-label">报告日期：</label><div class="col-md-5 cl-sm-5 col-xs-5"><input type="hidden" name="relavants[' + i + '].netResult" value="1" /><input type="text" name="relavants[' + i + '].netReportDate" value="' + getValue(a[i], 'netReportDate') + '" placeholder="请输入报告日期" disabled="disabled" class="form-control date required dateISO" required="" aria-required="true" /></div></div>'+
//            '<div class="input-tip">'+
//            	'<label class="col-md-3 col-xs-3 col-sm-3 control-label">风险等级：</label>'+
//            	'<div class="col-md-5 cl-sm-5 col-xs-5">'+
//            	'<select name="relavants[' + i + '].riskStatus" value="' + a[i].riskStatus + '" class="form-control riskStatus" disabled="disabled" required="" aria-required="true">'+
//            		'<option value="1">正常</option>'+
//            		'<option value="2">黑名单</option>'+
//            		'<option value="3">灰名单</option>'+
//            	'</select>'+
//            	'</div>'+
//            '</div>'+
            '</div><div class="form-group form-group-sm"><label class="col-md-3 control-label">网络征信：</label><div class="col-md-21"><textarea disabled="disabled" required="" aria-required="true" class="form-control netReportDetailVal netReportDetail' + i + '" rows="3" name="relavants[' + i + '].riskDetail"></textarea></div></div>' +
            '</fieldset>' +
            '</div>' +
            '</div>' +
            '</div>' +
            '</div>' +
            //---网络征信信息结束
           
            //---反欺诈数据开始
			'<div id="fqz_'+ a[i].borrowerRelationship +'" data-id='+a[i].borrowerRelationship+' class="panel panel-default collapseFlex '+(a[i].borrowerRelationship == 1 || a[i].borrowerRelationship == 2 ? '':'hide')+'">',
				'<div class="panel-heading">',
					'<div class="col-md-8">',
						'<label class="panel-title">反欺诈数据评估表</label>',
					'</div>' ,
					'<div class="col-md-16 text-right">',
		            	'<a href="javascript:;" class="btn flexBtn" data-status="1"><span class="glyphicon glyphicon-chevron-right"></span></a>',
		            '</div>',
				'</div>' ,
				'<div class="panel-body">',
						//$("#fanqi").html(),
						//'<div id="fanqi" class="hide">'+
							'<div class="form-group form-group-sm row">'+
								'<div class="input-tip text-right" style="margin-right:10px;">'+
									'<button onClick="getfanqiClick('+a[i].creditId +',' + a[i].id + ',' + a[i].borrowerRelationship +')" type="button" class="btn btn-primary hide" id="getfanqi_'+ a[i].borrowerRelationship +'">获取反欺诈数据</button>'+
								'</div>'+
							'</div>'+
								'<p style="color:red">注：</p>'+
								'<p style="color:red">1：低风险黑体</p>'+
								'<p style="color:red">2：中风险蓝色</p>'+
								'<p style="color:red">3：高风险红色</p>'+
								'<table id="table_fanqi_'+a[i].borrowerRelationship+'" class="table table-bordered">'+
									'<thead>'+
										'<tr>'+
											'<th data-field="fieldName">字段名称</th>'+
											'<th data-field="dataFrom">数据来源</th>'+
											'<th data-field="dataRule">数据格式与限制</th>'+
											'<th data-field="result">结果</th>'+
											//'<th data-field="riskLevel" data-formatter="riskLevel">风险等级</th>'+
											'</tr>'+
									'</thead>'+
									'<tbody>'+
									'</tbody>'+
								'</table>'+
							'</div>',
						//'</div>' ,
					'</div>' ,
			//---反欺诈数据结束
            '</div>',
            '</div>'
        ];
        var netArr = ['<div class="netForm">',
            '	<div class="panel panel-default hide">',
            '		<div class="panel-heading">',
            '			<h3 class="panel-title">百融</h3>',
            '		</div>',
            '		<div class="panel-body">',
            '			<div class="form-group form-group-sm">',
            '				<div class="input-tip col-md-12">',
            '					<label class="col-md-5 col-xs-5 col-sm-5 control-label">手机三要素：</label>',
            '					<label class="radio-inline "> <input type="radio" value="1" name="mobileBase">一致</label>',
            '					<label class="radio-inline "> <input type="radio" value="2" name="mobileBase">不一致</label>',
            '					<label class="radio-inline "> <input type="radio" value="0" name="mobileBase">查无此号或非实名认证</label>',
            '				</div>',
            '				<div class="input-tip ">',
            '					<label class="col-md-3 col-xs-3 col-sm-3 control-label">手机在网时长：</label>',
            '					<div class="col-md-3 cl-sm-3 col-xs-3">',
            '						<input type="text" name="mobileOnline" placeholder="" class="form-control">',
            '					</div>',
            '				</div>',
            '				<div class="input-tip ">',
            '					<label class="col-md-3 col-xs-3 col-sm-3 control-label">手机号码个数：</label>',
            '					<div class="col-md-3 cl-sm-3 col-xs-3">',
            '						<input type="text" name="mobileNum" placeholder="" class="form-control">',
            '					</div>',
            '				</div>',
            '			</div>',
            '			<div class="form-group form-group-sm mobile2 hide">',
            '				<div class="input-tip col-md-12">',
            '					<label class="col-md-5 col-xs-5 col-sm-5 control-label">手机2三要素：</label>',
            '					<label class="radio-inline"> <input type="radio" value="1" name="mobileBase2">一致</label>',
            '					<label class="radio-inline"> <input type="radio" value="2" name="mobileBase2">不一致</label>',
            '					<label class="radio-inline"> <input type="radio" value="0" name="mobileBase2">查无此号或非实名认证</label>',
            '				</div>',
            '				<div class="input-tip ">',
            '					<label class="col-md-3 col-xs-3 col-sm-3 control-label">手机2在网时长：</label>',
            '					<div class="col-md-3 cl-sm-3 col-xs-3">',
            '						<input type="text" name="mobileOnline2" placeholder="" class="form-control">',
            '					</div>',
            '				</div>',
            '			</div>',
            '			<div class="form-group form-group-sm">',
            '				<div class="input-tip">',
            '					<label class="col-md-3 col-xs-3 col-sm-3 control-label">特殊名单：</label>',
            '					<div class="col-md-21">',
            '						<textarea class="form-control " rows="3" name="specialList"></textarea>',
            '					</div>',
            '				</div>',
            '			</div>',
            '			<div class="form-group form-group-sm">',
            '				<div class="input-tip">',
            '					<label class="col-md-3 col-xs-3 col-sm-3 control-label">法院被执行人：</label>',
            '					<div class="col-md-21">',
            '						<textarea class="form-control " rows="8" name="courtExecutor"></textarea>',
            '					</div>',
            '				</div>',
            '			</div>',
            '			<div class="form-group form-group-sm">',
            '				<div class="input-tip">',
            '					<label class="col-md-3 col-xs-3 col-sm-3 control-label">公安网信息：</label>',
            '					<div class="col-md-21">',
            '						<table id="pubNetworkInfo" data-ajax="pubNetworkInfo" class="table table-bordered">',
            '							<thead>',
            '							<tr>',
            '								<th data-field="num">序号</th>',
            '								<th data-field="caseSource">案件来源</th>',
            '								<th data-field="caseType" data-formatter="">案件类别</th>',
            '								<th data-field="caseTime" data-formatter="">案发时间</th>',
            '							</tr>',
            '							</thead>',
            '							<tbody>',
            '							</tbody>',
            '						</table>',
            '					</div>',
            '				</div>',
            '			</div>',
            '		</div>',
            '	</div>',
            '	<div class="panel panel-default">',
            '		<div class="panel-heading ">',
            '			<div class="col-md-8">',
            '				<label class="panel-title">同盾</label>',
            '			</div>',
            '			<div class="col-md-16 text-right">',
            '            	<span><button type="button" class=" btn btn-primary getReport text-right hide " style="margin-right: 5px;">获取报告</button></span>',
            '			</div>',
            '		</div>',
            '		<div class="panel-body">',
            '			<div class="form-group form-group-sm row">',
            '				<div class="input-tip">',
            '					<label class="radio-inline"> <input type="checkbox" name="s1942707" />失信黑名单</label>',
            '					<label class="radio-inline"> <input type="checkbox" name="s1942739" />税务行政执法黑名单</label>',
            '					<label class="radio-inline"> <input type="checkbox" name="s1942711" />法院案例黑名单</label>',
            '					<label class="radio-inline"> <input type="checkbox" name="s1942715" />网贷逾期</label>',
            '					<label class="radio-inline"> <input type="checkbox" name="s1942713" />催欠公告</label>',
            '					<label class="radio-inline"> <input type="checkbox" name="s1942715" />网贷黑名单</label>',
            '				</div>',
            '			</div>',
            '		</div>',
            '	</div>',
            '	<div class="panel panel-default hide">',
            '		<div class="panel-heading ">',
            '			<div class="col-md-8">',
            '				<label class="panel-title">法海</label>',
            '			</div>',
            '			<div class="col-md-16 text-right">',
            '               <button type="button" class="btn btn-primary hide">获取法海数据</button>',
            '			</div>',
            '		</div>',
            '		<div class="panel-body">',
            '			<table class="table table-bordered">',
            '				<thead>',
            '				<tr>',
            '					<th data-field="sortTimeString">立案时间</th>',
            '					<th data-field="dataType">数据类型</th>',
            '					<th data-field="body">内容摘要</th>',
            '					<th data-field="matchRatio">匹配度</th>',
            '				</tr>',
            '				</thead>',
            '				<tbody>',
            '				</tbody>',
            '			</table>',
            '		</div>',
            '	</div>',
            '</div>'
        ];

        var paramCreditId;
        if(a[i].oldCreditId == "" || a[i].oldCreditId == undefined || a[i].oldCreditId == null){
    		paramCreditId = a[i].creditId;
    	}else{
    		paramCreditId = a[i].oldCreditId;
    	}
        
        if (a[i].borrowerRelationship == 1) {    //本人
        	var inquryBank = a[i].inquryBank;
        	//获取征信模板
        	var creditModel = a[i].showCreditModel;
        	bankHtmlStr = bankHtml(creditModel);
        	var html = (function () {
				if (a[i].checkResultPassstatus == 0) {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus" checked class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">附条件通过</label>'
				} else if (a[i].checkResultPassstatus == 1) {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus" checked class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">附条件通过</label>'
				} else if (a[i].checkResultPassstatus == 2) {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" checked class="required" aria-required="true">附条件通过</label>'
				}
				else {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">附条件通过</label>'
				}

            })();
        	checkResultTypeStr = '<input type="hidden" name="relavants[' + i + '].id" value="' + a[i].id + '" />' + checkResultType(i, a[i], creditModel, html);
            htmlArr[6] = bankHtmlStr;
            htmlArr[8] = checkResultTypeStr;
            netArr[1] =  '<div class="panel panel-default hide" id="baiRongDiv_'+ a[i].borrowerRelationship +'">';
            netArr[99] =  '<div class="panel panel-default hide" id="fahaiDiv_'+ a[i].borrowerRelationship +'">';
            netArr[105] =  '<button onClick="getfahaiClick('+a[i].creditId +',' + a[i].id + ',' + a[i].borrowerRelationship +',&quot;' + a[i].fullName +'&quot;,&quot;' + a[i].cardId +'&quot;)" type="button" class="btn btn-primary hide" id="getfahai_'+ a[i].borrowerRelationship +'">重新获取法海数据</button>';
            netArr[109] =  '<table class="table table-bordered" id="fahai_'+ a[i].borrowerRelationship +'">';
            htmlArr[19] = netArr.join('');

        	var relationshipBR = a[i].borrowerRelationship;
            var oneself = htmlArr.join('');
            $("#host").append(oneself);
            //自动获取最新一条历史反欺诈数据表
            $.ajax({
        		url:"/customer/credit/getSauron",
        		data:{
        			"creditId":paramCreditId,
        			"creditRelavantId":a[i].id
        		},
        		success:function(item){
        			showFanQi($("#table_fanqi_"+relationshipBR+""), item.data);
        		}
        	});
            
            //selectCreditResult(a[i].id,"#host",0)
            if(showCreditModel(creditModel)){
                selectCYRCreditResult(a[i].id, "#host", 0);
            }else{
                selectCreditResult(a[i].id, "#host", 0);
            }
            //获取网络征信结果
            getnetWork($("#host").find(".getNet"), a[i].id, 1, 1, a[i].borrowerRelationship, a[i].fahaiId);
            getBankNoteAnalysis(a[i].id, a[i].creditId, $("#host .borrowUser").eq(0));

            if(!isNull(a[i].entryList)){
                //填充法海数据
                entryList = JSON.parse(a[i].entryList);
                //调用通用函数
                bootstrapFaHai(a[i].borrowerRelationship,entryList);
            }
            if(a[i].fahaiId == 0){
            	 $("#getfahai_1").removeClass("hide");
            }
            showFahai(a[i]);
        } else if (a[i].borrowerRelationship == 2) {    //妻子
        	var inquryBank = a[i].inquryBank;
        	var creditModel = a[i].showCreditModel;
        	bankHtmlStr = bankHtml(creditModel);
        	var html = (function () {
				if (a[i].checkResultPassstatus == 0) {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus" checked class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">附条件通过</label>'
				} else if (a[i].checkResultPassstatus == 1) {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus" checked class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">附条件通过</label>'
				} else if (a[i].checkResultPassstatus == 2) {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" checked class="required" aria-required="true">附条件通过</label>'
				}
				else {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">附条件通过</label>'
				}
            })();
        	checkResultTypeStr = '<input type="hidden" name="relavants[' + i + '].id" value="' + a[i].id + '" />' + checkResultType(i, a[i], creditModel, html);
            htmlArr[6] = bankHtmlStr;
            htmlArr[8] = checkResultTypeStr;
            netArr[1] =  '<div class="panel panel-default hide" id="baiRongDiv_'+ a[i].borrowerRelationship +'">';
            netArr[99] =  '<div class="panel panel-default hide" id="fahaiDiv_'+ a[i].borrowerRelationship +'">';
            netArr[105] =  '<button onClick="getfahaiClick('+a[i].creditId +',' + a[i].id + ',' + a[i].borrowerRelationship +',&quot;' + a[i].fullName +'&quot;,&quot;' + a[i].cardId +'&quot;)" type="button" class="btn btn-primary hide" id="getfahai_'+ a[i].borrowerRelationship +'">重新获取法海数据</button>';
            netArr[109] =  '<table class="table table-bordered" id="fahai_'+ a[i].borrowerRelationship +'">';
            htmlArr[19] = netArr.join('');
        	
        	var relationshipFQ = a[i].borrowerRelationship;
            htmlArr[0] = '<div class="panel panel-default partyList">';
            htmlArr[2] = '<h3 class="panel-title">配偶 - ' + a[i].fullName + '</h3>';
            var wife = htmlArr.join('');
            $("#wife").append(wife);
            //自动获取最新一条历史反欺诈数据表
            $.ajax({
        		url:"/customer/credit/getSauron",
        		data:{
        			"creditId":paramCreditId,
        			"creditRelavantId":a[i].id
        		},
        		success:function(item){
        			showFanQi($("#table_fanqi_"+relationshipFQ+""), item.data);
        		}
        	});
            
            //selectCreditResult(a[i].id,"#wife",0)
            if (!showCreditModel(creditModel)) {
                selectCreditResult(a[i].id, "#wife", 0);
            } else{
                selectCYRCreditResult(a[i].id, "#wife", 0);
            }
            
            getnetWork($("#wife").find(".getNet"), a[i].id, 1, 1, a[i].borrowerRelationship, a[i].fahaiId);
            getBankNoteAnalysis(a[i].id, a[i].creditId, $("#wife .borrowUser").eq(0));

            if(!isNull(a[i].entryList)){
                //填充法海数据
                entryList = JSON.parse(a[i].entryList);
                //调用通用函数
                bootstrapFaHai(a[i].borrowerRelationship,entryList);
            }
            
            if(a[i].fahaiId == 0){
           	 $("#getfahai_2").removeClass("hide");
            }
            showFahai(a[i]);
        } else {
        	var inquryBank = a[i].inquryBank;
        	var creditModel = a[i].showCreditModel;
        	bankHtmlStr = bankHtml(creditModel);
        	var html = (function () {
				if (a[i].checkResultPassstatus == 0) {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus" checked class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">附条件通过</label>'
				} else if (a[i].checkResultPassstatus == 1) {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus" checked class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">附条件通过</label>'
				} else if (a[i].checkResultPassstatus == 2) {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" checked class="required" aria-required="true">附条件通过</label>'
				}
				else {
					return '<label class="radio-inline"><input type="radio"  value="0" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">有征信通过</label>' +
						'<label class="radio-inline"><input type="radio"  value="1" name="relavants[' + i + '].checkResultPassstatus"  class="required" aria-required="true">无征信通过</label>'
						+ '<label class="radio-inline"><input type="radio"  value="2" name="relavants[' + i + '].checkResultPassstatus" class="required" aria-required="true">附条件通过</label>'
				}
            })();
        	checkResultTypeStr = '<input type="hidden" name="relavants[' + i + '].id" value="' + a[i].id + '" />' + checkResultType(i, a[i], creditModel, html);
            htmlArr[6] = bankHtmlStr;
            htmlArr[8] = checkResultTypeStr;
            netArr[105] =  '<button onClick="getfahaiClick('+a[i].creditId +',' + a[i].id + ',' + a[i].borrowerRelationship +',&quot;' + a[i].fullName +'&quot;,&quot;' + a[i].cardId +'&quot;)" type="button" class="btn btn-primary" id="getfahai_'+ a[i].borrowerRelationship +'">重新获取法海数据</button>';
            netArr[109] =  '<table class="table table-bordered" id="fahai_'+ a[i].borrowerRelationship +'">';
            htmlArr[19] = netArr.join('');
        	
            htmlArr[0] = '<div class="panel panel-default partyList party_mean re'+a[i].id+'">';//标示担保人
            htmlArr[2] = '<h3 class="panel-title">借款关系人 - ' + a[i].fullName + '</h3>';
            var Borrower = htmlArr.join('');
            $("#partyBox").append(Borrower);
            
            if (!showCreditModel(creditModel)) {
                selectCreditResult(a[i].id, "#partyBox", guaranteeOrder);
            } else{
                selectCYRCreditResult(a[i].id, "#partyBox", guaranteeOrder);
            }
            
            getnetWork($("#partyBox").find(".getNet").eq(guaranteeOrder), a[i].id, 1, 1, null);
            getBankNoteAnalysis(a[i].id, a[i].creditId, $("#partyBox .borrowUser").eq(guaranteeOrder));
            guaranteeOrder++;//担保人次数加1

            if(!isNull(a[i].entryList)){
                //填充法海数据
                entryList = JSON.parse(a[i].entryList);
                //调用通用函数
                bootstrapFaHai(a[i].borrowerRelationship,entryList);
            }
        }
        if (a[i].riskDetail) {
            $(".netReportDetail" + i + "").html(a[i].riskDetail);
        } else {
            $(".netReportDetail" + i + "").html('无记录');
        }
        $("select[name='relavants[" + i + "].checkResult']").attr("value", a[i].checkResult).change();    //调查结果
        if(a[i].checkResult == 2){
            $("#checkResultStatusY"+i+"").hide();
            $("#checkResultStatusN"+i+"").show();
        }else if(a[i].checkResult == 1){
            $("#checkResultStatusY"+i+"").show();
            $("#checkResultStatusN"+i+"").hide();
        }else{
            $("#checkResultStatusN"+i+"").hide();
            $("#checkResultStatusY"+i+"").hide();
        }
        $("input[name='relavants[" + i + "].checkResultStatus'][value='" + a[i].checkResultStatus + "']").attr("checked", true);    //调查结果状态
        viewCredit(creditModel);
    }
    selectCheck();
    $(".disabledClass,.disabled1Class").attr("disabled", true);
    $(".chForm").find("input,select,textarea").attr("disabled", true);
    $(".getNet").addClass("hide");
    $('.flexBtn').each(function(){
        var value = $(this).attr("data-status");
        $(this).flexBtnInit(value);
    })

//反欺诈按钮
//    $("#getfanqi").click(function(){
//		$.ajax({
//			url:"/customer/credit/getAntiFraud",
//			data:{
//				"creditId":a[0].creditId,
//				"relastion":$("#fqz").attr("data-id")
//			},
//			beforeSend:function(){
//				$("#getfanqi").html("获取中...")
//				$("#getfanqi").attr("disabled",true);
//			},
//			success:function(item){
//				alert(item.data);
//				if(item.data){
//					showFanQi($("#table_fanqi"),item.data);
//				}
//			},
//			complete:function(){
//				$("#getfanqi").html("获取反欺诈数据")
//				$("#getfanqi").attr("disabled",false);
//				$("#table_5").bootstrapTable("refresh", {url: "..."});
//			}
//		})
//	})

//反欺诈权限
$.ajax({
	url:"/customer/credit/hasFraudAccess",
	success:function(item){
		var antiFraud = item.data;
		if(antiFraud != true){
			//$("#fqz").addClass("hide");
			for (var i = 0; i < a.length; i++) {
				$("#fqz_"+a[i].borrowerRelationship+"").addClass("hide");
		    }
		}
	}
})

//贷款查询-反欺诈获取按钮显示
if(args['showfqzbtn'] == 1){
	//$("#getfanqi").removeClass("hide");
	for (var i = 0; i < a.length; i++) {
		$("#getfanqi_"+a[i].borrowerRelationship+"").removeClass("hide");
    }
}

};

CustomerLoad = function (a, b, c) {
    comn.ajax({
        url: b,
        async: false,
        data: {
            projectId: a.projectId,
            loanApplyId: a.loanApplyId,
			flowType: a.flowType,
			conversion:a.conversion
        },
        success: function (res) {
        	$("#creditInfoForm").values(res.data);
        	if (res.data.source == 2) $(".Number").addClass('hide');
        	args["creditApplyId"] = res.data.id;
        	args["customerId"] = res.data.customerId;
        	if ($('#loadCreditInfo')) {
        		$('#loadCreditInfo').getLoad();
        	}
        	loanVal(res.data.relavants, c); //借款人、借款关系人信息处理
        	//$(".panel-body #net").removeClass('hide')
        	//impObject = res.data.relavants.creditFiles;
        	impObject = res.data;
        	$(".netForm").find("input,select,textarea").attr("disabled", true);
        }
    });
};

selectCheck = function () {
    var length = $("select").length;
    for (var i = 0; i < length; i++) {
        var val = $("select:eq(" + i + ")").attr('value');
        $("select:eq(" + i + ") option[value=" + val + "]").attr("selected", true);
    }
};

})()

$(function () {
	if(args["pageStatus"]=="1"||args["pageStatus"]=="2"||args["pageStatus"]=="3"||args["pageStatus"]=="4"){
		CustomerLoad({
	        flowType: args['releventFlow'] || "",
	        projectId: args["projectId"],
	        loanApplyId: args["loanApplyId"],
	        conversion:true
	    }, interUrl.credit.loanCreditInfo, '1');
	}else{
		CustomerLoad({
			flowType: args['releventFlow'] || "",
			projectId: args["projectId"],
			loanApplyId: args["loanApplyId"]
		}, interUrl.credit.loanCreditInfo, '1');
	}

    //展开关闭动画
    $(document).on("click", ".open", function () {
        $(this).removeClass("open").addClass("closeOp").parents(".openBox").next(".openValBox").stop().slideDown(1000);
    });
    $(document).on("click", ".closeOp", function () {
        $(this).removeClass("closeOp").addClass("open").parents(".openBox").next(".openValBox").stop().slideUp(1000);
    });
});

//工行征信结果html
//function bankHtml(){
//var bankHtml='<form class="creditResultForm hide">'+
//			'<input name="creditRelavantId" type="hidden"/>'+
//			'<div class="form-group form-group-sm">'+
//					'<div class="input-tip">'+
//						'<label class="col-md-3 col-xs-3 col-sm-3 control-label">客户信用等级：</label>'+
//						'<div class="col-md-21">'+
//							'<textarea required="" aria-required="true" class="form-control level" rows="3" name="result"></textarea>'+
//						'</div>'+
//					'</div>'+
//			'</div>'+
//			'<div class="form-group form-group-sm">'+
//					'<div class="input-tip">'+
//						'<label class="col-md-3 col-xs-3 col-sm-3 control-label">贷款逾期记录：</label>'+
//						'<div class="col-md-21">'+
//							'<textarea required="" aria-required="true" class="form-control loanRecode" rows="3" name="loancrdt"></textarea>'+
//						'</div>'+
//					'</div>'+
//			'</div>'+
//			'<div class="form-group form-group-sm">'+
//				'<div class="input-tip">'+
//						'<label class="col-md-3 col-xs-3 col-sm-3 control-label">信用卡逾期记录：</label>'+
//						'<div class="col-md-21">'+
//						'<textarea required="" aria-required="true" class="form-control cardRecode" rows="3" name="cardcrdt"></textarea>'+
//						'</div>'+
//					'</div>'+
//			'</div>'+
//			'<div class="form-group form-group-sm">'+
//			'<div class="input-tip">'+
//				'<label class="col-md-3 col-xs-3 col-sm-3 control-label">工行专项卡分期笔数：</label>'+
//				'<div class="col-md-21">'+
//					'<textarea required="" aria-required="true" class="form-control count" rows="3" name="leftnum"></textarea>'+
//				'</div>'+
//			'</div>'+
//	'</div>'+
//	'<div class="form-group form-group-sm">'+
//			'<div class="input-tip">'+
//				'<label class="col-md-3 col-xs-3 col-sm-3 control-label">未结清余额：</label>'+
//				'<div class="col-md-21">'+
//					'<textarea required="" aria-required="true" class="form-control money" rows="3" name="leftamount"></textarea>'+
//				'</div>'+
//			'</div>'+
//	'</div>'+
//	'<div class="form-group form-group-sm">'+
//		'<div class="input-tip">'+
//				'<label class="col-md-3 col-xs-3 col-sm-3 control-label">备注：</label>'+
//				'<div class="col-md-21">'+
//				'<textarea required="" aria-required="true" class="form-control note" rows="3" name="creditRemark"></textarea>'+
//				'</div>'+
//			'</div>'+
//	'</div></form>';
//	return bankHtml
//}

//判断非空
function isNull(a) {
    if (a == "" || a == null || a == undefined) {
        return true;
    } else {
        return false;
    }
}

function getValueRemark (o, key) {
    return o[key] ? o[key] : "";
}




//不同的银行，不同的页面
function checkResultType(i, object, creditModel, html) {
    if (!showCreditModel(creditModel)) {
        return '<fieldset class="disabled1Class">' +
            '<div class="form-group form-group-sm"><div class="input-tip">' +
            '<label class="col-md-3 col-xs-3 col-sm-3 control-label">调查方式：</label><div class="col-md-5 cl-sm-5 col-xs-5">' +
            '<select id="seHan" name="relavants[' + i + '].checkType" value="' + (typeof(object.checkType) == "undefined" ? 2 : object.checkType) + '" class="form-control" required="" aria-required="true">' +
            '<option value="">--请选择--</option><option value="1">电话</option><option value="2">网络</option></select></div></div>' +
            '<div class="input-tip">' +
            '<label class="col-md-3 col-xs-3 col-sm-3 control-label">调查结果：</label>' +
            '<div class="col-md-5 cl-sm-5 col-xs-5">' +
            '<select name="relavants[' + i + '].checkResult" value="' + object.checkResult + '" class="form-control checkResult" required="" aria-required="true">' +
            '<option value="" >--请选择--</option>' +
            '<option value="1">通过</option>' +
            '<option value="2">不通过</option>' +
            '</select></div></div>' +
            '<div id="checkResultStatusN' + i + '" class="input-tip">' +
            '<label class="radio-inline"><input type="radio" fors="radio0" value="1" name="relavants[' + i + '].checkResultStatus" required="" aria-required="true" />关注</label>' +
            '<label class="radio-inline"><input type="radio" fors="radio0" value="2" name="relavants[' + i + '].checkResultStatus" required="" aria-required="true" />禁入</label>' +
            '<label class="radio-inline"><input type="radio" fors="radio0" value="3" name="relavants[' + i + '].checkResultStatus" required="" aria-required="true" />其他</label>' +
            '</div>' +
            '<div id="checkResultStatusY' + i + '"  class="input-tip" >' +
            html +
            '</div>' +
            '</div><div class="form-group form-group-sm"><div class="input-tip"><label class="col-md-3 col-xs-3 col-sm-3 control-label">调查人：</label><div class="col-md-5 cl-sm-5 col-xs-5"><input  readonly = "readonly" type="text" maxlength="5" name="relavants[' + i + '].staffName" value="' + getValue(object, 'staffName') + '" for="staffName"  class="form-control"  required="" aria-required="true" /><input type="hidden" name="relavants[' + i + '].staffId" value="' + getValue(object, 'staffId') + '" /></div></div><div class="input-tip"><label class="col-md-3 col-xs-3 col-sm-3 control-label">调查日期：</label><div class="col-md-5 cl-sm-5 col-xs-5"><input type="text" name="relavants[' + i + '].checkDate" placeholder="请输入调查日期" value="' + getValue(object, 'checkDate') + '" class="form-control date required checkDate" required="" aria-required="true" /></div></div></div>' +
            '<div class="form-group form-group-sm"><label class="col-md-3 control-label">补充信息：</label><div class="col-md-21"><textarea  class="form-control  supplement" rows="3" maxlength="2000" name="relavants[' + i + '].creditRemark">' + getValueRemark(object, 'creditRemark') + '</textarea></div>' +
            '</div>' +
            // $("#saveTem").html() +
            '</fieldset>';
    } else{
        return '<div class="resultForm"><fieldset class="disabled1Class">' +
            '<input type="hidden" class="checkResult" name="relavants[' + i + '].checkResult" value="' + object.checkResult + '"/>' +
            "<div class=\"form-group form-group-sm\"><div class=\"input-tip has-success\"><label class=\"col-md-3 col-xs-3 col-sm-3 control-label\">调查结果：<\/label><div class=\"col-md-5 cl-sm-5 col-xs-5\"><select name=\"relavants[" + i + "].wzCreditResult\" value=" + object.wzCreditResult + " class=\"form-control\" required='' aria-required='true'><option value>--请选择--<\/option><option value=\"1\">通过<\/option><option value=\"2\">不通过<\/option><\/select><\/div><\/div><div class=\"input-tip has-success\"><label class=\"col-md-3 col-xs-3 col-sm-3 control-label\">调查人：<\/label><div class=\"col-md-5 cl-sm-5 col-xs-5\"><input readonly type=\"text\" maxlength=\"5\" name=\"relavants[" + i + "].staffName\" for=\"staffName\"  class=\"form-control valid\" value=\"" + getValue(object, 'staffName') + "\"  ><input type=\"hidden\" name=\"relavants[0].staffId\" value=\"" + getValue(object, 'staffId') + "\" ><\/div><\/div><div class=\"input-tip has-success\"><label class=\"col-md-3 col-xs-3 col-sm-3 control-label\">调查日期：<\/label><div class=\"col-md-5 cl-sm-5 col-xs-5\"><input type=\"text\" name=\"relavants[" + i + "].checkDate\" value=" + (object.checkDate ? object.checkDate : getNowTime()) + " placeholder=\"请输入调查日期\" class=\"form-control date required checkDate valid\" required aria-required=\"true\" aria-invalid=\"false\"><\/div><\/div><\/div>\n" +
            '<div class="form-group form-group-sm"><label class="col-md-3 control-label">补充信息：</label><div class="col-md-21"><textarea  maxlength="2000" class="form-control supplement" rows="3" name="relavants[' + i + '].creditRemark">' + getValueRemark(object, 'creditRemark') + '</textarea></div>' +
            '</div>' +
            // $("#saveTem").html() +
            '</fieldset></div>';
    }
}

//工行征信结果html
function bankHtml(creditModel) {
    if(showCreditModel(creditModel)){
        //温州银行模板
        return $("#ch").html()
    }else{
        return $("#creditResultForm").html();
    }

}

//查询银行征信结果
function selectCreditResult(revalantId,item,guaranteeOrder){
	$.ajax({
		url:"/customer/credit/selectCreditResult.html",
		data:{
			"creditRelavantId":revalantId
		},
		async:false,
		success:function(res){
			var b =$(item)
			if(res.code=="20001"){
				$(item).find(".level").eq(guaranteeOrder).html("查询中")
				$(item).find(".loanRecode").eq(guaranteeOrder).html("查询中")
				$(item).find(".cardRecode").eq(guaranteeOrder).html("查询中")
				$(item).find(".count").eq(guaranteeOrder).html("查询中")
				$(item).find(".money").eq(guaranteeOrder).html("查询中")
				$(item).find(".note").eq(guaranteeOrder).html("查询中")
				//失败也要置灰
				$(".creditResultForm").find("textarea").attr("disabled",true)
			}else{
				data=res.data
				//把银行征信信息放到页面上
				$(item).find(".level").eq(guaranteeOrder).html(data.result)
				$(item).find(".loanRecode").eq(guaranteeOrder).html(data.loancrdt)
				$(item).find(".cardRecode").eq(guaranteeOrder).html(data.cardcrdt)
				$(item).find(".count").eq(guaranteeOrder).html(data.leftnum)
				$(item).find(".money").eq(guaranteeOrder).html(data.leftamount)
				$(item).find(".note").eq(guaranteeOrder).html(data.note)
				$(".creditResultForm").find("textarea").attr("disabled",true)
			}
		}
	});
}

function selectCYRCreditResult(revalantId, item, guaranteeOrder) {
    $.ajax({
        url: "/customer/credit/selectBankInfo.html",
        data: {
            "creditRelavantId": revalantId
        },
        success: function (res) {
            if (res.data) {//已经保存了温州银行征信信息
                //按钮变修改
//                var a = $(item).find(".saves").eq(guaranteeOrder);
//                a.find("span").html("修改");
//                a.prev().addClass("hide");
                //银行信息置灰
                $(item).find(".chForm,.disabled1Class").find("input,select,textarea").attr("disabled", true);
                $(item).find(".chForm,.disabled1Class").find(".checkResult").attr("disabled", false);
                $(item).find(".chForm").eq(guaranteeOrder).values(res.data)
                if (!isNull(res.data.loanInfo)) {
                    var str = res.data.loanInfo;
                    $(item).find(".dkinfo").eq(guaranteeOrder).find("[name='lm']").each(function () {
                        var a = $(this).val();
                        if (str.indexOf(a) > -1) {
                            $(this).attr("checked", "checked")
                        }
                    })
                }
            }
        }
    })
}

//如果拥有相应节点权限，则显示工行征信结果，否则不显示
function viewCredit(creditModel){
	$.ajax({
		url:"/customer/credit/selectRight.html",
		async:false,
		success:function(item){
			if(item.data){
			    if(showCreditModel(creditModel)){
                    $(".chForm").removeClass("hide");
                    $('.chForm:last').addClass("hide");
                }else{
                    $(".creditResultForm").removeClass("hide");
                    $('.creditResultForm:last').addClass("hide");
                }
			}
		}
	});
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

function getBankNoteAnalysis(creditRelavantId, creditId, seletor) {
    $.ajax({
        url: "/customer/credit/bankNoteAnalysis",
        data: {
            "creditRelavantId": creditRelavantId,
            "creditId": creditId
        },
        success: function (res) {
            if (res.code == 10000) {
                var html1 = '', html2 = '', html3 = '', html4 = '', html5 = '';
                var leftContent = '<label class="col-md-3 col-xs-3 col-sm-3 control-label" style="font-weight: normal">';
                var centerContent = '</label><div class="col-md-9 cl-sm-9 col-xs-9 form-group"><input readonly="readonly" type="text"  value="';
                var rightContent = '" class="form-control"></div>';
                var titleContentLeft = '<div class="form-group form-group-sm"><div class="col-md-3 col-xs-3 col-sm-3 control-label" style="font-weight: bold">';
                var titleContentRight = '</div><br><hr/>';
                $.each(res.data, function (i, n) {
                    switch (n.type) {
                        case '贷款汇总(抵押)':
                            html1 += leftContent + n.noteKey + centerContent +( n.noteValue||"") + rightContent;
                            break;
                        case '贷款汇总(信用)':
                            html2 += leftContent + n.noteKey + centerContent + ( n.noteValue||"") + rightContent;
                            break;
                        case '信用卡汇总':
                            html3 += leftContent + n.noteKey + centerContent + ( n.noteValue||"")+ rightContent;
                            break;
                        case '对外担保':
                            html4 += leftContent + n.noteKey + centerContent +( n.noteValue||"")+ rightContent;
                            break;
                        case '备注':
                            html5 += leftContent + n.noteKey + centerContent +( n.noteValue||"") + rightContent;
                            break;
                    }
                })
           
            html =
                titleContentLeft + '贷款汇总(抵押)' + titleContentRight + html1 + '</div>' +
                titleContentLeft + '贷款汇总(信用)' + titleContentRight + html2 + '</div>' +
                titleContentLeft + '信用卡汇总' + titleContentRight + html3 + '</div>' +
                titleContentLeft + '对外担保' + titleContentRight + html4 + '</div>' +
                titleContentLeft + '备注' + titleContentRight + html5 + '</div>';
            seletor.html(html);
            }
        }
    });
}

function getnetWork(a, revalantId, type, businessTypeId, relationship, fahaiId) {
    $.ajax({
        url: "/customer/credit/selectTengInfo",
        data: {
            "creditRelavantId": revalantId,
            "type": type
        },
        success: function (res) {
//        	if(res.data == "" || res.data == null || res.data == undefined){
//        		$("#baiRongDiv_"+relationship+"").removeClass("hide");
//            }
            if (res.code == 10005) {
                tip({content: "接口调用失效"});
                $(a).attr("disabled", false);
                return;
            }
            var netForm=$(a).parents(".partyList:first").find(".netForm");
            if (res.data) {
            	//网络征信显示
            	showNetCredit(res, netForm, relationship, fahaiId);
                //获取同盾报告点击事件(贷款详情页只展示,不获取)
//                netForm.find(".getReport").click(function () {
//                    $.ajax({
//                        url: "/customer/credit/selectTongdun",
//                        data: {
//                            "creditRelavantId": revalantId,
//                        },
//                        success: function (item) {
//                            //同盾报告命中处理
//                            checkboxS(item.data, "s", netForm)
//                        }
//                    })
//                });
            }
        }
    });
}

//网络征信显示
function showNetCredit(res, netForm, relationship, fahaiId){
	if(fahaiId < 0){
		$("#baiRongDiv_"+relationship+"").removeClass("hide");
	}
	netForm.values(res.data);
	//同盾信息展示
    checkboxS(res.data.tongInfo, "s", netForm);
    //腾讯信息展示
    //checkboxS(res.data.tengXunInfo, "t", netForm);
    //公安网信息显示
    showPubNetworkInfo(netForm, res.data.pubNetworkInfo);
    //法院被执行人展示
    convertJson(res.data.courtExecutor, res.data.courtDetail, netForm);
    //特殊名单核查，暂无
    if (isNull(res.data.specialList)) {
    	netForm.find("[name='specialList']").val("暂无");
    }
    //腾讯评分
    //netForm.find("[name='tengXunScore']").html(res.data.tengXunScore)
    //其他异常行为
    if (!isNull(res.data.otherAbnormalite)) {
    	netForm.find("[name='otherAbnormaliteBox']").attr("checked", true);
    } else {
    	netForm.find("[name='otherAbnormalite']").val("暂无");
    }
    //报告还未生成,显示获取同盾报告按钮(贷款详情页只展示,不获取)
//    if (res.data.tongInfo == "204") {
//    	netForm.find(".getReport").removeClass('hide');
//    }
}

//将用逗号分隔的字符串，转化成值赋值给多选框，b用来标示多选框统一的name
function checkboxS(str, b, cur) {
    if (str == "" || str == null || str == undefined) {
    	return;
    }
    var arr = str.split(",");
    $(arr).each(function (index, value) {
        var str = "[name='" + b + value + "']";
        cur.find(str).attr("checked", "checked")
    });
}

//公安网信息前端展示
function showPubNetworkInfo(cur, pubNetworkInfo) {
    if (isNull(pubNetworkInfo)) {
        return;
    }
    var tbodyHtml = "";
    var json = $.parseJSON(pubNetworkInfo);
    for (var i = 0; i < json.length; i++) {
        tbodyHtml += "<tr>" +
            "<td>" + (i + 1) + "</td>" +
            "<td>" + json[i].caseSource + "</td>" +
            "<td>" + json[i].caseType + "</td>" +
            "<td>" + json[i].caseTime + "</td>" +
            "</tr>";
    }
    cur.find("tbody").empty()
    cur.find("tbody").append(tbodyHtml);
}

//将法院被执行人-个人版json转化成一个字符串
function convertJson(json, str, cur) {
    var map = '{"name":"姓名","cid":"身份证号/组织机构代码","cidtype":"证件类型","datatime":"数据时间","datatypeid":"数据类型编码","datatype":"数据类型","leader":"法定代表人/负责人","address":"住所地","court":"执行法院","time":"立案时间","casenum":"执行案号","money":"执行标的","base":"执行依据文号","basecompany":"做出执行依据单位","obligation":"生效法律文书确定的义务","lasttime":"生效法律文书确定的最后履行义务截止时间","performance":"被执行人的履行情况","concretesituation":"失信被执行人行为具体情形","breaktime":"认定失信时间","posttime":"发布时间","performedpart":"已履行","unperformpart":"未履行","basic":"执行依据","basiccourt":"做出执行依据的机构","statute":"案件状态"}';
    if (isNull(json)) {
        return;
    }
    var b = "";
    var a = $.parseJSON(json);
    var c = $.parseJSON(map);
    if (a.flag_execution != "0") {
        for (i in a) {
            var d = i.split("_")[2];//分割获取key
            if (i != "swift_number" && i != "code" && i != "flag_execution") {
                b += c[d] + " : " + a[i] + "\n";
            }
        }
    }
    //法院个人详情拼接
    if (!str) {//法院个人信息无的情况
        if (a.flag_execution == "0") {
            b = "暂无";
        }
    } else {
        b += str;
    }
    cur.find("[name='courtExecutor']").val(b);
}

//法海bootstrap table 通用函数
function bootstrapFaHai(borrowerRelationship,entryList) {
    $('#fahai_'+borrowerRelationship).bootstrapTable({
        data: entryList,
        pagination: true,
        paginationNextText:'下一页',
        paginationPreText:'上一页',
        pageNumber: 1,
        pageSize: 5,
        pageList: [10, 25, 50, 100],
        sidePagination:"client",
        columns: [{
            field: 'sortTimeString',
            title: '立案时间'
        }, {
            field: 'dataType',
            title: '数据类型',
            formatter:function(value,row,index){
                switch (value){
                    case 'cpws':
                        return '裁判文书';
                    case 'zxgg':
                        return '执行公告';
                    case 'shixin':
                        return '失信公告';
                    case 'wdhmd':
                        return '逾期催收名单';
                    case 'bgt':
                        return '曝光台';
                    case 'ktgg':
                        return '开庭公告';
                    case 'fygg':
                        return '法院公告';
                    case 'ajlc':
                        return '案件流程';
                    default:
                        return '--';
                }
            }
        }, {
            field: 'body',
            title: '内容摘要',
            formatter:function(value,row,index){
                return '<a href="#" class="jump">'+ value +'</a>';
            },
            events:{
                'click .jump': function (e, value, row, index) {
                    var myTitle = '';
                    switch (row.dataType){
                        case 'cpws':
                            myTitle = '裁判文书';
                            break;
                        case 'zxgg':
                            myTitle = '执行公告';
                            break;
                        case 'shixin':
                            myTitle = '失信公告';
                            break;
                        case 'wdhmd':
                            myTitle = '逾期催收名单';
                            break;
                        case 'bgt':
                            myTitle = '曝光台';
                            break;
                        case 'ktgg':
                            myTitle = '开庭公告';
                            break;
                        case 'fygg':
                            myTitle = '法院公告';
                            break;
                        case 'ajlc':
                            myTitle = '案件流程';
                            break;
                        default:
                            myTitle = '--';
                    }

                    return comn.addTab({
                        title: myTitle,
                        href: "./Modal/common/commonCreditInfo/fhtemplate.html?entryId="+row.entryId+'&dataType='+row.dataType+'&partyId='+row.partyId
                    })
                }
            }
        }, {
            field: 'matchRatio',
            title: '匹配度',
            formatter:function(value,row,index){
                return value*100+'%';
            }
        }]
    });
}