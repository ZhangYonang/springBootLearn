package com.aili.yibu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

// 开启异步注解功能
@EnableAsync
@SpringBootApplication
public class SpringbootYiburenwuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootYiburenwuApplication.class, args);
    }

}
