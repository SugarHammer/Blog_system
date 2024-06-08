package com.example.blog.controller;

import com.example.blog.service.CommentService;
import com.example.pojo.Comment;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/blog/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    //添加评论
    @RequestMapping("/sendComment")
    public String sendComment(@RequestParam(defaultValue = "0") int articleId,String comment,HttpSession session){
        if (articleId>0){
            User user = (User) session.getAttribute("user");
            Comment comment1 = new Comment(user.getId(),articleId,comment,0,null);
            commentService.addComment(comment1);
        }
        return "redirect:/article_detail?articleId="+articleId;
    }


}
