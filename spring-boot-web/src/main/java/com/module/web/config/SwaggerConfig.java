package com.module.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author lvxc
 * @Date 2021/5/7 9:57
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("web分组")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.module.web.controller"))
                .paths(PathSelectors.any())
                .build().globalRequestParameters(parameter());
    }

    private List<RequestParameter> parameter() {
        List<RequestParameter> requestParameters=new ArrayList<>();
        requestParameters.add(new RequestParameterBuilder().name("userId").description("用户id").in(ParameterType.HEADER).required(false).build());
        return requestParameters ;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("spring-boot-module工程")
                .description("spring-boot-module工程接口文档")
                .termsOfServiceUrl("http://www.group.com/")
                .contact(new Contact("lvxc","",""))
                .version("1.0")
                .build();
    }
}
