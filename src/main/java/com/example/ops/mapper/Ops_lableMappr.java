package com.example.ops.mapper;

import com.example.pojo.Lable;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Ops_lableMappr {


    List<Lable> getLableList();
}
