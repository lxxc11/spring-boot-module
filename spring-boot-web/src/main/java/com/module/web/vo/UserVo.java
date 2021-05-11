package com.module.web.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/5/6 10:17
 **/
@Data
@ApiModel
public class UserVo  implements Serializable {

     @ApiModelProperty(value = "姓名")
     private String name ;

     @ApiModelProperty(value = "密码")
     private String password ;

     @ApiModelProperty(value = "邮件")
     private String email ;
}
