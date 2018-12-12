var args, zTreeOnClick, dataLoad_1, tableEvent_1, treeObj, tableD2;


jQuery.browser = {};
pageData = {};
args = comn.getArgs();
$("#addForm input[name='id'] ").val(args.id);
$("#tmgzrwId").val(args.id);
if (args.read) {
    $("input").attr("disabled", "disabled");
    $("#gzrwId").attr("disabled",false);
    $("textarea").attr("disabled", "disabled");
    $("input[type='button']").addClass("hide");
    $("button").addClass("hide");
}
(function () {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        return jQuery.browser.version = RegExp.$1;
    }
    $("#addForm input[name='rwbh'] ").attr("disabled", "disabled");
    $("#addForm input[name='zfsj'] ").attr("disabled", "disabled");
    if (args.id) {
        comn.ajax({
            url: interUrl.gzrw.getById,
            data: {
                id: args.id
            },
            success: function (res) {
                $("#addForm").values(res.data);
                //$("#tableTeam").bootstrapTable("refresh", {url: "..."});
            }
        });
    }
    //$("#table4").bootstrapTable($.extend(comn.table, {"pagination":false}));
})();


function editeGroup() {

    if ($("#gzrwId").val() == '') {
        return;
    }

    $('.teamSel').editable({
        //type: "select",                //编辑框的类型。支持text|textarea|select|date|checklist等
        //title: "小组",              //编辑框的标题
        //name:"name",
        // source:dd,
        disabled: false,             //是否禁用编辑
        //  pk: row.id,
        url: interUrl.basic + interUrl.gzrw.updateGzxz,
        success: function (aa) {
            $("#tableTeam").bootstrapTable("refresh", {url: "..."});
        },
        validate: function (v) {

        },
        error: function (resp, value) {
            return resp.responseJSON.msg;
        },
        emptytext: "请选择",          //空值的默认文本
        mode: "popup"              //编辑框的模式：支持popup和inline两种模式，默认是popup
    });
}

$('#tableTeam').on('load-success.bs.table', function (row, $element, field) {
    editeGroup();
});

function addInitData() {
    if (!checkCando()) {
        return;
    }
    var d = $("#tableTeam").bootstrapTable("getData");
    ids = [];
    $.each(d, function (index, row) {
        if (row.id < 0) {
            ids.push(1);
        }
    });

    if (ids.length > 0) {
        layer.msg("请先设置新增组的组名");
        return;
    }
    var data = {id: -args.id};
    $("#tableTeam").bootstrapTable('append', data);
    editeGroup();
    // editeGroup();


}

tableTeam = function (params) {
    var data=$.extend($("#addForm").values(),{})
    tableData(params,data , interUrl.gzrw.xzList);
};

tableRyNew = function (params) {
    if ($("#tmid").val() < 0) {
        return;
    }
    tableData(params, $.extend($("#peopleNewAddForm").values(), {}), interUrl.gzrw.ryList);
};
tableRySelect = function (params) {
    if ($("#tmid").val() < 0) {
        return;
    }
    tableData(params, $.extend($("#peopleNewAddForm").values(), {isSelectEd: 1}), interUrl.gzrw.ryList);
};
tableRyNoSelect = function (params) {
    if ($("#tmid").val() < 0) {
        return;
    }
    tableData(params, $.extend($("#peopleNewAddForm").values(), {isSelectEd: 0}), interUrl.gzrw.ryList);
};

function handle_1(value, row, index) {
    return `<a class='del'>删除</a></li>`;
};

tableRyNoSelect = function (params) {
    if ($("#tmid").val() < 0) {
        return;
    }
    tableData(params, $.extend($("#peopleNewAddForm").values(), {isSelectEd: 0}), interUrl.gzrw.ryList);
};

tableTemp = function (params) {
    params.complete();
    // if($("#tmid").val()<0){
    //     return;
    // }
    // tableData(params, $.extend($("#peopleNewAddForm").values(), {isSelectEd:0}) , interUrl.gzrw.ryList);
};

tableEvent_1 = {
    "click .del": function (a, val, item, d) {
        $("#tabletmp").bootstrapTable('remove', {
            field: 'v',
            values: [item.v]
        });
        //$("#addEditModal .modal-title").html("修改角色");


    }

}

function editTeam(value, row, index) {
    if (!value) {
        value = ""
    }
    if (args.read) {
        return value;
    }
    var jsonData = parent.dropDownMap['individual_team'];
    var dd = {};
    for (k in jsonData) {
        dd[jsonData[k].name] = jsonData[k].name;
    }
    str = JSON.stringify(dd);
    return `<a data-pk="${row.id}" data-title="小组" data-type="select" data-source='${str}' data-name="name" class="teamSel">${value}</a>`;
};

function editComment(value, row, index) {
    if (!value) {
        value = "无";
    }
    if (args.read || row.id < 0) {
        return value;
    }
    return `<a data-pk="${row.id}" data-title="备注" data-type="text"  data-name="bz" class="teamSel">${value}</a>`;
};

function editTrain(value, row, index) {
    if (!value) {
        value = "无";
    }
    if (args.read || row.id < 0) {
        return value;
    }
    return `<a data-pk="${row.id}" data-title="列车" data-type="text"  data-name="lc" class="teamSel">${value}</a>`;
};

function showType(value, row, index) {
    if (value == '0') {
        return "未生效"
    }
    if (value == '1') {
        return "生效"
    }
    if (value == '2') {
        return "解散"
    }
};

function editPeoPle(value, row, index) {
    if(!value){
        value="";
    }
    if (args.read || row.id < 0) {
        return value;
    }
    return `<a  onclick="showGrant(${row.id})">编辑人员</a>${value}`;
};

function editCZ(value, row, index) {
    if (!value) {
        value = '';
    }
    if (args.read || row.id < 0) {
        return value;
    }

    return `<a  onclick="showselect(${row.id},'cdzdcz','${value}')">选择车站</a>${value}`;
};

function editZd(value, row, index) {
    if (!value) {
        value = '';
    }
    if (args.read || row.id < 0) {
        return value;
    }

    return `<a  onclick="showselect(${row.id},'zd','${value}')">选择站段</a>${value}`;
};

function editGzr(value, row, index) {
    if (!value) {
        value = '';
    }
    if (args.read || row.id < 0) {
        return value;
    }

    return `<a  onclick="showselect(${row.id},'gzrap','${value}')">选择日期</a>${value}`;
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
    $("#tmgzrwId").val($("#gzrwId").val());
    $("#tmid").val(id);
    let tconf=comn.table;
    tconf.height="200px";
    $("#tableRyNew").bootstrapTable(tconf);
    $("#tableRyNew").bootstrapTable("refresh", {url: "..."});
    $("#tableRySelect").bootstrapTable("refresh", {url: "..."});
    $("#tableRyNoSelect").bootstrapTable("refresh", {url: "..."});
}

function showselect(id, type, v) {
    if (!checkCando()) {
        return;
    }
    if (id < 0) {
        layer.alert("请先选择组名");
        return;
    }
    $("#editselect").modal("show");
    $("#tabletmp").bootstrapTable("removeAll");
    $("#temptype").val(type);
    $("#tempzyid").val(id);
    if (v) {
        let tempv = v.split(",");
        $.each(tempv, function (i, o) {
            let td = {"v": o}
            $("#tabletmp").bootstrapTable("append", td);
        });
    }

    var name2Id = {};
    if (type == 'cdzdcz') {
        $("#editselect .modal-title").html("编辑查堵重点车站");
        $("#addTemForm label").html("车站名称");
        $("#tempadd").attr("placeholder", "输入简称搜索");
        $(".tmpdate").hide();
        $("#tempaddstr").show();
    }
    if (type == 'zd') {
        $("#editselect .modal-title").html("编辑站段");
        $("#addTemForm label").html("站段");
        $("#tempadd").attr("placeholder", "输入简称搜索");
        $(".tmpdate").hide();
        $("#tempaddstr").show();
    }
    if (type == 'gzrap') {
        $("#editselect .modal-title").html("工作日安排");
        $("#addTemForm label").html("工作日");
        //$("#tempadd").attr("placeholder", "输入简称搜索");
        $(".tmpdate").show();
        $("#tempaddstr").hide();
    }
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
                    //tip({content:"操作成功"});
                }
            });
        },//数据源
        items: 8,//最多显示个数
        updater: function (item) {
            return item;
            //return name2Id[item];//这里一定要return，否则选中不显示，外加调用display的时候null reference错误。
        },
        displayText: function (item) {
            //return "=>"+item+"<=";
            return `${item}:${name2Id[item]}`;
        },
        afterSelect: function (item) {
            $("#tempadd").val(name2Id[item]);
            name2Id = {};
            //return name2Id[item];
            //选择项之后的事件 ，item是当前选中的。
        },
        delay: 500//延迟时间
    });

    // $("#tmgzrwId").val(args.id);
    // $("#tmid").val(id);
    // $("#tableRyNew").bootstrapTable(comn.table);
    // $("#tableRyNew").bootstrapTable("refresh", {url: "..."});
    // $("#tableRySelect").bootstrapTable("refresh", {url: "..."});
    // $("#tableRyNoSelect").bootstrapTable("refresh", {url: "..."});
}


$("#addNewTeam").click(function () {
    addInitData();
    //$("#addEditModal .modal-title").html("新增角色");
    //$("#addEditModal").modal("show");
});

function checkCando() {
    if ($("#gzrwId").val() == '') {
        layer.alert("请先保存基本信息");
        return false;
    }
    return true;
}

$("#delTeam").click(function () {
    if (!checkCando()) {
        return;
    }
    var ids = $.map($("#tableTeam").bootstrapTable('getSelections'), function (row) {
        return row.id;
    });
    if (ids.length < 1) {
        layer.alert("请选择一行删除!");
        return;
    }
    oppSureModal("确定刪除么？");
    $("#sureOption").unbind("click").click(function () {
        // $("#tableTeam").bootstrapTable("remove",{field:"name",values:ids});
        // $("#sureModal").modal("hide");
        comn.ajax({
            url: interUrl.gzrw.delGzxz,
            data: {
                ids: ids.join(",")
            },
            success: function (resp) {
                tip({content: "操作成功"});
                $("#sureModal").modal("hide");
                $("#tableTeam").bootstrapTable("refresh", {url: "..."});

            }
        });
    });

});


//查询按钮
$("#btn-search").click(function () {
    $("#table1").bootstrapTable("refresh", {url: "..."});

});


$("#addTemp").click(function () {
    let v = $("#tempadd").val();
    if($("#temptype").val()=='gzrap'){
      let  v1=$("#tempd1").val();
      let  v2=$("#tempd2").val();
      if(!v1 ||v1==''){
          layer.msg("开始时间必须选择");
          return;
      }
      v=v1;
      if(v2){
          let t1=Date.parse(getStrDateTime(v1));
          let t2=Date.parse(getStrDateTime(v2));
          if(t1>t2){
              layer.msg("开始时间不能大于结束时间");
              return;
          }
          v=v+"-----"+v2;
      }
    }

    if (!v || v == '') {
        layer.msg("不能添加空值");
        return;
    }
    let dict = {"v": v}
    var data = $("#tabletmp").bootstrapTable("getData", true);
    let canDo = true;
    $.each(data, function (i, o) {
        if (o.v == v) {
            layer.alert(v + "已经存在");
            canDo = false;
        }
    });
    if (canDo) {
        $(".tmp").val("");
        $("#tabletmp").bootstrapTable("append", dict);
    }
});

$("#saveSelect").click(function () {

    var data = $("#tabletmp").bootstrapTable("getData", true);
    var resultstr = [];
    $.each(data, function (i, o) {
        resultstr.push(o.v);
    });

    comn.ajax({
        url: interUrl.gzrw.updateGzxz,
        data: {pk: $("#tempzyid").val(), name: $("#temptype").val(), value: resultstr.join(",")},
        success: function (res) {
            tip({content: "操作成功"});
            $("#editselect").modal("hide");
            $("#tableTeam").bootstrapTable("refresh", {url: "..."});
        }
    });
});




$("#save").click(function () {
    if (!$("#addForm").valid()) {
        return;
    }
    var _data = $("#addForm").values();
    var _url = interUrl.gzrw.addGzrw;
    comn.ajax({
        url: _url,
        data: _data,
        success: function (res) {
            $("#gzrwId").val(res.data.id);
            $("#tmgzrwId").val(res.data.id);
            $("#addForm input[name='rwbh'] ").val(res.data.rwbh);
            $("#tableTeam").bootstrapTable("refresh", {url: "..."});
            pageRefreshTo("./Modal/bizywgl/gzrwManage.html", "");
        }
    });
});

$("#savePush").click(function () {
    if (!$("#addForm").valid()) {
        return;
    }
    var _data = $("#addForm").values();
    var _url = interUrl.gzrw.addGzrw;
    _data.rwzt=1;
    comn.ajax({
        url: _url,
        data: _data,
        success: function (res) {
            pageRefreshTo("./Modal/bizywgl/gzrwManage.html", "closeCurrent");
        }
    });
});

$("#dimiss").click(function () {
    //$("#grantModal").modal('show');
    dismiss("2");

});

$('#grantModal').on('hidden.bs.modal', function () {
    $("#tableTeam").bootstrapTable("refresh", {url: "..."});
})


function dismiss(type) {
    if (!checkCando()) {
        return;
    }
    var ids = $.map($("#tableTeam").bootstrapTable('getSelections'), function (row) {
        return row.id;
    });
    if (ids.length < 1) {
        layer.alert("请至少选择一行来操作");
        return;
    }
    comn.ajax({
        url: interUrl.gzrw.dismissXz,
        data: {ids: ids.join(","), type: type},
        success: function (res) {
            $("#tableTeam").bootstrapTable("refresh", {url: "..."});
            layer.msg("操作成功");
        }
    });
}


$("#recover").click(function () {
    dismiss("1");
});

$("#delAll").click(function () {
    var selids = $("#table1").bootstrapTable('getSelections');
});

function handle_free(value, row, index) {
    return `<a  class="addfree">添加</a>`;
}

function handle_team(value, row, index) {
    return `<a  class="free">移出</a>`;
}

function handle_Role(value, row, index) {
    let checked1 = (value == 1) ? "checked" : "";
    let checked2 = (value == 0) ? "checked" : "";
    let dis=""
    console.log(row);
    if(!row.workNumber){
        dis="disabled='disabled'"
    }
    return `组长<input type="radio" ${checked1} ${dis}  onchange="changeRole(${row.id})"  name="type${row.id}" value="1"/>组员<input ${dis}  ${checked2} onchange="changeRole(${row.id})" type="radio" name="type${row.id}" value="1"/>`;
}

function changeRole(id) {
    comn.ajax({
        url: interUrl.gzrw.updateCyRole,
        data: {id: id},
        success: function (res) {
            $("#tableRyNew").bootstrapTable("refresh", {url: "..."});
            $("#tableRyNoSelect").bootstrapTable("refresh", {url: "..."});
        }
    });
}

tableEvent_free = {
    "click .addfree": function (a, val, item, d) {
        // $("#addEditModal .modal-title").html("修改角色");
        item.gzrwxzId = $("#tmid").val();
        comn.ajax({
            url: interUrl.gzrw.addXzcy,
            data: item,
            success: function (res) {
                $("#tableRyNew").bootstrapTable("refresh", {url: "..."});
                $("#tableRyNoSelect").bootstrapTable("refresh", {url: "..."});
            }
        });
    },
    "click .free": function (a, val, item, d) {
        // $("#addEditModal .modal-title").html("修改角色");
        //item.gzrwxzId=$("#tmid").val();

        comn.ajax({
            url: interUrl.gzrw.freeXzcy,
            data: {id: item.id},
            success: function (res) {
                $("#tableRyNew").bootstrapTable("refresh", {url: "..."});
                $("#tableRyNoSelect").bootstrapTable("refresh", {url: "..."});
                $("#tableRySelect").bootstrapTable("refresh", {url: "..."});
            }
        });
    }
}

$("#addTempx").click(function () {
    $("#addtempCy").modal('show');
});

$("#addTempCySave").click(function () {
    if(!$("#addTemCYForm").valid()){
        return ;
    }
    let values=$("#addTemCYForm").values();
    let xzid=$("#tmid").val();
    values.gzrwxzId=xzid;
    console.log(values);
    comn.ajax({
        url: interUrl.gzrw.addTemp,
        data: values,
        success: function (res) {
            $("#tableRyNew").bootstrapTable("refresh", {url: "..."});
            $("#addtempCy").modal('hide');
            //$("#tableRyNoSelect").bootstrapTable("refresh", {url: "..."});
            //$("#tableRySelect").bootstrapTable("refresh", {url: "..."});
        }
    });
});
