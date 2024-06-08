package com.example.blog.service.impl;

import com.example.blog.mapper.MessageMapper;
import com.example.blog.service.MessageService;
import com.example.pojo.Message;
import com.example.pojo.Message2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Map<Object, Object>> queryMessageAll() {
        //查询一级留言列表
        List<Map<Object, Object>> messageList1 = messageMapper.queryMessageAll();
        List<Map<Object, Object>> messageList2 = new ArrayList<>();
        for (int i=0;i<messageList1.size();i++){
            Map<Object, Object> map = messageList1.get(i);
            //添加二级留言
            map.put("message2",messageMapper.queryMessage2((int)map.get("id")));
            messageList2.add(map);
        }
        return messageList2;
    }

    @Override
    public int addMessage1(Message m) {
        return messageMapper.addMessage1(m);
    }

    @Override
    public void addMessage2(Message2 m) {
        messageMapper.addMessage2(m);
    }


}
