package com.example.ops.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface Ops_messageService {
    PageInfo<List<Map<String, Object>>> message1List(int pageNum, int pageSize,int deleted);

    void deletedMessage1(int id);

    PageInfo<List<Map<String, Object>>> message2List(int pageNum, int pageSize, int i);

    void deletedMessage2(int id);

    void deleteMessage1(int id);

    void deleteMessage2(int id);
}
