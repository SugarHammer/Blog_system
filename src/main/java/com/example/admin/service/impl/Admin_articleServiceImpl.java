package com.example.admin.service.impl;

import com.example.admin.entity.SelectParam;
import com.example.admin.mapper.Admin_articleMapper;
import com.example.admin.service.Admin_articleService;
import com.example.ops.entity.SelectArticle;
import com.example.pojo.Article;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Admin_articleServiceImpl implements Admin_articleService {

    @Autowired
    private Admin_articleMapper articleMapper;

    @Override
    public void deleted(int id) {
        articleMapper.deleted(id);
    }

    @Override
    public Map<String,Object> queryOne(int id) {
        return articleMapper.queryOne(id);
    }

    @Override
    public void articleUpdate(Article article) {
        articleMapper.articleUpdate(article);
    }

    @Override
    public void addArticle(Article article) {
        articleMapper.addArticle(article);
    }

    @Override
    public PageInfo<List<Map<String, Object>>> pageQueryArticleList(SelectParam selectParam) {
        PageInfo<List<Map<String, Object>>> info = PageHelper.startPage(selectParam.getPageNum(),selectParam.getPageSize()).doSelectPageInfo(() -> articleMapper.pageQueryArticleList(selectParam));
        return info;
    }
}
