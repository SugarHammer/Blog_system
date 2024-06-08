package com.example.ops.service.impl;

import com.example.ops.mapper.Ops_lableMappr;
import com.example.ops.service.Ops_lableService;
import com.example.pojo.Lable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ops_lableServiceImpl implements Ops_lableService {
    @Autowired
    private Ops_lableMappr ops_lableMappr;

    @Override
    public List<Lable> getLableList() {
        return ops_lableMappr.getLableList();
    }
}
