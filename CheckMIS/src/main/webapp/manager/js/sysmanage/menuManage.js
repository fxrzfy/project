var args, zTreeOnClick,dataLoad_1,tableEvent_1, g_isModify = false,PData=[];

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

current_node = null;

zTreeOnClick = function(event, treeId, treeNod) {
    current_node = treeNod;
    $("#orgName").html(current_node.name);
    //$("#syncButton").hide();
    // if (current_node.type == 'BRANCH_COMPANY') {
    //     if(current_node.state != 1){
    //         $("#syncButton").show();
    //     }
    // }
    openOrg();
};

openOrg = function(){
    comn.ajax({
        url: interUrl.resourcesManage.get,
        data: {id:current_node.id},
        success: function(res) {
            $("#orgForm").values(res.data);
            if(current_node.getParentNode())
                $("#parentOrgstr").val(current_node.getParentNode().text);
            else
                $("#parentOrgstr").val("无");
            $("#show").attr("class","");
            $("#show").attr("class",res.data.icons)
            setButtonStatus();
           // if(_callback)_callback(res);
        }
    });

};

openTree = function(){
    comn.ajax({
        url: interUrl.resourcesManage.tree,
        success: function(res) {
            PData=res.data[0];
            var treeObj;
            treeObj = $.fn.zTree.init($("#tree"), {
                showLine: true,
                expand: true,
                callback: {
                    onClick: zTreeOnClick
                },
                data: {
                    key: {
                        name: "text"
                    },
                    simpleData: {
                        enable: true,
                        idKey: "id",
                        pIdKey: "pid",
                        state:"state",
                        type:"type",
                        rootPId: 0
                    }
                },
                check : {
                    enable:true
                }
            }, res.data);
            var node = treeObj.getNodes()[0];
            if(node){
                treeObj.selectNode(node);
                zTreeOnClick(null, null, node);
            }
            return treeObj.expandAll(true);
        }
    });
};

saveOrg = function(_form, _callback){
    var _data = _form.values();
    var _url = _data.id?interUrl.resourcesManage.update:interUrl.resourcesManage.add;
    return comn.ajax({
        url: _url,
        data: _data,
        success: function(res) {
            if(res.code==10000){
                if(_callback)_callback();
                openTree();
                g_isModify = false;
                setButtonStatus();
            }else{
                tip({content: res.message});
            }
        }
    });
};

setButtonStatus = function(){
    var span = $('#modify').find("span:last");

    if(current_node.id==0){
        g_isModify=false;
    }
    if(g_isModify==true){
        span.html("&nbsp;取消&nbsp;");
        $("#orgForm").find(":input").attr("disabled",false);
        $("#orgForm").find(".readInput").attr("disabled",true);
        $("#orgForm").find("#selectType").attr("disabled",true);
        $("#orgForm").find("#orgCode").attr("readonly",true);
        $("#orgForm").find("#save").show();
        $("#ibtn").show();
    }else{
        span.html("&nbsp;修改&nbsp;");
        $("#orgForm").find(":input").not(":button").attr("disabled",true);
        $("#orgForm").find("#save").hide();
        $("#ibtn").hide();
        $("#iconstreeview").hide();
    }
};

$(function() {
    var validate = {
        rules: {
            telephone: {phoneMix: true},
            fax: {telephone: true}
        },
        messages: {
            telephone: {phoneMix: "公司电话格式不正确"},
            fax: {telephone: "传真格式不正确"}
        }
    };
    $("#addOrgForm").validate(validate);
    $("#orgForm").validate(validate);
    $("#add").click(function() {
        console.log(current_node);
        $("#addOrg").modal("show");
        if(current_node){
            $("#addOrg").find("input[name='pid']").val(current_node.id);
            $("#addOrg").find("input[name='pname']").val(current_node.text);
            $("#addOrg").find("input[name='pname']").attr("disabled",true);
        }
    });
    $("#saveOrg").click(function() {
        if($("#addOrgForm").valid()==false)return;
        saveOrg($("#addOrgForm"), function(){$("#addOrg").modal("hide");});
    });
    $("#modify").click(function(){
        $("#treeview").hide();
        g_isModify = g_isModify?false:true;
        setButtonStatus();
    });

    $("#save").click(function(){
        $("#treeview").hide();
        if($("#orgForm").valid()==false)return;
        saveOrg($("#orgForm"));
    });

    $("#del").click(function() {
        if(!current_node||current_node.id<=0){
            tip({content: "请选择菜单来删除"});
            return;
        }
        oppSureModal("确定刪除么？");
        $("#sureOption").unbind("click").click(function (){
            comn.ajax({
                url: interUrl.resourcesManage.del,
                data: {
                    id: current_node.id
                },
                success: function (resp) {
                    openTree();
                    tip({content:"操作成功"});
                    $("#sureModal").modal("hide");
                }
            });
        });
    });
    openTree();
});

function buildDomTree() {
    var data = [];
    var root ={};
    root.text=PData.text;
    root.id=PData.id;
    root.selectable=false;
    root.nodes=[]
    $.each(PData.children,function (i,o) {
        var obj ={};
        obj.id=o.id;
        obj.text=o.text;
        root.nodes.push(obj);
    });

    // function walk(nodes, data) {
    //     if (!nodes) {
    //         return;
    //     }
    //     $.each(nodes, function(id, node) {
    //         var obj = {
    //             id : id,
    //             text : node.name != null ? node.name : root
    //             // 										tags : [ node.isLeaf == true ? node.
    //             // 												+ ' child elements'
    //             // 												: '' ]
    //         };
    //         if (node.isLeaf = true) {
    //             obj.nodes = [];
    //             walk(node.children, obj.nodes);
    //         }
    //         data.push(obj);
    //     });
    // }
    //
    // walk(data1, data);
    data.push(root);
    return data;
}

$("#parentOrgstr").click(function() {
    var options = {
        bootstrap2 : false,
        showTags : true,
        levels : 5,
        showCheckbox : true,
        checkedIcon : "glyphicon glyphicon-check",
        data : buildDomTree(),
        onNodeSelected : function(event, data) {
            $("#parentOrgstr").val(data.text);
            $("#orgForm input[name='pid']").val(data.id);
            $("#treeview").hide();
        }
    };
   // console.log("----------------------------")
    $('#treeview').treeview(options);
    $("#treeview").show();
});

$("#parentOrgstr").click(function() {
    var options = {
        bootstrap2 : false,
        showTags : true,
        levels : 5,
        showCheckbox : true,
        checkedIcon : "glyphicon glyphicon-check",
        data : buildDomTree(),
        onNodeSelected : function(event, data) {
            $("#parentOrgstr").val(data.text);
            $("#orgForm input[name='pid']").val(data.id);
            $("#treeview").hide();
        }
    };
   // console.log("----------------------------")
    $('#treeview').treeview(options);
    $("#treeview").show();
});

function buildIconsTree(){
    return treed;
}

$("#ibtn").unbind('click').click(function () {
   let iscons=[];
   iscons.push("glyphicon glyphicon-asterisk");
   iscons.push("glyphicon glyphicon-glass");
   iscons.push("glyphicon glyphicon-envelope");
   iscons.push("glyphicon glyphicon-heart");
   iscons.push("glyphicon glyphicon-user");
   iscons.push("glyphicon glyphicon-home");
   iscons.push("glyphicon glyphicon-tree-conifer");
   iscons.push("glyphicon glyphicon-tree-conifer");
   iscons.push("glyphicon glyphicon-tree-deciduous");
   //iscons.push("icon-cog");
   //iscons.push("icon-moren");
   //iscons.push("icon-zhichi");
    //console.log("----------------------------")
    //$('#iconstreeview').treeview(options);
    $("#iconstreeview").toggle('show');
    let html='';
    $.each(iscons,function (i,o) {
        html+=`<span class='${o}' style="width: 30px;"></span>`;
    })
    console.log(html);
    $("#iconstreeview").html(html);
    $("#iconstreeview .glyphicon").click(function () {
        let sclass=$(this).attr("class");
        $("#show").attr("class",sclass)
        $("#icons").val(sclass)
        $("#iconstreeview").hide();
        console.log(sclass)
    });
});

//


