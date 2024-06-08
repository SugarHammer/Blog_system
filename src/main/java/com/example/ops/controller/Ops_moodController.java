package com.example.ops.controller;

import com.example.ops.service.Ops_moodService;
import com.example.pojo.Mood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ops/mood")
public class Ops_moodController {

    @Autowired
    private Ops_moodService moodService;

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteMood(int id){
        moodService.deleteMood(id);
        return "200";
    }

    @RequestMapping("/add")
    public String addMood(String title,String content){
        moodService.addMood(new Mood(title,content,null,null));
        return "close";
    }

    @RequestMapping("/update")
    public String updateMood(int id,String title,String content){
        moodService.updateMood(new Mood(id,title,content,null,null));
       return "close";
    }

}
