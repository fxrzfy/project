var system = ['report/'],
    interUrl = {
        mockList: "",
        basic: "/api/", //nginx代理使用
        // basic: "/",
        common: {
            login: "login"
        },
        user: {
            login: "login",
            getUser: "personController/session/get",
            menu: "resourcesController/loanMenu",
            logOut: "logout",
            getPasswordComplex: "getPasswordComplex"
        },
        resourcesManage:{
            tree:"resourcesController/tree",
            get:"resourcesController/get",
            add:"resourcesController/add",
            update:"resourcesController/update",
            del:"resourcesController/del"
        },
        userManage:{
            dataGrid:"personController/dataGrid",
            get:"personController/get",
            saveUpdate:"personController/saveUpdate",
            changeInuse:"personController/changeInuse",
            resetPwd:"personController/resetPwd",
            userRoleList:"personController/userRoleList",
            updateRole:"personController/updateRole",
            list: "api/user/list"
        },
        roleManage:{
            dataGrid:"roleController/dataGrid",
            get:"roleController/get",
            saveUpdate:"roleController/saveUpdate",
            grant:"roleController/grant",
            del:"roleController/del"

        },
        unitManage:{
            tree:"unitController/tree",
            get:"unitController/get",
            save:"unitController/save",
            delete:"unitController/delete"
        },
        teamManage:{
          list:"codeList/singleList",
          updateField:"codeList/updateField",
          del:"codeList/deltails",
          addDetail:"codeList/addDetail",
          tree:"codeList/tree",
          add:"codeList/add",
          get:"codeList/get",
          delcodeList:"codeList/del",
          clear:"codeList/clear"

        },
        deptManage:{
            tree:"deptController/tree",
            get:"deptController/get",
            save:"deptController/save",
            delete:"deptController/delete",
            list:"deptController/list"
        },
        gzxsManager:{
            dataGrid:"gzxs/list",
            get:"gzxs/get",
            delete:"gzxs/delete",
            add:"gzxs/add",
        },
        cache:{
            dpAll:"dropDown/allMap"
        },
        gzrw:{
            xzList:"gzrw/xzList",
            ryList:"gzrw/ryList",
            addGzrw:"gzrw/addGzrw",
            list:"gzrw/list",
            getById:"gzrw/getById",
            zfRw:"gzrw/zfGzrw",
            delGzxz:"gzrw/delGzxz",
            updateGzxz:"gzrw/updateGzxz",
            addXzcy:"gzrw/addXzcy",
            freeXzcy:"gzrw/freeXzcy",
            updateCyRole:"gzrw/updateCyRole",
            dismissXz:"gzrw/dismissXz",
            delGzrw:"gzrw/delGzrw",
            getSignstatus:"gzrw/getSignstatus",
            addTemp:"gzrw/addTemp"

        },
        dict:{
            zsztree:"zsz/tree",
            zszaddEdit:"zsz/addEdit",
            zdList:"zsz/zdList",
            zszget:"zsz/get",
            zszdel:"zsz/del",
            sync:"zsz/sync",
            zdList:"zsz/zdList",
            updateZd:"zsz/updateZd",
            getZd:"zsz/getZd",
            delZd:"zsz/delZd",
            suggestList:"zsz/suggestList",
            zdAll:"zsz/listAll",
            wentitree:"wenti/tree",
            wentiwtxList:"wenti/wtxList",
            wentiaddWtFl:"wenti/addWtFl",
            wentiaddWtXD:"wenti/addWtXD",
            wentidelWtXD:"wenti/delWtXD",
            wentidelWtFl:"wenti/delWtFl",
            lqskree:"lqsk/tree",
            lqskxdList:"lqsk/list",
            lqskaddfl:"lqsk/addFl",
            lqskaddxd:"lqsk/addXD",
            lqskdelxd:"lqsk/delXD",
            lqskdelfl:"lqsk/delFl"
        },
        gzjl:{
            getById:"gzjl/getById",
            addEditGzjl:"gzjl/addEditGzjl",
            deleteGzjl:"gzjl/deleteGzjl",
            checkGzjl:"gzjl/checkGzjl",
            gzjlmxList:"gzjl/gzjlmxList",
            selectJccz:"gzjl/selectJccz",
            selectJclc:"gzjl/selectJclc",
            addGzjlMx:"gzjl/addGzjlMx",
            getGzmxById:"gzjl/getGzmxById",
            deleteGzjlMx:"gzjl/deleteGzjlMx",
            copy:"gzjl/copy",
            apply:"gzjl/apply",
            getCheckData:"gzjl/getCheckData",
            check:"gzjl/check",
            exportgzjl:"file/gzjl"
        },
        leave:{
            list:"leave/list",
            addEdit:"leave/addEdit",
            del:"leave/del",
            apply:"leave/apply",
            check:"leave/check",
            get:"leave/get"
        },
        gzzd:{
            list:"gzzd/list",
            addEdit:"gzzd/addEdit",
            del:"gzzd/del",
            apply:"gzzd/apply",
            check:"gzzd/check",
            get:"gzzd/get"
        },
        gzjlsc:{
            dataGrid:"gzjlsc/dataGrid",
            groupList:"gzjlsc/grouplist",
            groupDetail:"gzjlsc/groupDetail",
        },
        jcfl:{
            list:"jcfl/list",
            add:"jcfl/add",
            delete:"jcfl/delete",
            get:"jcfl/get",
            detail:"jcfl/detail",
            addDetail:"jcfl/addDetail",
            deleteDetail:"jcfl/deleteDetail"
        }
    };




























