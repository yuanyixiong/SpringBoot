/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * Bootstrap Table 服务器分页结果
 */
@JsonSerialize(using = BootstrapTableJsonSerializer.class)
public class PageResultForBootstrapTable<T> {

    //[Bootstrap Table 分页显示需要]数据总量
    private Long total;

    //[Bootstrap Table 分页显示需要]数据所有数据--此数据用于显示
    private List<T> rows;

    //[程序逻辑]选中的数据--此数据用于更改rows集合中数据的状态
    private List<T> checkeds;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public List<T> getCheckeds() {
        return checkeds;
    }

    public void setCheckeds(List<T> checkeds) {
        this.checkeds = checkeds;
    }

    public PageResultForBootstrapTable(Long total, List<T> rows, List<T> checkeds) {
        this.total = total;
        this.rows = rows;
        this.checkeds = checkeds;
    }
}
