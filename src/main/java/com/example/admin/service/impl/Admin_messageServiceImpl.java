package com.example.admin.service.impl;

import com.example.admin.entity.SelectParam;
import com.example.admin.mapper.Admin_messageMapper;
import com.example.admin.service.Admin_messageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Admin_messageServiceImpl implements Admin_messageService {

    @Autowired
    private Admin_messageMapper messageMapper;

    @Override
    public void message1Deleted(int id) {
        messageMapper.message1Deleted(id);
    }

    @Override
    public void message2Deleted(int id) {
        messageMapper.message2Deleted(id);
    }

    @Override
    public PageInfo<List<Map<String, Object>>> getMessage2(SelectParam selectParam) {
        PageInfo<List<Map<String, Object>>> info = PageHelper.startPage(selectParam.getPageNum(),selectParam.getPageSize()).doSelectPageInfo(() -> messageMapper.getMessage2(selectParam));
        return info;
    }

    @Override
    public PageInfo<List<Map<String, Object>>> PageComment(SelectParam selectParam) {
        PageInfo<List<Map<String, Object>>> info = PageHelper.startPage(selectParam.getPageNum(),selectParam.getPageSize()).doSelectPageInfo(() -> messageMapper.queryListMessage1(selectParam));
        return info;
    }
}
