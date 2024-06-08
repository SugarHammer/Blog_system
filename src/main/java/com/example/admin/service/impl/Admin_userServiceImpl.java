package com.example.admin.service.impl;

import com.example.admin.mapper.Admin_userMapper;
import com.example.admin.service.Admin_userService;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Admin_userServiceImpl implements Admin_userService {

    @Autowired
    private Admin_userMapper userMapper;

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }
}
