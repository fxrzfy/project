var documnetFlag, oData = {}, _current = 0, guarantyRelationship = 1, delteLoanGuarantor = null;
//反担保信息-抵/质押信息
//getApprovalAsserts();

//反担保信息-保证人信息 table
//getGuarantor();

/*table_guarantor = function (params) {
    var p=params.data;
    return comn.ajax({
        url: interUrl.myTask.approvalGuarantor,
        data: $.extend(loanApplyId,p),
        success: function (res) {
            params.success({
                'total': res.totalItem,
                rows: res.data
            });
            return params.complete();
        }
    });
}; 
$("#table_guarantor").bootstrapTable(comn.table);*/

$("body").on("change", "input[name='cardNo'], select[name='cardType']",function(){
	var $form = $(this).parents("form");
	var o = $form.values();
	if(o.cardType == 1 && o.cardNo.length == 18){
		var resut = getInfo($("input[name='cardNo']").val()); 
		$form.find("[name='birthday']").val(resut.birth);
		$form.find("[name='age']").val(resut.age);
		$form.find("[name='sex']").val(resut.sex);
	} 
});

var documnetFlagXZ= [
	'LOAN_OFFICE_STAFF_BUDGET',
	'LOAN_MODIFY_OFFICE_STAFF_BUDGET',
	'DOCUMENT_VERIFY',
	'COPY_CONTRACT'
].indexOf(args['currentNodeKey']) != -1;

tableEvent_rGuarantor = {
    "click .xz": function (e, a, item, index) {
		if(_current == 4){
			tip({content: "已添加至最大担保人！！"});
			$("#guarantorModal").modal("hide"); 
			return;
		}
		comn.ajax({
			url: interUrl.gr.lauchLoanGuarantorInfo,
			data: {
				loanApplyId: args['loanApplyId'],
				guarantyRelationship: guarantyRelationship,
				creditApplyId: item.id 
			},
			success: function(res){
				_current++;
				var item = res.data;
				addGuarrantor($.extend(res.data, {guarantyRelationship: guarantyRelationship}), _current); 
				$("#getLoanGuarantorInfo").prepend(addGuarrantor(res.data, _current));
				var _form = $("#getLoanGuarantorInfo").children().eq(0);
				_form.values($.extend(res.data, {loanApplyId: args['loanApplyId']}));		
				//循环绑定省市区下拉选择事件 
				_form.find("select[name='companyAddressPid']", $("#guarantee")[0]).getProvince(item['companyAddressPid']);
				_form.find("select[name='homeAddressPid']", $("#guarantee")[0]).getProvince(item['homeAddressPid']);

				_form.find("select[name='companyAddressCid']", $("#guarantee")[0]).getCity(item['companyAddressPid'], item['companyAddressCid']);
				_form.find("select[name='homeAddressCid']", $("#guarantee")[0]).getCity(item['homeAddressPid'], item['homeAddressCid']);

				_form.find("select[name='companyAddressRid']", $("#guarantee")[0]).getArea(item['companyAddressCid'], item['companyAddressRid']);
				_form.find("select[name='homeAddressRid']", $("#guarantee")[0]).getArea(item['homeAddressCid'], item['homeAddressRid']);
				//|| args['documentFlowType'] == "2" || args['documentFlowType'] == "3" 文档流程可修改
				if(documnetFlag || args['releventFlowNode'] == "LOAN_LAUNCH"){
					$("#getLoanGuarantorInfo").find("fieldset").attr("disabled",false);
				}

				$("#guarantorModal").modal("hide"); 
				$("#getLoanGuarantorInfo").find(".guarranRecord").attr("readonly", true);
				
				if(documnetFlagXZ){
					if(item.cardType != "" && item.cardType != undefined && item.cardType != null){
	            		if(item.cardType == "1"){
	            			$("#birthday_"+_current+"").attr("readonly","readonly");
	            			$("#birthday_"+_current+"").removeClass("date");
	            		}
	            	}
	            	$("#age_"+_current+"").attr("readonly","readonly");
	            	$("#birthday_"+_current+"").change(function(){
	            		var dataId = $(this).attr("data-id");
	            		$("#age_"+dataId+"").val(getAgeBybirth($("#birthday_"+dataId+"").val()));
	            	});
				}
				
			} 
		})

    }
};

//根据身份证取 省份,生日，性别
function getInfo(ic) {
	//获取输入身份证号码
	var ic = String(ic);
	//获取出生日期
	var birth = ic.substring(6, 10) + "-" + ic.substring(10, 12) + "-" + ic.substring(12, 14);
	//获取性别
	var gender = ic.slice(14, 17) % 2 ? "1" : "0"; // 1代表男性，0代表女性
	//获取年龄
	var myDate = new Date();
	var month = myDate.getMonth() + 1;
	var day = myDate.getDate();
	var age = myDate.getFullYear() - ic.substring(6, 10) - 1;
	if (ic.substring(10, 12) < month || ic.substring(10, 12) == month && ic.substring(12, 14) <= day) {
		age++;
	}
	return {
		"birth": birth,
		"sex": gender,
		"age": age 
	}
}

handle_rGuarantor = function (value, row, index) {
    return ["<a href='javascript:;' class='xz'>选择</a>"].join("");
};

function addGuarrantor(item, i) {
	var tpl = "";
	var o = {
		title: ["", "担保人-" + item.guarantorName, "反担保人-" + (item.guarantorName || "")][item.guarantyRelationship] || "",
		index: i
	};

	tpl = $("#tpl").html().replace(/{([\w \d]+)}/g, function(k0, k1){ return o[k1]; });
	return tpl;
}


if(location.href.indexOf("loanDetail.html") > 0){
	oData['projectId'] = args["projectId"]; 
	oData['callType'] = 1;
}else{
	oData['loanApplyId'] = args['loanApplyId']; 
	table_rGuarantor = function (params) {
		tableData(params, 
			$.extend($("#searchGuarantor").values(), {
				loanApplyId: args['loanApplyId'], 
				guarantyRelationship: guarantyRelationship
			})
		,interUrl.myTask.relateLoanGuarantor)
	};
}
$(function () {
	//发起文档、 资料审核、抄写可编辑
	documnetFlag= [
		'LOAN_OFFICE_STAFF_BUDGET',
		'LOAN_MODIFY_OFFICE_STAFF_BUDGET',
		'DOCUMENT_VERIFY',
		'COPY_CONTRACT'
	].indexOf(args['currentNodeKey']) != -1;
	
	documnetFlagPos= [
		'TRANSMIT_LAUNCH',
		//'DOCUMENT_VERIFY',
		'COPY_CONTRACT',
		'DOCUMENT_REVIEW',
		'DOCUMENT_CLASSIFY'
	].indexOf(args['currentNodeKey']) != -1;

	//判断流程节点
	  if( args['releventFlowNode'] == "LOAN_LAUNCH"){
	    $("#btnGuarantor").removeClass("hide");
	    if(args['releventFlow'] == "LOAN_MODIFY_FLOW" && args['typeFlag'] == "modifySubmitted"){
	      $("#btnGuarantor").addClass("hide");
	    }
	  }
	  

	var nodeKey = args['currentNodeKey'];
	
	//搜索担保人信息
	$("#btn-guarantor-search2").click(function(){
		$("#table_rGuarantor").bootstrapTable("refresh", {url: '...'})
	});
	$("#table_rGuarantor").bootstrapTable(tableConfig);
	var getLoanGua, gData;
	if(args['businessTypeCode'] == "DOCUMENT_TRANSMIT_FLOW"){
		 getLoanGua=interUrl.gr.dGetLoanGuarantorInfo;
		 gData = {projectId: args['projectId']}
	}else{
		getLoanGua = interUrl.gr.getLoanGuarantorInfo; 
		gData = oData;
	}

	$("body").on("change", "select[name='companyAddressPid'], select[name='homeAddressPid']", function(){
		var name = $(this).find("option:selected").text();
		$(this).prev("input", $(this).parents(".input-tip")[0]).val(name);
		$(this).parents(".form-group").find("select[name='companyAddressCid'], select[name='homeAddressCid']").getCity(this.value);
	}).on("change", "select[name='companyAddressCid'], select[name='homeAddressCid']", function(){
		var name = $(this).find("option:selected").text();
		$(this).prev("input", $(this).parents(".input-tip")[0]).val(name);
		$(this).parents(".form-group").find("select[name='companyAddressRid'], select[name='homeAddressRid']").getArea(this.value); 
	}).on("change", "select[name='companyAddressRid'], select[name='homeAddressRid']", function(){
		var name = $(this).find("option:selected").text();
		$(this).prev("input", $(this).parents(".input-tip")[0]).val(name); 
	})

	comn.ajax({
		url: getLoanGua,
		data: gData,
		success: function(res){
			var data = res.data;
			if(data.length == 0){
				var html = [
					"<div class='row'>",
					"<div class='col-xs-24 col-sm-24 col-md-24 col-lg-24 text-center'>",
					"<h2>没有关联反担保人信息</h2>",
					"</div>",
					"</div>"
				].join("");
				return $("#getLoanGuarantorInfo").append(html);
			}
			for (var i = 0, len = data.length; i < len; i++) {
				_current++;
				var item = data[i];
				window['_mobilePhone_guarantee_'+i]=item.mobilePhone;
				$("#getLoanGuarantorInfo").append(addGuarrantor(item, i));
				$("#getLoanGuarantorInfo").find("input[name='mobilePhone']").attr("data-check","_mobilePhone_guarantee_"+i+";手机号有变动");
				$("#getLoanGuarantorInfo").find(".guarranRecord").attr("readonly", true);
				if(item.speaName!=null&&item.speaName!=""&&item.speaName!=undefined && args['currentNodeKey'] == "LOAN_MODIFY_LAUNCH"){
					$("#getLoanGuarantorInfo ").find("fieldset").eq(i).attr("disabled",false);
				}
			}
			//循环绑定省市区下拉选择事件
			$("select[name='companyAddressPid'], select[name='homeAddressPid']", $("#guarantee")[0]).getProvinceC({
				callback: function(){
					for (var j = 0, len = data.length; j < len; j++) {
						var item = data[j], _form = $("#getLoanGuarantorInfo").children().eq(j);
						//单位地址
						_form.find("select[name='companyAddressCid']").getCityC(item.companyAddressPid, {
							code: item.companyAddressCid,
							value: item.companyAddressCname
						}, _form.find("select[name='companyAddressCid']").is(":disabled"))

						_form.find("select[name='companyAddressRid']").getAreaC(item.companyAddressCid, {
							code: item.companyAddressRid,
							value: item.companyAddressRname
						}, _form.find("select[name='companyAddressRid']").is(":disabled"))

						//家庭地址
						_form.find("select[name='homeAddressCid']").getCityC(item.homeAddressPid, {
							code: item.homeAddressCid,
							value: item.homeAddressCname
						}, _form.find("select[name='homeAddressCid']").is(":disabled")) 

						_form.find("select[name='homeAddressRid']").getAreaC(item.homeAddressCid, {
							code: item.homeAddressRid,
							value: item.homeAddressRname
						}, _form.find("select[name='homeAddressRid']").is(":disabled"))
						_form.values($.extend(item, {loanApplyId: args['loanApplyId']})); 
						
						if(documnetFlag){
							if(item.cardType != "" && item.cardType != undefined && item.cardType != null){
			            		if(item.cardType == "1"){
			            			$("#birthday_"+j+"").attr("readonly","readonly");
			            			$("#birthday_"+j+"").removeClass("date");
			            		}
			            	}
			            	$("#age_"+j+"").attr("readonly","readonly");
			            	$("#birthday_"+j+"").change(function(){
			            		var dataId = $(this).attr("data-id");
			            		$("#age_"+dataId+"").val(getAgeBybirth($("#birthday_"+dataId+"").val()));
			            	});
						}
					}
				}
			}, false);
			
			if(documnetFlag){
				$(".guarantor").attr("disabled",false);
				if(args['releventFlowNode'] == "COPY_CONTRACT"){
					$(".addressGuarantor").attr("disabled",true);
					$(".guarantor").attr("disabled",true);
				}
			}else{
				$(".guarantor").attr("disabled",true);
                $('.getGuarantorAddressShow').css('display','block');
				$('.getGuarantorAddressGet').remove();
			}
			
			if(documnetFlagPos){
				$('.getGuarantorAddressShow').css('display','block');
				$('.getGuarantorAddressGet').remove();
			}
			
			//判断流程节点
			if(documnetFlag || args['releventFlowNode'] == "LOAN_LAUNCH"){
				$("#getLoanGuarantorInfo").find("fieldset").attr("disabled",false);
			}
			//文档传递流程所有节点(禁止反担保信息删除)
			if(args['releventFlow'] == "DOCUMENT_TRANSMIT_FLOW"){
				$(".btnDelete").attr('disabled', true);
			}
			
			if(args['releventFlow'] == "LOAN_MODIFY_FLOW" && args['typeFlag'] == "modifySubmitted"){
				$("#getLoanGuarantorInfo").find("fieldset").attr("disabled",true);
				$(".guarantor").attr("disabled",true);
				$('.getGuarantorAddressShow').css('display','block');
				$('.getGuarantorAddressGet').remove();
			}
			
			//在业务录入环节，隐藏删除按钮
			if (nodeKey == "LOAN_OFFICE_STAFF_BUDGET" || nodeKey == "LOAN_MODIFY_OFFICE_STAFF_BUDGET" || nodeKey == "LOAN_CANCEL_OFFICE_STAFF_BUDGET" ) {
				$(".btnDelete").addClass("hide");
			}
			
			if(args['releventFlowNode'] == "LOAN_OFFICE_STAFF_BUDGET" || args['releventFlowNode'] == "LOAN_CANCEL_OFFICE_STAFF_BUDGET"){
				$(".mobile").attr("readOnly", true);
			}
			if(args['releventFlowNode'] == "LOAN_MODIFY_OFFICE_STAFF_BUDGET"){
				$(".mobile").attr("readOnly", false);
			}
			
		}
	});

	//关联担保人
	$("#relationGuarantor").click(function(){
		guarantyRelationship = 1;
		$("#table_rGuarantor").bootstrapTable("refresh", {url: '...'})
		$("#guarantorModal").modal("show"); 
	});

	//添加反担保人
	$("#addGuarantor").click(function(){
		guarantyRelationship = 2;
		$("#table_rGuarantor").bootstrapTable("refresh", {url: '...'})
		$("#guarantorModal").modal("show"); 
	});

	//公安网查询不到此人，是否继续录入？   确定时再调保存,取消时调删除
	//再次调用保存反担保人接口时把needInquiry设成false
	function saveLoanGuarantorInfo(_form){
		$("#gaQuery").modal("hide");
		if(_form.valid()){
			comn.ajax({
				url: interUrl.myTask.saveLoanGuarantorInfo,
				data: $.extend(_form.values(),{
					guarantyRelationship: guarantyRelationship,
					loanApplyId: args['loanApplyId'],
					projectId: args['projectId'] || "",
					needInquiry:false
				}),
				success: function(res){
					_form.values(res.data);
					tip({content: "保存成功！！"});
				}
			});
		}
	}

	//删除反担保人,并给出信息添加失败
	function deleteLoanGuarantorInfo(_form){
		$("#gaQuery").modal("hide");
		//删除
		var values = _form.values();
		comn.ajax({
			url: interUrl.myTask.deleteLoanGuarantorInfo,
			data: values,
			success: function(res){
				_current--;
				_form.remove();
				tip({content: "反担保人添加失败！"});
			}
		});
	}

	//保存
	$("#getLoanGuarantorInfo").on("click", ".btnSave", function(){
		var $form = $(this).parents("form");
		var url; // 文档传递流程 资料审核(担保人 读取和保存调用小哥接口) 
		if(['DOCUMENT_VERIFY', 'COPY_CONTRACT'].indexOf(args['currentNodeKey']) != -1){
			if(['COPY_CONTRACT'].indexOf(args['currentNodeKey']) != -1){
				$(".addressGuarantor").removeAttr("disabled");
				$(".guarantor").removeAttr("disabled");
			}
			url = interUrl.myTask.dSaveLoanGuarantorInfo; 
		}else{ 
			url = interUrl.myTask.saveLoanGuarantorInfo
		}
		if($form.valid()){
			comn.ajax({
				url: url,
				data: $.extend({
					guarantyRelationship: guarantyRelationship,
					loanApplyId: args['loanApplyId'],
					projectId: args['projectId'] || "",
					needInquiry:true
				}, $form.values()),
				success: function(res){
					if(args['businessTypeCode'] == "DOCUMENT_TRANSMIT_FLOW"){
						tip({content: "保存成功！！"}); 
					}
					if(res.data.inquiryResult){
						$form.values(res.data);
						tip({content: "保存成功！！"});
					}else if(!res.data.inquiryResult){
						if(args['businessTypeCode'] != "DOCUMENT_TRANSMIT_FLOW"){
							$("#gaQuery").modal("show");
							$("#gaQuerySure").unbind("click").click(function(){
								saveLoanGuarantorInfo($form);
							})
							$("#gaQueryCancel").unbind("click").click(function(){
								deleteLoanGuarantorInfo($form);
							}) 
						}
					}
				}
			});
		}
		if(['COPY_CONTRACT'].indexOf(args['currentNodeKey']) != -1){
			$(".addressGuarantor").attr("disabled",true);
			$(".guarantor").attr("disabled",true);
		}
	}).on("click", ".btnDelete", function(){
		//删除
		var $form = $(this).parents("form"), values = $form.values();
		if(values['id']){
			$("#deleteLoanGuarantor").modal("show");
			delteLoanGuarantor = function(){
				comn.ajax({
					url: interUrl.myTask.deleteLoanGuarantorInfo,
					data: values,
					success: function(res){
						_current--;
						$form.remove();
						$("#deleteLoanGuarantor").modal("hide");
						tip({content: "删除成功！！"}); 
					} 
				});
			};
		}else{
			$form.remove();
		}

	}).on("change", ".housingStatus", function(){
		var $el = $(this);
		var a = "<span class='text-danger'>*</span>";
		var c = $el.parents("form").find(".mortgageRepayment").eq(0);

		if($el.val()==1 || $el.val()==""){
			c.hide();
		}else if($el.val()==2){
			c.show().find("label").html(a+"月还款:");
		}else if($el.val()==3){
			c.show().find("label").html(a+"月租:");
		}else if($el.val()==4){
			c.show().find("label").html(a+"说明:");
		} 
	});

	$("#deleteBtnSure").click(function(){
		if(typeof delteLoanGuarantor == "function"){
			delteLoanGuarantor(); 
		} 
	});

});

//单位家庭地址
var province = '', city = '', area = '';
function getGuarantorCompanyPos(obj){
	var index = $(obj).attr("data-id");
    province = $("#provinceCode_name_"+index+"").val();
    city = $("#cityCode_name_"+index+"").val();
    area = $("#areaCode_name_"+index+"").val();
    setTimeout(function(){
        $("#mapSelfModalGuarantor").modal("show");
        map = new BMap.Map("mapCommonGuarantor");
        menu = new BMap.ContextMenu();
        map.addContextMenu(menu);
        map.centerAndZoom("杭州", 16);
        if(city == "县"){
        	setPlaceInMapGuarantor(province + area + $("#guarantorCompanyAddressDetail_"+index+"").val(),'获取当前位置','#guarantorCompanyPosition_'+index+'','#guarantorCompanyLongitude_'+index+'','#guarantorCompanyLatitude_'+index+'');
        }else{
        	setPlaceInMapGuarantor(province + city + area + $("#guarantorCompanyAddressDetail_"+index+"").val(),'获取当前位置','#guarantorCompanyPosition_'+index+'','#guarantorCompanyLongitude_'+index+'','#guarantorCompanyLatitude_'+index+'');
        }
    },500);
}

function getGuarantorHomePos(obj){
	var index = $(obj).attr("data-id");
    province = $("#provinceCode_name_1_"+index+"").val();
    city = $("#cityCode_name_1_"+index+"").val();
    area = $("#areaCode_name_1_"+index+"").val();
    setTimeout(function(){
        $("#mapSelfModalGuarantor").modal("show");
        map = new BMap.Map("mapCommonGuarantor");
        menu = new BMap.ContextMenu();
        map.addContextMenu(menu);
        map.centerAndZoom("杭州", 16);
        if(city == "县"){
        	setPlaceInMapGuarantor(province + area + $("#guarantorHomeAddressDetail_"+index+"").val(),'获取当前位置','#guarantorHomePosition_'+index+'','#guarantorHomeLongitude_'+index+'','#guarantorHomeLatitude_'+index+'');
        }else{
        	setPlaceInMapGuarantor(province + city + area + $("#guarantorHomeAddressDetail_"+index+"").val(),'获取当前位置','#guarantorHomePosition_'+index+'','#guarantorHomeLongitude_'+index+'','#guarantorHomeLatitude_'+index+'');
        }
    },500);
}

function getGuarantorCompanyPosShow(obj){
    var index = $(obj).attr("data-id");
    province = $("#provinceCode_name_"+index+"").val();
    city = $("#cityCode_name_"+index+"").val();
    area = $("#areaCode_name_"+index+"").val();
    $("#mapModalGuarantorRow").css('display','none');
    $("#mapModalGuarantor").modal("show");
//    setTimeout(function(){
//        map = new BMap.Map("mapGuarantor");
//        map.clearOverlays();
//        var address;
//        if(city == "县"){
//        	address = province + area + $("#guarantorCompanyAddressDetail_"+index+"").val()
//        }else{
//        	address = province + city + area + $("#guarantorCompanyAddressDetail_"+index+"").val()
//        }
//        getPosFromAddress(address)
//    },500);
    
    var _this = this;
    setTimeout(function(){
		map = new BMap.Map("mapGuarantor");
		map.clearOverlays();
		try {
			var guarantorCompanyPosition = $("#guarantorCompanyPosition_"+index+"").val();
            var p = guarantorCompanyPosition.split(",");
            var curIcon = new BMap.Icon("./../../../images/red_icon.png", new BMap.Size(30,30));
            var point = new BMap.Point(p[0], p[1]);
            map.centerAndZoom(point, 15);
            map.enableScrollWheelZoom();
            map.enableContinuousZoom();
            var circle = new BMap.Circle(point,1000,{fillColor:"#0b70d6", strokeWeight: 1 ,fillOpacity: 0.25, strokeOpacity: 0.25});
            map.addOverlay(circle);
            var marker = new BMap.Marker(point, {icon: curIcon});        // 创建标注
            map.addOverlay(marker);
            var callback = $(_this).data("callback")
            if(typeof(callback) == "function"){ callback(BMap, map); }
		}catch (e){
            //var address = $("input[name='companyAddressPname']").val()+ $("input[name='companyAddressCname']").val()+ $("input[name='companyAddressRname']").val()+ $("input[name='companyAddressDetail']").val();
            var address;
            if(city == "县"){
            	address = province + area + $("#guarantorCompanyAddressDetail_"+index+"").val();
            }else{
            	address = province + city + area + $("#guarantorCompanyAddressDetail_"+index+"").val();
            }
            alert("address: "+address);
            getPosFromAddressGuarantor(address)
		}
    },500);
    
}

function getGuarantorHomePosShow(obj){
    var index = $(obj).attr("data-id");
    province = $("#provinceCode_name_1_"+index+"").val();
    city = $("#cityCode_name_1_"+index+"").val();
    area = $("#areaCode_name_1_"+index+"").val();
    $("#mapModalGuarantorRow").css('display','none');
    $("#mapModalGuarantor").modal("show");
//    setTimeout(function(){
//        map = new BMap.Map("mapGuarantor");
//        map.clearOverlays();
//        var address;
//        if(city == "县"){
//        	address = province + area + $("#guarantorHomeAddressDetail_"+index+"").val()
//        }else{
//        	address = province + city + area + $("#guarantorHomeAddressDetail_"+index+"").val()
//        }
//        getPosFromAddress(address)
//    },500);
    
    var _this = this;
    setTimeout(function(){
		map = new BMap.Map("mapGuarantor");
		map.clearOverlays();
		try {
			var guarantorHomePosition = $("#guarantorHomePosition_"+index+"").val();
            var p = guarantorHomePosition.split(",");
            var curIcon = new BMap.Icon("./../../../images/red_icon.png", new BMap.Size(30,30));
            var point = new BMap.Point(p[0], p[1]);
            map.centerAndZoom(point, 15);
            map.enableScrollWheelZoom();
            map.enableContinuousZoom();
            var circle = new BMap.Circle(point,1000,{fillColor:"#0b70d6", strokeWeight: 1 ,fillOpacity: 0.25, strokeOpacity: 0.25});
            map.addOverlay(circle);
            var marker = new BMap.Marker(point, {icon: curIcon});        // 创建标注
            map.addOverlay(marker);
            var callback = $(_this).data("callback")
            if(typeof(callback) == "function"){ callback(BMap, map); }
		}catch (e){
            //var address = $("input[name='homeAddressPname']").val()+ $("input[name='homeAddressCname']").val()+ $("input[name='homeAddressRname']").val()+ $("input[name='homeAddressDetail']").val();
            var address;
            if(city == "县"){
            	address = province + area + $("#guarantorHomeAddressDetail_"+index+"").val();
            }else{
            	address = province + city + area + $("#guarantorHomeAddressDetail_"+index+"").val();
            }
            getPosFromAddressGuarantor(address)
		}
    },500);
    
}

//设置地图地点坐标
setPlaceInMapGuarantor = function (address,title,myPosition,myLongitude,myLatitude) {
    var local, sc;
    map.clearOverlays();
    menu.removeItem(menu.getItem(0));
    sc = function () {
        try {
            var p;
            p = local.getResults().getPoi(0).point;

            map.centerAndZoom(p, 18);
            return map.addOverlay(new BMap.Marker(p));

        } catch (e) {
            tip({content: '没有搜索到当前地理位置！'});
            /* handle error */
        }
    };

    menu.addItem(new BMap.MenuItem(title, function (e) {
        map.clearOverlays();
        map.addOverlay(new BMap.Marker(e));
        $(myPosition).val(e.lng + "," + e.lat);
        $(myLongitude).val(e.lng);   //经度
        $(myLatitude).val(e.lat);    //纬度
        return
    }));

    local = new BMap.LocalSearch(map, {
        onSearchComplete: sc
    });
    return local.search(address);
};

//根据地址获得经纬度
function getPosFromAddressGuarantor(address) {
    var local, sc,_this;
    sc = function () {
        try {
            var p;
            p = local.getResults().getPoi(0).point;
            var curIcon = new BMap.Icon("./../../../images/red_icon.png", new BMap.Size(30,30));
            var point = new BMap.Point(p.lng, p.lat);
            map.centerAndZoom(point, 15);
            map.enableScrollWheelZoom();
            map.enableContinuousZoom();
            var circle = new BMap.Circle(point,1000,{fillColor:"#0b70d6", strokeWeight: 1 ,fillOpacity: 0.25, strokeOpacity: 0.25});
            map.addOverlay(circle);
            var marker = new BMap.Marker(point, {icon: curIcon});        // 创建标注
            map.addOverlay(marker);
            var callback = $(_this).data("callback")
            if(typeof(callback) == "function"){ callback(BMap, map); }
        } catch (e) {
            tip({content: '没有获取到当前地理位置！'});
        }
    };
    local = new BMap.LocalSearch(map, {
        onSearchComplete: sc
    });
    return local.search(address);
};

function changeCompanyAddressRid(obj){
	var index = $(obj).attr("data-id");
	$("#areaCode_"+index+"").change(function(){
		$("#guarantorCompanyPosition_"+index+"").val('');
	});
}

function changeHomeAddressRid(obj){
	var index = $(obj).attr("data-id");
	$("#areaCode_1_"+index+"").change(function(){
		$("#guarantorHomePosition_"+index+"").val('');
	});
}

//根据生日计算年龄
function getAgeBybirth(birthParam) { 
	if(birthParam == "" || birthParam == undefined || birthParam == null){
		return "";
	}else{
		var myDate = new Date();
		var month = myDate.getMonth() + 1;
		var day = myDate.getDate();
		var age = myDate.getFullYear() - birthParam.substring(0, 4) - 1;
		if (birthParam.substring(5, 7) < month || birthParam.substring(5, 7) == month && birthParam.substring(8, 10) <= day) {
			age++;
		}
		return age+""; 
	}
}