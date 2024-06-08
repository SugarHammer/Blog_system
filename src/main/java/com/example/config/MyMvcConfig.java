package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**","/fonts/**","/images/**","/js/**","/img/**","/layer/**","/lib/**","/plugin/**","/temp/**","opsadmin/**",
                        "/mood","/mood.html",
                        "/index","/about","/article","/article_detail","/board","/user-login","/user-register",
                        "/index.html","/about.html","/article.html","/article_detail.html","/board.html","/user-login.html","/user-register.html",
                        "/randoms","/blog/user/login","/blog/user/register",
                        "/ops-index.html","ops-index");
    }

}
