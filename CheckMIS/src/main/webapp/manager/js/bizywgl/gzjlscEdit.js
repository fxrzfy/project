var args, table_hy;
var zd = parent.zd, zzdw = parent.zzdw;
var gzxs={};
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

table_hy = function (params) {
    tableData(params, $.extend(this.$body.parents(".tab-pane").find(".searchForm").values(), {
        isProcessed: false
    }), interUrl.gzjlsc.groupList);
};

function id_formatter(value, row, index) {
    return index+1;
}

function jcsj_formatter(value, row, index) {
    return row.jckssj+' - ' +row.jcjssj;
}

function hy_bcdw_formatter(value, row, index) {
    var dw = '';
    if(row.ty1 && zzdw[row.ty1]){
        dw += zzdw[row.ty1].name;
    }
    if(row.ty2 && zd[row.ty2]){
        dw += zd[row.ty2].name;
    }
    return dw;
}

function count_formatter(value, row, index){
    return row.ids.split(',').length;
}


var wt_columns = [
    {
        field:'id',
        title:'选择',
        checkbox:true
    },
    {
        field:'index',
        title:'序号',
        formatter:function(value, row, index){
            return index+1;
        },
        width : '5%'
    },
    {
        field:'jtnr',
        title:'具体问题'
    },
    {
        field:'',
        title:'检查人',
        formatter:function(value, row, index){
            return gzxs[row.gzxsId].jcry;
        },
        width : '10%'
    },
    {
        field:'wtzt',
        title:'状态',
        formatter:function(value, row, index){
            if(value==0){
                return '<span class="label label-info">未用</span>';
            }else{
                return '<span class="label label-warning-light">已用</span>';
            }

        },
        width : '5%'
    }

];

var jc_columns = [
    {
        field:'id',
        title:'选择',
        checkbox:true
    },
    {
        field:'index',
        title:'序号',
        formatter:function(value, row, index){
            return index+1;
        },
        width : '5%'
    },
    {
        field:'jcqk',
        title:'检查情况',
        formatter:function(value, row, index){
            var jxqk = bouncer([row.field1, row.field2, row.field3, row.field4, row.field5]);
            return jxqk.join(',');
        }
    },
    {
        field:'jcry',
        title:'检查人',
        formatter:function(value, row, index){
            return gzxs[row.gzxsId].jcry;
        },
        width : '10%'

    },
    {
        field:'zt',
        title:'状态',
        formatter:function(value, row, index){
            if(value==0){
                return '<span class="label label-info">未用</span>';
            }else{
                return '<span class="label label-warning-light">已用</span>';
            }

        },
        width : '5%'
    }
];

var lqk_columns = [
    {
        field:'id',
        title:'选择',
        checkbox:true
    },
    {
        field:'index',
        title:'序号',
        formatter:function(value, row, index){
            return index+1;
        },
        width : '5%'
    },
    {
        field:'nr',
        title:'漏(欠)收款内容'
    },
    {
        field:'je',
        title:'金额'
    },
    {
        field:'xqshrq',
        title:'限定收回日期'
    },
    {
        field: '',
        title: '检查人',
        formatter:function(value, row, index){
            return gzxs[row.gzxsId].jcry;
        },
        width : '15%'
    }
];

$("table").on("expand-row.bs.table", function(e, index, row, $detail){
    comn.ajax({
        url: interUrl.gzjlsc.groupDetail,
        data: {ids:row.ids},
        success: function(res) {
            var data = res.data
            $.each(data.gzxsList, function(i, o){
                gzxs[o.id] = o;
            });
            if(data.gzxsJcqkbList.length>0){
                build_table($detail.append('<br><table id="ky_jc"></table>').find('#ky_jc'), jc_columns, data.gzxsJcqkbList);
            }
            if(data.gzxsJtwtList.length>0){
                build_table($detail.append('<br><table id="ky_wt"></table>').find('#ky_wt'), wt_columns, data.gzxsJtwtList);
            }
            if(data.gzxsRqktzsList.length>0){
                build_table($detail.append('<br><table id="ky_rqk"></table>').find('#ky_rqk'), lqk_columns, data.gzxsRqktzsList);
            }
        }
    });

});

function build_table($el, columns, data){
    $el.bootstrapTable({
        columns: columns,
        data: data
    });

}

function bouncer(arr) {
    return arr.filter(function(val){
        return !(!val || val === "");
    });
}