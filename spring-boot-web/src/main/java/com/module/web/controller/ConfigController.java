//package com.module.web.controller;
//
//import com.alibaba.nacos.api.config.annotation.NacosValue;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
//import org.springframework.context.ApplicationContext;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @Description
// * @Author lvxc
// * @Date 2021/7/8 11:28
// **/
//@RestController
//@RequestMapping("config")
//@RefreshScope
//@Slf4j
//public class ConfigController {
//    @Value("${useLocalCache:false}")
//    private boolean useLocalCache;
//
//    @Autowired
//    private ApplicationContext applicationContext ;
//
//    @RequestMapping(value = "/get", method = RequestMethod.GET)
//    @ResponseBody
//    public boolean get() {
//        //日志级别动态刷新,nacos配置中心配置如下
////        logging:
////          level:
////            root: warn
////            com.alibaba: debug
//        log.debug("debug get");
//        log.info("info get");
//        log.warn("warn get");
//        log.error("error get");
//        return useLocalCache;
//    }
//
//    @RequestMapping(value = "/get2", method = RequestMethod.GET)
//    @ResponseBody
//    public String get2() {
//        return applicationContext.getEnvironment().getProperty("knife4j.enable");
//    }
//}
