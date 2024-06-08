package com.example.blog.service;

import com.example.pojo.Comment;

import java.util.List;
import java.util.Map;

public interface CommentService {

    // 查询 这条插画教程下的留言 list
    List<Map<Object,Object>> queryCommentByAid(int aid);

    //添加评论
    int addComment(Comment comment);


}
