package com.module.common.api;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/4/26 10:54
 **/
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态码
     **/
    private int code;
    /**
     * 返回信息
     **/
    private String message;
    /**
     * 返回具体对象信息
     **/
    private T data;

    private String tid;

    public int getCode() {
        return code;
    }

    public ResponseResult<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseResult<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseResult<T> setData(T data) {
        this.data = data;
        return this;
    }

    public String getTid() {
        return tid;
    }

    public ResponseResult<T> setTid(String tid) {
        this.tid = tid;
        return this;
    }

    public ResponseResult() {
    }

    public ResponseResult(int code) {
        this.code = code;
    }

    public ResponseResult(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public ResponseResult(int code, String message, T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    public static <T> ResponseResult<T> success() {
        return new ResponseResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg());
    }

    public static <T> ResponseResult<T> success(T data) {
        if (data == null) {
            List<T> a = new ArrayList<>();
            data = (T) a;
        }
        return new ResponseResult<>(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMsg(),data);
    }

    public static <T> ResponseResult<T> error(ResultEnum resultEnum) {
        ResponseResult<T> result = new ResponseResult<>();
        result.setCode(resultEnum.getCode());
        result.setMessage(resultEnum.getMsg());
        return result;
    }

    public static <T> ResponseResult<T> error(Integer code, String msg) {
        return new ResponseResult<>(code, msg);
    }

    public static <T> ResponseResult<T> error() {
        return ResponseResult.error(ResultEnum.FAILED);
    }

    public static <T> ResponseResult<T> error(ResultEnum resultEnum, String msg) {
        return error(resultEnum.getCode(), msg);
    }

    public boolean isSuccess() {
        return Objects.equals(this.code, ResultEnum.SUCCESS.getCode());
    }

    public boolean isError() {
        return !Objects.equals(this.code, ResultEnum.SUCCESS.getCode());
    }

}
