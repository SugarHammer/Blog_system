package com.example.ops.controller;

import com.example.ops.service.Ops_messageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ops/message")
public class Ops_messageController {

    @Autowired
    private Ops_messageService messageService;

    @RequestMapping("/deleted")
    @ResponseBody
    public String deletedMessage1(int id){
        messageService.deletedMessage1(id);
        return "200";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteMessage1(int id){
        messageService.deleteMessage1(id);
        return "200";
    }

    @RequestMapping("/delete2")
    @ResponseBody
    public String deleteMessage2(int id){
        messageService.deleteMessage2(id);
        return "200";
    }

    @RequestMapping("/deleted2")
    @ResponseBody
    public String deletedMessage2(int id){
        messageService.deletedMessage2(id);
        return "200";
    }


}
