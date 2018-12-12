var args, zTreeOnClick,dataLoad_1,tableEvent_1,  treeObj;



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



table_1 = function (params) {
    tableData(params, $.extend($("#searchForm").values(), {
        isProcessed: false
    }), interUrl.roleManage.dataGrid);
};


function handle_1(value, row, index) {
    var string = "";
    string += "<li><a class='del'>删除</a></li>";
    string += "<li><a class='grant'>授权</a></li>";
    return ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary'>操作</button>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>", "<li><a class='modify'>编辑</a></li>", string, "</ul>", "</div>"].join("");
};


tableEvent_1 = {
    "click .modify": function (a, val, item, d) {
        $("#addEditModal .modal-title").html("修改角色");
        comn.ajax({
            url: interUrl.roleManage.get,
            data: {
                id: item.id
            },
            success: function (res) {
                $("#addEditModal").modal("show");
                $("#addForm").values(res.data);

            }
        });
    },
    "click .del": function (a, val, item, d) {
        oppSureModal("确定刪除么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.roleManage.del,
                data: {
                    ids: item.id
                },
                success: function (resp) {
                    tip({content:"操作成功"});
                    $("#sureModal").modal("hide");
                    $("#table1").bootstrapTable("refresh", {url: "..."});

                }
            });
        });
    },
    "click .grant": function (a, val, item, d) {
        openTree(item.id);
        $("#grantModal").modal("show");
        $("#selectedRoleId").val(item.id);
    }
}


$("#addNew").click(function () {
    $("#addEditModal .modal-title").html("新增角色");
    $("#addEditModal").modal("show");


});


//查询按钮
$("#btn-search").click(function () {
    $("#table1").bootstrapTable("refresh", {url: "..."});

});



zTreeOnClick = function(event, treeId, treeNod) {
    current_node = treeNod;
    $("#orgName").html(current_node.name);
    //$("#syncButton").hide();
    // if (current_node.type == 'BRANCH_COMPANY') {
    //     if(current_node.state != 1){
    //         $("#syncButton").show();
    //     }
    // }
  //  openOrg();
};

addDiyDom=function(event, treeId, treeNod){

}
openTree = function(id){
    comn.ajax({
        url: interUrl.resourcesManage.tree,
        data:{ roleId:id},
        success: function(res) {
            treeObj = $.fn.zTree.init($("#tree"), {
                showLine: true,
                expand: true,
                check: {
                    enable: true
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
                        state:"state",
                        type:"type",
                        rootPId: 0
                    }
                },
                view: {
                    addDiyDom: addDiyDom
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

$("#grantMenu").click(function () {
    var nodes = treeObj.getCheckedNodes(true);
    var arr=[];
    for(j = 0; j < nodes.length; j++) {
        arr.push(nodes[j].id);
    }
    comn.ajax({
        url: interUrl.roleManage.grant,
        data:{ ids:arr.join(","),roleId:$("#selectedRoleId").val()},
        success: function(res) {
            $("#grantModal").modal("hide");
            tip({content:"操作成功"});
        }
    });
});

$("#save").click(function () {
    if(!$("#addForm").valid() ){
        return;
    }
    var _data = $("#addForm").values();
    var _url = interUrl.roleManage.saveUpdate;
     comn.ajax({
        url: _url,
        data: _data,
        success: function(res) {
            $("#addEditModal").modal("hide");
            $("#table1").bootstrapTable("refresh", {url: "..."});
        }
    });
});

$("#delAll").click(function () {
    var selids=$.map($("#table1").bootstrapTable('getSelections'),function (row) {
        return row.id;
    });
    if(selids.length<1){
        layer.alert("至少选择一条来操作");
        return;
    }
    oppSureModal("确定刪除么？");

    $("#sureOption").unbind("click").click(function (){
        comn.ajax({
            url: interUrl.roleManage.del,
            data: {
                ids: selids.join(",")
            },
            success: function (resp) {
                tip({content:"操作成功"});
                $("#sureModal").modal("hide");
                $("#table1").bootstrapTable("refresh", {url: "..."});

            }
        });
    });
});


