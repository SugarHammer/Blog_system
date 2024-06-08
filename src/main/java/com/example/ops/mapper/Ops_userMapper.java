package com.example.ops.mapper;

import com.example.ops.entity.SelectArticle;
import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Ops_userMapper {
    List<User> PageUserList(SelectArticle selectParam);

    void addUser(User user);

    User queryOneById(int id);

    void updateUser(User user);

    void updateDeleted(int id);

    void updateDelete(int id);

    void startUser(int id);
}
