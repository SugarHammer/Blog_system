package com.example.blog.mapper;

import com.example.pojo.Lable;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ArticleMapper {


    List<Map<Object, Object>> queryArticleTogether();

    Map<Object, Object> queryOneArticleById(int id);

    List<Map<Object, Object>> getHeatArticle();

    List<Map<Object,Object>> getRandomLable4();

    List<Map<Object, Object>> PageQueryArticleTogetherByLable(int lableId);

    int updateHeatAdd(int id);
}
