/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *  模块主页分页负责分页的控制
 * 请求地址：
 * saveUrl          = 添加-跳转from页面URL,且指定多动类型为add
 * editUrl          = 编辑-跳转from页面URL,且指定多动类型为edit
 * infoUrl          = 详情-跳转from页面URL,且指定多动类型为info
 * getPagesUrl      = 模块分页的URL
 * deleteUrl        = 分页列表删除的URL
 *
 *
 * buttons          = 按钮对象指定绑定的按钮
 *********************************************/
$(function () {

    //分页查询数据
    initTableAndPagination();

    //查询按钮的单击事件
    $("button[sign='search']").on("click", function () {
        //设置为第一页
        $("#page").val(0);
        //分页查询数据
        initTableAndPagination();
    });

    //添加按钮的单击事件
    $("button[sign='new']").on("click", function () {
        loadHTML(saveUrl);
    });

    //添加按钮的单击事件,控制界面场景
    $("button[sign='trigger']").on("click", function () {
        if ($(this).html() == '回收站') {
            $("#is_del").val(1);

            //回收站场景
            $(this).html("桌&nbsp;&nbsp;面"); //显示[切换桌面]按钮
            $("#triggerInfo").text("回收站列表");//显示路径[回收站列表]
            buttons.setDeleteButtonFake(false);//[隐藏][假删]
            buttons.setDeleteButtonReal(true);//[显示][真删]
            buttons.setDeleteButtonRestore(true);//[显示][还原]
        } else {
            $("#is_del").val(2);

            //桌面场景
            $(this).html("回收站");//显示[切换回收站]按钮
            $("#triggerInfo").text("桌面列表");//显示路径[桌面列表]
            buttons.setDeleteButtonFake(true);//[显示][假删]
            buttons.setDeleteButtonReal(false);//[隐藏][真删]
            buttons.setDeleteButtonRestore(false);//[隐藏][还原]
        }

        //触发查询按钮的查询事件
        //$("button[sign='search']").trigger("click");
        //分页查询数据
        initTableAndPagination();
    });
});

/**
 *初始化表格和分页插件
 */
function initTableAndPagination() {
    $.ajax({
        url: getPagesUrl,
        data: $("form").serialize(),
        type: "get",
        dataType: "json",
        success: function (responseData) {

            //服务器响应的逻辑错误判断
            if (responseData.status == "-1") {
                console.log(responseData.data);
                alert(responseData.data);
                return;
            }

            //分页数据
            var totalPages = responseData.data.totalPages;//分页信息[总页数]
            var number = responseData.data.number;//分页信息[当前页码]

            //初始化分页工具
            $("#pagination").pagination(totalPages, {
                num_edge_entries: 4,
                num_display_entries: 2,
                current_page: number,
                prev_text: '上一页',
                next_text: '下一页',
                prev_show_always: true,
                next_show_always: true,
                ellipse_text: '...',
                callback: function (page_index, jq) {
                    //设置页码
                    $("#page").val(page_index);
                    //执行翻页
                    pageTurning();
                },
                items_per_page: 1
            });

        },
        error: function () {
            console.log("失败");
        }
    });
}

/**
 * 翻页
 */
function pageTurning() {
    $.ajax({
        url: getPagesUrl,
        data: $("form").serialize(),
        type: "get",
        dataType: "json",
        success: function (responseData) {

            //服务器响应的逻辑错误判断
            if (responseData.status == "-1") {
                console.log(responseData.data);
                alert(responseData.data);
                return;
            }
            //分页数据
            var size = responseData.data.size; //分页信息[每页显示的数据条数]
            var list = responseData.data.content; //分页后的数据

            //初始化表格
            //清空表格数据
            $("table tbody#data").empty();

            //分页的数据,组装到表格中
            for (var i in list) {
                //序号 = 当前页码 * 每页显示的数据量 + 当前的行号 + 1
                var serialNumber = parseInt($("#page").val()) * parseInt(size) + parseInt(i) + 1;

                /**
                 * 初始化表格中一行的数据
                 * 重点此处功能由不同模块单独提供实现表格行上需要显示的数据数组
                 * @type {Array}
                 */
                var rowValues = initRowValues(list[i], serialNumber);

                //根据数据初始化表格中一行的结构
                var row = $(newRow(rowValues, i));
                //将初始化完成的表格行信息追加到表格中
                $("table tbody#data").append(row);
            }
        },
        error: function () {
            console.log("失败");
        }
    });
}

/**
 * 构建成表格的tr部分
 * @param rowValues 当前行列数据的数组
 * @param rowIndex 行号
 * @returns 构建完成的tr
 */
function newRow(rowValues, rowIndex) {

    var tr = $("<tr></tr>");

    //根据行编号控制隔行变色
    if (rowIndex % 2 == 0) {
        $(tr).addClass("active");
    }

    //根据数据构建行同时设置好行对应的数据
    for (var i = 0; i < rowValues.length - 1; i++) {
        tr.append($("<td></td>").text(rowValues[i]));
    }

    //组装当前行最后一个td，主要展示操作按钮
    var td = $("<td></td>");
    var id = rowValues[rowValues.length - 1];

    //绑定按钮
    bindingButtons(td, id);

    tr.append(td);

    return tr;
}


/***
 * 绑定按钮，内部需要一个Buttons对象指定绑定的按钮
 * @param td 绑定的位置(td)
 * @param id 数据编号
 */
function bindingButtons(td, id) {
    //设置当前行绑定的按钮
    if (buttons.getInfoButton()) {
        //详情按钮
        td.append($("<button type='button' class='btn-info btn-xs' sign='info'>详情</button>").on("click", function () {
            loadHTML(infoUrl + "&" + $.param({'id': id}));
        }));
    }
    if (buttons.getEditButton()) {
        //编辑按钮
        td.append($("<button type='button' class='btn-warning btn-xs' sign='edit'>编辑</button>").on("click", function () {
            loadHTML(editUrl + "&" + $.param({'id': id}));
        }));
    }
    if (buttons.getDeleteButtonFake()) {
        //假删除按钮
        td.append($("<button type='button' class='btn-danger btn-xs' sign='delFake'>删除</button>").on("click", function () {
            $.ajax({
                url: deleteUrlFake,
                type: "get",
                data: {"id": id},
                dataType: "json",
                success: function (responseData) {
                    if (responseData.status == "-1") {
                        console.log(responseData.data);
                        alert(responseData.data);
                        return;
                    }
                    //初始化数据
                    initTableAndPagination();
                },
                error: function () {
                    console.log("失败");
                }
            });
        }));
    }
    if (buttons.getDeleteButtonReal()) {
        //真删除按钮
        td.append($("<button type='button' class='btn-danger btn-xs' sign='delRea'>删除</button>").on("click", function () {
            $.ajax({
                url: deleteUrlReal,
                type: "get",
                data: {"id": id},
                dataType: "json",
                success: function (responseData) {
                    if (responseData.status == "-1") {
                        console.log(responseData.data);
                        alert(responseData.data);
                        return;
                    }
                    //初始化数据
                    initTableAndPagination();
                },
                error: function () {
                    console.log("失败");
                }
            });
        }));
    }

    if (buttons.getDeleteButtonRestore()) {
        //真删除按钮
        td.append($("<button type='button' class='btn-success btn-xs' sign='delRestore'>还原</button>").on("click", function () {
            $.ajax({
                url: deleteUrlRestore,
                type: "get",
                data: {"id": id},
                dataType: "json",
                success: function (responseData) {
                    if (responseData.status == "-1") {
                        console.log(responseData.data);
                        alert(responseData.data);
                        return;
                    }
                    //初始化数据
                    initTableAndPagination();
                },
                error: function () {
                    console.log("失败");
                }
            });
        }));
    }

    if (buttons.getUpButton()) {
        //上架按钮
        td.append($("<button type='button' class='btn-success btn-xs' sign='up'>上架</button>").on("click", function () {
            $.ajax({
                url: productUpUrl,
                type: "get",
                data: {"id": id},
                dataType: "json",
                success: function (responseData) {
                    if (responseData.status == "-1") {
                        console.log(responseData.data);
                        alert(responseData.data);
                        return;
                    }
                    //初始化数据
                    initTableAndPagination();
                },
                error: function () {
                    console.log("失败");
                }
            });
        }));
    }

    if (buttons.getDownButton()) {
        //下架按钮
        td.append($("<button type='button' class='btn-warning btn-xs' sign='down'>下架</button>").on("click", function () {
            $.ajax({
                url: productDownUrl,
                type: "get",
                data: {"id": id},
                dataType: "json",
                success: function (responseData) {
                    if (responseData.status == "-1") {
                        console.log(responseData.data);
                        alert(responseData.data);
                        return;
                    }
                    //初始化数据
                    initTableAndPagination();
                },
                error: function () {
                    console.log("失败");
                }
            });
        }));
    }
}