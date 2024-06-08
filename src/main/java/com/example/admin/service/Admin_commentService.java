package com.example.admin.service;

import com.example.admin.entity.SelectParam;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface Admin_commentService {
    PageInfo<List<Map<String, Object>>> PageComment(SelectParam selectParam);
    PageInfo<List<Map<String, Object>>> PageComment2(SelectParam selectParam);


    void deleted(int id);
}
