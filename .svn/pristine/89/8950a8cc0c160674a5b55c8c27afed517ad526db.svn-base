var args, zTreeOnClick,dataLoad_1,tableEvent_1,  treeObj,back;

var hy_table1_line, hy_table2_line, ky_table1_line, ky_table2_line, ky_table2_line, lc_table1_line, lc_table2_line;

var hy_table1, hy_table2, ky_table1, ky_table2, ky_table3, lc_table1, lc_table2;

var dept_map={};


var jcqk_empty={
    fl:'',rjs:'',zl:'',bpk:'',qj:'',ph:'',zt:0
},
    jtwt_empty={
    wtfl:'', wtxd:'',jtnr:'',zrdw:'',zt:0
    },
    lqsk_empty={
    jtnr:'',je:'',xqshrq:''
    };

var lx={
    1:'货运车站',2:'客运车站',3:'列车'
};

jQuery.browser = {};

(function() {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        return jQuery.browser.version = RegExp.$1;
    }
    //$("#table2").bootstrapTable($.extend(comn.table, {"pagination":false}));
})();

args = comn.getArgs();

$('.datepicker').datetimepicker({format: 'yyyy-mm-dd',autoclose:true,minView:2});


table_gzxs = function (params) {
    tableData(params, $.extend($("#searchForm").values(), {
        isProcessed: false
    }), interUrl.gzxsManager.dataGrid);
};

function lx_formatter(value, row, index) {
    return lx[value];
}

function jcsj_formatter(value, row, index) {
    if(row.jckssj){
        row.jckssj = row.jckssj.split(' ')[0];
    }
    if(row.jcjssj){
        row.jcjssj = row.jcjssj.split(' ')[0];
    }
    return row.jckssj + ' - ' + row.jcjssj;
}

function jcfl_formatter(value, row, index) {
    return readDpData("st_jcfs", value);
}

function jcxq_formatter(value, row, index) {
    return '<a class="detail"></a>'
}

jcxq_event ={
    "click .detail": function (a, val, item, d) {
        comn.closeTabByUrl('./Modal/bizywgl/gzxsEdit.html');
        return comn.addTab({
            title: "查看工作写实",
            href: "./Modal/bizywgl/gzxsEdit.html?id=" + item.id
        });
    }
}

//查询按钮
$("#btn-search").click(function () {
    $("#table_gzxs").bootstrapTable("refresh", {url: "..."});

});


$("#add").click(function () {
    comn.closeTabByUrl('./Modal/bizywgl/gzxsEdit.html');
    return  comn.addTab({
        title: "新增工作写实",
        href: "./Modal/bizywgl/gzxsEdit.html"
    });



});


$("#del").click(function(){
    var rows= $("#table_gzxs").bootstrapTable('getSelections');
    if(rows.length>0){
        var ids=[];
        rows.forEach(function(value,index,array){
            ids.push(value.id);
        })
        comn.ajax({
            url: interUrl.gzxsManager.delete,
            data: {ids: ids.join(',')},
            success: function(res) {
                if(res.code = 20000) {
                    tip({content: "操作成功"});
                    $("#table_gzxs").bootstrapTable("refresh");
                }
            }
        });

    }else{
        tip({content:"请选中一行"});
    }

});


//货运问题分类
comn.ajax({
    url: interUrl.dict.wentitree,
    data: {type:2},
    success: function(res) {
        var hy_wtfl_options = "<option value=\'\'>--请选择--</option>";
        $.each(res.data, function(i, wt){
            hy_wtfl_options = hy_wtfl_options + "<option value=\'" + wt.id + "\'>" + wt.wtms + "</option>";
        });
        parent.hy_wtfl_options = hy_wtfl_options;
    }
});
//客运问题分类
comn.ajax({
    url: interUrl.dict.wentitree,
    data: {type:1},
    success: function(res) {
        var ky_wtfl_options = "<option value=\'\'>--请选择--</option>";
        $.each(res.data, function(i, wt){
            ky_wtfl_options = ky_wtfl_options + "<option value=\'" + wt.id + "\'>" + wt.wtms + "</option>";
        });
        parent.ky_wtfl_options = ky_wtfl_options;
    }
});
//列车问题分类
comn.ajax({
    url: interUrl.dict.wentitree,
    data: {type:3},
    success: function(res) {
        var lc_wtfl_options = "<option value=\'\'>--请选择--</option>";
        $.each(res.data, function(i, wt){
            lc_wtfl_options = lc_wtfl_options + "<option value=\'" + wt.id + "\'>" + wt.wtms + "</option>";
        });
        parent.lc_wtfl_options = lc_wtfl_options;
    }
});
//问题项点

comn.ajax({
    url: interUrl.dict.wentiwtxList,
    data: {wtflId:0},
    success: function(res) {
        var wtxd_options={};
        $.each(res.data.data, function(i, wtxd){
            if(!wtxd_options[wtxd.wtflId]) {
                wtxd_options[wtxd.wtflId] = "<option value=\'\'>--请选择--</option>";
            }
            wtxd_options[wtxd.wtflId] = wtxd_options[wtxd.wtflId] + "<option value=\'" + wtxd.id + "\'>" + wtxd.wtxsm + "</option>";
        });
        parent.wtxd_options = wtxd_options;
    }
});

//客运检查分类
comn.ajax({
    url: interUrl.jcfl.list,
    data: {type:2},
    success: function(res) {
        var ky_jcfl_options = "<option value=\'\'>--请选择--</option>";
        $.each(res.data, function(i, jc){
            ky_jcfl_options = ky_jcfl_options + "<option value=\'" + jc.id + "\'>" + jc.jcflmc + "</option>";
        });
        parent.ky_jcfl_options = ky_jcfl_options;
    }
});
//列车检查分类
comn.ajax({
    url: interUrl.jcfl.list,
    data: {type:3},
    success: function(res) {
        var lc_jcfl_options = "<option value=\'\'>--请选择--</option>";
        $.each(res.data, function(i, jc){
            lc_jcfl_options = lc_jcfl_options + "<option value=\'" + jc.id + "\'>" + jc.jcflmc + "</option>";
        });
        parent.lc_jcfl_options = lc_jcfl_options;
    }
});
//漏欠款
comn.ajax({
    url: interUrl.dict.lqskree,
    success: function(res) {
        var lqk_options ='';
        var lqk = {};
        $.each(res.data, function(i, item){
            item.child=[];
            lqk[item.id] = item;
        });
        comn.ajax({
            url: interUrl.dict.lqskxdList,
            data: {lqsknrflId:0},
            success: function(res) {
                $.each(res.data.data, function(i, item){
                    lqk[item.lqsknrflId].child.push(item);
                });
                $.each(lqk, function(i, item){
                    lqk_options = lqk_options+"<optgroup label='"+item.name+"'>";
                    $.each(item.child, function(i, child){
                        lqk_options = lqk_options + "<option value=\'" + child.id + "\'>" + child.name + "</option>";
                    });
                    lqk_options = lqk_options+"</optgroup>";
                });
                parent.lqk_options = lqk_options;
            }

        });
    }
});

//稽查人员
comn.ajax({
    url: interUrl.userManage.list,
    data: {deptType:0},
    success: function(res) {
        var jcry_options = "";
        $.each(res.data, function(i, jcry){
            jcry_options = jcry_options + "<option value=\'" + jcry.workNumber + "\'>" + jcry.name + "</option>";
        });
        parent.jcry_options = jcry_options;
    }
});
