package com.module.web.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/5/6 10:23
 **/
@Configuration
@EnableTransactionManagement
@MapperScan({"com.module.generate.mapper"})
public class MyBatisConfig {
}
