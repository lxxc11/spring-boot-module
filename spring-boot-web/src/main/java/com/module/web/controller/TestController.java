package com.module.web.controller;

import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.module.common.api.ResponseResult;
import com.module.web.service.UserService;
import com.module.web.vo.TestVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public ResponseResult<String> insert(@RequestBody TestVo vo) {
        log.info("日志输出");
        return ResponseResult.success("你好");
    }


}
