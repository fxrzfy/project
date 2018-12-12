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
    if(current_node.id<=0){
        $("#add").attr("disabled",true);
        $(".edzz").attr("disabled",true);
        $(".addsub").attr("disabled",true)
    }else{
        if($("#typestr").val()=='x'){
            $("#add").attr("disabled",true)
        }else{
            $("#add").attr("disabled",false)
        }
        $(".addsub").attr("disabled",false)
    }
    if(current_node.pid<0){
        $(".edzz").attr("disabled",true);
        $("#add").attr("disabled",false);
        //需要加载数据
    }else{
        //$(".edzz").attr("disabled",true)
    }
    if(current_node.attributes=='1'){
        $(".edzz").attr("disabled",false);
        $("#add").attr("disabled",true);
    }
    if(($("#typestr").val()=='x'  && current_node.pid<0 ) ||current_node.attributes=='1'){
        $("#zszId").val(current_node.id);
        $("#ptype").val(current_node.type);
        $("#table1").bootstrapTable("refresh", {url: "..."});
    }

    //

};


openTree = function(){
    comn.ajax({
        url: interUrl.dict.zsztree,
        data:{typestr:$("#typestr").val()},
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
                view: {
                    addDiyDom: addDiyDom
                },
                check : {
                    enable:true
                }
            }, res.data);
            var node = treeObj.getNodes()[0];
            if(node){
                treeObj.selectNode(node);
                zTreeOnClick(null, null, node);
            }
            return treeObj.expandAll(true);
        }
    });
};
addDiyDom = function(treeId,treeNode) {
    if (treeNode.type != 'BRANCH_COMPANY') return;
    var btn = $("#diyBtn_"+treeNode.id);
    if (btn.length>0) return;
    var str = (treeNode.state == 0) ? "<span id='diyBtn_" + treeNode.id + "' style='color:red;'>" + "[同步失败]" +"</span>"
        : "<span id='diyBtn_" + treeNode.id + "' style='color:green;'>" + "[同步成功]" +"</span>";
    $("#" + treeNode.tId + "_a").append(str);
    btn.bind("click", function(){alert("diy Button for " + treeNode.name);});
};

saveOrg = function(_form, _callback){
    var _data = _form.values();
    var _url =interUrl.dict.zszaddEdit;
    return comn.ajax({
        url: _url,
        data: _data,
        success: function(res) {
            if(res.code==10000){
                if(_callback)_callback();
                openTree();
               // g_isModify = false;
               // setButtonStatus();
            }else{
                tip({content: res.message});
            }
        }
    });
};


table_1 = function (params) {
    if($("#zszId").val()<0){
        params.complete();
        return;
    }
    tableData(params,$.extend($("#searchForm").values(), {})  , interUrl.dict.zdList);
};

function editTeam(value, row, index) {
    if(!value){
        value=""
    }
    return `<a data-pk="${row.id}" data-name="name" data-title="名称" onclick="editZdMap('${row.id}','${value}')" >${value}</a>`;
};
function editCode(value, row, index) {
    if(!value){
        value=""
    }
    if(row.id<1){
        return value;
    }
    return `<a data-pk="${row.id}" data-title="代码" data-name="code" class="teamSel">${value}</a>`;
};


function editeGroup() {
    $('.teamSel').editable({
        type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
        disabled: false,             //是否禁用编辑
        //  pk: row.id,
        // url:interUrl.basic+interUrl.dict.updateZd,
        // success:function(aa){
        //     $("#table1").bootstrapTable("refresh", {url: "..."});
        // },
        // validate:function(v){
        //
        // },
        // error:function(resp,value){
        //     return resp.responseJSON.msg;
        // },
        emptytext: "请输入",          //空值的默认文本
        mode: "popup"              //编辑框的模式：支持popup和inline两种模式，默认是popup
    });
}

$('#table1').on('load-success.bs.table', function (row, $element, field) {
   // editeGroup();
});


$("#sync").click(function () {
    comn.ajax({
        url: interUrl.dict.sync,
        data: {
            type:$(this).attr("data-value")
        },
        success: function (resp) {
            openTree();
            tip({content:resp.data});

        }
    });
});

function editZdMap(id,v){
    $("#addSub").modal('show');
    $("#addSubForm input[name='pk']").val(id);
    $("#addSubForm input[name='value']").val(v);
    $("#addSubForm input[name='name']").val('name');
}


$(function() {




    var validate = {
        rules: {
            telephone: {phoneMix: true},
            fax: {telephone: true}
        },
        messages: {
            telephone: {phoneMix: "公司电话格式不正确"},
            fax: {telephone: "传真格式不正确"}
        }
    };
    $("#orgForm").validate(validate);
    $("#addOrgForm").validate(validate);
    $("#add").click(function() {
        $("#addOrg").modal("show");
        if(current_node){
            $("#addOrg").find("input[name='type']").val(current_node.type);
            if($("#typestr").val()!='x'){
                $("#addOrg").find("input[name='pid']").val(current_node.id);
            }
        }
    });
    $("#modifyzz").click(function() {
        $("#addOrg").modal("show");
        if(current_node){
            $("#addOrg").find("input[name='type']").val(current_node.type);
            $("#addOrg").find("input[name='id']").val(current_node.id);
            $("#addOrg").find("input[name='name']").val(current_node.text);
            comn.ajax({
                url: interUrl.dict.zszget,
                data: {
                    id: current_node.id
                },
                success: function (resp) {
                    $("#addOrg").find("input[name='code']").val(resp.data.code);
                }
            });
        }
    });
    $("#del").click(function() {
        oppSureModal("确定刪除么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.dict.zszdel,
                data: {
                    id: current_node.id
                },
                success: function (resp) {
                    tip({content:"操作成功"});
                    $("#sureModal").modal("hide");
                    openTree();
                }
            });
        });
    });




    $("#saveOrg").click(function() {
        if($("#addOrgForm").valid()==false)return;
        saveOrg($("#addOrgForm"), function(){$("#addOrg").modal("hide");});
    });



    $("#zdaddNew").click(function(){
        $("#addSub").modal('show');
        $("#addSubForm input[name='pk']").val(-$("#zszId").val());
        $("#addSubForm input[name='name']").val('name');
        // var d=$("#table1").bootstrapTable("getData");
        // ids=[];
        // $.each(d,function(index,row){
        //     if(row.id<0){
        //         ids.push(1);
        //     }
        // });
        //
        // if(ids.length>0){
        //     layer.msg("请先设置新增组的组名");
        //     return ;
        // }
        // var data={id:-$("#zszId").val(),code:"",name:""};
        // console.log(data);
        // $("#table1").bootstrapTable('append',data);
        // editeGroup();
    });
    $("#saveSub").click(function () {
        if(!$("#addSubForm").valid() ){
            return;
        }
        var _data = $("#addSubForm").values();
        var _url = interUrl.dict.updateZd;
        comn.ajax({
            url: _url,
            data: _data,
            success: function(res) {
                $("#addSub").modal("hide");
                $("#table1").bootstrapTable("refresh", {url: "..."});
            }
        });
    });
    $("#zddelAll").click(function(){
        var ids = $.map($("#table1").bootstrapTable('getSelections'), function (row) {
            return row.id;
        });
        if (ids.length  <1 ) {
            layer.alert("请至少选择一行来操作");
            return;
        }
        oppSureModal("确定刪除么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.dict.delZd,
                data: {
                    deptId:$("#zszId").val() ,
                    ids: ids.join(",")
                },
                success: function(res) {
                    tip({content: "删除成功!"});
                    $("#sureModal").modal("hide");
                    $("#table1").bootstrapTable("refresh", {url: "..."});
                }
            });
        });

        //var data={id:-$("#zszId").val(),code:"",name:""};
        //console.log(data);
       // $("#table1").bootstrapTable('append',data);
        editeGroup();
    });
    $("#syncButton").click(function(){
        syncState();
    });
    $("#save").click(function(){
        if($("#orgForm").valid()==false)return;
        saveOrg($("#orgForm"));
    });
    $("#stop").click(function() {
        if(!current_node){
            tip({content: "请选择机构!"});
            return;
        }
        return comn.ajax({
            url: interUrl.org["setStatus"],
            data: {
                dealerId: current_node.id,
                status: (current_node['status']==0?1:0)
            },
            success: function(res) {
                tip({content: "操作成功!"});
                return $("#btn-search").trigger("click");
            }
        });
    });
    $("#del").click(function() {
        if(!current_node){
            tip({content: "请选择机构!"});
            return;
        }
        $("#sure").modal("show");
        return $("#OK").unbind("click").on("click", function() {
            return comn.ajax({
                url: interUrl.org["delete"],
                data: {
                    orgId: current_node.id
                },
                success: function(res) {
                    tip({
                        content: "删除成功!"
                    });
                    $("#sure").modal("hide");
                    return $("#btn-search").trigger("click");
                }
            });
        });
    });
    openTree();
});


