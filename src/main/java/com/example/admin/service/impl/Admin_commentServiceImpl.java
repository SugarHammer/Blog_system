package com.example.admin.service.impl;

import com.example.admin.entity.SelectParam;
import com.example.admin.mapper.Admin_commentMapper;
import com.example.admin.service.Admin_commentService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Admin_commentServiceImpl implements Admin_commentService {
    @Autowired
    private Admin_commentMapper commentMapper;


    @Override
    public PageInfo<List<Map<String, Object>>> PageComment(SelectParam selectParam) {
        PageInfo<List<Map<String, Object>>> info = PageHelper.startPage(selectParam.getPageNum(), selectParam.getPageSize()).doSelectPageInfo(() -> commentMapper.PageComment(selectParam));;
        return info;
    }

    @Override
    public PageInfo<List<Map<String, Object>>> PageComment2(SelectParam selectParam) {
        PageInfo<List<Map<String, Object>>> info = PageHelper.startPage(selectParam.getPageNum(), selectParam.getPageSize()).doSelectPageInfo(() -> commentMapper.PageComment2(selectParam));;
        return info;
    }

    @Override
    public void deleted(int id) {
        commentMapper.deleted(id);
    }
}
