/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 * 分页列表的按钮
 *********************************************/

/**
 * 构造方法
 * @param infoButton  详情按钮 true-显示,false-不显示
 * @param editButton 修改按钮 true-显示,false-不显示
 * @param deleteButtonFake 假删除按钮 true-显示,false-不显示
 * @param deleteButtonReal 真删除按钮 true-显示,false-不显示
 * @param deleteButtonRestore 还原按钮 true-显示,false-不显示
 * @param upButton 上架按钮 true-显示,false-不显示
 * @param downButton 下架按钮 true-显示,false-不显示
 * @constructor
 */
function Buttons(infoButton, editButton, deleteButtonFake, deleteButtonReal,deleteButtonRestore,upButton, downButton) {
    this.infoButton = infoButton;
    this.editButton = editButton;
    this.deleteButtonFake = deleteButtonFake;
    this.deleteButtonReal = deleteButtonReal;
    this.deleteButtonRestore=deleteButtonRestore;
    this.upButton = upButton;
    this.downButton = downButton;
}
Buttons.prototype.infoButton = true;    // 详情按钮 true-显示,false-不显示
Buttons.prototype.editButton = true;    // 修改按钮 true-显示,false-不显示
Buttons.prototype.deleteButtonFake = false;   // 假删除按钮 true-显示,false-不显示
Buttons.prototype.deleteButtonReal = false;   // 真删除按钮 true-显示,false-不显示
Buttons.prototype.deleteButtonRestore = false; //还原按钮 true-显示,false-不显示
Buttons.prototype.upButton= false;   // 上架按钮 true-显示,false-不显示
Buttons.prototype.downButton = false;   // 下架按钮 true-显示,false-不显示


Buttons.prototype.getInfoButton = function () {
    return this.infoButton;
}
Buttons.prototype.setInfoButton = function (infoButton) {
    this.infoBitton = infoButton;
}


Buttons.prototype.getEditButton = function () {
    return this.editButton;
}
Buttons.prototype.setEditButton = function (editButton) {
    this.editButton = editButton;
}


Buttons.prototype.getDeleteButtonFake = function () {
    return this.deleteButtonFake;
}
Buttons.prototype.setDeleteButtonFake = function (deleteButtonFake) {
    this.deleteButtonFake = deleteButtonFake;
}

Buttons.prototype.getDeleteButtonReal = function () {
    return this.deleteButtonReal;
}
Buttons.prototype.setDeleteButtonReal = function (deleteButtonReal) {
    this.deleteButtonReal = deleteButtonReal;
}
Buttons.prototype.getDeleteButtonRestore = function () {
    return this.deleteButtonRestore;
}
Buttons.prototype.setDeleteButtonRestore = function (deleteButtonRestore) {
    this.deleteButtonRestore = deleteButtonRestore;
}
Buttons.prototype.getUpButton = function () {
    return this.upButton;
}
Buttons.prototype.setUpButton = function (upButton) {
    this.upButton = upButton;
}


Buttons.prototype.getDownButton = function () {
    return this.downButton;
}
Buttons.prototype.setDownButton = function (downButton) {
    this.downButton = downButton;
}




