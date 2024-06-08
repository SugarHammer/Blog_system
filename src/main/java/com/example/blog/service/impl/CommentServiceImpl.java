package com.example.blog.service.impl;

import com.example.blog.mapper.CommentMapper;
import com.example.blog.service.CommentService;
import com.example.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public List<Map<Object, Object>> queryCommentByAid(int aid) {
        return commentMapper.queryCommentByAid(aid);
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.addComment(comment);
    }
}
