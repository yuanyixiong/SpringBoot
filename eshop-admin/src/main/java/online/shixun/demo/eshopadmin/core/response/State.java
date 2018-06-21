/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshopadmin.core.response;

/**
 * 节点状态
 * 请求响应：treeview 插件 所需的json格式类-工具类
 */
public class State {

    private boolean checked = false;//[treeview]节点选中

    private boolean disabled = false;//[treeview]节点禁用

    private boolean expanded = false;//[treeview]节点展开

    private boolean selected = false;//[treeview]节点是否被选中

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    @Override
    public String toString() {
        return "State{" +
                "checked=" + checked +
                ", disabled=" + disabled +
                ", expanded=" + expanded +
                ", selected=" + selected +
                '}';
    }

    public State(boolean checked, boolean disabled, boolean expanded, boolean selected) {
        this.checked = checked;
        this.disabled = disabled;
        this.expanded = expanded;
        this.selected = selected;
    }
}
