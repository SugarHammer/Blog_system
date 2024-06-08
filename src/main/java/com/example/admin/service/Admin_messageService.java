package com.example.admin.service;

import com.example.admin.entity.SelectParam;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

public interface Admin_messageService {
    PageInfo<List<Map<String, Object>>> PageComment(SelectParam selectParam);

    void message1Deleted(int id);

    void message2Deleted(int id);

    PageInfo<List<Map<String, Object>>> getMessage2(SelectParam selectParam);
}
