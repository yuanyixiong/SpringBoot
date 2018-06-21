/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 * 模块表单页面负责from页面表单数据的初始化(详情、编辑、添加)
 * 需要提供
 * 临时变量：
 * var action=[add/info/edit] 页面的活动类型
 * info 浏览详情，需要赋值
 * edit 修改数据，需要赋值
 * add  添加数据, 无需处理
 * var $model=返回的数据模型
 * 请求地址：
 * saveUrl          = 保存、修改公用此URL
 * mainUrl          = 返回模块主页面的URL
 * inspectRepeatUrl = 编号重复验证的URL
 *********************************************/
$(function () {
    //加载数据
    if (action == "info") {
        //操作类型为info所有表单仅提供浏览
        for (var i = 0; i < $model.length; i++) {
            if ($model[i].filter("[type='radio']").length > 0) {
                //单选框
                $model[i].filter("[type='radio']").each(function (index, dom) {
                    $(dom).attr("disabled", true);
                });
            } else {
                //常规文本框
                $model[i].attr("readonly", true);
            }
        }
    } else if (action == "edit") {
        //操作类型为edit隐藏编号表单
        $model[0].parent().attr("readonly", true).addClass("sr-only");
    }
});

