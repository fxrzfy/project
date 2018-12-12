var args, zTreeOnClick,dataLoad_1,tableEvent_1,  treeObj,back;

var hy_table1_line, hy_table2_line, ky_table1_line, ky_table2_line, ky_table3_line, lc_table1_line, lc_table2_line;

var hy_table1, hy_table2, ky_table1, ky_table2, ky_table3, lc_table1, lc_table2;

var dept_map={};

var hy_wtfl_options = parent.hy_wtfl_options,
    ky_wtfl_options = parent.ky_wtfl_options,
    lc_wtfl_options = parent.lc_wtfl_options,
    wtxd_options = parent.wtxd_options,
    ky_jcfl_options = parent.ky_jcfl_options,
    lc_jcfl_options = parent.lc_jcfl_options,
    lqk_options = parent.lqk_options;

var show_ty2, show_ty3;

var jcqk_empty={
    jcflId:'',field1:'',field2:'',field3:'',field4:'',field5:'',zt:0
},
    jtwt_empty={
    wtfl:'', wtxd:'',jtnr:'',zrdw:'',wtzt:0
    },
    lqsk_empty={
    jtnr:'',je:'',xqshrq:''
    };

var lx={
    0:'货运车站',1:'客运车站',2:'列车'
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


$('.jcsj').daterangepicker({
    "timePicker": false,
    "linkedCalendars": false,
    "autoUpdateInput": false,
    "locale": {
        format: 'YYYY-MM-DD',
        separator: ' - ',
        applyLabel: "确定",
        cancelLabel: "取消",
        resetLabel: "重置",
    }
},function() {
    if(!this.startDate){
        this.element.find('.sj').val('');
        this.element.find("input[name='jckssj']").val('');
        this.element.find("input[name='jcjssj']").val('');
    }else{
        var start = this.startDate.format(this.locale.format);
        var end = this.endDate.format(this.locale.format);
        this.element.find('.sj').val(start + this.locale.separator + end);
        this.element.find("input[name='jckssj']").val(start);
        this.element.find("input[name='jcjssj']").val(end);
    }
});



//货运中心
comn.ajax({
    url: interUrl.dict.zsztree,
    data: {typestr:'y'},
    success: function(res) {
        var options = "<option value=\'\'>--请选择--</option>";
        $.each(res.data, function(i, item){
            $.each(item.children,function(i, hyzx){
                dept_map[hyzx.id] = hyzx;
                options = options + "<option value=\'" + hyzx.id +"\'>" + hyzx.text+ "</option>";
            });
        });
        $("#hy_form select[name='ty1']").append(options);
        $("#hy_form select[name='ty1']").selectpicker('refresh');
    }
});
//直属站
comn.ajax({
    url: interUrl.dict.zsztree,
    data: {typestr:'x'},
    success: function(res) {
        var options = "<option value=\'\'>--请选择--</option>";
        $.each(res.data, function(i, item){
            $.each(item.children,function(i, data){
                $.each(data.children,function(i, zsz) {
                    dept_map[zsz.id] = zsz;
                    options = options + "<option value=\'" + zsz.id + "\'>" + zsz.text + "</option>";
                });
            });
        });
        $("#ky_form select[name='ty1']").append(options);
        $("#ky_form select[name='ty1']").selectpicker('refresh');
    }
});
//客运段
comn.ajax({
    url: interUrl.dict.zsztree,
    data: {typestr:'z'},
    success: function(res) {
        var options = "<option value=\'\'>--请选择--</option>";
        $.each(res.data, function(i, item){
            $.each(item.children,function(i, kyd){
                dept_map[kyd.id] = kyd;
                options = options + "<option value=\'" + kyd.id + "\'>" + kyd.text + "</option>";
            });
        });
        $("#lc_form select[name='ty1']").append(options);
        $("#lc_form select[name='ty1']").selectpicker('refresh');
    }
});

$("select[name='workNumber']").append(parent.jcry_options);
$("select[name='workNumber']").selectpicker('refresh');
$("select[name='workNumber']").change(function(e){
    $(this).parents('fieldset').find("input[name='jcry']").val($(this).find("option:selected").text());
});

$("#hy_form select[name='ty1']").change(function(e){
    var select = $(this).find("option:selected").val();
    var options = "<option value=\'\'>--请选择--</option>";
    if(select) {
        $.each(dept_map[select].children, function (i, item) {
            options = options + "<option value=\'" + item.id + "\'>" + item.text + "</option>";

        });
    }
    $("#hy_form select[name='ty2']").html(options);
    $("#hy_form select[name='ty2']").selectpicker('refresh');
    $("#hy_form select[name='ty3']").html('');
    $("#hy_form select[name='ty3']").selectpicker('refresh');

});

$("#hy_form select[name='ty2']").change(function(e){
    var select = $(this).find("option:selected").val();
    var options = "<option value=\'\'>--请选择--</option>";
    if(select) {
        comn.ajax({
            url: interUrl.dict.zdList,
            data: {zszId: select, type: 3},
            success: function (res) {
                $.each(res.data.data, function (i, item) {
                    options = options + "<option value=\'" + item.id + "\'>" + item.name + "</option>";
                });
                $("#hy_form select[name='ty3']").html(options);
                $("#hy_form select[name='ty3']").selectpicker('refresh');
                if(show_ty3){
                    $("#hy_form select[name='ty3']").selectpicker('val', show_ty3);
                    show_ty3 = undefined;
                }
            }
        });
    }
});

$("#ky_form select[name='ty1']").change(function(e){
    var select = $(this).find("option:selected").val();
    var options = "<option value=\'\'>--请选择--</option>";
    if(select) {
        comn.ajax({
            url: interUrl.dict.zdList,
            data: {zszId: select, type: dept_map[select].type},
            success: function (res) {
                $.each(res.data.data, function (i, item) {
                    options = options + "<option value=\'" + item.id + "\'>" + item.name + "</option>";
                });
                $("#ky_form select[name='ty2']").html(options);
                $("#ky_form select[name='ty2']").selectpicker('refresh');
                if(show_ty2){
                    $("#ky_form select[name='ty2']").selectpicker('val', show_ty2);
                    show_ty2 = undefined;
                }
            }
        });
    }

});
$("#lc_form select[name='ty1']").change(function(e){
    var select = $(this).find("option:selected").val();
    var options = "<option value=\'\'>--请选择--</option>";
    if(select) {
        $.each(dept_map[select].children, function (i, item) {
            options = options + "<option value=\'" + item.id + "\'>" + item.text + "</option>";

        });
    }
    $("#lc_form select[name='ty2']").html(options);
    $("#lc_form select[name='ty2']").selectpicker('refresh');

});
$("#lc_form select[name='ty2']").change(function(e){
    var select = $(this).find("option:selected").val();
    var options = "<option value=\'\'>--请选择--</option>";
    if(select) {
        comn.ajax({
            url: interUrl.dict.zdList,
            data: {zszId: select, type: 4},
            success: function (res) {
                $.each(res.data.data, function (i, item) {
                    options = options + "<option value=\'" + item.id + "\'>" + item.name + "</option>";
                });
                $("#lc_form select[name='ty3']").html(options);
                $("#lc_form select[name='ty3']").selectpicker('refresh');
                if(show_ty3){
                    $("#lc_form select[name='ty3']").selectpicker('val', show_ty3);
                    show_ty3 = undefined;
                }
            }
        });
    }
});




hy_table1= function (params) {
    $("#hy_table1").bootstrapTable({
        columns:[
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
                }
            },
            {
                field:'wtfl',
                title:'问题分类',
                formatter:function(value, row, index){
                    return '<select name="wtfl" class="selectpicker form-control required" data-live-search="true" data-container="body" index="' + index + '" field="wtfl" value="' +value+'">'+hy_wtfl_options +'</select>';
                },
            },
            {
                field:'wtxd',
                title:'问题项点',
                formatter:function(value, row, index){
                    var options ='';
                    if(wtxd_options[row.wtfl]){
                        options = wtxd_options[row.wtfl];
                    }
                    return '<select name="wtxd" class="selectpicker form-control required" data-live-search="true" data-container="body" index="' + index + '" field="wtxd">'+options+'</select>';
                },
            },
            {
                field:'jtnr',
                title:'具体内容',
                formatter:function(value, row, index){
                    return '<input class="form-control cell" field="jtnr" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'zyzrdw',
                title:'主要责任单位',
                formatter:function(value, row, index){
                    return '<input class="form-control cell" field="zyzrdw" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'xgzrdw',
                title:'相关责任单位',
                formatter:function(value, row, index){
                    return '<input class="form-control cell" field="xgzrdw" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'wtzt',
                title:'状态',
                align: 'center',
                formatter:function(value, row, index){
                    if(value==0){
                        return '<span class="label label-info">未用</span>';
                    }else{
                        return '<span class="label label-warning-light">已用</span>';
                    }

                }
            }
        ],
        formatNoMatches: function () {
            return '';
        }
    });
    $("#hy_table1").bootstrapTable("removeAll");
};

hy_table2= function (params) {
    $("#hy_table2").bootstrapTable({
        columns:[
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
                }
            },
            {
                field:'jtnr',
                title:'漏（欠）收款内容',
                formatter:function(value, row, index){
                    return '<select name="jtnr" class="selectpicker form-control required" data-live-search="true" data-container="body" index="' + index + '" field="jtnr" data-title="--请选择--">'+lqk_options+'</select>';
                }
            },
            {
                field:'je',
                title:'金额（元）',
                formatter:function(value, row, index){
                    return '<input class="form-control cell" field="je" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'xqshrq',
                title:'限定收回日期',
                editable: {
                    type: 'date',
                    clear: false,
                    emptytext: '请选择'
                }
            }
        ],
        formatNoMatches: function () {
            return '';
        }
    });
    $("#hy_table2").bootstrapTable("removeAll");
};

ky_table1= function (params) {
    $("#ky_table1").bootstrapTable({
        columns:[
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
                }
            },
            {
                field:'jcflId',
                title:'分类',
                formatter:function(value, row, index){
                    return '<select name="jcflId" class="selectpicker form-control required" data-live-search="true" data-container="body" index="' + index + '" field="jcflId" value="' +value+'">'+ ky_jcfl_options +'</select>';
                },

            },
            {
                field:'field1',
                title:'人(件)数',
                formatter:function(value, row, index){
                    if(value == undefined){
                        value='';
                    }
                    return '<input class="form-control cell" field="field1" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'field2',
                title:'重量（kg）',
                formatter:function(value, row, index){
                    if(value == undefined){
                        value='';
                    }
                    return '<input class="form-control cell" field="field2" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'field3',
                title:'补票款（元）',
                formatter:function(value, row, index){
                    if(value == undefined){
                        value='';
                    }
                    return '<input class="form-control cell" field="field3" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'field4',
                title:'区间',
                formatter:function(value, row, index){
                    if(value == undefined){
                        value='';
                    }
                    return '<input class="form-control cell" field="field4" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'field5',
                title:'票号',
                formatter:function(value, row, index){
                    if(value == undefined){
                        value='';
                    }
                    return '<input class="form-control cell" field="field5" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'zt',
                title:'状态',
                align: 'center',
                formatter:function(value, row, index){
                    if(value==0){
                        return '<span class="label label-primary">未用</span>';
                    }else{
                        return '<span class="label label-warning-light">已用</span>';
                    }

                }
            }
        ],
        formatNoMatches: function () {
            return '';
        }
    });
    $("#ky_table1").bootstrapTable("removeAll");
};

ky_table2= function (params) {
    $("#ky_table2").bootstrapTable({
        columns:[
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
                }
            },
            {
                field:'wtfl',
                title:'问题分类',
                formatter:function(value, row, index){
                    return '<select name="wtfl" class="selectpicker form-control required" data-live-search="true" data-container="body" index="' + index + '" field="wtfl" value="' +value+'">'+ky_wtfl_options +'</select>';
                },
            },
            {
                field:'wtxd',
                title:'问题项点',
                formatter:function(value, row, index){
                    return '<select name="wtxd" class="selectpicker form-control required" data-live-search="true" data-container="body" index="' + index + '" field="wtxd"></select>';
                },
            },
            {
                field:'jtnr',
                title:'具体内容',
                formatter:function(value, row, index){
                    return '<input class="form-control cell" field="jtnr" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'zrdw',
                title:'责任单位',
                formatter:function(value, row, index){
                    return '<input class="form-control cell" field="zrdw" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'wtzt',
                title:'状态',
                align: 'center',
                formatter:function(value, row, index){
                    if(value==0){
                        return '<span class="label label-info">未用</span>';
                    }else{
                        return '<span class="label label-warning-light">已用</span>';
                    }

                }
            }
        ],
        formatNoMatches: function () {
            return '';
        }
    });
    $("#ky_table2").bootstrapTable("removeAll");
};

ky_table3=function(params){
    $("#ky_table3").bootstrapTable({
        columns:[
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
                }
            },
            {
                field:'jtnr',
                title:'漏（欠）收款内容',
                formatter:function(value, row, index){
                    return '<select name="jtnr" class="selectpicker form-control required" data-live-search="true" data-container="body" index="' + index + '" field="jtnr" data-title="--请选择--">'+lqk_options+'</select>';
                },
            },
            {
                field:'je',
                title:'金额（元）',
                formatter:function(value, row, index){
                    return '<input class="form-control cell" field="je" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'xqshrq',
                title:'限定收回日期',
                editable: {
                    type: 'date',
                    clear: false,
                    emptytext: '请选择'
                }
            }
        ],
        formatNoMatches: function () {
            return '';
        }
    });
    $("#ky_table3").bootstrapTable("removeAll");
};

lc_table1= function (params) {
    $("#lc_table1").bootstrapTable({
        columns:[
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
                }
            },
            {
                field:'jcflId',
                title:'分类',
                formatter:function(value, row, index){
                    return '<select name="jcflId" class="selectpicker form-control required" data-live-search="true" data-container="body" index="' + index + '" field="jcflId" value="' +value+'">'+lc_jcfl_options +'</select>';
                },

            },
            {
                field:'field1',
                title:'人(件)数',
                formatter:function(value, row, index){
                    if(value == undefined){
                        value='';
                    }
                    return '<input class="form-control cell" field="field1" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'field2',
                title:'重量（kg）',
                formatter:function(value, row, index){
                    if(value == undefined){
                        value='';
                    }
                    return '<input class="form-control cell" field="field2" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'field3',
                title:'补票款（元）',
                formatter:function(value, row, index){
                    if(value == undefined){
                        value='';
                    }
                    return '<input class="form-control cell" field="field3" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'field4',
                title:'区间',
                formatter:function(value, row, index){
                    if(value == undefined){
                        value='';
                    }
                    return '<input class="form-control cell" field="field4" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'field5',
                title:'票号',
                formatter:function(value, row, index){
                    if(value == undefined){
                        value='';
                    }
                    return '<input class="form-control cell" field="field5" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'zt',
                title:'状态',
                align: 'center',
                formatter:function(value, row, index){
                    if(value==0){
                        return '<span class="label label-info">未用</span>';
                    }else{
                        return '<span class="label label-warning-light">已用</span>';
                    }

                }
            }

        ],
        formatNoMatches: function () {
            return '';
        }
    });
    $("#lc_table1").bootstrapTable("removeAll");
};

lc_table2= function (params) {
    $("#lc_table2").bootstrapTable({
        columns:[
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
                }
            },
            {
                field:'wtfl',
                title:'问题分类',
                formatter:function(value, row, index){
                    return '<select name="wtfl" class="selectpicker form-control required" data-live-search="true" data-container="body" index="' + index + '" field="wtfl" value="' +value+'">'+lc_wtfl_options +'</select>';
                },
            },
            {
                field:'wtxd',
                title:'问题项点',
                formatter:function(value, row, index){
                    return '<select name="wtxd" class="selectpicker form-control required" data-live-search="true" data-container="body" index="' + index + '" field="wtxd"></select>';
                },
            },
            {
                field:'jtnr',
                title:'具体内容',
                formatter:function(value, row, index){
                    return '<input class="form-control cell" field="jtnr" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'zrdw',
                title:'责任单位',
                formatter:function(value, row, index){
                    return '<input class="form-control cell" field="zrdw" index="'+index+'" value="'+value+'"/>';
                },
            },
            {
                field:'wtzt',
                title:'状态',
                align: 'center',
                formatter:function(value, row, index){
                    if(value==0){
                        return '<span class="label label-info">未用</span>';
                    }else{
                        return '<span class="label label-warning-light">已用</span>';
                    }

                }
            }
        ],
        formatNoMatches: function () {
            return '';
        }
    });
    $("#lc_table2").bootstrapTable("removeAll");
};

hy_table1_line = 0;
ky_table2_line = 0;
lc_table2_line = 0;
ky_table1_line = 0;
lc_table1_line = 0;
hy_table2_line = 0;
ky_table3_line = 0;
var hy_table1_data = {},ky_table2_data={},lc_table2_data={};
var ky_table1_data = {},lc_table1_data ={};
var hy_table2_data = {},ky_table3_data ={};
$(".add").click(function(){
    var data, table, type;
    var id = $(this).attr("id");
    var row;
    if(id == 'hy_table1_add'){
        table = $("#hy_table1");
        row = $.extend(true, {}, jtwt_empty);
        row.index = hy_table1_line++;
        type = 'wt';
    }else if(id == 'ky_table2_add'){
        table = $("#ky_table2");
        row = $.extend(true, {}, jtwt_empty);
        row.index = ky_table2_line++;
        type = 'wt';
    }else if(id == 'lc_table2_add'){
        table = $("#lc_table2");
        row = $.extend(true, {}, jtwt_empty);
        row.index = lc_table2_line++;
        type = 'wt';
    }else if(id == 'ky_table1_add'){
        table = $("#ky_table1");
        row = $.extend(true, {}, jcqk_empty);
        row.index = ky_table1_line++;
        type = 'jc';
    }else if(id == 'lc_table1_add'){
        table = $("#lc_table1");
        row = $.extend(true, {}, jcqk_empty);
        row.index = lc_table1_line++;
        type = 'jc';
    }else if(id == 'hy_table2_add'){
        table = $("#hy_table2");
        row = $.extend(true, {}, lqsk_empty);
        row.index = hy_table2_line++;
        type = 'lqk';
    }else if(id == 'ky_table3_add'){
        table = $("#ky_table3");
        row = $.extend(true, {}, lqsk_empty);
        row.index = ky_table3_line++;
        type = 'lqk';
    }

    table.bootstrapTable('append', row);
    data = table.bootstrapTable('getData');
    if(type == 'wt') {
        wt_display(table, data);
        table.find(".selectpicker").on('changed.bs.select',function(e){
            var data;
            var id = $(this).parents('.table').attr("id");
            if(id == 'hy_table1'){
                hy_table1_data = $(this).parents('.table').bootstrapTable('getData');
                data = hy_table1_data;
            }else if(id == 'ky_table2'){
                ky_table2_data = $(this).parents('.table').bootstrapTable('getData');
                data = ky_table2_data;
            }else if(id == 'lc_table2'){
                lc_table2_data = $(this).parents('.table').bootstrapTable('getData');
                data = lc_table2_data;
            }
            //data = $(this).parents('.table').bootstrapTable('getData');
            data[$(this).attr('index')][$(this).attr('field')] = $(this).val();
            if($(this).attr('field') == 'wtfl'){
                $(this).parents('tr').find("select[name='wtxd']").html('');
                if(wtxd_options[$(this).val()]){
                    $(this).parents('tr').find("select[name='wtxd']").html(wtxd_options[$(this).val()]);
                }
                $(this).parents('tr').find("select[name='wtxd']").selectpicker('refresh');

            }
        });
    }else if(type == 'jc'){
        jc_display(table, data);
        table.find(".selectpicker").on('changed.bs.select',function(e){
            var data;
            var id = $(this).parents('.table').attr("id");
            if(id == 'ky_table1'){
                ky_table1_data = $(this).parents('.table').bootstrapTable('getData');
                data = ky_table1_data;
            }else if(id == 'lc_table1'){
                lc_table1_data = $(this).parents('.table').bootstrapTable('getData');
                data = lc_table1_data;
            }
            data[$(this).attr('index')][$(this).attr('field')] = $(this).val();
        });
    }else if(type == 'lqk'){
        lqk_display(table, data);
        table.find(".selectpicker").on('changed.bs.select',function(e){
            var data;
            var id = $(this).parents('.table').attr("id");
            if(id == 'hy_table2'){
                hy_table2_data = $(this).parents('.table').bootstrapTable('getData');
                data = hy_table2_data;
            }else if(id == 'ky_table3'){
                ky_table3_data = $(this).parents('.table').bootstrapTable('getData');
                data = ky_table3_data;
            }
            data[$(this).attr('index')][$(this).attr('field')] = $(this).val();
        });
    }

});

$(document).on('change', 'table input', function() {
    if($(this).attr("type")=='checkbox'){
        return;
    }
    var data,type;
    var id = $(this).parents('.table').attr("id");
    if(id == 'hy_table1'){
        hy_table1_data =  $(this).parents('.table').bootstrapTable('getData');
        data = hy_table1_data;
        type = 'wt';
    }else if(id == 'ky_table2'){
        ky_table2_data =  $(this).parents('.table').bootstrapTable('getData');
        data = ky_table2_data;
        type = 'wt';
    }else if(id == 'lc_table2'){
        lc_table2_data =  $(this).parents('.table').bootstrapTable('getData');
        data = lc_table2_data;
        type = 'wt';
    }else if(id == 'ky_table1'){
        ky_table1_data =  $(this).parents('.table').bootstrapTable('getData');
        data = ky_table1_data;
        type = 'jc';
    }else if(id == 'lc_table1'){
        lc_table1_data =  $(this).parents('.table').bootstrapTable('getData');
        data = lc_table1_data;
        type = 'jc';
    }else if(id == 'hy_table2'){
        hy_table2_data =  $(this).parents('.table').bootstrapTable('getData');
        data = hy_table2_data;
        type = 'lqk';
    }else if(id == 'ky_table3'){
        ky_table3_data =  $(this).parents('.table').bootstrapTable('getData');
        data = ky_table3_data;
        type = 'lqk';
    }
    //data = $(this).parents('.table').bootstrapTable('getData');
    data[$(this).attr('index')][$(this).attr('field')] = $(this).val();
    if(type == 'wt') {
        wt_display($(this).parents('.table'), data);
    }else if(type == 'jc'){
        jc_display($(this).parents('.table'), data);
    }else if(type == 'lqk'){
        lqk_display($(this).parents('.table'), data);
    }
    // var count = $(this).parents('.table').bootstrapTable('getData').length;
    // for(var i=0;i<count;i++){
    //     $(this).parents('.table').find("select[name='wtfl'][index='"+i+"']").selectpicker();
    //     $(this).parents('.table').find("select[name='wtxd'][index='"+i+"']").selectpicker();
    //     $(this).parents('.table').find("select[name='wtfl'][index='" + i + "']").selectpicker('val', data[i].wtfl);
    //     if(wtxd_options[data[i].wtfl]){
    //         $(this).parents('.table').find("select[name='wtxd'][index='" + i + "']").html(wtxd_options[data[i].wtfl]);
    //     }
    //     $(this).parents('.table').find("select[name='wtxd'][index='" + i + "']").selectpicker('refresh');
    //     $(this).parents('.table').find("select[name='wtxd'][index='" + i + "']").selectpicker('val', data[i].wtxd);
    // }

});

// hy_table2_line = 0;
// $("#hy_table2_add").click(function(){
//     var row = $.extend(true, {}, lqsk_empty);
//     row.index = hy_table2_line++;
//     $("#hy_table2").bootstrapTable('append', row);
// });
// ky_table1_line = 0;
// $("#ky_table1_add").click(function(){
//     var row = $.extend(true, {}, jcqk_empty);
//     row.index = ky_table1_line++;
//     $("#ky_table1").bootstrapTable('append', row);
//
// });
//
// ky_table3_line = 0;
// $("#ky_table3_add").click(function(){
//     var row = $.extend(true, {}, lqsk_empty);
//     row.index = ky_table3_line++;
//     $("#ky_table3").bootstrapTable('append', row);
// });
// lc_table1_line = 0;
// $("#lc_table1_add").click(function(){
//     var row = $.extend(true, {}, jcqk_empty);
//     row.index = lc_table1_line++;
//     $("#lc_table1").bootstrapTable('append', row);
//
// });




$(".del").click(function(){
    var table = $(this).parent().siblings().find(".table");
    var indexes = $.map(table.bootstrapTable("getSelections"), function (row) {
        return row.index;
    });
    table.bootstrapTable('remove', {
        field: 'index',
        values: indexes
    });
    var id = $(this).attr("id");
    if(id == 'hy_table1_del'){
        hy_table1_data = table.bootstrapTable('getData');
        wt_display(table, hy_table1_data);
    }else if(id == 'ky_table2_del'){
        ky_table2_data = table.bootstrapTable('getData');
        wt_display(table, ky_table2_data);
    }else if(id == 'lc_table2_del'){
        lc_table2_data = table.bootstrapTable('getData');
        wt_display(table, lc_table2_data);
    }else if(id == 'ky_table1_del'){
        ky_table1_data = table.bootstrapTable('getData');
        jc_display(table, ky_table1_data);
    }else if(id == 'lc_table1_del'){
        lc_table1_data = table.bootstrapTable('getData');
        jc_display(table, lc_table1_data);
    }else if(id == 'hy_table2_del'){
        hy_table2_data = table.bootstrapTable('getData');
        lqk_display(table, hy_table2_data);
    }else if(id == 'ky_table3_del'){
        ky_table3_data = table.bootstrapTable('getData');
        lqk_display(table, ky_table3_data);
    }



});

//问题分类显示
function wt_display(table, data){
    var count = table.bootstrapTable('getData').length;
    for(var i=0;i<count;i++){
        table.find("select[name='wtfl'][index='"+i+"']").selectpicker();
        table.find("select[name='wtxd'][index='"+i+"']").selectpicker();
        table.find("select[name='wtfl'][index='" + i + "']").selectpicker('val', data[i].wtfl);
        if(wtxd_options[data[i].wtfl]){
            table.find("select[name='wtxd'][index='" + i + "']").html(wtxd_options[data[i].wtfl]);
        }
        table.find("select[name='wtxd'][index='" + i + "']").selectpicker('refresh');
        table.find("select[name='wtxd'][index='" + i + "']").selectpicker('val', data[i].wtxd);
    }
}

//检查分类显示
function jc_display(table, data){
    var count = table.bootstrapTable('getData').length;
    for(var i=0;i<count;i++){
        table.find("select[name='jcflId'][index='" + i + "']").selectpicker();
        table.find("select[name='jcflId'][index='" + i + "']").selectpicker('val', data[i].jcflId);
    }
}

//漏欠款显示
function lqk_display(table, data){
    var count = table.bootstrapTable('getData').length;
    for(var i=0;i<count;i++){
        table.find("select[name='jtnr'][index='" + i + "']").selectpicker();
        table.find("select[name='jtnr'][index='" + i + "']").selectpicker('val', data[i].jtnr);
    }
}


$("#save1").click(function(){
    if($("#hy_form").valid()==false)return;
    var data = {};
    data.gzxs = $('#hy_form').serializeObject();
    data.gzxsJtwtList = $("#hy_table1").bootstrapTable("getData");
    data.gzxsRqktzsList = $("#hy_table2").bootstrapTable("getData");
    reload_table(data);
});

$("#save2").click(function(){
    var data = {};
    data.gzxs = $('#ky_form').serializeObject();
    data.gzxsJcqkbList = $("#ky_table1").bootstrapTable("getData");
    data.gzxsJtwtList = $("#ky_table2").bootstrapTable("getData");
    data.gzxsRqktzsList = $("#ky_table3").bootstrapTable("getData");
    reload_table(data);
});

$("#save3").click(function(){
    var data = {};
    data.gzxs = $('#lc_form').serializeObject();
    data.gzxsJcqkbList = $("#lc_table1").bootstrapTable("getData");
    data.gzxsJtwtList = $("#lc_table2").bootstrapTable("getData");
    reload_table(data);
});

function reload_table(data){
    comn.ajax({
        url: interUrl.gzxsManager.add,
        data: JSON.stringify(data),
        contentType : "application/json",
        success: function(res) {
            tip({content:"操作成功"});
            comn.closeCurrentTab();
        }
    });
}

hy_table1();
hy_table2();
ky_table1();
ky_table2();
ky_table3();
lc_table1();
lc_table2();

if(args.id){
    showDetail(args.id);
}

function showDetail(id){
    comn.ajax({
        url: interUrl.gzxsManager.get,
        data: {
            id: id
        },
        success: function (res) {
            var data = res.data;
            var tab_title,tab, wt_table,jc_table,lqk_table;
            if(data.gzxs.lx==1){
                tab_title = $('#lx_tab a[href="#tab1"]');
                tab = $("#tab1");
                $("#hy_form").values(data.gzxs);
                wt_table = $("#hy_table1");
                lqk_table = $("#hy_table2");
            }else if(data.gzxs.lx==2){
                tab_title = $('#lx_tab a[href="#tab2"]');
                tab = $("#tab2");
                $("#ky_form").values(data.gzxs);
                jc_table = $("#ky_table1");
                wt_table = $("#ky_table2");
                lqk_table = $("#ky_table3");
            }else if(data.gzxs.lx==3){
                tab_title = $('#lx_tab a[href="#tab3"]');
                tab = $("#tab3");
                $("#lc_form").values(data.gzxs);
                jc_table = $("#lc_table1");
                wt_table = $("#lc_table2");
            }
            tab_title.tab('show');
            tab.find('select[name="jcfl"]').selectpicker();
            tab.find('select[name="jcfl"]').selectpicker('val', data.gzxs.jcfl);
            tab.find(".sj").val(tab.find("input[name='jckssj']").val()+ ' - ' + tab.find("input[name='jcjssj']").val());
            tab.find('select[name="workNumber"]').selectpicker();
            tab.find('select[name="workNumber"]').selectpicker('val', data.gzxs.workNumber);
            tab.find('select[name="ty1"]').selectpicker();
            tab.find('select[name="ty1"]').selectpicker('val',data.gzxs.ty1).trigger("change");
            tab.find('select[name="ty2"]').selectpicker();
            tab.find('select[name="ty2"]').selectpicker('val',data.gzxs.ty2).trigger("change");
            show_ty2 = data.gzxs.ty2;
            show_ty3 = data.gzxs.ty3;
            if(data.gzxsJtwtList.length) {
                wt_table.bootstrapTable('load', data.gzxsJtwtList);
                wt_display(wt_table, data.gzxsJtwtList);
            }
            if(data.gzxsRqktzsList.length) {
                lqk_table.bootstrapTable('load', data.gzxsRqktzsList);
                lqk_display(lqk_table, data.gzxsRqktzsList);
            }
            if(data.gzxsJcqkbList.length){
                jc_table.bootstrapTable('load', data.gzxsJcqkbList);
                jc_display(jc_table, data.gzxsJcqkbList);
            }
            $('.add').hide();
            $('.del').hide();
            $('.save').hide();

        }
    });
};
