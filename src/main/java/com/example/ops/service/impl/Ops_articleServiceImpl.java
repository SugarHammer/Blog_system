package com.example.ops.service.impl;

import com.example.ops.entity.SelectArticle;
import com.example.ops.mapper.Ops_articleMapper;
import com.example.ops.service.Ops_articleService;
import com.example.pojo.Article;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class Ops_articleServiceImpl implements Ops_articleService {

    @Autowired
    private Ops_articleMapper opsArticleMapper;

    @Override
    public PageInfo<List<Map<String, Object>>> pageQueryArticleList(SelectArticle selectArticle) {
        PageInfo<List<Map<String, Object>>> info = PageHelper.startPage(selectArticle.getPageNum(),selectArticle.getPageSize()).doSelectPageInfo(() -> opsArticleMapper.pageQueryArticleList(selectArticle));
        return info;
    }


    @Override
    public Map<String,Object> queryOneById(int aid) {
        return opsArticleMapper.queryOneById(aid);
    }

    @Override
    public int update(Article article) {
        System.out.println(article);
        return opsArticleMapper.updateArticle(article);
    }

    @Override
    public void deleteArticle(int id) {
        opsArticleMapper.deleteArticle(id);
    }

    @Override
    public void deletedArticle(int id) {
        opsArticleMapper.deletedArticle(id);
    }

    @Override
    public void startArticle(int id) {
        opsArticleMapper.startArticle(id);
    }
}
