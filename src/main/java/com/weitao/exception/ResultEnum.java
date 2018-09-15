package com.weitao.exception;

/**
 * Created by lzr on 2018/9/5.
 */
public enum ResultEnum {
    UNKNOW_ERROR("-1","未知错误"),
    SUCCESS("0","成功"),
    USERNAME_EXIST("101","用户名已存在"),
    USER_NOT_EXIST("102","用户名不存在"),
    USER_NOT_FAIL("103","查询用户失败"),
    USER_LOGIN_FAIL("103","登陆失败"),


    ITEMS_EXSIT("201","库存小于0"),
    ITEMS_INSERT_FAIL("202","商品添加失败")
    ;
    private String code;
    private String msg;

    ResultEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
