package com.example.ops.service.impl;

import com.example.ops.mapper.Ops_messageMapper;
import com.example.ops.service.Ops_messageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Ops_messageServiceImpl implements Ops_messageService {

    @Autowired
    private Ops_messageMapper messageMapper;

    @Override
    public void deletedMessage1(int id) {
        messageMapper.deletedMessage1(id);
    }

    @Override
    public PageInfo<List<Map<String, Object>>> message1List(int pageNum, int pageSize,int deleted) {
        PageInfo<List<Map<String, Object>>> info = PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(() -> messageMapper.message1List(deleted));;
        return info;
    }

    @Override
    public void deleteMessage2(int id) {
        messageMapper.deleteMessage2(id);
    }

    @Override
    public void deleteMessage1(int id) {
        messageMapper.deleteMessage1(id);
    }

    @Override
    public void deletedMessage2(int id) {
        messageMapper.deletedMessage2(id);
    }

    @Override
    public PageInfo<List<Map<String, Object>>> message2List(int pageNum, int pageSize,int deleted) {
        PageInfo<List<Map<String, Object>>> info = PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(() -> messageMapper.message2List(deleted));;
        return info;
    }
}
