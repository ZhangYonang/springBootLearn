package com.wuhu.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 登录页面拦截器
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 登录成功之后，应该有用户的session
        Object userSignin = request.getSession().getAttribute("userSignin");
        if(userSignin==null){
            request.setAttribute("signinerr","请先登录");
            request.getRequestDispatcher("/signin").forward(request,response);
            return false;
        }else {
            return true;
        }
    }
}
