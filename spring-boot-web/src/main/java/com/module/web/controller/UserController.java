package com.module.web.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.module.common.api.ResponseResult;
import com.module.web.service.UserService;
import com.module.web.vo.UserVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/5/6 10:19
 **/
@Api(tags = "用户模块")
@ApiSupport(order = 1)
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService ;

    @ApiOperation(value = "用户注册接口")
    @ApiOperationSupport(author = "lvxc",order = 2)
    @PostMapping(value = "/register")
    public ResponseResult<Integer> register(@RequestBody UserVo vo) {
        Integer num = userService.register(vo);
        return ResponseResult.success(num);
    }

    @ApiOperation(value = "用户注册接口第二代")
    @ApiOperationSupport(author = "lvxc2",order = 1,ignoreParameters = {"password","email"})
    @PostMapping(value = "/register2")
    public ResponseResult<Integer> register2(@RequestBody UserVo vo) {
        Integer num = userService.register(vo);
        return ResponseResult.success(num);
    }

    @ApiOperation(value = "用户列表查询")
    @ApiOperationSupport(author = "lvxc",order = 3)
    @GetMapping(value = "/selectUsers")
    public ResponseResult<Object> selectUsers(@RequestParam(value = "pageNum" ,defaultValue="1") Integer pageNum
                                            ,@RequestParam(value = "pageSize" ,defaultValue="10") Integer pageSize) {
        Object data = userService.selectUsers(pageNum,pageSize);
        return ResponseResult.success(data);
    }

}
