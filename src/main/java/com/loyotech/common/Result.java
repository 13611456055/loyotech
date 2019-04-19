package com.loyotech.common;

import org.springframework.stereotype.Component;

@Component
public class Result {

    private Integer status = 200;
    private Object msg = "success";

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getMsg() {
        return msg;
    }

    public void setMsg(Object msg) {
        this.msg = msg;
    }

    public Result(Integer status, Object msg) {
        super();
        this.status = status;
        this.msg = msg;
    }

    public Result() {
        super();
    }

    @Override
    public String toString() {
        return "Result [status=" + status + ", msg=" + msg + "]";
    }
}
