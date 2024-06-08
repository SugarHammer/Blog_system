package com.example.config;

import com.example.ops.entity.Ops_user;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取登录成功的session
        Object loginUser = request.getSession().getAttribute("user");
        if (loginUser==null){
            request.setAttribute("msg","请登录后再进行操作");
            request.getRequestDispatcher("/user-login").forward(request,response);  //转发跳转
            return false;
        }else {
            return true;
        }
    }
}
