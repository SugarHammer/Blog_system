package com.example.ops.service;

import com.example.pojo.Mood;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface Ops_moodService {
    PageInfo<List<Mood>> moodList(int pageNum, int pageSize);

    Mood moodOneById(int id);

    int addMood(Mood mood);

    int updateMood(Mood mood);

    int deleteMood(int id);

}
