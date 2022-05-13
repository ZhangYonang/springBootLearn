package com.aili.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// AOP
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // 所有人都能访问首页
                .antMatchers("/").permitAll()
                // leave1下的页面只能leve1的能访问
                .antMatchers("/leave1/**").hasRole("leave1")
                .antMatchers("/leave2/**").hasRole("leave2")
                .antMatchers("/leave3/**").hasRole("leave3");

        // 没有权限跳到登录页面
        http.formLogin()
                // 定制登录页面
                .loginPage("/login")
                // 登录认证
                .loginProcessingUrl("/")
                // 前端登录 用户名密码  默认为 username password
                .usernameParameter("username").
                passwordParameter("password");
        // 注销登录
        http.logout().logoutSuccessUrl("/");
        // 开启记住登录 cookie 默认保存两周
        http.rememberMe().rememberMeParameter("remember");
    }

    // 认证
    // 密码编码 PasswordEncoder
    // 在Spring Security 5.0+ 新增了很多的加密方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 数据库认证
        auth.jdbcAuthentication();
        // 内存 认证
        auth.inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("aili")
                .password(new BCryptPasswordEncoder().encode("123456"))
                .roles("leave1");
    }
}
