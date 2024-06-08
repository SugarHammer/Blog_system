package com.example.ops.mapper;

import com.example.pojo.Mood;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Ops_moodMapper {
    List<Mood> moodList();

    Mood moodOneById(int id);

    int addMood(Mood mood);

    int updateMood(Mood mood);

    int deleteMood(int id);
}
