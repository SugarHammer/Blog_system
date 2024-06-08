package com.example.admin.mapper;

import com.example.admin.entity.SelectParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface Admin_messageMapper {
    List<Map<String, Object>> queryListMessage1(SelectParam selectParam);

    void message1Deleted(int id);

    void message2Deleted(int id);

    List<Map<String, Object>> getMessage2(SelectParam selectParam);
}
