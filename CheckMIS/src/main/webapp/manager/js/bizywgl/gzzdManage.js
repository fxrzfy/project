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
    }), interUrl.gzzd.list);
};

$("#addNew").click(function () {

    // $("#addEditModal .modal-title").html("新增");
    // $("#addEditModal").modal("show");
    // $("#addForm input[name='deptName']").val(parent.user.deptName)
    // $("#addForm input[name='deptId']").val(parent.user.deptId)
    // $("#addForm input[name='workNumber']").val(parent.user.workNumber)
    // $("#addForm input[name='name']").val(parent.user.name);
    // $("#addForm input[name='jl']").attr("checked",false)
    // $(".checktd").hide();
    // $(".new").attr("disabled",false);
    // comn.addTab({
    //             title: "新增文档",
    //             href: "./Modal/bizywgl/createDoc.html?read=read&id=1"
    // });
    //window.open("/addDoc.jsp", "_blank");
    comn.addTab({
        title: "规章制度维护",
        href: "./Modal/bizywgl/gzzdEdit.html"
    });

});


//查询按钮
$("#btn-search").click(function () {
    refreshData();
});


function refreshData(){
    $("#table1").bootstrapTable("refresh", {url: "..."});
}


$("#save").click(function () {

    if(!$("#addForm").valid() ){
        return;
    }
    var _url = interUrl.gzzd.addEdit;
    var _data = $("#addForm").values();
    var jl=$("#addForm input[name='jl']:checked").val();
    if(jl||jl==0){
        _url=interUrl.gzzd.check;
        if(jl==0){
            _data.zt=2;
            if(!_data.shyj){
                layer.alert('审核意见不能为空');
                return;
            }
        }else{
            _data.zt=1;
        }
    }
     comn.ajax({
        url: _url,
        data: _data,
        success: function(res) {
            $("#addEditModal").modal("hide");
            $("#table1").bootstrapTable("refresh", {url: "..."});
        }
    });
});
function formatter_zt(value, row, index) {
    if(value==0){
        return "待审核";
    }else if(value==1){
        return "审核通过";
    }else if(value==2){
        return "驳回";
    }else{
        return "";
    }
}
function formatter_type(value, row, index) {
    if(value==0){
        return "事假";
    }else if(value==1){
        return "病假";
    }else if(value==2){
        return "婚假";
    }else{
        return "其他";
    }
}
function handle_1(value, row, index) {
    var arr=[];
    if(!row.zt ||row.zt==2){
        arr.push("<a class='del btna'>删除</a>");
        arr.push("<a class='edit btna'>编辑</a>");
        arr.push("<a class='apply btna'>提交</a>");
    }
    // if(!row.zt){
    //     arr.push(`<a class='apply btna'>提交</a>`);
    // }
    if(row.zt==0 || parent.user.roleMap['gzzd']){
        arr.push("<a class='check btna'>审核</a>");
    }
    return arr.join("")

};


tableEvent_1 = {
    "click .apply": function (a, val, item, d) {
        oppSureModal("确定提交审核么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.gzzd.apply,
                data: {
                    id: item.id
                },
                success: function (resp) {
                    tip({content:"操作成功"});
                    $("#sureModal").modal("hide");
                    $("#addForm input[name='jl']").attr("checked",false)
                    $("#table1").bootstrapTable("refresh", {url: "..."});

                }
            });
        });
    },
    "click .del": function (a, val, item, d) {
        oppSureModal("确定刪除么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.gzzd.del,
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
    "click .edit": function (a, val, item, d) {
        window.open("/addDoc.jsp?id="+item.id, "_blank");
    },
    "click .check": function (a, val, item, d) {
        window.open("/addDoc.jsp?id="+item.id+"&type=check", "_blank");
    }
}









