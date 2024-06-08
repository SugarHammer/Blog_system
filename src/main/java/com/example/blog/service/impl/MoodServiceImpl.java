package com.example.blog.service.impl;

import com.example.blog.mapper.MoodMapper;
import com.example.blog.service.MoodService;
import com.example.pojo.Mood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoodServiceImpl implements MoodService {
    
    @Autowired
    private MoodMapper moodMapper;
    
    @Override
    public List<Mood> queryMoodList() {
        return moodMapper.queryMoodList();
    }
}
