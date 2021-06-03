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

    public static <T> ResponseResultBuilder<T> builder(){ return  new  ResponseResultBuilder<T>();}

    public static final class ResponseResultBuilder<T> {

        private int code;

        private String message;

        private T data;

        private ResponseResultBuilder() {
        }

        public ResponseResultBuilder<T> withCode(int code) {
            this.code = code;
            return this;
        }

        public ResponseResultBuilder<T> withMsg(String message) {
            this.message = message;
            return this;
        }

        public ResponseResultBuilder<T> withData(T data) {
            this.data = data;
            return this;
        }

        /**
         * Build result.
         *
         * @return result
         */
        public ResponseResult<T> build() {
            ResponseResult<T> restResult = new ResponseResult<T>();
            restResult.setCode(code);
            restResult.setMessage(message);
            restResult.setData(data);
            return restResult;
        }
    }

    public static <T> ResponseResult<T> success() {
        return ResponseResult.<T>builder().withCode(ResultEnum.SUCCESS.getCode()).withMsg(ResultEnum.SUCCESS.getMsg()).build();
    }

    public static <T> ResponseResult<T> success(T data) {
        if (data == null) {
            List<T> a = new ArrayList<>();
            data = (T) a;
        }
        return ResponseResult.<T>builder().withCode(ResultEnum.SUCCESS.getCode()).withMsg(ResultEnum.SUCCESS.getMsg()).withData(data).build();
    }

    public static <T> ResponseResult<T> error(ResultEnum resultEnum) {
        return ResponseResult.<T>builder().withCode(resultEnum.getCode()).withMsg(resultEnum.getMsg()).build();
    }

    public static <T> ResponseResult<T> error(Integer code, String msg) {
        return ResponseResult.<T>builder().withCode(code).withMsg(msg).build();
    }

    public static <T> ResponseResult<T> error() {
        return ResponseResult.error(ResultEnum.FAILED);
    }

    public static <T> ResponseResult<T> error(ResultEnum resultEnum, String msg) {
        return error(resultEnum.getCode(), msg);
    }

    public static <T> ResponseResult<T> error(String message) {
        return new ResponseResult<T>(ResultEnum.FAILED.getCode(), message, null);
    }

    public boolean isSuccess() {
        return Objects.equals(this.code, ResultEnum.SUCCESS.getCode());
    }

    public boolean isError() {
        return !Objects.equals(this.code, ResultEnum.SUCCESS.getCode());
    }

}
