/********************************************
 * Copyright (c) , shixun.online
 *
 * All rights reserved
 *
 *********************************************/
package online.shixun.demo.eshop.core.response;

/**
 * 请求响应：web 异步响应对象
 */
public class ResponseData {

    private static final long serialVersionUID = 1L;

    // 成功状态编码
    private static final String SUCCESS_CODE = "0";

    // 失败状态编码
    private static final String ERROR_CODE = "-1";

    // 状态
    private String status = SUCCESS_CODE;

    // 返回数据
    private Object data;

    public boolean isSuccess() {
        return this.status.equalsIgnoreCase(SUCCESS_CODE) ? true : false;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setError(Object data) {
        this.status = ERROR_CODE;
        this.data = String.format("%s:%s", "操作失败", data);
    }

    public void setError(String status, Object data) {
        this.status = status;
        this.data = data;
    }
}
