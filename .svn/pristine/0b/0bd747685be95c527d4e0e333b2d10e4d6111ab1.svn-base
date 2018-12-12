var treeObj, selectNode, selectData, initTree, zTreeOnClick;


initTree = function(selectNode){

    comn.ajax({
        url: interUrl.unitManage.tree,
        success: function(res) {
            treeObj = $.fn.zTree.init($("#tree"), {
                view: {
                    showIcon: showIcon
                },
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
                        rootPid:0
                    }
                }
            }, construct(res.data));
            var node = selectNode || treeObj.getNodes()[0];
            if(node){
                zTreeOnClick(null, null, node);
            }
            return treeObj.expandNode(treeObj.getNodes()[0], true);
        }
    });
};

construct = function(data){
    // var root = {
    //     id:0,
    //     pid:-1,
    //     text:'公司信息',
    //     open:'true'
    // };
    // data.push(root);
    $(data).each(function (i, o) {
        o.iconSkin = o.iconCls;
        o.open = false;
    });
    return data;
};

showIcon = function(treeId, treeNode) {
    return treeNode.id != 0;
};

zTreeOnClick = function(event, treeId, treeNode){
    treeObj.selectNode(treeNode);
    if(treeNode.id != 0){
        comn.ajax({
            url: interUrl.unitManage.get,
            data: {id : treeNode.id},
            success: function(res) {
                $("#orgForm").values(res.data);
                selectNode = treeNode;
                selectData = res.data;
            }
        });
    }else{
        selectData = {
            id:0
        };
        $("#orgForm").values(selectData);
    }
    viewMode();

};


$("#add").click(function(){
    editMode();
    $("#orgForm").values({});
    $("#parentId").val(selectData.id);
});

$("#modify").click(function () {
    editMode();
    $("#parentId").val(selectNode.pid);
});

$("#save").click(function(){
    comn.ajax({
        url: interUrl.unitManage.save,
        data: $("#orgForm").serialize(),
        success: function (res) {
            viewMode();
            var node = treeObj.getNodeByParam("id", res.data.id);
            if(node){
                node.text = $("#name").val();
                treeObj.updateNode(node);
            }else{
                initTree(selectNode);
            }
        }
    });

});

$("#deleteConfirm").click(function () {
    comn.ajax({
        url: interUrl.unitManage.delete,
        data: {id: selectData.id},
        success: function () {
            $("#deleteDialog").modal('hide');
            treeObj.removeNode(selectNode);
            zTreeOnClick(null, null, selectNode.getParentNode());
        }
    });
});

$("#cancel").click(function(){
    viewMode();
    $("#orgForm").values(selectData);
});


editMode = function(){
    $("#add").hide();
    $("#modify").hide();
    $("#delete").hide();
    $("#save").show();
    $("#cancel").show();
    $("#orgForm input").attr("readonly",false);
};

viewMode = function(){
    $("#save").hide();
    $("#cancel").hide();
    $("#add").show();
    $("#modify").show();
    $("#delete").show();
    $("#orgForm input").attr("readonly",true);
};


$(function() {
    initTree();
})