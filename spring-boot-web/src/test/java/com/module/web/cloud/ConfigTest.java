package com.module.web.cloud;

import com.alibaba.nacos.api.NacosFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;

import java.util.Properties;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/7/12 18:14
 **/
public class ConfigTest {
    public static void main(String[] args) {
        try {
            String serverAddr = "127.0.0.1:8848";
            String dataId = "example-dev.yaml";
            String group = "DEFAULT_GROUP";
            Properties properties = new Properties();
            properties.put("serverAddr", serverAddr);
            ConfigService configService = NacosFactory.createConfigService(properties);
            String content = configService.getConfig(dataId, group, 5000);
            System.out.println(content);
        } catch (NacosException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
