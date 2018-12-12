var dropDownMap;
$(function () {
    /**
     * 初始化下拉框数据，只执行一次
     */
        comn.ajax({
            url: interUrl.basic+interUrl.cache.dpAll,
            success: (function (_this) {
                return function (res) {
                    dropDownMap=res.data;
                };
            })(this)
        });

});