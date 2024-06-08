package com.example.admin.service;

import com.example.admin.entity.SelectParam;
import com.example.ops.entity.SelectArticle;
import com.example.pojo.Article;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface Admin_articleService {
    PageInfo<List<Map<String, Object>>> pageQueryArticleList(SelectParam selectParam);

    void deleted(int id);

    Map<String,Object> queryOne(int id);

    void articleUpdate(Article article);

    void addArticle(Article article);
}
