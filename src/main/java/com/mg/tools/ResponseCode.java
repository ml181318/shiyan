package com.mg.tools;

/**
 * 响应码枚举类
 */
public enum ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(10,"ERROR"),
    NEED_LOGIN(20,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(30,"ILLEGAL_ARGUMENT");
    private int code ;
    private String desc;
    ResponseCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }
    public int getCode(){
        return this.code;
    }
    public String getDesc(){
        return this.desc;
    }
}
