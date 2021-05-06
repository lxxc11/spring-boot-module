package com.module.generate.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author lvxc
 * @since 2021-05-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("zs_sys_user")
@ApiModel(value="SysUser对象", description="用户表")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户名(登录帐号)")
    private String loginName;

    @ApiModelProperty(value = "用户密码")
    private String loginPassword;

    @ApiModelProperty(value = "手机号")
    private String mobile;

    @ApiModelProperty(value = "电子邮箱")
    private String email;

    @ApiModelProperty(value = "新增时间")
    private LocalDateTime createTime;


    public static final String ID = "id";

    public static final String LOGIN_NAME = "login_name";

    public static final String LOGIN_PASSWORD = "login_password";

    public static final String MOBILE = "mobile";

    public static final String EMAIL = "email";

    public static final String CREATE_TIME = "create_time";

}
