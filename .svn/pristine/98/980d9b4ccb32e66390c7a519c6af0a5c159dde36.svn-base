var args, table_gzjlsc;
var zd = {}, zzdw = {};
var lx={
    0:'货运车站',1:'客运车站',2:'列车'
};

args = comn.getArgs();


table_gzjlsc = function (params) {console.log(params);
    tableData(params, $.extend($("#searchForm").values(), {
        isProcessed: false
    }), interUrl.gzjlsc.dataGrid);
};

function lx_formatter(value, row, index) {
    return lx[value];
}

$("#btn-search").click(function () {
    $("#table_gzjlsc").bootstrapTable("refresh", {url: "..."});

});


$("#add").click(function(){
    comn.addTab({
        title: "新增工作记录",
        href: "./Modal/bizywgl/gzjlscEdit.html"
    });
});

comn.ajax({
    url: interUrl.dict.zdAll,
    success: function(res) {
        $.each(res.data.zd, function(i, o){
            zd[o.id] = o;
        });
        $.each(res.data.zzdw, function(i, o){
            zzdw[o.id] = o;
        });
        parent.zd = zd;
        parent.zzdw = zzdw;
    }
});