var args, zTreeOnClick, dataLoad_1, tableEvent_1, treeObj, tableD2;


jQuery.browser = {};

table_2 = function (params) {
    tableData(params, $.extend($("#searchForm").values(), {}), interUrl.gzrw.list);
};
//$("#table1").bootstrapTable(comn.table);
(function () {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        return jQuery.browser.version = RegExp.$1;
    }

    $("#table2").bootstrapTable($.extend(comn.table, {detailView: true, ajax: table_2}));
})();

args = comn.getArgs();




function formatter_zgrwzt(value, rows, index) {
    return readDpData("gzrw_zt", value);
}



$("#btn-search").click(function () {
    $("#table2").bootstrapTable("refresh", {url: "..."});
});




$('#table2').on('expand-row.bs.table', function (e, index, row, $detail) {
    var parentid = row.id;
    var cur_table = $detail.html('<table id="tt_' + parentid + '"></table>').find('table');
    let arr = row.gzjlList;
    if (!arr) {
        arr = []
    }
    $(cur_table).bootstrapTable({
        data: arr,
        method: 'get',
        ajax: void(0),

        // queryParams: { strParentID: parentid },

        //  ajaxOptions: { strParentID: parentid },

        clickToSelect: true,

        pagination: false, //是否显示分页（*）

        sortOrder: "asc", //排序方式

        pageNumber: 1, //初始化加载第一页，默认第一页

        height: 260,

        pageSize: 6, //每页的记录行数（*）

        pageList: [6, 12, 24, 48], //可供选择的每页的行数（*）


        paginationPreText: '<', //上下翻页

        paginationNextText: '>',

        columns: [{

            title: "序号",


            formatter: function (value, row, index) {

                return index + 1;

            },

            rowspan: 1,

            align: 'center',

            width: '50px'

        }, {

            field: 'x',
            checkbox: true,
            //visible:false,
            title: '',
            align: 'left',
            formatter:function (value,row,index) {
                if(row.shzt!=1){
                    return {disabled:true}
                }
            }

        }, {

            field: 'id',
            title: 'id',
            align: 'left',
            visible:false

        },{

            field: 'jhmc',

            title: '计划名称',

            align: 'left',

        }, {

            field: 'zm',

            title: '小组名称',

            align: 'center',

        }, {

            field: 'persionStr',

            title: '小组成员',

            align: 'right',

        },

            {

                field: 'tbzt',

                title: '填报状态',

                align: 'right',
                formatter: function (value, row, index) {
                    if(value==0){
                        return `<span class="text-muted">未填报</span>`
                    }else{
                        return `<span class="text-success">已填报</span>`
                    }

                }
            }, {

                field: 'shzt',

                title: '审核状态',

                align: 'right',
                formatter: function (value, row, index) {
                    if(value==0){
                        return '<span class="text-muted">未提交</span>'
                    }else if(value==1){
                        return '<span class="Pending-review">待审核</span>'
                    }else if(value==2){
                        return '<span class="text-muted">审核通过</span>'
                    }else if(value==3){
                        return '<span class="text-muted">驳回</span>'
                    }

                }

            },{

                field: 'aa',

                title: '操作',

                align: 'left',
                formatter:function(value,row,index){
                    if(row.shzt==1){
                        return `<a class="btna" onclick="checkApply('${row.id}')">审核</a>`
                    }else{
                        return "";
                    }

                }

            }

        ],


    });

});



$("#batchCheck").click(function () {
    var datas=$("#table2").bootstrapTable("getData", true);
    var selectdata=[]
    $.each(datas,function (i,o) {
       var d= $("#tt_"+o.id).bootstrapTable("getSelections");
       if(d.length>0){
           d.forEach(function (v,index) {
               selectdata.push(d);
           })
       }
    });
    if(selectdata.length==0){
        layer.alert("至少选择一个");
        return;
    }
    checkApply(selectdata.join(","))
});

function checkApply(ids) {
    comn.addTab({
        title: "审核工作任务",
        // href: "./Modal/bizywgl/gzrwedit.html?read=read&id="+item.id
        href: "./Modal/bizywgl/gzjlreview.html?ids="+ids

    });
}











