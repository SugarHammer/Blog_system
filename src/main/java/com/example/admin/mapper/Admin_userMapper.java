package com.example.admin.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface Admin_userMapper {
    void updateUser(User user);

    User getUser(int id);
}
