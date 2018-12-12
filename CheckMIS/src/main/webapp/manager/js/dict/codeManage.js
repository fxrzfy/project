var args, zTreeOnClick,dataLoad_1,tableEvent_1, g_isModify = false;

jQuery.browser = {};

(function() {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        return jQuery.browser.version = RegExp.$1;
    }
})();

args = comn.getArgs();

current_node = null;

zTreeOnClick = function(event, treeId, treeNod) {
    current_node = treeNod;
    //$("#orgName").html(current_node.name);
    //$("#syncButton").hide();
    // if (current_node.type == 'BRANCH_COMPANY') {
    //     if(current_node.state != 1){
    //         $("#syncButton").show();
    //     }
    // }
    //openOrg();
    openDetail();
};

function openDetail(){
    $("#pcode").val(current_node.id);

    $("#table1").bootstrapTable("refresh", {url: "..."});
}


table_1 = function (params) {
    tableData(params,$("#searchForm").values(), interUrl.teamManage.list);
};

openTree = function(){
    comn.ajax({
        url: interUrl.teamManage.tree,
        success: function(res) {
            var treeObj;
            treeObj = $.fn.zTree.init($("#tree"), {
                showLine: true,
                expand: true,
                callback: {
                    onClick: zTreeOnClick
                },
                data: {
                    key: {
                        name: "text"
                    },
                    simpleData: {
                        enable: true,
                        idKey: "id",
                        pIdKey: "pid",
                        state:"state",
                        type:"type",
                        rootPId: 0
                    }
                },
                check : {
                    enable:true
                }
            }, res.data);
            var node = treeObj.getNodes()[0];
            if(node){
               var nodes=node.children;
                if(!nodes){
                    return;
                }
                node=nodes[0];
                treeObj.selectNode(node);
                zTreeOnClick(null, null, node);
            }
            return treeObj.expandAll(true);
        }
    });
};


saveOrg = function(_form, _callback){
    var _data = _form.values();
    var _url = interUrl.teamManage.add
    return comn.ajax({
        url: _url,
        data: _data,
        success: function(res) {
            if(res.code==10000){
                if(_callback)_callback();
                openTree();
                g_isModify = false;
                setButtonStatus();
            }else{
                tip({content: res.message});
            }
        }
    });
};

saveDetail = function(_form, _callback){
    var _data = _form.values();
    var _url = interUrl.teamManage.addDetail
    return comn.ajax({
        url: _url,
        data: _data,
        success: function(res) {
            if(res.code==10000){
                if(_callback)_callback();
                $("#table1").bootstrapTable("refresh", {url: "..."});
                //g_isModify = false;
              //  setButtonStatus();
            }else{
                tip({content: res.message});
            }
        }
    });
};

$("#delAll").click(function () {
    var selids=$("#table1").bootstrapTable('getSelections');
    arr=[];
    $(selids).each(function(index,ele){
        arr.push(ele.id);
    });
    if(arr.length==0){
        tip({content:"至少选择一个"});
        return;
    }

    oppSureModal("确定刪除么？");
    $("#sureOption").unbind("click").click(function (){
        comn.ajax({
            url: interUrl.teamManage.del,
            data: {
                ids: arr.join(",")
            },
            success: function (resp) {
                tip({content:"操作成功"});
                $("#sureModal").modal("hide");
                $("#table1").bootstrapTable("refresh", {url: "..."});
            }
        });
    });
});
setButtonStatus = function(){
    var span = $('#modify').find("span:last");
    if(current_node.id==0){
        g_isModify=false;
    }
    if(g_isModify==true){
        span.html("&nbsp;取消&nbsp;");
        $("#orgForm").find(":input").attr("disabled",false);
        $("#orgForm").find(".readInput").attr("disabled",true);
        $("#orgForm").find("#selectType").attr("disabled",true);
        $("#orgForm").find("#orgCode").attr("readonly",true);
        $("#orgForm").find("#save").show();
    }else{
        span.html("&nbsp;修改&nbsp;");
        $("#orgForm").find(":input").not(":button").attr("disabled",true);
        $("#orgForm").find("#save").hide();
    }
};

//新增账户
$("#saveAccount").click(function () {
    var companyId = current_node.id;
    if ($("#addAccountForm").valid() == true) {
        var data = $("#addAccountForm").values();
        return comn.ajax({
            url: interUrl.org["accountAdd"],
            data: $.extend(data, {companyId: companyId}),
            success: function (res) {
                $("#addAccountModal").modal("hide");
                tip({content: res.message || "新增账户成功"});
                $("#table_account").bootstrapTable('refresh');
            }
        });
    }
});
$("#openingBankSelect").change(function(){
    $("#openBankName").val($(this).find('option:selected').text())
});

$("#setAccount").click(function() {
    if(!current_node){
        tip({content: "请选择机构!"});
        return;
    }
    $("#accountId").val('');
    $("#addAccountModal .modal-title").html("添加账户");
    $("#addAccountModal").modal("show");

});


function dealerror(response, newValue){
    console.log(response.responseText)
    return JSON.parse(response.responseText).msg;
}

$('#table1').on('load-success.bs.table', function (row, $element, field) {
    $('.nametxt').editable({
        type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
        title: "组名",              //编辑框的标题
        disabled: false,             //是否禁用编辑
        pk:row.id,
        url:interUrl.basic+interUrl.teamManage.updateField,
        emptytext: "空文本",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
        error:dealerror,
        success:function(response, newValue){
            $("#table1").bootstrapTable("refresh", {url: "..."});
        },
        validate: function (value) { //字段验证
            if (!$.trim(value)) {
                return '不能为空';
            }
        }
    });
    $('.keytxt').editable({
        type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
        title: "组名代码",              //编辑框的标题
        disabled: false,             //是否禁用编辑
        pk:row.id,
        url:interUrl.basic+interUrl.teamManage.updateField,
        emptytext: "空文本",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
        error:dealerror,
        validate: function (value) { //字段验证
            if (!$.trim(value)) {
                return '不能为空';
            }
        }
    });

    $('.sorttxt').editable({
        type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
        title: "组名顺序",              //编辑框的标题
        disabled: false,             //是否禁用编辑
        pk:row.id,
        url:interUrl.basic+interUrl.teamManage.updateField,
        emptytext: "空文本",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
        error:dealerror,
        validate: function (value) { //字段验证
            if (!$.trim(value)) {
                return '不能为空';
            }
            if(isNaN(value)){
                return "必须是数字";
            }
        }
    });

});


function editableName(value, row, index) {
    // return '<a style="border:0;" class="nametxt" data-pk="'+row.id+'" class="name'+row.id+'" id="name">'+ value +'</a>';
    return `<a style="border:0;"  data-pk="${row.id}" class="nametxt name${row.id}" id="name">${value}</a>`;
};
function editableSort(value, row, index) {
    return '<a style="border:0;" class="sorttxt" data-pk="'+row.id+'" class="sort'+row.id+'" id="sort">'+ value +'</a>';
};
function editablekey(value, row, index) {
    return '<a style="border:0;" class="keytxt" data-pk="'+row.id+'" class="key'+row.id+'" id="key">'+ value +'</a>';
};




$(function() {
    $("#add").click(function() {
        $("#addOrg").modal("show");
    });
    $("#modify").click(function() {
        $("#addOrg").modal("show");
        if(!current_node && !current_node.id){
            tip({content: "请选择一个节点来修改!"});
        }
        comn.ajax({
            url: interUrl.teamManage.get,
            data: {code:current_node.id},
            success: function (resp) {
                $("#addOrgForm").values(resp.data);
            }
        });

    });


    $("#del").click(function() {
        oppSureModal("确定刪除么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.teamManage.delcodeList,
                data: {
                    code: current_node.id
                },
                success: function (resp) {
                    $("#sureModal").modal("hide");
                    tip({content:"操作成功"});
                    openTree();


                }
            });
        });
    });

    $("#clear").click(function() {
        comn.ajax({
            url: interUrl.teamManage.clear,
            data: {
                code: current_node.id
            },
            success: function (resp) {
                $("#sureModal").modal("hide");
                tip({content:"缓存已经清除，请刷新整个页面"});
                openTree();


            }
        });
    });

    $("#addDetailNew").click(function() {
        $("#addDetail").modal("show");
        $("#addpcode").val(current_node.id);
    });
    $("#saveOrg").click(function() {
        if($("#addOrgForm").valid()==false)return;
        saveOrg($("#addOrgForm"), function(){$("#addOrg").modal("hide");});
    });
    $("#saveDetail").click(function() {
        if($("#addDetailForm").valid()==false)return;
        saveDetail($("#addDetailForm"), function(){$("#addDetail").modal("hide");});
    });

    openTree();

});


