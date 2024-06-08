package com.example.ops.service;

import com.example.ops.entity.SelectArticle;
import com.example.pojo.Article;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface Ops_articleService {

    //分页查询所有 article
    PageInfo<List<Map<String, Object>>> pageQueryArticleList(SelectArticle selectArticle);

    //按照 id 查询单个
    Map<String,Object> queryOneById(int aid);

    //修改 article
    int update(Article article);

    // 删除 article
    void deleteArticle(int id);


    void deletedArticle(int id);

    void startArticle(int id);
}
