var args, zTreeOnClick,dataLoad_1,tableEvent_1,  treeObj;



jQuery.browser = {};

(function() {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        return jQuery.browser.version = RegExp.$1;
    }
   //$('.username').editable();
})();

args = comn.getArgs();



table_1 = function (params) {
    tableData(params, $.extend($("#searchForm").values(), {
        isProcessed: false
    }), interUrl.teamManage.list);
};

function updatedata(params){
    comn.ajax({
        url: interUrl.teamManage.updateField,
        data: params,
        success: function (resp) {
            tip({content:"操作成功"});
            $("#table1").bootstrapTable("refresh", {url: "..."});
        }
    });
}

$('#table1').on('load-success.bs.table', function (row, $element, field) {
    $('.nametxt').editable({
        type: "text",                //编辑框的类型。支持text|textarea|select|date|checklist等
        title: "组名",              //编辑框的标题
        disabled: false,             //是否禁用编辑
        pk:row.id,
        url:updatedata,
        emptytext: "空文本",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
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
        url:updatedata,
        emptytext: "空文本",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
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
        url:updatedata,
        emptytext: "空文本",          //空值的默认文本
        mode: "popup",              //编辑框的模式：支持popup和inline两种模式，默认是popup
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




// $('#table1').on('editable-save.bs.table',  function (field, row, oldValue, $el) {
//     console.log(field);
//     console.log(row);
//     console.log(oldValue);
//     console.log($el);
// });

$('#table1').on('editable-save.bs.table',  function (field, row, oldValue, $el) {
  //  $(field).editable({'validate':validate_empty});
  //   console.log(field);
  //   console.log(row);
  //   console.log(oldValue);
  //   console.log($el);
});
// $('#table1').on('editable-shown.bs.table',  function (field, row, $el) {
//     //$(field).editable({'validate':validate_empty});
//     console.log(field);
//     console.log(row);
//     console.log(oldValue);
//     console.log($el);
// });




function handle_1(value, row, index) {
    var string = "";
    string += "<li><a class='del'>删除</a></li>";
    string += "<li><a class='grant'>授权</a></li>";
    return ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary'>操作</button>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>", "<li><a class='modify'>编辑</a></li>", string, "</ul>", "</div>"].join("");
};
function editableName(value, row, index) {
    return '<a style="border:0;" class="nametxt" data-pk="'+row.id+'" id="name">'+ value +'</a>';
};
function editableSort(value, row, index) {
    return '<a style="border:0;" class="sorttxt" data-pk="'+row.id+'" id="sort">'+ value +'</a>';
};
function editablekey(value, row, index) {
    return '<a style="border:0;" class="keytxt" data-pk="'+row.id+'" id="key">'+ value +'</a>';
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
                url: interUrl.teamManage.updateField,
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
        openTree(item.id);
        $("#grantModal").modal("show");
        $("#selectedRoleId").val(item.id);
    }
}


$("#addNew").click(function () {
    $("#addEditModal .modal-title").html("新增");
    $("#addEditModal").modal("show");


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
    _data=$.extend(_data, {pcode: $("#pcode").val() });
    var _url = interUrl.teamManage.addDetail;
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





