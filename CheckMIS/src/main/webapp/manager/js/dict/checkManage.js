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
    $("#jcflId").val(current_sub_node.id);
    $("#table1").bootstrapTable("refresh", {url: "..."});
};


table_1 = function (params) {
    tableData(params,$("#searchForm").values(), interUrl.jcfl.detail);
};

openTree = function(){
    var zNodes = [
        {name:"被检查对象", open:true, children:[
                {name:"客运车站",type:1}, {name:"货运车站",type:2},{name:"列车",type:3}]}
    ];
    let  setting={
        callback:{
            onClick: zTreeOnClick
        },
        showLine: true,
        expand: true
    }
    let treeObj=zTreeObj = $.fn.zTree.init($("#tree"), setting, zNodes);
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
};

openTreeSub = function(){
    comn.ajax({
        url: interUrl.jcfl.list,
        data:{type:current_node.type},
        success: function(res) {
            let childs=$(res.data).map(function (i,ele) {
                return {name:ele.jcflmc,id:ele.id}
            }).get();

            let data=[];
            root={name:"检查分类",children:[]}
            root.children=childs;
            data.push(root);
            var treeObj;
            treeObj = $.fn.zTree.init($("#treeSub"), {
                showLine: true,
                expand: true,
                callback: {
                    onClick: zTreeOnClickSub
                }
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


save = function(_form, _callback){
    var _data = _form.values();
    var _url = interUrl.jcfl.add
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
    var _url = interUrl.jcfl.addDetail
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

$("#delDetail").click(function () {
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
            url: interUrl.jcfl.deleteDetail,
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



function dealerror(response, newValue){
    return JSON.parse(response.responseText).msg;
}

function jcflFormatter(value, row, index) {
    if(current_sub_node) {
        return current_sub_node.name;
    }
}

$(function() {
    $("#add").click(function() {
        $("#addFl").modal("show");
        $("#addForm input[name='type']").val(current_node.type);
    });
    $("#modify").click(function() {
        $("#addFl").modal("show");
        if(!current_sub_node && !current_sub_node.id){
            tip({content: "请选择一个节点来修改!"});
        }
        comn.ajax({
            url: interUrl.jcfl.get,
            data: {id:current_sub_node.id},
            success: function (resp) {
                $("#addForm").values(resp.data);
            }
        });

    });


    $("#del").click(function() {
        oppSureModal("确定刪除么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.jcfl.delete,
                data: {
                    id: current_sub_node.id
                },
                success: function (resp) {
                    $("#sureModal").modal("hide");
                    tip({content:"操作成功"});
                    openTree();
                }
            });
        });
    });

    $("#editDetail").click(function() {
        var selids=$("#table1").bootstrapTable('getSelections');
        if(selids.length!=1){
            layer.alert('必须且只能选择一个');
            return;
        }
        $("#addFlxdsx").modal("show");
        $("#addDetailForm").values(selids[0]);

    });

    $("#addDetail").click(function() {
        $("#addFlxdsx").modal("show");
        $("#addDetailForm input[name='jcflId']").val(current_sub_node.id);
    });
    $("#save").click(function() {
        if($("#addForm").valid()==false)return;
        save($("#addForm"), function(){$("#addFl").modal("hide");});
    });
    $("#saveDetail").click(function() {
        if($("#addDetailForm").valid()==false)return;
        saveDetail($("#addDetailForm"), function(){$("#addFlxdsx").modal("hide");});
    });

    openTree();

});


