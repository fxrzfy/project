var alljs = {};
(function () {
    alljs = {
        // 时间组件
        action: function (number) {
            for (var i = 0; i < number; i++) {
                laydate.render({
                    elem: '#test' + i
                    , type: 'date'
                });
            }
        },
        laytable: function () {
            var $ = layui.jquery,
                form = layui.form;
            //全选
            form.on('checkbox(allChoose)', function (data) {
                console.log(data)
                var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
                child.each(function (index, item) {
                    item.checked = data.elem.checked;
                });
                form.render('checkbox');
            });
        },
        
        testContext: function () {

        }
    }
})()