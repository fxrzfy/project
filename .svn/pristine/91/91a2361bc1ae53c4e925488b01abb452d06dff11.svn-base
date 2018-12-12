var args, zTreeOnClick,dataLoad_1,tableEvent_1,  treeObj;



jQuery.browser = {};

(function() {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        return jQuery.browser.version = RegExp.$1;
    }
    $("#qdate").daterangepicker({
    });

    $("#table1").bootstrapTable({
        dataType: "json",
        method: 'get',
        contentType: "application/x-www-form-urlencoded",
        cache: false,
        //url:"../data/mergeData.json",
        columns:[
            [
                {
                    field: 'name',
                    title: "序号",
                    valign:"middle",
                    align:"center",
                    colspan: 1,
                    rowspan: 2
                },
                {
                    field: 'name',
                    title: "项目",
                    valign:"middle",
                    align:"center",
                    colspan: 1,
                    rowspan: 2
                },



                {
                    title: "检查车站",
                    valign:"middle",
                    align:"center",
                    colspan: 2,
                    rowspan: 1
                },
                {
                    title: "检查列车",
                    valign:"middle",
                    align:"center",
                    colspan: 2,
                    rowspan: 1
                },
                {
                    title: "合计",
                    valign:"middle",
                    align:"center",
                    colspan: 2,
                    rowspan: 1
                }
            ],
            [
                {
                    field: 'mideaNum',
                    title: '件数',
                    valign:"middle",
                    align:"center"
                },
                {
                    field: 'mideaPercent',
                    title: '补款（元）',
                    valign:"middle",
                    align:"center"
                },
                {
                    field: 'panasonicNum',
                    title: '件数',
                    valign:"middle",
                    align:"center"
                },
                {
                    field: 'panasonicPercent',
                    title: '补款（元）',
                    valign:"middle",
                    align:"center"
                },
                {
                    field: 'panasonicNum',
                    title: '件数',
                    valign:"middle",
                    align:"center"
                },
                {
                    field: 'panasonicPercent',
                    title: '补款（元）',
                    valign:"middle",
                    align:"center"
                }
            ]
        ]
    })


})();

args = comn.getArgs();



table_1 = function (params) {
    tableData(params, $.extend($("#searchForm").values(), {
        isProcessed: false
    }), interUrl.roleManage.dataGrid);
};


//查询按钮
$("#btn-search").click(function () {
    $("#table1").bootstrapTable("refresh", {url: "..."});

});







