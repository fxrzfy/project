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
current_sub_node = null;

zTreeOnClick = function(event, treeId, treeNod) {
    current_node = treeNod;
    if(current_node==null||!current_node.type||current_node==''){
        return ;
    }
    openTreeSub();
};

zTreeOnClickSub = function(event, treeId, treeNod) {
    current_sub_node = treeNod;
    if(current_sub_node==null ||!current_sub_node.id){
        return ;
    }
    $("#slqsknrflId").val(current_sub_node.id);
    $("#table1").bootstrapTable("refresh", {url: "..."});
};

function openDetail(){
    $("#pcode").val(current_node.id);

    $("#table1").bootstrapTable("refresh", {url: "..."});
}


table_1 = function (params) {
    tableData(params,$("#searchForm").values(), interUrl.dict.lqskxdList);
};



openTreeSub = function(){
    comn.ajax({
        url: interUrl.dict.lqskree,
        //data:{type:current_node.type},
        success: function(res) {
            let childs=$(res.data).map(function (i,ele) {
                return {name:ele.name,id:parseInt(ele.id),pId:0}
            }).get();

            let data=[];
            root={name:"问题分类",id:0,pId:-1}
            //childs.push(root)
            //root.children=childs;
           data.push(root);
            $.each(childs,function (i,o) {
                data.push(o);
            })
           // data.push(childs);
            var treeObj;
            treeObj = $.fn.zTree.init($("#treeSub"), {
                showLine: true,
                expand: true,
                callback: {
                    onClick: zTreeOnClickSub
                },
                data:{simpleData: {
                    enable: true, rootPId: -1
                }}
            }, data);
            var node = treeObj.getNodes()[0];
            if(node){
                var nodes=node.children;
                if(!nodes){
                    return;
                }
                node=nodes[0];
                treeObj.selectNode(node);
                zTreeOnClickSub(null, null, node);
            }
            return treeObj.expandAll(true);
        }
    });
};


saveOrg = function(_form, _callback){
    var _data = _form.values();
    var _url = interUrl.dict.lqskaddfl
    return comn.ajax({
        url: _url,
        data: _data,
        success: function(res) {
            if(res.code==10000){
                if(_callback)_callback();

                openTreeSub();
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
    var _url = interUrl.dict.lqskaddxd
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
            url: interUrl.dict.lqskdelxd,
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
    // var span = $('#modify').find("span:last");
    // if(current_node.id==0){
    //     g_isModify=false;
    // }
    // if(g_isModify==true){
    //     span.html("&nbsp;取消&nbsp;");
    //     $("#orgForm").find(":input").attr("disabled",false);
    //     $("#orgForm").find(".readInput").attr("disabled",true);
    //     $("#orgForm").find("#selectType").attr("disabled",true);
    //     $("#orgForm").find("#orgCode").attr("readonly",true);
    //     $("#orgForm").find("#save").show();
    // }else{
    //     span.html("&nbsp;修改&nbsp;");
    //     $("#orgForm").find(":input").not(":button").attr("disabled",true);
    //     $("#orgForm").find("#save").hide();
    // }
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
        if(!current_sub_node && !current_sub_node.id){
            tip({content: "请选择一个节点来修改!"});
        }
        console.log(current_sub_node)
        $("#addOrgForm input[name='id']").val(current_sub_node.id);
        $("#addOrgForm input[name='name']").val(current_sub_node.name);
       // $("#addOrgForm").values(current_sub_node);
    });


    $("#del").click(function() {
        oppSureModal("确定刪除么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.dict.lqskdelfl,
                data: {
                    id: current_sub_node.id
                },
                success: function (resp) {
                    $("#sureModal").modal("hide");
                    tip({content:"操作成功"});
                    openTreeSub();
                }
            });
        });
    });

    $("#editDetailNew").click(function() {
        var selids=$("#table1").bootstrapTable('getSelections');
        if(selids.length!=1){
            layer.alert('必须且只能选择一个');
            return;
        }
        $("#addDetail").modal("show");
        $("#addDetailForm").values(selids[0]);

    });

    $("#addDetailNew").click(function() {
        $("#addDetail").modal("show");
        $("#addDetailForm input[name='lqsknrflId']").val(current_sub_node.id);
    });
    $("#saveOrg").click(function() {
        if($("#addOrgForm").valid()==false)return;
        saveOrg($("#addOrgForm"), function(){$("#addOrg").modal("hide");});
    });
    $("#saveDetail").click(function() {
        if($("#addDetailForm").valid()==false)return;
        saveDetail($("#addDetailForm"), function(){$("#addDetail").modal("hide");});
    });
    openTreeSub();
});


