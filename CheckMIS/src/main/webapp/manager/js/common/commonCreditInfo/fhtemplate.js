var args = comn.getArgs();
//判断非空
function isNull(a) {
    if (a === "" || a == null || a === undefined) {
        return true;
    } else {
        return false;
    }
}
comn.ajax({
    url: 'customer/credit/getFaHaiItem',
    data: {
        dataType: args['dataType'],
        entryId:args['entryId'],
        partyId:args['partyId']
    },
    async: false,
    success: function (res) {
        var myTitle = '';
        var myHtml = '';
        if(res.data){
        	$.each(res.data,function (key,val) {
                if(isNull(val)){
                    res.data[key] = '--';
                }
            });

            var showArr = [];
            switch (res.data.dataType){
                case 'cpws':
                    myTitle = '裁判文书';
                    if(res.data.partList != null && res.data.partList != "" && res.data.partList != undefined){
                    	myHtml =
                        	'<strong>审结时间</strong>:'+ res.data.sortTime +'</br></br>'+
                            '<strong>内容</strong>:'+ res.data.body +'</br></br>'+
                            '<strong>生日</strong>:'+ res.data.partList[0].birthday +'</br></br>'+
                            '<strong>案件类型</strong>:'+ res.data.caseType +'</br></br>'+
                            '<strong>法院名称</strong>:'+ res.data.court +'</br></br>'+
                            '<strong>身份证号</strong>:'+ res.data.idcardNo +'</br></br>'+
                            '<strong>标题</strong>:'+ res.data.partList[0].title +'</br></br>'+
                            '<strong>案由</strong>:'+ res.data.partList[0].caseCause +'</br></br>'+
                            '<strong>当事人称号</strong>:'+ res.data.partList[0].partyTitle +'</br></br>'+
                            '<strong>胜负状态</strong>:'+ res.data.partList[0].partyResult +'</br></br>'+
                            '<strong>判决结果</strong>:'+ res.data.partList[0].judgeResult +'</br></br>'+
                            '<strong>审理程序</strong>:'+ res.data.partList[0].trialProcedure +'</br></br>'+
                            '<strong>律师事务所</strong>:'+ res.data.partList[0].lawOffice +'</br></br>'+
                            '<strong>当事人案件受理费</strong>:'+ res.data.partList[0].partyCaf +'</br></br>'+
                            '<strong>案由编码</strong>:'+ res.data.partList[0].anyou +'</br></br>'+
                            '<strong>判决金额</strong>:'+ res.data.partList[0].fee +'</br></br>'+
                            '<strong>地址</strong>:'+ res.data.partList[0].address +'</br></br>'+
                            '<strong>姓名</strong>:'+ res.data.partList[0].pname +'</br></br>';
                    }
                    break;
                case 'zxgg':
                    myTitle = '执行公告';
                    myHtml = 
    	                '<strong>立案时间</strong>:'+ res.data.sortTime +'</br></br>'+
    	                '<strong>内容</strong>:'+ res.data.body +'</br></br>'+
    	                '<strong>标题</strong>:'+ res.data.title +'</br></br>'+
    	                '<strong>被执行人姓名</strong>:'+ res.data.pname +'</br></br>'+
    	                '<strong>执行法院名称</strong>:'+ res.data.court +'</br></br>'+
    	                '<strong>申请人</strong>:'+ res.data.proposer +'</br></br>'+
    	                '<strong>案号</strong>:'+ res.data.caseNo +'</br></br>'+
    	                '<strong>案件状态</strong>:'+ res.data.caseState +'</br></br>'+
    	                '<strong>身份证/组织机构代码</strong>:'+ res.data.idcardNo +'</br></br>'+
    	                '<strong>执行标的</strong>:'+ res.data.execMoney +'</br></br>'+
    	                '<strong>执行公告ID</strong>:'+ res.data.zxggId +'</br></br>';
                    break;
                case 'shixin':
                    myTitle = '失信公告';
                    myHtml = 
    	                '<strong>立案时间</strong>:'+ res.data.sortTime +'</br></br>'+
    	                '<strong>性别</strong>:'+ res.data.sex +'</br></br>'+
    	                '<strong>被执行人的履行情况</strong>:'+ res.data.lxqk +'</br></br>'+
    	                '<strong>执行依据文号</strong>:'+ res.data.yjCode +'</br></br>'+
    	                '<strong>执行法院名称</strong>:'+ res.data.court +'</br></br>'+
    	                '<strong>身份证/组织机构代码</strong>:'+ res.data.idcardNo +'</br></br>'+
    	                '<strong>做出执行依据单位</strong>:'+ res.data.yjdw +'</br></br>'+
    	                '<strong>失信被执行人行为具体情形</strong>:'+ res.data.jtqx +'</br></br>'+
    	                '<strong>生效法律文书确定的义务</strong>:'+ res.data.yiwu +'</br></br>'+
    	                '<strong>年龄</strong>:'+ res.data.age +'</br></br>'+
    	                '<strong>被执行人姓名</strong>:'+ res.data.pname +'</br></br>'+
    	                '<strong>省份</strong>:'+ res.data.province +'</br></br>'+
    	                '<strong>案号</strong>:'+ res.data.caseNo +'</br></br>'+
    	                '<strong>失信公告ID</strong>:'+ res.data.shixinId +'</br></br>'+
    	                '<strong>发布时间</strong>:'+ res.data.postTime +'</br></br>';
                    break;
                case 'wdhmd':
                    myTitle = '逾期催收名单';
                    myHtml = 
                    '<strong>贷款时间</strong>:'+ res.data.sortTime +'</br></br>'+
                    '<strong>内容</strong>:'+ res.data.body +'</br></br>'+
                    '<strong>性别</strong>:'+ res.data.sex +'</br></br>'+
                    '<strong>居住电话</strong>:'+ res.data.phone +'</br></br>'+
                    '<strong>信息更新时间</strong>:'+ res.data.updateTime +'</br></br>'+
                    '<strong>执行法院</strong>:'+ res.data.execCourt +'</br></br>'+
                    '<strong>相关当事人</strong>:'+ res.data.relatedParty +'</br></br>'+
                    '<strong>未还/罚息</strong>:'+ res.data.whfx +'</br></br>'+
                    '<strong>身份证号</strong>:'+ res.data.idcardNo +'</br></br>'+
                    '<strong>籍贯地址</strong>:'+ res.data.birthPlace +'</br></br>'+
                    '<strong>本金/本息</strong>:'+ res.data.bjbx +'</br></br>'+
                    '<strong>案号</strong>:'+ res.data.caseCode +'</br></br>'+
                    '<strong>居住地址</strong>:'+ res.data.address +'</br></br>'+
                    '<strong>邮箱地址</strong>:'+ res.data.email +'</br></br>'+
                    '<strong>来源单位名称</strong>:'+ res.data.sourceName +'</br></br>'+
                    '<strong>年龄</strong>:'+ res.data.age +'</br></br>'+
                    '<strong>姓名</strong>:'+ res.data.pname +'</br></br>'+
                    '<strong>逾期催收名单ID</strong>:'+ res.data.wdhmdId +'</br></br>'+
                    '<strong>数据源</strong>:'+ res.data.datasource +'</br></br>'+
                    '<strong>已还金额</strong>:'+ res.data.yhje +'</br></br>'+
                    '<strong>手机号</strong>:'+ res.data.mobile +'</br></br>';
                    break;
                case 'bgt':
                    myTitle = '曝光台';
                    myHtml = 
                        '<strong>立案时间</strong>:'+ res.data.sortTime +'</br></br>'+
                        '<strong>内容</strong>:'+ res.data.body +'</br></br>'+
                        '<strong>曝光日期</strong>:'+ res.data.bgDate +'</br></br>'+
                        '<strong>当事人类型</strong>:'+ res.data.partyType +'</br></br>'+
                        '<strong>法院名称</strong>:'+ res.data.court +'</br></br>'+
                        '<strong>申请人</strong>:'+ res.data.proposer +'</br></br>'+
                        '<strong>身份证/组织机构代码</strong>:'+ res.data.idcardNo +'</br></br>'+
                        '<strong>曝光台ID</strong>:'+ res.data.bgtId +'</br></br>'+
                        '<strong>案由</strong>:'+ res.data.caseCause +'</br></br>'+
                        '<strong>未履行金额</strong>:'+ res.data.unnexeMoney +'</br></br>'+
                        '<strong>地址</strong>:'+ res.data.address +'</br></br>'+
                        '<strong>当事人</strong>:'+ res.data.pname +'</br></br>'+
                        '<strong>案号</strong>:'+ res.data.caseNo +'</br></br>'+
                        '<strong>依据</strong>:'+ res.data.yiju +'</br></br>'+
                        '<strong>标的金额</strong>:'+ res.data.execMoney +'</br></br>';
                    break;
                case 'ktgg':
                    myTitle = '开庭公告';
                    myHtml = 
                        '<strong>开庭时间</strong>:'+ res.data.sortTime +'</br></br>'+
                        '<strong>内容</strong>:'+ res.data.body +'</br></br>'+
                        '<strong>开庭公告ID</strong>:'+ res.data.ktggId +'</br></br>'+
                        '<strong>原告</strong>:'+ res.data.plaintiff +'</br></br>'+
                        '<strong>组织者</strong>:'+ res.data.organizer +'</br></br>'+
                        '<strong>法庭名称</strong>:'+ res.data.courtroom +'</br></br>'+
                        '<strong>法院名称</strong>:'+ res.data.court +'</br></br>'+
                        '<strong>标题</strong>:'+ res.data.title +'</br></br>'+
                        '<strong>案由</strong>:'+ res.data.caseCause +'</br></br>'+
                        '<strong>法官</strong>:'+ res.data.judge +'</br></br>'+
                        '<strong>案号</strong>:'+ res.data.caseNo +'</br></br>'+
                        '<strong>被告</strong>:'+ res.data.defendant +'</br></br>';

                    break;
                case 'fygg':
                    myTitle = '法院公告';
                    myHtml = 
                        '<strong>发布时间</strong>:'+ res.data.sortTime +'</br></br>'+
                        '<strong>内容</strong>:'+ res.data.body +'</br></br>'+
                        '<strong>法院公告ID</strong>:'+ res.data.fyggId +'</br></br>'+
                        '<strong>版面</strong>:'+ res.data.layout +'</br></br>'+
                        '<strong>姓名</strong>:'+ res.data.pname +'</br></br>'+
                        '<strong>法院名称</strong>:'+ res.data.court +'</br></br>'+
                        '<strong>公告类型</strong>:'+ res.data.ggType +'</br></br>';
                    break;
                case 'ajlc':
                    myTitle = '案件流程';
                    myHtml = 
                        '<strong>立案时间</strong>:'+ res.data.sortTime +'</br></br>'+
                        '<strong>法庭成员</strong>:'+ res.data.member +'</br></br>'+
                        '<strong>当值员电话</strong>:'+ res.data.clerkPhone +'</br></br>'+
                        '<strong>案件类别</strong>:'+ res.data.caseType +'</br></br>'+
                        '<strong>内容</strong>:'+ res.data.body +'</br></br>'+
                        '<strong>审理程序</strong>:'+ res.data.trialProcedure +'</br></br>'+
                        '<strong>案件流程ID</strong>:'+ res.data.ajlcId +'</br></br>'+
                        '<strong>判决日期</strong>:'+ res.data.sentencingDate +'</br></br>'+
                        '<strong>案件状态</strong>:'+ res.data.caseStatus +'</br></br>'+
                        '<strong>组织者</strong>:'+ res.data.organizer +'</br></br>'+
                        '<strong>法院名称</strong>:'+ res.data.court +'</br></br>'+
                        '<strong>审理状态</strong>:'+ res.data.ajlcStatus +'</br></br>'+
                        '<strong>主要法官</strong>:'+ res.data.chiefIudge +'</br></br>'+
                        '<strong>案由</strong>:'+ res.data.caseCause +'</br></br>'+
                        '<strong>审判限制日期</strong>:'+ res.data.trialLimitDate +'</br></br>'+
                        '<strong>诉讼标的</strong>:'+ res.data.actionObject +'</br></br>'+
                        '<strong>当事人</strong>:'+ res.data.pname +'</br></br>'+
                        '<strong>案号</strong>:'+ res.data.caseNo +'</br></br>'+
                        '<strong>有效日期</strong>:'+ res.data.effectiveDate +'</br></br>';
                    break;
                default:
                    myTitle = '--';
                    myHtml = '--';
            }
            $('.page-header > .text-center').html(myTitle);
            $('.panel-heading > .panel-title').html(myTitle+'详情');
            myHtml = myHtml.replace(/undefined/g,"--");
            $('.panel-default >.panel-body').append(myHtml);
        }
    }

});


//function publicDesensitization(){ 
//	//先将内置的 arguments 转换为真正的数组 
//	var dataArr = Array.prototype.slice.apply(arguments); 
//	for (var i = 0; i < dataArr.length; i++) { 
//		var data = dataArr[i]; 
//		// 正则判断返回相应数据 
//		if(/(^\d{18}$)|(^\d{17}(\d|X|x)$)/.test(data) || /^(13[0-9]|16[0-9]|19[0-9]|147|15[0-9]|17[6-8]|18[0-9])\d{8}|17[0-9]\d{8}$/.test(data) || /(^(?:(?![IOZSV])[\dA-Z]){2}\d{6}(?:(?![IOZSV])[\dA-Z]){10}$)|(^\d{15}$)/.test(data)){
//			//身份证号 || 手机号 || 营业执照 前三后四 
//			data = data.substr(0,3) + "****" + data.substr(-4); 
//		}else if(/^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/.test(data)){
//			//邮箱号码 前二 后以 @ 分割 
//			data = data.substr(0,2) + "****" + data.substr(data.indexOf('@')); 
//		}else if(/^\d{16}|\d{19}$/.test(data)){
//			//银行卡号 后四位 data = "****" + data.substr(-4); 
//		}else if(data.indexOf('公司') > -1){
//			//企业名称 前二后四 data = data.substr(0,2) + "****" + data.substr(-4); 
//		}else{ 
//			return; 
//		} 
//		dataArr[i] = data; 
//	} 
//	return dataArr; 
//} 
//测试输出，数据都是虚假的 身份证号 手机号 邮箱 企业名称 营业执照 银行卡号
//console.log(publicDesensitization('13062119801124217X','13688888888','xiaochuan@qq.com','河南你想网络科技有限公司','914101003172188172','6228480402564890018'));