package com.example.blog.service;

import com.example.pojo.Message;
import com.example.pojo.Message2;

import java.util.List;
import java.util.Map;

public interface MessageService {

    //展示留言板内容
    List<Map<Object,Object>> queryMessageAll();

    //添加一级留言
    int addMessage1(Message m);

    void addMessage2(Message2 m);
}
