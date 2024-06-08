package com.example.blog.service;

import com.example.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    //用户登录
    User login(User u);

    //添加最近登录记录
    int recordLoginTime(int id);

    //查看站内活跃4人
    List<Map<Object,Object>> getHeatUser();

    //注册
    int registerUser(User user);

}
