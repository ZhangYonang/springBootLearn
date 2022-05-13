package com.aili.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("A");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C");
    }
    @Bean
    public Docket docket4(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("D");
    }
    // 配置了Swagger的Docket的bean实例
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                // 配置API文档的分组
                .groupName("AILI")
                // 是否启动swagger false启动
                // .enable(false)
                .select()
                // 配置要扫描接口的方式f
                // basePackage:指定要扫描的包
                // any():扫描全部
                // none():不扫描
                // withClassAnnotation:扫描类上的注解
                // withMethodAnnotation:扫描方法上的注解
                .apis(RequestHandlerSelectors.any())
                // 过滤 .paths()
                .build();
    }
    // 配置swagger信息=apiInfo
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact("AILI", "www.ailixiya.xyz", "2784729102@qq.com");
        return new ApiInfo(
                "AILIXIYA API 文档",
                "送你一朵花",
                "1.0",
                "www.ailixiya.xyz:8888",
                 contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList()
        );

    }
}
