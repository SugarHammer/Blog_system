package com.example.ops.controller;

import com.example.ops.service.Ops_commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ops/comment")
public class Ops_commentController {

    @Autowired
    private Ops_commentService commentService;

    @RequestMapping("/deleted")
    @ResponseBody
    public String commmentDeleted(int id){
        commentService.commmentDeleted(id);
        return "200";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String commmentDelete(int id){
        commentService.commmentDelete(id);
        return "200";
    }

    @RequestMapping("/start")
    @ResponseBody
    public String commmentstart(int id){
        commentService.commmentstart(id);
        return "200";
    }




}
