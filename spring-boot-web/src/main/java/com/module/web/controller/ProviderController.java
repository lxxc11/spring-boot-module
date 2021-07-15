package com.module.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/7/15 16:03
 **/
@RestController
public class ProviderController {
    @RequestMapping(value = "/echo/{string}", method = RequestMethod.GET)
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }
}

//   如下在消费端配置
//    @Bean
//    public RestTemplate restTemplate() {
//        return new RestTemplate();
//    }
//
//    public static void main(String[] args) throws UnknownHostException {
//        SpringApplication.run(Application.class, args);
//    }
//
//@RestController
//public class ConsumerController {
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//
//    @GetMapping(value = "/test/haha")
//    public String echo() {
//        //使用 DiscoveryClient 和 RestTemplate 结合的方式来访问
//        ServiceInstance serviceInstance = discoveryClient.getInstances("service-provider").get(0);
//        String url = String.format("http://%s:%s/echo/%s", serviceInstance.getHost(), serviceInstance.getPort(), "1111");
//        return restTemplate.getForObject(url, String.class);
//    }
//}