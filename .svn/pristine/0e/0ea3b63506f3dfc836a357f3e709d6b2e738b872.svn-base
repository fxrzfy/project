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
    }), interUrl.leave.list);
};

$("#addNew").click(function () {
    $("#addEditModal .modal-title").html("新增");
    $("#addEditModal").modal("show");
    $("#addForm input[name='deptName']").val(parent.user.deptName)
    $("#addForm input[name='deptId']").val(parent.user.deptId)
    $("#addForm input[name='workNumber']").val(parent.user.workNumber)
    $("#addForm input[name='name']").val(parent.user.name);
    $("#addForm input[name='jl']").attr("checked",false)
    $(".checktd").hide();
    $(".new").attr("disabled",false);
});


//查询按钮
$("#btn-search").click(function () {
    $("#table1").bootstrapTable("refresh", {url: "..."});
});





$("#save").click(function () {

    if(!$("#addForm").valid() ){
        return;
    }
    var _url = interUrl.leave.addEdit;
    var _data = $("#addForm").values();
    let jl=$("#addForm input[name='jl']:checked").val();
    if(jl||jl==0){
        _url=interUrl.leave.check;
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
    let arr=[];
    if(!row.zt ||row.zt==2){
        arr.push(`<a class='del btna'>删除</a>`);
        arr.push(`<a class='edit btna'>编辑</a>`);
        arr.push(`<a class='apply btna'>提交</a>`);
    }
    // if(!row.zt){
    //     arr.push(`<a class='apply btna'>提交</a>`);
    // }
    if(row.zt==0 || parent.user.roleMap['leave']){
        arr.push(`<a class='check btna'>审核</a>`);
    }
    return arr.join("")

};


tableEvent_1 = {
    "click .apply": function (a, val, item, d) {
        oppSureModal("确定提交审核么？");

        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.leave.apply,
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
                url: interUrl.leave.del,
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
        comn.ajax({
            url: interUrl.leave.get,
            data: {
                id: item.id
            },
            success: function (res) {
                $("#addEditModal").modal("show");
                $("#addForm input[name='jl']").attr("checked",false)
                $("#addEditModal .modal-title").html("编辑");
                $("#addForm").values(res.data);
                $(".new").attr("disabled",false);
                $(".checktd").hide();

            }
        });
    },
    "click .check": function (a, val, item, d) {
        comn.ajax({
            url: interUrl.leave.get,
            data: {
                id: item.id
            },
            success: function (res) {
                $("#addEditModal").modal("show");
                $("#addEditModal .modal-title").html("审核");
                $("#addForm input[name='jl']").attr("checked",false)
                $(".checktd").show();
                $(".new").attr("disabled",true);
                $("#addForm").values(res.data);

            }
        });
    }
}
$(".dd").datetimepicker({
    startView:2,minView:1,maxView:4,
    format:'yyyy-mm-dd hh:00',showMeridian:true,autoclose:true
});

$(".dd").change(function () {
    let v1=$(".dd").eq(0).val();
    let v2=$(".dd").eq(1).val();
    calDays(v1,v2);
});

function calDays(v1,v2){
    if(!v1 || !v2){
        return;
    }
    var begintime_ms = Date.parse(getDateTime(v1,1));
    var endtime_ms = Date.parse(getDateTime(v2,2));
    let range=endtime_ms-begintime_ms;
    if(begintime_ms<0){
        layer.alert("开始时间必须小于结束时间");
    }
    let days=range/(24*3600*1000);
    $("#addForm input[name='hjts']").val(days);
}

function getDateTime(str,type){
    var myDate=new Date()
    daystr=str.split(" ")[0];
    hstr=str.split(" ")[1];
    let h=parseInt(hstr.split(":")[0]);
    dayarr=daystr.split("-");
    if(type===1){//开始时间
        h=h<12?0:12;
    }
    let add=false;
    if(type===2){//结束时间
        h=h<12?12:0;
        if(h==0){
            add=true;
        }
    }
    myDate.setHours(h,0,0,0);
    myDate.setFullYear(dayarr[0],parseInt(dayarr[1])-1,dayarr[2]);
    if(add){
        myDate.setDate(myDate.getDate()+1);
    }
    return myDate;
}





