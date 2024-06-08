package com.example.blog.mapper;

import com.example.pojo.Message;
import com.example.pojo.Message2;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface MessageMapper {

    List<Map<Object, Object>>  queryMessageAll();

    List<Map<Object, Object>> queryMessage2(int mid);

    int addMessage1(Message m);

    int addMessage2(Message2 m);
}
