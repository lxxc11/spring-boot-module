package com.module.web.vo;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.io.Serializable;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/5/6 10:17
 **/
@Data
public class UserVo  implements Serializable {

     private String name ;

     private String password ;

     private String email ;
}
