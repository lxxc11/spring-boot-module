package com.module.web.controller;

import com.module.common.api.ResponseResult;
import com.module.web.service.UserService;
import com.module.web.vo.TestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/4/26 10:45
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @PostMapping(value = "/insert")
    public ResponseResult<String> insert(@RequestBody TestVo vo) {
        return ResponseResult.success("你好");
    }


}
