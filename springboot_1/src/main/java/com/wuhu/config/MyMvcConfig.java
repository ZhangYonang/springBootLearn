package com.wuhu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 全面扩展MVC
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("signin");
        registry.addViewController("/signin").setViewName("signin");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/add").setViewName("add");
    }
    // 国际化
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
    // 登录拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/","/signin","/user/signin","/index","/add"
                        ,"/css/**","/fonts/**","/image/**","/js/**","/picture/**","/webfonts/**","/webfonts/**","/favicon.ico");
    }
    // 配置让thymeleaf能成功显示静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }
}















