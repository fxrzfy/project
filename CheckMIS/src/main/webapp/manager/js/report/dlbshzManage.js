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







