package com.example.admin.mapper;

import com.example.admin.entity.SelectParam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface Admin_commentMapper {
    List<Map<String, Object>> PageComment(SelectParam selectParam);

    List<Map<String, Object>> PageComment2(SelectParam selectParam);

    void deleted(int id);
}
