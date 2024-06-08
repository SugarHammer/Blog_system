package com.example.ops.service.impl;

import com.example.ops.entity.SelectArticle;
import com.example.ops.mapper.Ops_commentMapper;
import com.example.ops.service.Ops_commentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Ops_commentServiceImpl implements Ops_commentService {

    @Autowired
    private Ops_commentMapper commentMapper;

    @Override
    public PageInfo<List<Map<String, Object>>> PageComment(SelectArticle selectArticle) {
        PageInfo<List<Map<String, Object>>> info = PageHelper.startPage(selectArticle.getPageNum(), selectArticle.getPageSize()).doSelectPageInfo(() -> commentMapper.PageComment(selectArticle));;
        return info;
    }

    @Override
    public PageInfo<List<Map<String, Object>>> PageComment2(SelectArticle selectArticle) {
        PageInfo<List<Map<String, Object>>> info = PageHelper.startPage(selectArticle.getPageNum(), selectArticle.getPageSize()).doSelectPageInfo(() -> commentMapper.PageComment2(selectArticle));;
        return info;
    }

    @Override
    public void commmentDeleted(int id) {
        commentMapper.commmentDeleted(id);
    }

    @Override
    public void commmentstart(int id) {
        commentMapper.commmentstart(id);
    }

    @Override
    public void commmentDelete(int id) {
        commentMapper.commmentDelete(id);
    }
}
