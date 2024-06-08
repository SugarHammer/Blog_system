package com.example.admin.controller;

import com.example.admin.service.Admin_commentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/comment")
public class Admin_commentController {

    @Autowired
    private Admin_commentService commentService;

    @RequestMapping("/deleted")
    @ResponseBody
    public String deleted(int id){
        commentService.deleted(id);
        return "200";
    }

}
