package com.example.ops.mapper;

import com.example.ops.entity.SelectArticle;
import com.example.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface Ops_articleMapper {
    List<Map<String, Object>> pageQueryArticleList(SelectArticle select);

    Map<String,Object> queryOneById(int aid);

    int updateArticle(Article article);

    void deleteArticle(int id);

    void deletedArticle(int id);

    void startArticle(int id);
}
