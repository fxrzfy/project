var args, zTreeOnClick, dataLoad_1, tableEvent_1, treeObj, tableD2, myData = false;


jQuery.browser = {};
pageData = {};
args = comn.getArgs();

if (args.id > 0) {
    $("#addForm input[name='id'] ").val(args.id);
}

// if (args.read) {
//     $("input").attr("disabled", "disabled");
//     $("#gzrwId").attr("disabled",false);
//     $("textarea").attr("disabled", "disabled");
//     $("input[type='button']").addClass("hide");
//     $("button").addClass("hide");
// }

tablemain = function (params) {
    var data = {}
    tableData(params, data, interUrl.gzjl.gzjlmxList);
};
(function () {
    jQuery.browser.msie = false;
    jQuery.browser.version = 0;
    if (navigator.userAgent.match(/MSIE ([0-9]+)\./)) {
        jQuery.browser.msie = true;
        return jQuery.browser.version = RegExp.$1;
    }
    $("#shoform input").attr("readonly", "readonly");
    let tbop=$.extend(comn.table,{ajax:tablemain});
    delete tbop.height;
    let templat=$("#template").html();
    comn.ajax({
        url: interUrl.gzjl.getCheckData,
        data: {
            ids: args.ids
        },
        success: function (res) {
            $("#shoform").values(res.data);
            $.each(res.data.gzjlList,function(i,o){
                console.log(o);
                let tid="tb_"+o.id;
                let txt=`<form class="form-horizontal tbform "  style="border-top: #0d8ddb solid 1px; margin-top: 50px;" id="${tid}">${templat}</form>`;
                $("#reviewbody").append(txt);
                $("#"+tid).values(o);
                let thop=tbop;
                thop.queryParams={id:o.id}
                console.log(thop)
                $("#"+tid+" .tablemain").bootstrapTable(tbop)
                $("#"+tid+" .editPlan").attr("data-id",o.id)
            });
            $(".tbform input").attr("readonly", "readonly");
            $(".editPlan").click(function () {
                let planid=$(this).attr("data-id");
                return  comn.addTab({
                    title: "编辑工作计划",
                    href: "./Modal/bizywgl/gzjledit.html?id="+planid
                });
            });
        }
    });


})();


$("#saveOpinion").click(function () {
    let valid=true;
    let forms=$(".tbform");
    let arr=[];
    $.each(forms,function (i,o) {
       console.log(o)
        x=$(o).values();
        console.log(x)
        console.log("------------------------")
        //console.log(x);
        if(!$(o).valid()){
            valid=false;
            return false;
        }
        console.log("------------2222------------")
        console.log(x)
       // x.shzt=x.shzt[0];
        if(x.shzt==3 && x.shbz==''){
            layer.alert("驳回备注不能为空");
            valid= false;
        }
        arr.push(x);
    });
    if(!valid){
        return;
    }
   // console.log(arr);
    comn.ajax({
        url: interUrl.gzjl.check,
       data:JSON.stringify({data:arr}) ,
       contentType:"application/json",
        success: function (res) {
            layer.msg("操作成功");
           // comn.closeCurrentTab();
        }
    });
    console.log(arr);

});




