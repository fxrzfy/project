var treeObj, selectNode, selectData, initTree, zTreeOnClick;


initTree = function(selectNode){

    comn.ajax({
        url: interUrl.deptManage.tree,
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
    selectNode = treeNode;
    if(!treeNode.id.startsWith('U')){
        comn.ajax({
            url: interUrl.deptManage.get,
            data: {id : treeNode.id.substring(1)},
            success: function(res) {
                $("#deptForm").values(res.data);
                selectData = res.data;
            }
        });
    }else{
        selectData = {
            id:0,
            unitId:selectNode.id.substring(1),
            parentId:''
        };
        $("#deptForm").values(selectData);
    }
    viewMode();

};


$("#add").click(function(){
    editMode();
    var type = $("#type").val();
    if(type && type != 9){
        $("#type").attr("disabled",true);
        setTimeout(function() {$("#type").val(type);});
    }
    var unitId = selectData.unitId;
    $("#deptForm").values({});
    if(!selectNode.id.startsWith('U')){
        $("#parentId").val(selectData.id);
    }
    $("#unitId").val(unitId);
});

$("#modify").click(function () {
    if(selectNode.id.startsWith("U")){
        tip({
            content: "请选中部门进行修改！！！"
        })
    }else {
        editMode();
    }
});

$("#save").click(function(){
    $("#type").attr("disabled",false);
    comn.ajax({
        url: interUrl.deptManage.save,
        data: $("#deptForm").serialize(),
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

$("#delete").click(function() {
    if (selectNode.id.startsWith("U")) {
        tip({
            content: "请选中部门进行删除！！！"
        });
    } else {
        $("#deleteDialog").modal();
    }
});


$("#deleteConfirm").click(function () {
    comn.ajax({
        url: interUrl.deptManage.delete,
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
    $("#deptForm").values(selectData);
});


editMode = function(){
    $("#add").hide();
    $("#modify").hide();
    $("#delete").hide();
    $("#save").show();
    $("#cancel").show();
    $("#deptForm input").attr("readonly",false);
    $("#deptForm select").attr("disabled",false);
};

viewMode = function(){
    $("#save").hide();
    $("#cancel").hide();
    $("#add").show();
    $("#modify").show();
    $("#delete").show();
    $("#deptForm input").attr("readonly",true);
    $("#deptForm select").attr("disabled",true);
};


$(function() {
    initTree();
})