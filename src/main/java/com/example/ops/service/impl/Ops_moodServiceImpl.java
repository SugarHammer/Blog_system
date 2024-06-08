package com.example.ops.service.impl;

import com.example.ops.mapper.Ops_moodMapper;
import com.example.ops.service.Ops_moodService;
import com.example.ops.service.Ops_userService;
import com.example.pojo.Mood;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Ops_moodServiceImpl implements Ops_moodService {

    @Autowired
    private Ops_moodMapper moodMapper;

    @Override
    public PageInfo<List<Mood>> moodList(int pageNum, int pageSize) {
        PageInfo<List<Mood>> info = PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(() -> moodMapper.moodList());
        return info;
    }

    @Override
    public Mood moodOneById(int id) {
        return moodMapper.moodOneById(id);
    }

    @Override
    public int deleteMood(int id) {
        return moodMapper.deleteMood(id);
    }

    @Override
    public int updateMood(Mood mood) {
        return moodMapper.updateMood(mood);
    }

    @Override
    public int addMood(Mood mood) {
        return moodMapper.addMood(mood);
    }
}
