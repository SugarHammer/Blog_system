package com.example.ops.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface Ops_messageMapper {
    List<Map<String, Object>> message1List(int deleted);

    void deletedMessage1(int id);

    List<Map<String, Object>> message2List(int deleted);

    void deletedMessage2(int id);

    void deleteMessage1(int id);

    void deleteMessage2(int id);
}
