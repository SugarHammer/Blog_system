package com.example.admin.controller;

import com.example.admin.service.Admin_messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/message")
public class Admin_messageController {

    @Autowired
    private Admin_messageService messageService;

    @RequestMapping("/message1Deleted")
    private String message1Deleted(int id){
        messageService.message1Deleted(id);
        return "200";
    }

    @RequestMapping("/message2Deleted")
    private String message2Deleted(int id){
        messageService.message2Deleted(id);
        return "200";
    }

}
