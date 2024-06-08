package com.example.ops.mapper;

import com.example.ops.entity.SelectArticle;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface Ops_commentMapper {

    List<Map<String, Object>> PageComment(SelectArticle selectArticle);

    List<Map<String, Object>> PageComment2(SelectArticle selectArticle);

    void commmentDeleted(int id);

    void commmentDelete(int id);

    void commmentstart(int id);
}
