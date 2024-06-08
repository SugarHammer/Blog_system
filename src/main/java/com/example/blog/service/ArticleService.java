package com.example.blog.service;

import com.example.pojo.Lable;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface ArticleService {

    //查询插画教程 关联查询  分页查询
    PageInfo<List<Map<Object,Object>>> PageQueryArticleTogether(int pageNum,int pageSize);

    //单个查询 根据 id
    Map<Object,Object> queryOneArticleById(int id);

    // 查询前5条热门排行插画教程
    List<Map<Object,Object>> getHeatArticle();

    // 随机查出 4条标签
    List<Map<Object,Object>>  getRandomLable4();

    // 通过 lable分类查询
    PageInfo<List<Map<Object, Object>>> PageQueryArticleTogetherByLable(int pageNum, int pageSize, int lableId);

    // 修改热度 +1
    int updateHeatAdd(int id);

}
