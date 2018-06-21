/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 * jquery treeview 插件
 * parentId             [不可见]父节点提交值的表单id
 * parentName           [可见]父节点显示的文本表单id
 * tree                 [默认不可见]treeview树的id
 *
 * 请求地址：
 * loadTreeViewUrl      = treeview树的加载数据的请求地址
 * loadParentNameUrl    = parentName表单显示值的请求地址
 * treeview 加载的json数据结构：[{text:"root1", id:"100", nodes:[]}]
 *********************************************/

if(action!='info') {

    /**
     * 表单parentName单击显示treeview树
     */
    $("#parentName").on("focus", function () {
        $("#tree").removeClass("sr-only");
    });

    /**
     * 加载treeview树的的数据
     */
    $.ajax({
        url: loadTreeViewUrl,
        data: {},
        type: "get",
        dataType: "json",
        success: function (responseData) {
            if (responseData.status == "-1") {
                console.log("失败");
                console.log(responseData.data);
                return;
            }
            initTreeview(JSON.stringify(responseData.data));
        },
        error: function () {
            console.log("失败");
        }
    });

    /**
     * 根据json
     * json 单个节点结构 {text:"root1", id:"100", nodes:[]}
     * @param data 加载 treeview
     */
    function initTreeview(data) {
        $("#tree").treeview({
            data: data,
            showIcon: true,
            showCheckbox: false,
            levels: 1, //默认展开级别
            onNodeSelected: function (event, node) {
                console.log("一个节点被选择");
                $("#parentId").val(node.id);
                $("#parentName").val(node.text);
                $("#tree").addClass("sr-only");
            }
        });
    }
}

if(action!='add') {
    /*
     * 开启页面加载父节点的名称
     */
    $(function () {
        $.ajax({
            url: loadParentNameUrl,
            data: {"id": $("#parentId").val()},
            type: "get",
            dataType: "json",
            success: function (responseData) {
                if (responseData.status == "-1") {
                    console.log("失败");
                    console.log(responseData.data);
                    return;
                }

                /**
                 * 绑定parentName
                 * 重点此处功能由不同模块单独提供实现取出什么取返回的数据模型中的数据绑定在parentName中
                 * @type {Array}
                 */
                bindingParentName(responseData);
            },
            error: function () {
                console.log("失败");
            }
        });
    });
}