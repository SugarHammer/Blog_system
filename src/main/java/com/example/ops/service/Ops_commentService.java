package com.example.ops.service;

import com.example.ops.entity.SelectArticle;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface Ops_commentService {
    PageInfo<List<Map<String, Object>>> PageComment(SelectArticle selectArticle);

    PageInfo<List<Map<String, Object>>> PageComment2(SelectArticle selectArticle);

    void commmentDeleted(int id);

    void commmentDelete(int id);

    void commmentstart(int id);
}
