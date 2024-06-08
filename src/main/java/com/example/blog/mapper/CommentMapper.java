package com.example.blog.mapper;

import com.example.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CommentMapper {


    List<Map<Object, Object>> queryCommentByAid(int aid);

    int addComment(Comment comment);
}
