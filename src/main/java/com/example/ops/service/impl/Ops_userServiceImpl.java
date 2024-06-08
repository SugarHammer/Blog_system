package com.example.ops.service.impl;

import com.example.ops.entity.SelectArticle;
import com.example.ops.mapper.Ops_userMapper;
import com.example.ops.service.Ops_userService;
import com.example.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Ops_userServiceImpl implements Ops_userService {

    @Autowired
    private Ops_userMapper userMapper;

    @Override
    public PageInfo<List<User>> PageUserList(SelectArticle selectParam) {
        PageInfo<List<User>> info = PageHelper.startPage(selectParam.getPageNum(),selectParam.getPageSize()).doSelectPageInfo(() -> userMapper.PageUserList(selectParam));
        return info;
    }

    @Override
    public void add(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User queryOneById(int id) {
        return userMapper.queryOneById(id);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void updateDeleted(int id) {
        userMapper.updateDeleted(id);
    }

    @Override
    public void updateDelete(int id) {
        userMapper.updateDelete(id);
    }

    @Override
    public void startUser(int id) {
        userMapper.startUser(id);
    }
}
