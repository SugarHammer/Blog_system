package com.example.blog.mapper;

import com.example.pojo.Mood;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MoodMapper {


    List<Mood> queryMoodList();
}
