package com.mg.tools;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

/**
 * 通用服务响应对象
 * @param <T>
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL) //序列化时 null 的对象消失
public class ServerResponse<T> implements Serializable {
    private int code ;
    private String msg ;
    private T data ;
    private ServerResponse(int status){
        this.code = status ;
    }
    private ServerResponse(int status,String msg){
        this.code = status ;
        this.msg = msg ;
    }
    private ServerResponse(int status,T data){
        this.code = status ;
        this.data = data ;
    }
    private ServerResponse(int status,T data,String msg){
        this.code = status ;
        this.data = data;
        this.msg = msg ;
    }

    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
    public T getData() {
        return data;
    }
    @JsonIgnore //忽略序列化
    public boolean isSuccess(){
        return this.code == com.mg.tools.ResponseCode.SUCCESS.getCode();
    }
    public static <T> com.mg.tools.ServerResponse<T> createBySuccess(){
        return new com.mg.tools.ServerResponse<>(com.mg.tools.ResponseCode.SUCCESS.getCode());
    }
    public static <T> com.mg.tools.ServerResponse<T> createBySuccemgessage(String msg){
        return new com.mg.tools.ServerResponse<>(com.mg.tools.ResponseCode.SUCCESS.getCode(),msg);
    }
    public static <T> com.mg.tools.ServerResponse<T> createBySuccess(T data){
        return new com.mg.tools.ServerResponse<>(com.mg.tools.ResponseCode.SUCCESS.getCode(),data);
    }
    public static <T> com.mg.tools.ServerResponse<T> createBySuccess(T data, String msg){
        return new com.mg.tools.ServerResponse<>(com.mg.tools.ResponseCode.SUCCESS.getCode(),data,msg);
    }
    public static <T> com.mg.tools.ServerResponse<T> createByError(){
        return  new com.mg.tools.ServerResponse<>(com.mg.tools.ResponseCode.ERROR.getCode(), com.mg.tools.ResponseCode.ERROR.getDesc());
    }
    public static <T> com.mg.tools.ServerResponse<T> createByErrorMessage(String errorMassage){
        return  new com.mg.tools.ServerResponse<>(com.mg.tools.ResponseCode.ERROR.getCode(),errorMassage);
    }
    public static <T> com.mg.tools.ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMassage){
        return  new com.mg.tools.ServerResponse<>(errorCode,errorMassage);
    }
}
