package com.example.ops.service;

import com.example.ops.entity.SelectArticle;
import com.example.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Ops_userService {

    PageInfo<List<User>> PageUserList(SelectArticle selectParam);

    void add(User user);

    User queryOneById(int id);

    void updateUser(User user);

    void updateDeleted(int id);

    void updateDelete(int id);

    void startUser(int id);
}
