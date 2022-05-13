package com.wuhu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;


@Controller
public class SigninController {
    @RequestMapping("/user/signin")
    public String Login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session){
        if(username.equals("123") && password.equals("123")){
            session.setAttribute("userSignin",username);
            return "redirect:/index";
        }else {
            model.addAttribute("signinerr","用户名或密码错误");
            return "signin";
        }
    }
}
