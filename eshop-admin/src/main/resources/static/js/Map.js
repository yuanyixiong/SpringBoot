/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 * 自定义键值对集合数据类型
 *********************************************/
function Map() {
    var obj = {};

    /**
     * put方法 添加数据进Map
     * @param key
     * @param value
     */
    this.put = function (key, value) {
        obj[key] = value;
    }

    /**
     * size方法 查看Map中的数据个数
     * @returns {number}
     */
    this.size = function () {
        var num = 0;
        for (var arr in b = obj) {
            num++;
        }
        return num;
    }

    /**
     * get 方法 通过Map的key获得Map的值
     * @param key
     * @returns {*}
     */
    this.get = function (key) {
        if (obj[key] || obj[key] === 0 || obj[key] == false) {
            return obj[key];
        } else {
            return null;
        }
    }

    /***
     * remove 方法 通过Map的key 将符合的键值对从Map中移除
     * @param key
     */
    this.remove = function (key) {
        delete obj[key];
    }

    /***
     * 遍历Map的所有key
     * @param fn
     */
    this.eachMap = function (fn) {
        for (var arr in obj) {
            fn(arr, obj[arr]);
        }
    }
}