package com.module.common.exception;

import com.module.common.api.ResultEnum;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/5/26 9:24
 **/
public class ApiException extends RuntimeException{
    private ResultEnum resultEnum ;

    public ApiException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.resultEnum = resultEnum ;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ResultEnum getErrorCode() {
        return resultEnum;
    }
}
