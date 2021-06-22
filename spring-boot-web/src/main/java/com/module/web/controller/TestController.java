package com.module.web.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.module.common.api.ResponseResult;
import com.module.common.exception.ApiException;
import com.module.web.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/4/26 10:45
 **/
@Api(tags = "测试模块")
@ApiSupport(order = 2)
@Slf4j
@RestController
@RequestMapping("/test")
public class TestController {

    @ApiOperation(value = "测试插入")
    @PostMapping(value = "/insert")
    public ResponseResult<String> insert(@RequestBody TestVo vo){
        log.info("日志输出");
        if(StringUtils.isBlank(vo.getName())){
            throw new ApiException("名称不能为空");
        }
        return ResponseResult.success("你好");
    }


}
