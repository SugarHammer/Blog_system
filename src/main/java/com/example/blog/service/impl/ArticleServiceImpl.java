package com.example.blog.service.impl;

import com.example.blog.mapper.ArticleMapper;
import com.example.blog.service.ArticleService;
import com.example.pojo.Lable;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public PageInfo<List<Map<Object,Object>>> PageQueryArticleTogether(int pageNum, int pageSize) {
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo( () ->{ articleMapper.queryArticleTogether();} );
    }

    @Override
    public Map<Object, Object> queryOneArticleById(int id) {
        return articleMapper.queryOneArticleById(id);
    }

    @Override
    public List<Map<Object, Object>> getHeatArticle() {
        return articleMapper.getHeatArticle();
    }

    @Override
    public List<Map<Object,Object>>  getRandomLable4() {
        return articleMapper.getRandomLable4();
    }

    @Override
    public PageInfo<List<Map<Object, Object>>> PageQueryArticleTogetherByLable(int pageNum, int pageSize, int lableId) {
        return PageHelper.startPage(pageNum,pageSize).doSelectPageInfo( () ->{ articleMapper.PageQueryArticleTogetherByLable(lableId);} );
    }

    @Override
    public int updateHeatAdd(int id) {
        return articleMapper.updateHeatAdd(id);
    }
}
