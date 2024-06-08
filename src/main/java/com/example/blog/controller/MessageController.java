package com.example.blog.controller;

import com.example.blog.service.MessageService;
import com.example.pojo.Message;
import com.example.pojo.Message2;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/blog/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @RequestMapping("/sendMessage1")
    public String sendMessage1(String content, HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user!=null){
            Message m = new Message(user.getId(),content,0,null);
            messageService.addMessage1(m);
        }
        return "redirect:/board";
    }

    @RequestMapping("/sendMessage2")
    @ResponseBody
    public String sendMessage2(String content,int mid,HttpSession session){
        User user = (User) session.getAttribute("user");
        if (user!=null){
            Message2 m = new Message2(user.getId(),mid,content,0,null);
            messageService.addMessage2(m);
        }
        return "200";
    }

}
