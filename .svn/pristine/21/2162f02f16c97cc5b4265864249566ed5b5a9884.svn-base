var args, zTreeOnClick,dataLoad_1,tableEvent_1,  treeObj,tableD2;



jQuery.browser = {};

(function() {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        return jQuery.browser.version = RegExp.$1;
    }
    //$("#table2").bootstrapTable($.extend(comn.table, {"pagination":false}));
    $(".dr").daterangepicker({autoUpdateInput:false,locale:comn.drlocale
    });
    $('.dr').on('apply.daterangepicker', function(ev, picker) {
        $(this).val(picker.startDate.format('YYYY-MM-DD') + '----' + picker.endDate.format('YYYY-MM-DD'));
    });

    $('.dr').on('cancel.daterangepicker', function(ev, picker) {
        $(this).val('');
    });
})();

args = comn.getArgs();


table_1 = function (params) {
    tableData(params, $.extend($("#searchForm").values(), {
        isProcessed: false
    }), interUrl.gzrw.list);
};

$("#btn-search").click(function () {
    $("#table1").bootstrapTable("refresh", {url: "..."});
});



function handle_1(value, row, index) {
    var string = "";
    let operate=""
    if(row.gzjlList){
        $.each(row.gzjlList,function (i,obj) {
            if(obj.workNumber==parent.user.workNumber){
                if(obj.id){
                    operate+=`<li><a class='view' data-workNumber="${obj.workNumber}" data-id="${obj.id}">查看本组计划</a></li>`;
                    if(obj.shzt==0||obj.shzt==2){
                        string+= `<a class='addPlan   btn btn-primary' data-id="${obj.id}" data-xzid='${obj.xzid}' >填报计划</a>`;
                        string+=`<a class='edit  btn btn-primary' data-id="${obj.id}">编辑</a>`;
                        string+=`<a class='del  btn btn-primary' data-id="${obj.id}">删除</a>`;
                    }
                }else{
                    string+= `<button type='button' class='addPlan   btn btn-primary' data-workNumber="${obj.workNumber}" data-xzid='${obj.xzid}'>填报计划</button>`;
                }
            }else{
                if(obj.id){
                    operate += `<li><a class='view ' data-workNumber="${obj.workNumber}" data-id='${obj.id}' >查看${obj.zm}计划</a></li>`;
                }

            }
        });
    }
    let s="";
    if(operate && operate!=""){
       s = ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary '>查看</button>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>",  operate, "</ul>", "</div>"].join("");
    }
    return `<div class='btn-group btn-group-xs'>`+ string+`<div>`+s;
};

function formatter_zgrwzt(value, rows, index) {
    return readDpData("gzrw_zt", value);
}

tableEvent_1 = {
    "click .view": function (a, val, item, d) {
        let workNumber=$(a.target).attr("data-workNumber");
        let planid=$(a.target).attr("data-id");
        return  comn.addTab({
            title: "查看工作任务",
           // href: "./Modal/bizywgl/gzrwedit.html?read=read&id="+item.id
            href: "./Modal/bizywgl/gzjledit.html?"+"id="+planid+"&view=read&workNumber="+workNumber
        });
    },
    "click .addPlan": function (a, val, item, d) {
        let planid=$(a.target).attr("data-id");
        if(!planid){
            planid=-1;
        }
        let xzid=$(a.target).attr("data-xzid");
        let workNumber=$(a.target).attr("data-workNumber");
        return  comn.addTab({
            title: "填报计划",
            href: "./Modal/bizywgl/gzjledit.html?pre=1&gzrwId="+item.id+"&id="+planid+"&xzid="+xzid+"&workNumber="+workNumber
        });
    },
    "click .del": function (a, val, item, d) {
        oppSureModal("确定刪除么？");
        $("#sureOption").unbind("click").click(function (){
            let otarget=$(a.target);
            comn.ajax({
                url: interUrl.gzjl.deleteGzjl,
                data: {
                    id: otarget.attr("data-id")
                },
                success: function (resp) {
                    $("#sureModal").modal("hide");
                    $("#table1").bootstrapTable("refresh", {url: "..."});
                    tip({content:"操作成功"});


                }
            });
        });
    },
    "click .edit": function (a, val, item, d) {
        let planid=$(a.target).attr("data-id");
        return  comn.addTab({
            title: "编辑工作计划",
            href: "./Modal/bizywgl/gzjledit.html?id="+planid+"&edit=edit"
        });
    },
    "click .zf": function (a, val, item, d) {
        //openTree(item.id);
        $("#zfModal").modal("show");
        comn.ajax({
            url: interUrl.gzrw.getById,
            data: {
                id: item.id
            },
            success: function (res) {
                $("#addEditModal").modal("show");
                $("#zfForm").values(res.data);
            }
        });
       // $("#selectedRoleId").val(item.id);
    }
}






$("#addPlan").click(function () {
    return  comn.addTab({
        title: "工作计划添加",
        href: "./Modal/bizywgl/gzjledit.html"
    });

});

$("#save").click(function () {
    if(!$("#zfForm").valid() ){
        return;
    }
    var _data = $("#zfForm").values();
    var _url = interUrl.gzrw.zfRw;
    comn.ajax({
        url: _url,
        data: _data,
        success: function(res) {
            $("#zfModal").modal("hide");
            $("#table1").bootstrapTable("refresh", {url: "..."});
        }
    });
});


// $("#delAll").click(function () {
//     return  comn.addTab({
//         title: "新增工作任务",
//         href: "./Modal/bizywgl/gzrwedit.html"
//     });
//
// });





$("#qsStatus").click(function () {
    return  comn.addTab({
        title: "新增工作任务",
        href: "./Modal/bizywgl/gzrwedit.html"
    });



});











