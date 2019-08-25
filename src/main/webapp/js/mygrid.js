$(function () {
    // 自定义一个数据表格函数
    $.fn.mygrid = function (args) {
        if (args.colnames != null) {
            // 绘制一个表格
            $(this).append('<tr>' +
                '<td>编号</td>' +
                '<td>名称</td>' +
                '<td>年龄</td>' +
                '</tr>').prop('border', '2px');
        }

    };
})
