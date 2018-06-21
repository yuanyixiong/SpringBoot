/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 * 模块表单页面负责from页面DOM事件处理
 * 事件：编号重复验证、数据保存、返回上级
 *********************************************/
$(function(){
    if (action=='add'||action=='edit') {
        /**保存**/
        $("button[sign='save']").on("click", function () {
            $.ajax({
                url: saveUrl,
                data: $("form").serialize(),
                type: "post",
                dataType: "json",
                success: function (responseData) {
                    if (responseData.status == "-1") {
                        console.log(responseData.data);
                        alert(responseData.data);
                        return;
                    }
                    alert(responseData.data);
                    loadHTML(mainUrl);
                },
                error: function () {
                    console.log("失败")
                }
            })
        });
    }

    /**返回**/
    $("button[sign='back']").on("click", function () {
        loadHTML(mainUrl);
    });

    /**重复验证**/
    $("input#id").on("change", function () {
        var $doms = $(this).nextAll().filter("span");
        var propertyValue = $(this).val();//id属性的值
        $.ajax({
            url: inspectRepeatUrl,
            data: $.param({"id": propertyValue}),
            type: "get",
            dataType: "json",
            success: function (responseData) {
                if (responseData.status == "0") {
                    inspectError($doms[0], $doms[1], "编号已存在");
                } else if (responseData.status == "-1") {
                    inspectSuccess($doms[0], $doms[1]);
                }
            },
            error: function () {
                console.log("失败");
            }
        });
    });
});
/**
 * 未通过验证
 * @param spanImage 显示图标样式的dom
 * @param spanInfo 显示文字的dom
 * @param errorInfo 显示的文字内容
 */
function inspectError(spanImage, spanInfo, errorInfo) {
    $(spanImage).addClass("glyphicon-remove").removeClass("glyphicon-ok");
    $(spanInfo).removeClass("sr-only").text(errorInfo);
    $(spanInfo).parent().addClass("has-error").removeClass("has-success");
}

/**
 * 通过验证
 * @param spanImage 显示图标样式的dom
 * @param spanInfo 显示文字的dom
 */
function inspectSuccess(spanImage, spanInfo) {
    $(spanImage).addClass("glyphicon-ok").removeClass("glyphicon-remove");
    $(spanInfo).addClass("sr-only").empty();
    $(spanInfo).parent().removeClass("has-error").addClass("has-success");
}