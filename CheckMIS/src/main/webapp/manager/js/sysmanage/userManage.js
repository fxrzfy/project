var table_1, handle_1, tableEvent_1,DeptData;
var dataList, idValue;

initTree = function(selectNode){
    comn.ajax({
        url: interUrl.deptManage.tree,
        success: function(res) {
            DeptData=res.data;
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


function disableChecked(o){
    o.chkDisabled=true;
    // if(o.checked){
    //     o.chkDisabled=true;
    // }
    if(o.children){
        $.each(o.children,function (i,x) {
            disableChecked(x);
        });
    }

}

openTree = function(id){
    comn.ajax({
        url: interUrl.resourcesManage.tree,
        data:{ roleId:id},
        success: function(res) {
            let treedata=res.data;
            $.each(treedata,function (i,x) {
                disableChecked(x);
            });
            treeObj2 = $.fn.zTree.init($("#tree2"), {
                showLine: true,
                expand: true,
                check: {
                    enable: true,
                    chkStyle : "checkbox",
                    chkDisabledInherit:false
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
                }
            }, res.data);
            return treeObj2.expandAll(true);
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

   //  if(!treeNode.id.startsWith('U')){
   //      comn.ajax({
   //          url: interUrl.deptManage.get,
   //          data: {id : treeNode.id.substring(1)},
   //          success: function(res) {
   //              $("#deptForm").values(res.data);
   //              selectData = res.data;
   //          }
   //      });
   //  }else{
   //      selectData = {
   //          id:0,
   //          unitId:selectNode.id.substring(1),
   //          parentId:''
   //      };
   //      $("#deptForm").values(selectData);
   //  }
   viewMode();

};

table_1 = function (params) {
    tableData(params, $.extend($("#searchForm").values(), {}), interUrl.userManage.dataGrid);
};
function handle_xb(value, row, index) {
    if(!value && value!=0){
        return "--"
    }
    if(value==0){
        return "男";
    }else{
        return "女";
    }
}

function handle_1(value, row, index) {


    // var string = "";
    // if (row.isuse == "1") {
    //     string = "<li><a class='btna changeInuse'>停用</a></li>";
    // } else if (row.isuse == "0") {
    //     string = "<li><a class='btna changeInuse'>启用</a></li>";
    // }
    // string += "<li><a class='btna resetPwd'>重置密码</a></li>";
    // string+="<li><a class='changeInuse'></a></li>";
    // return ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary'>操作</button>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>", "<li><a class='modify'>修改</a></li>", string, "</ul>", "</div>"].join("");
    var string = "";
    string += "<a class='btna modify'>编辑</a>";
    //string += "<a class='btna delete'>删除</a>";
    if (row.yxbz == "1") {
        string += "<a class='btna changeInuse'>停用</a>";
    } else if (row.yxbz == "0") {
        string += "<a class='btna changeInuse'>启用</a>";
    }

    string += "<a class='btna resetPwd'>重置密码</a>";
    string += "<a class='btna grant'>授权</a>";
    return string;
};

function bindRolecheck(){
    $(".roleCheck").unbind('click').click(function () {
        let check=[];
        $.each($(".roleCheck"),function (i,o) {
            if(o.checked){
                check.push(o.value);
            }
        });
        openTree(check.join(','));
    });
}

tableEvent_1 = {
    "click .modify": function (a, val, item, d) {
        $("#contractModal .modal-title").html("修改用户");
        $("#addForm").clearForm(true);
        comn.ajax({
            url: interUrl.userManage.get,
            data: {
                id: item.id
            },
            success: function (res) {
                $('#contractModal').modal('show');
                $("#addForm").values(res.data);

            }
        });
    },
    "click .resetPwd": function (a, val, item, d) {
        oppSureModal("确定要重置密码么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.userManage.resetPwd,
                data: {
                    id: item.id
                },
                success: function (resp) {
                    $("#sureModal").modal("hide");
                    tip({content:"操作成功"});
                }
            });
        });
    },
    "click .changeInuse": function (a, val, item, d) {
        var text="确定要停用该用户么？";
        if(item.isuse==0){
            text="确定要启用该用户么？"
        }
        oppSureModal(text);
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.userManage.changeInuse,
                data: {
                    id: item.id
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
        $("#grantModal").modal("show");
        comn.ajax({
            url: interUrl.userManage.userRoleList,
            data: {
                id: item.id,type:"edit"
            },
            success: function (resp) {
                let roleHmml=""; let checkids=[];
             $.each(resp.data,function (i,o) {
                 roleHmml+=`<label class="checkbox-inline"><input type="checkbox"  name="roleName" ${o.checked?"checked=\"checked\"":""} class="roleCheck" value="${o.id}"/>${o.roleName}</label>`;
                 if(o.checked){
                     checkids.push(o.id);
                 }

             });
             $("#roleDiv").html(roleHmml);
             bindRolecheck();
                openTree(checkids.join(','));
            }
        });
        $("#schemeForm input[name='userName']").val(item.userName);
        $("#schemeForm input[name='id']").val(item.id);
    }
}

$("#saveu").click(function () {
   let userName=  $("#schemeForm input[name='userName']").val();
   let password= $("#schemeForm input[name='password']").val();
   let id= $("#schemeForm input[name='id']").val();
   if(!userName||userName==''){
       layer.alert('用户名不能为空');
       return;
   }
    if(!password||password==''){
        layer.alert('密码不能为空');
        return;
    }
    var _url = interUrl.userManage.saveUpdate;
    comn.ajax({
        url: _url,
        data: {id:id,userName:userName,password:password},
        success: function(res) {
            layer.msg("修改成功");
            $("#table1").bootstrapTable("refresh", {url: "..."});
        }
    });

});

$("#saver").click(function () {
    let check=[];
    $.each($(".roleCheck"),function (i,o) {
        if(o.checked){
            check.push(o.value);
        }
    });
    let userId= $("#schemeForm input[name='id']").val();
    comn.ajax({
        url: interUrl.userManage.updateRole,
        data: {ids:check.join(','),userId:userId},
        success: function(res) {
            layer.msg("修改成功");
        }
    });
});


$("#addNew").click(function () {
    $("#contractModal .modal-title").html("新增用户");
    $("#contractModal").modal("show");
    $("#addForm").clearForm(false);
    $("#addForm input[name='id']").val("");
});


//查询按钮
$("#btn-search").click(function () {
    $("#table1").bootstrapTable("refresh", {url: "..."});

});

$("#save").click(function () {
    if(!$("#addForm").valid() ){
        return;
    }
    var _data = $("#addForm").values();
    _data.deptId=_data.deptId.replace("D","");
    var _url = interUrl.userManage.saveUpdate;
    comn.ajax({
        url: _url,
        data: _data,
        success: function(res) {
            $("#contractModal").modal("hide");
            $("#table1").bootstrapTable("refresh", {url: "..."});
        }
    });
});

function formatter_Inuser(value, rows, index) {
    return readDpData("yes_or_no", value);
}
function formatter_zw(value, rows, index) {
    return readDpData("zw", value);
}

viewMode = function(){
    $("#searchForm input[name='qid']").val(selectNode.id);
    $("#table1").bootstrapTable("refresh", {url: "..."});
};


function buildDomTree() {
    //let rootData={};
    let data = [];
    tempData={};
    let p0id=""
    let list=DeptData;
    $.each(list,function (i,o) {
        // delete o.checked
        // delete o.iconCls
        // delete o.state
        if(o.pid =='U0'){
            p0id=o.id;
        }
        if(o.pid.startsWith('U')){
            o.selectable=false;
        }
        let obj={
            id:o.id,
            text:o.text,
            pid:o.pid,
            selectable:o.pid.startsWith('U')?false:true,
            nodes:[]
        }
        tempData[o.id]=obj;
    });
    $.each(list,function (i,o) {
        let my=tempData[o.id];
        let p=tempData[o.pid];
        if(!p){
            return true;
        }
        // if(!p.nodes){
        //     p.nodes=[];
        // }
        p.nodes.push(my);
        tempData[p.id]=p;
    });
    let temp0=tempData[p0id];
   // walk(temp0);
    data.push(temp0)
    return data;
}

$("#deptSel").click(function() {
    let vis=$('#treeview').is(':visible');
    if(vis){
        $('#treeview').treeview('remove');
        $("#treeview").hide();
        return;
    }
    var options = {
        bootstrap2 : false,
        showTags : true,
        levels : 5,
        showCheckbox : true,
        checkedIcon : "glyphicon glyphicon-check",
        data : buildDomTree(),
        onNodeSelected : function(event, data) {
            $("#deptSel").val(data.text);
            $("#deptId").val(data.id);
            $("#treeview").hide();
        }
    };
    //$('#tree').treeview('remove');
    $('#treeview').treeview(options);
    $("#treeview").show();
});







jQuery.browser={}
$(function() {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        return jQuery.browser.version = RegExp.$1;
    }
    initTree();
})

