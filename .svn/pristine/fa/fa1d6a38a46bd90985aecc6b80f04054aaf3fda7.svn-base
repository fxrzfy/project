var args, zTreeOnClick, dataLoad_1, tableEvent_1, treeObj, tableD2, myData = false;


jQuery.browser = {};
pageData = {};
args = comn.getArgs();

if (args.id > 0) {
    $("#addForm input[name='id'] ").val(args.id);
}
if (args.view) {
    if (args.workNumber == parent.user.workNumber) {
        myData = false;
        $("#apply").hide();
        $("#addPlan").hide();
        $(".saveGzjl").hide();
        $("#copy").hide();
        $("#export").show();
    } else {
        $("#apply").hide();
        $("#addPlan").hide();
        //$("#copy").show();
        $(".saveGzjl").hide();
    }
} else {
    myData = true;
    $("#apply").show();
    $("#addPlan").show();
    $(".saveGzjl").show();
    $("#copy").hide();
}
// if (args.read) {
//     $("input").attr("disabled", "disabled");
//     $("#gzrwId").attr("disabled",false);
//     $("textarea").attr("disabled", "disabled");
//     $("input[type='button']").addClass("hide");
//     $("button").addClass("hide");
// }
(function () {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        return jQuery.browser.version = RegExp.$1;
    }

    $("#addForm input[name='rwmc'] ").attr("readonly", "readonly");
    $("#addForm input[name='jhbh'] ").attr("readonly", "readonly");
    $("#addForm input[name='zm'] ").attr("readonly", "readonly");
    $("#sshzt").attr("readonly", "readonly");


    comn.ajax({
        url: interUrl.gzjl.getById,
        data: {
            id: args.id, gzrwId: args.gzrwId, gzrwxzId: args.xzid
        },
        success: function (res) {
            $("#addForm").values(res.data);
            //$("#addForm input[name='xzid'] ").val(args.xzid);
            $("#addForm input[name='workNumber'] ").val(args.workNumber);
            //$("#addForm input[name='gzrwId'] ").val(args.gzrwId);
            if (res.data.shzt == 0) {
                $("#sshzt").val("未提交");
            } else if (res.data.shzt == 1) {
                $("#sshzt").val("待审核");
            } else if (res.data.shzt == 2) {
                $("#sshzt").val("审核通过");
            } else if (res.data.shzt == 3) {
                $("#sshzt").val("驳回");
            }
            if (args.view && res.data.copytarget > 0 && args.workNumber != parent.user.workNumber) {
                $("#copytarget").val(res.data.copytarget);
                $("#copy").show();
            }
            //
        }
    });

    var houthtml = "";
    let sed = ""
    for (x = 0; x < 24; x++) {
        if (x == 8) {
            sed = "selected"
        } else {
            sed = ""
        }
        houthtml += `<option value="${format2d(x)}" ${sed}>${format2d(x)}</option>`
    }
    var minthtml = "";
    for (x = 0; x < 60; x++) {
        minthtml += `<option value="${format2d(x)}">${format2d(x)}</option>`
    }
    $(".shour").html(houthtml);
    $(".sminute").html(minthtml);
})();

function format2d(x) {
    if (x < 10) {
        return "0" + x;
    }
    return x;
}


tablemain = function (params) {
    var data = $.extend($("#addForm").values(), {})
    let edit = args['edit']
    if (edit) {
        data.edit = edit;
    }
    tableData(params, data, interUrl.gzjl.gzjlmxList);
};

tablejccz = function (params) {

    tableData(params, $.extend({"id": $("#jhmxid").val()}, {}), interUrl.gzjl.selectJccz);
};
tablejclc = function (params) {
    tableData(params, $.extend({"id": $("#jhmxid").val()}, {isSelectEd: 1}), interUrl.gzjl.selectJclc);
};

function handle_1(value, row, index) {
    if (!myData) {
        return "";
    }
    return `<a class='del' data-id="${row.id}">删除</a></li>`;
};

function handle_2(value, row, index) {
    if (!myData) {
        return "";
    }
    if (row.jhlx == 0) {
        return `<a class='edit'>编辑</a></li>`;
    } else {
        return `<a class='edit btna '>编辑</a></li> <a class='del btna'>删除</a></li>`;
    }
};

// tableTemp = function (params) {
//     params.complete();
//     // if($("#tmid").val()<0){
//     //     return;
//     // }
//     // tableData(params, $.extend($("#peopleNewAddForm").values(), {isSelectEd:0}) , interUrl.gzrw.ryList);
// };

tableEvent_1 = {
    "click .del": function (a, val, item, d) {
        $("#tablecz").bootstrapTable('removeByUniqueId', item.id);
    }

}

function handle_lc(value, row, index) {
    return `<a class='edit btna'>编辑</a></li>` + `<a class='del btna' >删除</a></li>`;
};
tableEvent_lc = {
    "click .del": function (e, value, row, index) {
        $("#tablelc").bootstrapTable('removeByUniqueId', row.id);
    },
    "click .edit": function (e, value, row, index) {
        showEditlc(index, row);
        //$("#tablelc").bootstrapTable('removeByUniqueId', item.id);
    }

}

tableEvent_222 = {
    "click .del": function (a, val, item, d) {
        comn.ajax({
            url: interUrl.gzjl.deleteGzjlMx,
            data: {id: item.gzjlId},
            success: function (res) {
                $("#tablemain").bootstrapTable("refresh", {url: "..."});
            }
        });
    },
    "click .edit": function (a, val, item, d) {
        addEdit(item.gzjlId);
    }

}

function editCz(value, row, index) {
    if (!value) {
        value = '';
    }
    return `<a  onclick="showselect(${index},'cdzdcz','${value}')">选择车站</a>${value}`;
};

function editSj(value, row, index) {
    if (!row.daterange) {
        row.daterange = ""
    }
    return `<a  onclick="showselect(${index},'daterange','${row.daterange}')">选择时间</a>${row.daterange}`;
};

function editZd(value, row, index) {
    if (!value) {
        value = "";
    }
    return `<a  onclick="showselect(${index},'jczd','${value}')">编辑重点</a>${value}`;
};

function showGrant(id) {
    if (!checkCando()) {
        return;
    }
    if (id < 0) {
        layer.alert("请先选择组名");
        return;
    }
    $("#grantModal").modal("show");
    $("#tmgzrwId").val(args.id);
    $("#tmid").val(id);
    $("#tableRyNew").bootstrapTable(comn.table);
    $("#tableRyNew").bootstrapTable("refresh", {url: "..."});
    $("#tableRySelect").bootstrapTable("refresh", {url: "..."});
    $("#tableRyNoSelect").bootstrapTable("refresh", {url: "..."});
}

function showselect(id, type, v) {
    $("#editselect").modal("show");
    $("#addTemForm").reset;
    $("#pindex").val(id);
    $("#ptype").val(type);
    $(".ts").css('display', 'none');
    $(".cz").css('display', 'none');
    $("#tempaddstr").val("");
    $("#zastr").val("");
    $("#tempadd").val("");
    if (type == 'daterange') {
        $(".ts").show();
        $(".cz").hide();
        $(".zd").hide();
        $("#editselect .modal-title").html("选择时间");
        $("#addTemForm label").html("时间");
        $("#tempadd").attr("placeholder", "选择");
        if (v) {
            let arr = v.split("-");
            let sarr = arr[0].split(":");
            let earr = arr[1].split(":");
            $("#sh1").val(sarr[0]);
            $("#sm1").val(sarr[1]);
            $("#sh2").val(earr[0]);
            $("#sm2").val(earr[1]);
        }
        return;
    }
    if (type == 'jczd') {
        $("#editselect .modal-title").html("编辑检查重点");
        $("#addTemForm label").html("检查重点");
        $(".ts").css('display', 'none');
        $(".cz").hide();
        $(".zd").show();
    }
    if (type == 'cdzdcz') {
        $(".ts").css('display', 'none');
        $(".cz").show();
        $(".zd").hide();
        name2Id = []
        $("#tempaddstr").typeahead({
            source: function (query, process) {
                comn.ajax({
                    url: interUrl.dict.suggestList,
                    data: {type: type, name: query},
                    success: function (res) {
                        var array = [];
                        $.each(res.data, function (index, ele) {
                            name2Id[ele.value] = ele.data;//键值对保存下来。
                            array.push(ele.value);
                        });
                        process(array);
                    }
                });
            },//数据源
            items: 8,//最多显示个数
            updater: function (item) {
                return item;
            },
            displayText: function (item) {
                return `${item}:${name2Id[item]}`;
            },
            afterSelect: function (item) {
                $("#tempadd").val(name2Id[item]);
                name2Id = {};
            },
            delay: 500//延迟时间
        });
    }
}

$("#addcz").click(function () {
    var data = $("#tablecz").bootstrapTable("getData", true);
    let tempid = data.length + 1;

    empty = []
    $.each(data, function (i, o) {
        if (!o.jccz || o.jccz == '') {
            empty.push(1);
        }
        if (!o.daterange || o.daterange == '') {
            empty.push(1);
        }
    });
    if (empty.length > 0) {
        layer.alert("请先完善新添加检查车站记录");
        return;
    }
    var data = {id: -tempid};
    $("#tablecz").bootstrapTable('append', data);
});
$("#export").click(function () {
    var downLink = interUrl.basic + interUrl.gzjl.exportgzjl + "?gzjlId=" + $("#gzjlid").val();
    window.open(downLink, "_blank");
});

function showEditlc(index, item) {
    $("#addlcModel").modal('show');
    $(".ts").show();
    $("#lcindex").val(index);
    if (index < 0) {
        $("#lcbz").val("上海局");
        $(".sminute").val("00");
        $(".shour").val("08");
    } else {
        $("#addlcForm").values(item);
        if (item.jcsj) {
            s1 = item.jcsj.split("-");
            if (s1.length == 2) {
                $("#sh11").val(s1[0].split(":")[0]);
                $("#sm11").val(s1[0].split(":")[1]);
                $("#sh22").val(s1[1].split(":")[0]);
                $("#sm22").val(s1[1].split(":")[1]);
            }
        }
        $("#lcddd").val(item.ddd);
        console.log(item);
    }
    name2Id = []
    $("#ddd").typeahead({
        source: function (query, process) {
            comn.ajax({
                url: interUrl.dict.suggestList,
                data: {type: $("#lcbz").val(), name: query},
                success: function (res) {
                    var array = [];
                    $.each(res.data, function (index, ele) {
                        name2Id[ele.value] = ele.data;//键值对保存下来。
                        array.push(ele.value);
                    });
                    process(array);
                }
            });
        },//数据源
        items: 8,//最多显示个数
        updater: function (item) {
            return item;
        },
        displayText: function (item) {
            return `${item}:${name2Id[item]}`;
        },
        afterSelect: function (item) {
            $("#lcddd").val(name2Id[item]);
            name2Id = {};
        },
        delay: 500//延迟时间
    });
}


$("#addlc").click(function () {
    showEditlc(-1);
});

$("#addlcBtn").click(function () {
    if (!$("#addlcForm").valid()) {
        return;
    }
    let v1 = $("#sh11").val();
    let v2 = $("#sm11").val();
    let v3 = $("#sh22").val();
    let v4 = $("#sm22").val();
    if (v1 > v3 || (v1 == v3 && v2 >= v4)) {
        layer.alert("开始时间不能大于等于结束时间");
        return;
    }
    let result = `${v1}:${v2}-${v3}:${v4}`;
    let data = $("#addlcForm").values();
    data.jcsj = result;
    if (data.bz == '上海局') {
        data.ddd = $("#lcddd").val();
    }
    let pindex = $("#lcindex").val();
    if (pindex < 0) {
        $("#tablelc").bootstrapTable('append', data);
    } else {
        $("#tablelc").bootstrapTable('updateRow', {index: pindex, row: data});
    }

    $("#addlcModel").modal('hide');
});

function addEdit(id) {
    $("#grantModal").modal('show');
    if (id) {
        $("#jhmxid").val(id);
        comn.ajax({
            url: interUrl.gzjl.getGzmxById,
            data: {"id": id},
            success: function (res) {
                $("#addPlanForm").values(res.data);
                for (i = 0; i < 3; i++) {
                    $("input:radio[name='jhlx']").eq(i).val(i);
                }
                //$("input:radio[name='jhlx']").eq(res.data.jhlx).attr("checked","checked");
                $("input:radio[name='jhlx']").eq(res.data.jhlx).trigger("click");
                $("#tablecz").bootstrapTable("refresh", {url: "..."});
                $("#tablelc").bootstrapTable("refresh", {url: "..."});
                //$("input:radio[name='jhlx']").
            }
        });
    }
    $(".oterhdiv").hide();
    $(".work").hide();
    $("#addPlanForm").clearForm(true);
    let tbOption = $.extend(comn.table, {"height": "200"});
    $("#tablecz").bootstrapTable(tbOption);
    $("#tablelc").bootstrapTable(tbOption);
    $("#tablecz").bootstrapTable("removeAll");
    $("#tablelc").bootstrapTable("removeAll");
}

$("#addPlan").click(function () {
    let gzjlid = $("#gzjlid").val();
    if (!gzjlid || gzjlid < 1) {
        layer.alert("请先保存工作交路信息");
        return;
    }
    addEdit();
});
$(".btntype").unbind('click').click(function () {
    let v = $(".btntype:checked").val();
    if (v == '0') {
        $(".oterhdiv").hide();
        $(".work").show();
    } else {
        $(".oterhdiv").show();
        $(".work").hide();

        if(v==1){
            $("#addPlanForm textarea[name ='bz']").val("休息");
            $("#addPlanForm textarea[name ='bz']").attr("readonly",true);
        }else{
            $("#addPlanForm textarea[name ='bz']").val("");
            $("#addPlanForm textarea[name ='bz']").attr("readonly",false);
        }
    }
});


function validcz(row) {
    console.log(row)
    if (!row.jccz || row.jccz == '') {
        layer.alert("检查车站不能为空");
        return false;
    }
    return true;
}

function validlc(row) {
    if (1 == 1) {
        return true;
    }
    return false;
}

$(".saveGzjl").click(function () {
    if (!$("#addForm").valid()) {
        return;
    }
    let _this = $(this);
    var _data = $("#addForm").values();
    var _url = interUrl.gzjl.addEditGzjl;
    comn.ajax({
        url: _url,
        data: _data,
        success: function (res) {
            let closeDta=$(_this).attr("data-id");
            let op='';
            let surl="./Modal/bizywgl/gzjlManage.html";
            if (closeDta) {
                op='closeCurrent';
            } else {
                $("#gzjlid").val(res.data.id);
                $("#jhbh").val(res.data.jhbh);
                $("#shzt").val("待审核");
            }
            if(args["pre"]!=1){
                surl="./Modal/bizywgl/gzjlreview.html";
            }
            pageRefreshTo(surl, op);
            //$("#addEditModal").modal("hide");
            // $("#table1").bootstrapTable("refresh", {url: "..."});
        }
    });
});

$("#savePlan").click(function () {
    if (!$("#addPlanForm").valid()) {
        return;
    }
    let formData = $("#addPlanForm").values();
    formData.jhlx = formData.jhlx[0];
    formData.xzid = $("#xzid").val();
    formData.gzjlId = $("#gzjlid").val();
    if (formData.jhlx == 0) {
        let datacz = $("#tablecz").bootstrapTable("getData", true);
        let datalc = $("#tablelc").bootstrapTable("getData", true);
        let valid = false;
        let validRow = 0;
        if (datalc.length > 0) {
            $.each(datalc, function (i, o) {
                if (validlc(o)) {
                    validRow++;
                    valid = true;
                } else {
                    valid = false;
                }
            });
            //formData.datalc=JSON.stringify(datalc);
            formData.datalc = datalc;
        }
        if (datacz.length > 0) {
            $.each(datacz, function (i, o) {
                if (validcz(o)) {
                    validRow++;
                    valid = true;
                } else {
                    valid = false;
                }
            })
            //formData.datacz=JSON.stringify(datacz);
            formData.datacz = datacz;
        }
        if (!valid) {
            return;
        }
        if (validRow == 0) {
            layer.alert("检查车站和检查列车至少选择一个");
            return;
        }
        if (!valid) {
            return;
        }

    }
    console.log(formData)
    comn.ajax({
        url: interUrl.gzjl.addGzjlMx,
        data: formData,
        success: function (res) {
            $("#grantModal").modal("hide");
            $("#tablemain").bootstrapTable("refresh", {url: "..."});
            tip({content: "操作成功"});
        }
    });
});


$("#sureDate").click(function () {
    let pt = $("#ptype").val();
    var data = $("#tablecz").bootstrapTable("getData", true);
    var pindex = $("#pindex").val();
    let row = data[pindex];
    if (pt == 'daterange') {
        let v1 = $("#sh1").val();
        let v2 = $("#sm1").val();
        let v3 = $("#sh2").val();
        let v4 = $("#sm2").val();
        if (v1 > v3 || (v1 == v3 && v2 >= v4)) {
            layer.alert("开始时间不能大于等于结束时间");
            return;
        }
        let result = `${v1}:${v2}-${v3}:${v4}`;
        row.daterange = result;
    }
    //console.log(pt)

    if (pt == 'cdzdcz') {
        row.jccz = $("#tempadd").val();
    }
    if (pt == 'jczd') {
        row.jczd = $("#zastr").val();
    }
    $("#tablecz").bootstrapTable("updateRow", {index: pindex, row: row});
    $("#editselect").modal("hide");
});

$("#jhjssj").change(function () {
    $('#jhkssj').datetimepicker('remove');
    $('#jhkssj').datetimepicker({
        //format: 'yyyy-mm-dd',
        //weekStart: 1,
        autoclose: true,
        startView: 2,
        minView: 2,
        // forceParse: false,
        language: 'zh-CN',
        showMeridian: false
    });
    let o = $("#jhjssj").val();
    if (o) {
        $('#jhkssj').datetimepicker('setStartDate', o);
    }
});
$("#jhkssj").change(function () {
    $('#jhjssj').datetimepicker('remove');
    $('#jhjssj').datetimepicker({
        //format: 'yyyy-mm-dd',
        //weekStart: 1,
        autoclose: true,
        startView: 2,
        minView: 2,
        // forceParse: false,
        language: 'zh-CN',
        showMeridian: false
    });
    let o = $("#jhkssj").val();
    if (o) {
        $('#jhjssj').datetimepicker('setStartDate', o);
    }
});
$("#apply").click(function () {
    oppSureModal("确定提交审核么？");
    $("#sureOption").unbind("click").click(function () {
        comn.ajax({
            url: interUrl.gzjl.apply,
            data: {
                id: $("#gzjlid").val()
            },
            success: function (resp) {
                comn.closeCurrentTab();
                tip({content: "操作成功"});

                // $("#sureModal").modal("hide");
                // $("#table1").bootstrapTable("refresh", {url: "..."});

            }
        });
    });
});
$("#copy").click(function () {
    oppSureModal("确定拷贝么？");
    $("#sureOption").unbind("click").click(function () {
        comn.ajax({
            url: interUrl.gzjl.copy,
            data: {
                id: $("#gzjlid").val(), xzid: $("#copytarget").val()
            },
            success: function (resp) {
                comn.closeCurrentTab();
                tip({content: "操作成功"});
            }
        });
    });
});

$(function () {
    let tcom=comn.table;
    tcom.pagination=false;
    $("#tablemain").bootstrapTable(tcom);
});

