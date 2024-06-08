package com.example.blog.mapper;

import com.example.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper{

    User login(User u);

    int recordLoginTime(int id);

    List<Map<Object, Object>> getHeatUser();

    int registerUser(User user);
}
