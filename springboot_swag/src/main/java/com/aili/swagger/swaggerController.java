package com.aili.swagger;

import com.aili.swagger.pojo.user;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class swaggerController {
    @ApiOperation("hello注释类")
    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }

    @PostMapping("/user")
    public user user(){
        return new user();
    }
}
