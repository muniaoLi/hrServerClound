package com.muniao.securityserver.bean;

import lombok.Data;

@Data
public class RespBean<T>
{
    private Integer status;
    private String msg;
    private T obj;

    private RespBean() {
    }

    public static RespBean build() {
        return new RespBean();
    }

    public static RespBean ok(String msg, Object obj) {
        return new RespBean(200, msg, obj);
    }

    public static RespBean ok(String msg) {
        return new RespBean(200, msg, null);
    }

    public static RespBean error(String msg, Object obj) {
        return new RespBean(500, msg, obj);
    }

    public static RespBean error(String msg) {
        return new RespBean(500, msg, null);
    }

    private RespBean(Integer status, String msg, T obj) {
        this.status = status;
        this.msg = msg;
        this.obj = obj;
    }

    public RespBean setObj(T obj) {
        this.obj = obj;
        return this;
    }

    public Boolean isOk()
    {
        if(this.getStatus()==200)
            return Boolean.TRUE;
        else
            return Boolean.FALSE;
    }
}
