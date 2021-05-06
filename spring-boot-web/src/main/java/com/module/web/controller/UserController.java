package com.module.web.controller;

import com.module.common.api.ResponseResult;
import com.module.web.service.UserService;
import com.module.web.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/5/6 10:19
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService ;

    @PostMapping(value = "/register")
    public ResponseResult<Integer> register(@RequestBody UserVo vo) {
        Integer num = userService.register(vo);
        return ResponseResult.success(num);
    }

}
