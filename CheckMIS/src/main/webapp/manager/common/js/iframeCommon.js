var comn, queryParams, ref, tableData, tip;
comn = {};

tip = null;

function isArray(o) {
    return Object.prototype.toString.call(o) == '[object Array]';
}


(function () {
    tip = function (o) {
        var base;
        return typeof (base = window.parent.comn).tip === "function" ? base.tip(o) : void 0;
    };
    return comn = {
        user: window.parent.user,
        cache: window.parent.cache,
        table: {
            "undefinedText": "--",
            "classes": "table-striped table-hover table",
            "pagination": true,
            "sidePagination": "server",
            "queryParams": "queryParams",
            "paginationFirstText": "第一页",
            "paginationPreText": "上一页",
            "paginationNextText": "下一页",
            "paginationLastText": "最后一页",
            "clickToSelect": true,
            "height": "500"
        },
        drlocale :{
            "format": 'YYYY-MM-DD',
            "separator": " -222 ",
            "applyLabel": "确定",
            "cancelLabel": "取消",
            "fromLabel": "起始时间",
            "toLabel": "结束时间'",
            "customRangeLabel": "自定义",
            "weekLabel": "W",
            "daysOfWeek": ["日", "一", "二", "三", "四", "五", "六"],
            "monthNames": ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            "firstDay": 1
        },
        toUrl: function (o) {
            var base;
            if (o.url.indexOf(".html") > -1) {
                return typeof (base = window.parent).toUrl === "function" ? base.toUrl(o.url) : void 0;
            }
        },
        closeTab: function () {
            window.parent.closeTab();
        },
        closeTabByUrl: function(url) {
            window.parent.closeTabByUrl(url);
        },
        closeCurrentTab: function () {
            window.parent.closeCurrentTab();
        },
        addTab: function (o) {
            if (o.href) {
                return window.parent.menuItemClick.call(o);
            }
        },
        accAdd: function (arg1, arg2) { //js精度问题(加法)
            var r1, r2, m;
            try {
                r1 = arg1.toString().split(".")[1].length
            } catch (e) {
                r1 = 0
            }
            try {
                r2 = arg2.toString().split(".")[1].length
            } catch (e) {
                r2 = 0
            }
            m = Math.pow(10, Math.max(r1, r2))
            return (arg1 * m + arg2 * m) / m
        },
        accSub: function (arg1, arg2) { //js精度问题(减法)
            var r1, r2, m, n;
            try {
                r1 = arg1.toString().split(".")[1].length
            } catch (e) {
                r1 = 0
            }
            try {
                r2 = arg2.toString().split(".")[1].length
            } catch (e) {
                r2 = 0
            }
            m = Math.pow(10, Math.max(r1, r2));
            //last modify by deeka
            //动态控制精度长度
            n = (r1 >= r2) ? r1 : r2;
            return ((arg1 * m - arg2 * m) / m).toFixed(n);
        },
        accMul: function (arg1, arg2) {  //js精度问题(乘法)
            var m = 0, s1 = arg1.toString(), s2 = arg2.toString();
            try {
                m += s1.split(".")[1].length
            } catch (e) {
            }
            try {
                m += s2.split(".")[1].length
            } catch (e) {
            }
            return Number(s1.replace(".", "")) * Number(s2.replace(".", "")) / Math.pow(10, m);
        },
        accDiv: function (arg1, arg2) {  //js精度问题(除法)
            var t1 = 0, t2 = 0, r1, r2;
            try {
                t1 = arg1.toString().split(".")[1].length
            } catch (e) {
            }
            try {
                t2 = arg2.toString().split(".")[1].length
            } catch (e) {
            }
            with (Math) {
                r1 = Number(arg1.toString().replace(".", ""))
                r2 = Number(arg2.toString().replace(".", ""))
                return (r1 / r2) * pow(10, t2 - t1);
            }
        },
        ajax: function (o) {
            var _this, mask;
            //console.log((o.url + " -->") + JSON.stringify(o.data));
            mask = layer.load();
            _this = this;
            if (o.url) {
                return $.ajax({
                    url: interUrl.basic + o.url,
                    type: o.type || "POST",
                    contentType: o.contentType,
                    dataType: "json",
                    async: o.async,
                    data: o.data || {},
                    complete: function (jqXHR, textStatus) {
                        return layer.close(mask);
                    },
                    success: function (data) {
                        if (data.code === 20000) {
                            return tip({
                                content: data.msg || "<code>" + o.url + "</code><br /> 接口异常！！！"
                            });
                        } else if (data.code === 30000) {
                            return window.parent.location.href = "../../../index.html";
                        } else {
                            if (typeof data === "string") {
                                data = JSON.parse(data);
                            }
                            return typeof o.success === "function" ? o.success(data) : void 0;
                        }
                    },
                    error: function (jqXHR, textStatus, errorThrown) {
                        return typeof o.error === "function" ? o.error(textStatus) : void 0;
                    }
                });
            }
        },
        getArgs: function () {
            var args, i, item, items, name, qs, value;
            qs = (location.search.length > 0 ? location.search.substring(1) : "");
            items = (qs.length ? qs.split("&") : []);
            args = {};
            i = 0;
            while (i < items.length) {
                item = items[i].split("=");
                name = decodeURIComponent(item[0]);
                value = decodeURIComponent(item[1]);
                if (name.length) {
                    args[name] = value;
                }
                i++;
            }
            return args;
        },
        /*
         *省市区三级联动,传递参数
         *{type: "car", level: [{
         *    el: $("#carBrandID")  渲染对象
         *    key: code  选中值
         *    target: $("#id") 中文赋值对象
         *},{
         *    el: $("#carMakeID")
         *    key: code
         *    target: $("#id")
         *},{
         *    el: $("#carModelID")
         *    key: code
         *}]}
         */
        linkage: function (o) {
            var o0, o1, o2;
            if (o.type === "car") {
                o0 = o.level[0];
                o1 = o.level[1];
                o2 = o.level[2];
                if (o1.key) {
                    o1.el.getCarList(o0.key, o1.key).unbind("change").change(function () {
                        if (o1.target) {
                            o1.target.val($(this).find("option:selected").text());
                        }
                        o2.el.val("");
                        if (this.value) {
                            return o2.el.getCarModel(this.value);
                        }
                    });
                }
                if (o2.key) {
                    o2.el.getCarModel(o1.key, o2.key).unbind("change").change(function () {
                        if (o1.target) {
                            return o2.target.val($(this).find("option:selected").text());
                        }
                    });
                }
                return o0.el.getBrand(o0.key || "").unbind("change").change(function () {
                    if (o0.target) {
                        o0.target.val($(this).find("option:selected").text());
                    }
                    if (this.value) {
                        o2.el.val("");
                        return o1.el.getCarList(this.value).unbind("change").change(function () {
                            if (o1.target) {
                                o1.target.val($(this).find("option:selected").text());
                            }
                            if (this.value) {
                                return o2.el.getCarModel(this.value).unbind("change").change(function () {
                                    if (o2.target) {
                                        return o2.target.val($(this).find("option:selected").text());
                                    }
                                });
                            }
                        });
                    }
                });
            }
        },
        getDropDown: function (o) {
            if (isArray(o)) {
                $.each(o, function (i, obj) {
                    initDropdown(obj);
                });
            } else {
                initDropdown(o);
            }
        }, /*
    函数，加法函数，用来得到精确的加法结果  
    说明：javascript的加法结果会有误差，在两个浮点数相加的时候会比较明显。这个函数返回较为精确的加法结果。
    参数：arg1：第一个加数；arg2第二个加数；d要保留的小数位数（可以不传此参数，如果不传则不处理小数位数）
    调用：Calc.Add(arg1,arg2,d)  
    返回值：两数相加的结果
    */
        Add: function (arg1, arg2) {
            arg1 = arg1.toString(), arg2 = arg2.toString();
            var arg1Arr = arg1.split("."), arg2Arr = arg2.split("."), d1 = arg1Arr.length == 2 ? arg1Arr[1] : "",
                d2 = arg2Arr.length == 2 ? arg2Arr[1] : "";
            var maxLen = Math.max(d1.length, d2.length);
            var m = Math.pow(10, maxLen);
            var result = Number(((arg1 * m + arg2 * m) / m).toFixed(maxLen));
            var d = arguments[2];
            return typeof d === "number" ? Number((result).toFixed(d)) : result;
        },
        /*
        函数：减法函数，用来得到精确的减法结果
        说明：函数返回较为精确的减法结果。
        参数：arg1：第一个加数；arg2第二个加数；d要保留的小数位数（可以不传此参数，如果不传则不处理小数位数
        调用：Calc.Sub(arg1,arg2)
        返回值：两数相减的结果
        */
        Sub: function (arg1, arg2) {
            return Calc.Add(arg1, -Number(arg2), arguments[2]);
        },
        /*
        函数：乘法函数，用来得到精确的乘法结果
        说明：函数返回较为精确的乘法结果。
        参数：arg1：第一个乘数；arg2第二个乘数；d要保留的小数位数（可以不传此参数，如果不传则不处理小数位数)
        调用：Calc.Mul(arg1,arg2)
        返回值：两数相乘的结果
        */
        Mul: function (arg1, arg2) {
            var r1 = arg1.toString(), r2 = arg2.toString(), m, resultVal, d = arguments[2];
            m = (r1.split(".")[1] ? r1.split(".")[1].length : 0) + (r2.split(".")[1] ? r2.split(".")[1].length : 0);
            resultVal = Number(r1.replace(".", "")) * Number(r2.replace(".", "")) / Math.pow(10, m);
            return typeof d !== "number" ? Number(resultVal) : Number(resultVal.toFixed(parseInt(d)));
        },
        /*
        函数：除法函数，用来得到精确的除法结果
        说明：函数返回较为精确的除法结果。
        参数：arg1：除数；arg2被除数；d要保留的小数位数（可以不传此参数，如果不传则不处理小数位数)
        调用：Calc.Div(arg1,arg2)
        返回值：arg1除于arg2的结果
        */
        Div: function (arg1, arg2) {
            var r1 = arg1.toString(), r2 = arg2.toString(), m, resultVal, d = arguments[2];
            m = (r2.split(".")[1] ? r2.split(".")[1].length : 0) - (r1.split(".")[1] ? r1.split(".")[1].length : 0);
            resultVal = Number(r1.replace(".", "")) / Number(r2.replace(".", "")) * Math.pow(10, m);
            return typeof d !== "number" ? Number(resultVal) : Number(resultVal.toFixed(parseInt(d)));
        }
    };
})();

$(function () {
    $(window).resize(function () {
        var base;
        return typeof (base = $("table")).bootstrapTable === "function" ? base.bootstrapTable('resetView') : void 0;
    });
    $("body").on("click", "a", function (e) {
        var ref;
        if (((ref = $(this).href) != null ? ref.index(".html") : void 0) > -1) {
            e.preventDefault();
            return comn.toUrl({
                "url": $(this).href
            });
        }
    }).on("focus", ".date", function () {
        //if(!$(this).is(":disabled")){ $(this).attr("readonly", true).css("background-color", "#FFF"); }
        var base;
        return typeof (base = $(this)).datetimepicker === "function" ? base.datetimepicker({
            format: "yyyy-mm-dd",
            pickerPosition: "bottom-right",
            language: "zh-CN",
            minView: 2,
            todayHighlight: true,
            autoclose: true,
            todayBtn: true,
            show: true
        }) : void 0;
    }).on("show.bs.tab", "[data-toggle='tab']", function (e) {
        return $($(this).attr("href")).find("[data-url]").each(function () {
            $(this).getLoad();
        });
    }).on("click", ".btn[modal='reset']", function () {
        var ref;
        return (ref = $(this).parents("form")[0]) != null ? ref.reset() : void 0;
    }).on("keyup", ".number, .mobile", function () {
        //if(!/^\d*(?:\.\d{0,2})?$/.test(this.value)){
        //this.value = '';
        //}
        //this.value = this.value.replace(/\D+.]/g,'');
    });
    $(".modal").on("show.bs.modal", function () {
        if ($(this).find("form").length) {
            var tmp = $(this).find("form")[0];
            if (!$(tmp).attr("data-noclear")) {
                return $(tmp).clearForm(true);
            }

        }
    });
    return $("#btn-search").click(function () {
        return $("#table").bootstrapTable('refresh', {url: "..."});
    });
});

if (typeof Mock !== "undefined" && Mock !== null) {
    Mock.mock(/list.json/, {
        'totalItem': 500,
        'data|40': [
            {
                'id': '@INT(1000, 60000)',
                'customerId': '@INT(1000, 60000)',
                'cardNo': '@INT(1000000000000000, 6000000000000000)',
                'loanAmount': '@INT(1000, 60000)',
                'loanTerm|1': [1, 2, 3],
                'customerName': '@CHINESENAME',
                'cardId': '@INT(1,100)',
                'projcetName|1': ['车贷项目申请', '某某项目申请'],
                'mobile': '@INT(600000)',
                'proceing|1': ['调度岗', '集团估计师', '录入内勤', '审核内勤'],
                'handleP': '@NAME',
                'proced|1': ['银行征信', '公安征信', '签单分配', '签单调查'],
                'orgname|1': ['杭州分公司', '湖北分公司'],
                'faqiren': '@CHINESENAME',
                'dbe': '@FLOAT(1,2)',
                'modifyTime': Random.datetime('yyyy-MM-dd A HH:mm:ss')
            }
        ]
    });
}

if ((ref = $.validator) != null) {
    ref.setDefaults({
        highlight: function (e) {
            return $(e).closest(".input-tip").removeClass("has-success").addClass("has-error");
        },
        success: function (e, r) {
            return $(r).closest(".input-tip").removeClass("has-error").addClass("has-success");
        },
        errorPlacement: function (e, r) {
            if (r.parent('.input-group').length) {
                e.insertAfter(r.parent());
            } else {
                if (e.text()) {
                    return e.appendTo((r.is(":radio") || r.is(":checkbox") ? r.parent().parent().parent() : r.parent()));
                }
            }
        }
    });
}

tableData = function (params, data, url, callback) {
    var p;
    p = params.data;
    if (url) {
        return comn.ajax({
            url: url,
            data: $.extend(data, p),
            success: function (res) {
                res = res.data;
                params.success({
                    'total': res.total,
                    'rows': res.data
                });
                params.complete();
                return typeof callback === "function" ? callback(res) : void 0;
            }
        });
    }
};

queryParams = function (params) {
    return {
        search: params.search,
        page: (params.limit + params.offset) / params.limit,
        rows: params.limit
    };
};
$.fn.extend({
    initCacheDropDown: function () {
        var dataKey = $(this).attr("data-type");
        var jsonData = parent.dropDownMap[dataKey];
        if (!jsonData) {
            return;
        }
        results = [];
        results.push("<option value=''>--请选择--</option>")
        for (k in jsonData) {
            results.push("<option value='" + jsonData[k].key + "'>" + jsonData[k].name + "</option>")
        }
        $(this).html(results.join(""));
    }
});

/**
 *
 * 获取当前时间
 */
function getNowTime() {
    function p(s) {
        return s < 10 ? '0' + s : s;
    }

    var myDate = new Date();
    //获取当前年
    var year = myDate.getFullYear();
    //获取当前月
    var month = myDate.getMonth() + 1;
    //获取当前日
    var date = myDate.getDate();
    var h = myDate.getHours();       //获取当前小时数(0-23)
    var m = myDate.getMinutes();     //获取当前分钟数(0-59)
    var s = myDate.getSeconds();

    var now = year + '-' + p(month) + "-" + p(date)
    /*+" "+p(h)+':'+p(m)+":"+p(s);*/
    return now;
}


$(function () {
    $(".rcDropdownInit").each(function () {
        $(this).initCacheDropDown();
    })
});


//数组去重
function arrayUnique(arr) {
    var new_arr = [];
    for (var i = 0; i < arr.length; i++) {
        var items = arr[i];
        if ($.inArray(items, new_arr) == -1) {
            new_arr.push(items);
        }
    }
    return new_arr;
}


function readDpData(k, k1) {
    var jsonData = parent.dropDownMap[k];
    if (!jsonData) {
        return;
    }
    var text = "";
    $.each(jsonData, function (i, o) {
        if (o.key == k1) {
            text = o.name;
        }
    });
    return text
}


//强制保留两位小数
function toDecimal2(x) {
    var f = parseFloat(x);
    if (isNaN(f)) {
        return false;
    }
    var f = Math.round(x * 100) / 100;
    var s = f.toString();
    var rs = s.indexOf('.');
    if (rs < 0) {
        rs = s.length;
        s += '.';
    }
    while (s.length <= rs + 2) {
        s += '0';
    }
    return s;
}

//当前月，年
var date, year, month, nowMonth;
date = new Date();
year = date.getFullYear();
month = date.getMonth() < 9 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
nowMonth = year + "-" + month;

// 日期格式化插件
Date.prototype.format = function (format) {
    var o = {
        "M+": this.getMonth() + 1, //month
        "d+": this.getDate(), //day
        "h+": this.getHours(), //hour
        "m+": this.getMinutes(), //minute
        "s+": this.getSeconds(), //second
        "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
        "S": this.getMilliseconds() //millisecond
    };
    if (/(y+)/.test(format)) format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(format))
            format = format.replace(RegExp.$1,
                RegExp.$1.length == 1 ? o[k] :
                    ("00" + o[k]).substr(("" + o[k]).length));
    return format;
};

//比较时间大小
function compareDate(d1, d2, flag, duration) {
    if (flag == true) {
        var dd1 = new Date(d1);
        dd1.setMonth(dd1.getMonth() + duration);
        return new Date(dd1) < (new Date(d2));
    } else {
        return (new Date(d1)) > (new Date(d2));
    }
}

$.fn.extend({
    getToday: function () {
        var date, y, m, d, today;
        date = new Date();
        y = date.getFullYear();
        m = date.getMonth() < 9 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        d = date.getDate() < 10 ? "0" + date.getDate() : date.getDate();
        today = y + "-" + m + "-" + d;
        $(this).val(today);
    },
    getMonthDay1: function () {
        var date, y, m, d, today;
        date = new Date();
        y = date.getFullYear();
        m = date.getMonth() < 9 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        today = y + "-" + m + "-" + "01";
        $(this).val(today);
    },
    getLastMonthDay1: function () {
        var date, y, m, d, today;
        date = new Date();
        y = date.getFullYear();
        m = date.getMonth() < 9 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        today = y + "-" + m + "-" + "01";
        $(this).val(today);
    },
    getYear1Day1: function () {
        var date, y, m, d, today;
        date = new Date();
        y = date.getFullYear();
        m = date.getMonth() < 9 ? "0" + (date.getMonth() + 1) : date.getMonth() + 1;
        d = date.getDate();
        today = (y + 1) + "-" + m + "-" + (d - 1);
        $(this).val(today);
    },
    //当年第一月
    getMonthFirst: function () {
        var date = new Date();
        var MonthFirst = date.getFullYear();
        $(this).val(MonthFirst + "-01");
    },
    //当月
    getMonthCur: function () {
        var date = new Date();
        var currentMonth = date.getMonth();
        var MonthFirstDay = new Date(date.getFullYear(), currentMonth, 1).format('yyyy-MM');
        $(this).val(MonthFirstDay);
    },
    //当月第一天
    getMonthDayFirst: function () {
        var date = new Date();
        var currentMonth = date.getMonth();
        var MonthFirstDay = new Date(date.getFullYear(), currentMonth, 1).format('yyyy-MM-dd');
        $(this).val(MonthFirstDay);
    },
    //当月最后一天
    getMonthDayLast: function () {
        var date = new Date();
        var currentMonth = date.getMonth();
        var nextMonth = ++currentMonth;
        var nextMonthFirstDay = new Date(date.getFullYear(), nextMonth, 1);
        var oneDay = 1000 * 60 * 60 * 24;
        var today = new Date(nextMonthFirstDay - oneDay).format('yyyy-MM-dd');
        $(this).val(today);
    }

});

//确认提交或退回模态框
var sureModal = '<div class="modal fade" id="sureModal">' +
    '<div class="modal-dialog">' +
    '<div class="modal-content">' +
    '<div class="modal-header">' +
    '<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>' +
    '<h4 class="modal-title">提示信息</h4>' +
    '</div>' +
    '<div class="modal-body">' +
    '<p class="tipText"></p>' +
    '</div>' +
    '<div class="modal-footer">' +
    '<button type="button" class="btn btn-primary" id="sureOption">确定</button>' +
    '<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>' +
    '</div></div></div></div>';

function oppSureModal(text) {
    if ($("#sureModal").length > 0) {
        $("#sureModal").modal("show");
        $("#sureModal").find(".tipText").text(text);
    } else {
        $("body").append(sureModal);
        $("#sureModal").find(".tipText").text(text);
        $("#sureModal").modal("show");
    }
}

function getindex(value, row, index) {
    return index + 1;
}

//跳转刷新
function pageRefreshTo(typeOrUrl, closeType) {
    var toUrl = './Modal/main/index/index.html';
    var cType = closeType;
    var currentUrl = parent.$(".active.J_menuTab").attr('data-id');
    switch (typeOrUrl) {
        case 'home':
            toUrl = './Modal/main/index/index.html';
            break;
        case 'pre':
            toUrl = '';
            break;
        case 'myTask':
            toUrl = './Modal/task/myTask/index.html';
            break;
        default:
            toUrl = typeOrUrl;
    }
    var secc = "[data-id='" + toUrl + "']";
    parent.$(secc).click().dblclick();
    if (cType === 'closeCurrent') {
        var secc = "[data-id='" + currentUrl + "']";
        parent.$(secc).find('.fa.fa-times-circle').click();
    }
}

function getIndex(value, row, index) {
    return index + 1;
}

$.fn.serializeObject = function () {
    var o = {};
    var a = this.serializeArray();
    $.each(a, function () {
        if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

function getStrDateTime(str) {
    var myDate = new Date()
    daystr = str.split(" ")[0];
    dayarr = daystr.split("-");
    myDate.setHours(0, 0, 0, 0);
    myDate.setFullYear(dayarr[0], parseInt(dayarr[1]) - 1, dayarr[2]);
    return myDate;
}