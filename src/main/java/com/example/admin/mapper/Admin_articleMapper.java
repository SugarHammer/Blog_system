package com.example.admin.mapper;

import com.example.admin.entity.SelectParam;
import com.example.ops.entity.SelectArticle;
import com.example.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface Admin_articleMapper {
    List<Map<String, Object>> pageQueryArticleList(SelectParam selectParam);

    void deleted(int id);

    Map<String,Object> queryOne(int id);

    void articleUpdate(Article article);

    void addArticle(Article article);
}
