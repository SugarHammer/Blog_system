package com.example.blog.service.impl;
import com.example.blog.mapper.UserMapper;
import com.example.blog.service.UserService;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public User login(User u) {
        return userMapper.login(u);
    }

    @Override
    public int recordLoginTime(int id) {
        return userMapper.recordLoginTime(id);
    }

    @Override
    public List<Map<Object, Object>> getHeatUser() {
        return userMapper.getHeatUser();
    }

    @Override
    public int registerUser(User user) {
        return userMapper.registerUser(user);
    }
}
