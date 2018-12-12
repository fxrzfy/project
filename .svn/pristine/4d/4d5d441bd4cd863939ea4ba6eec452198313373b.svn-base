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

    // $(function() {
    //
    //     $('input[name="datefilter"]').daterangepicker({
    //         autoUpdateInput: false,
    //         locale: {
    //             cancelLabel: 'Clear'
    //         }
    //     });
    //
    //     $('input[name="datefilter"]').on('apply.daterangepicker', function(ev, picker) {
    //         $(this).val(picker.startDate.format('MM/DD/YYYY') + ' - ' + picker.endDate.format('MM/DD/YYYY'));
    //     });
    //
    //     $('input[name="datefilter"]').on('cancel.daterangepicker', function(ev, picker) {
    //         $(this).val('');
    //     });
    //
    // });

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
    string += "<li><a class='view'>查看</a></li>";
    if(row.rwzt==0||row.rwzt==4){
        string += "<li><a class='zf'>作废</a></li>";
    }
    if(row.rwzt!=4){
        string += "<li><a class='edit'>编辑</a></li>";
    }

    return ["<div class='btn-group btn-group-xs'>", "<button type='button' class='btn btn-primary'>操作</button>", "<button type='button' class='btn btn-primary dropdown-toggle' data-toggle='dropdown'>", "<span class='caret'></span>", "<span class='sr-only'>下拉切换</span>", "</button>", "<ul class='dropdown-menu' role='menu'>",  string, "</ul>", "</div>"].join("");
};

function formatter_zgrwzt(value, rows, index) {
    return readDpData("gzrw_zt", value);
}

tableEvent_1 = {
    "click .view": function (a, val, item, d) {
        return  comn.addTab({
            title: "查看工作任务",
            href: "./Modal/bizywgl/gzrwedit.html?read=read&id="+item.id
        });
    },
    "click .del": function (a, val, item, d) {
        oppSureModal("确定刪除么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.roleManage.del,
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
        return  comn.addTab({
            title: "编辑工作任务",
            href: "./Modal/bizywgl/gzrwedit.html?id="+item.id
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






$("#addNew").click(function () {
    return  comn.addTab({
        title: "新增工作任务",
        href: "./Modal/bizywgl/gzrwedit.html"
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


$("#delAll").click(function () {
    var ids = $.map($("#table1").bootstrapTable('getSelections'), function (row) {
        return row.id;
    });
    if (ids.length < 1) {
        layer.alert("请至少选择一行来操作");
        return;
    }
    oppSureModal("确定刪除么？");
    $("#sureOption").unbind("click").click(function (){
        comn.ajax({
            url: interUrl.gzrw.delGzrw,
            data: {ids: ids.join(",")},
            success: function (res) {
                $("#table1").bootstrapTable("refresh", {url: "..."});
                layer.msg("操作成功");
                $("#sureModal").modal("hide");
            }
        });
    });


});

function formater_qszt(value, row, index){
    if(value==0){
        return `<a class="unsign"></a>`;
    }else{
        return `<a class="sign"></a>`;
    }
}



$("#qsStatus").click(function () {
    var ids = $.map($("#table1").bootstrapTable('getSelections'), function (row) {
        return row.id;
    });
    if (ids.length < 1) {
        layer.alert("请至少选择一行来操作");
        return;
    }
    if (ids.length > 1) {
        layer.alert("只能选择一条");
        return;
    }
    let  tableConfig=comn.table;
    tableConfig.columns= [ {
        field: 'name',
        title: '签收人'
    }, {
        field: 'qssj',
        title: '签收时间'
    }, {
        field: 'qszt',
        title: '签收状态',
        formatter:formater_qszt
    } ]
    delete tableConfig.height;
    tableConfig.pagination=false;
    $("#signInfo").modal("show");
    $("#signInfoDiv").html("");
    comn.ajax({
        url: interUrl.gzrw.getSignstatus,
        data: {id: ids[0]},
        success: function (res) {
           for( k in res.data){
                  let x= ` <div style="text-align:left;"> <h4>${k}</h4></div><table id="tab_${k}" class="table"></table>`
               $("#signInfoDiv").append(x);
               tableConfig.data=res.data[k];
               $("#tab_"+k).bootstrapTable("removeAll");
               $("#tab_"+k).bootstrapTable(tableConfig);
           }
        }
    });


});











