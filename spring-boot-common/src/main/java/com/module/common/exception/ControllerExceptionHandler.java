package com.module.common.exception;


import com.module.common.api.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description 统一异常处理
 * @Author lvxc
 * @Date 2021/5/26 9:29
 **/
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ResponseResult handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return ResponseResult.error(e.getErrorCode());
        }
        return ResponseResult.error(e.getMessage());
    }
}
