package com.dnp.common.auth.config;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    //private ApiInfo apiInfo() {
    //    return new ApiInfoBuilder().title("common_auth")
    //            .description("common_auth")
    //            .contact("Software_King@qq.com")
    //            .version("1.0").build();
    //}

    //@Bean
    //public Docket api() {
    //    return new Docket(DocumentationType.SWAGGER_2)
    //            .apiInfo(apiInfo())
    //            .pathMapping("/")
    //            .select() // 选择那些路径和api会生成document
    //            .apis(RequestHandlerSelectors.any())// 对所有api进行监控
    //            //不显示错误的接口地址
    //            .paths(Predicates.not(PathSelectors.regex("/error.*")))//错误路径不监控
    //            .paths(PathSelectors.regex("/.*"))// 对根下所有路径进行监控
    //            .build();
    //}
    //
    //private ApiInfo apiInfo() {
    //    return new ApiInfoBuilder().title("这是我的接口文档")
    //            .contact("dnp")
    //            .description("这是SWAGGER_2生成的接口文档")
    //            .termsOfServiceUrl("NO terms of service")
    //            .license("The Apache License, Version 2.0")
    //            .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
    //            .version("v1.0")
    //            .build();
    //}

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))                         //这里采用包含注解的方式来确定要显示的接口
//                .apis(RequestHandlerSelectors.basePackage("com.dnp.modular.controller"))    //这里采用包扫描的方式来确定要显示的接口
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("baomidou-test")
                .description("测试保密都 Api文档")
                .termsOfServiceUrl("")
                .contact("华仔")
                .version("2.0")
                .build();
    }
}
