package com.example.admin.controller;

import com.example.admin.entity.SelectParam;
import com.example.admin.service.Admin_articleService;
import com.example.admin.service.Admin_commentService;
import com.example.admin.service.Admin_messageService;
import com.example.ops.entity.SelectArticle;
import com.example.ops.service.Ops_lableService;
import com.example.pojo.Article;
import com.example.pojo.Lable;
import com.example.pojo.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class AdminRouter {

    @Autowired
    private Admin_articleService articleService;
    @Autowired
    private Ops_lableService lableService;
    @Autowired
    private Admin_commentService commentService;
    @Autowired
    private Admin_messageService messageService;



    /*
    * 用户修改界面
    * */
    @RequestMapping("/admin-user-update.html")
    public String userUpdate(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "admin-user-update";
    }


    /*
    * 用户后端首页
    * */
    @RequestMapping("admin-index.html")
    public String adminIndex(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "admin-index";
    }


    /*
    * 用户 查看发布插画教程
    * */
    @RequestMapping("/admin-article-list.html")
    public String adminArticleList(Model model,
                                   HttpSession session,
                                   @RequestParam(defaultValue = "1") int pageNum,
                                   @RequestParam(defaultValue = "6") int pageSize,
                                   @RequestParam(defaultValue = "0") int deleted,
                                   @RequestParam(defaultValue = "") String keyword,
                                   @RequestParam(defaultValue = "") String createtime1,
                                   @RequestParam(defaultValue = "") String createtime2){
        User user = (User)session.getAttribute("user");
        SelectParam selectParam = new SelectParam(user.getId(),pageNum,pageSize,deleted, keyword, createtime1, createtime2);
        //获取分页后的 插画教程 列表
        PageInfo<List<Map<String,Object>>> pageInfo = articleService.pageQueryArticleList(selectParam);
        model.addAttribute("selectParam",selectParam);
        model.addAttribute("pageInfo",pageInfo);
        return "admin-article-list";
    }

    /*
    * 用户修改插画教程页面
    * */
    @RequestMapping("/admin-article-update.html")
    public String articleUpdate(int id,Model model){
        Map<String,Object> article = articleService.queryOne(id);
        List<Lable> lableList = lableService.getLableList();
        model.addAttribute("article",article);
        model.addAttribute("lableList",lableList);
        return "admin-article-update";
    }

    /*
    * 添加插画教程页面
    * */
    @RequestMapping("/admin-article-add.html")
    public String addArticle(Model model){
        List<Lable> lableList = lableService.getLableList();
        model.addAttribute("lableList",lableList);
        return "admin-article-add";
    }

    @RequestMapping("/admin-comment-list.html")
    public String commentList(@RequestParam(defaultValue = "1") int pageNum,
                              @RequestParam(defaultValue = "10") int pageSize,
                              @RequestParam(defaultValue = "0") int deleted,
                              @RequestParam(defaultValue = "") String keyword,
                              @RequestParam(defaultValue = "") String createtime1,
                              @RequestParam(defaultValue = "") String createtime2,HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        SelectParam selectParam = new SelectParam(user.getId(),pageNum,pageSize,0,keyword,createtime1,createtime2);
        PageInfo<List<Map<String,Object>>> pageInfo = commentService.PageComment(selectParam);
        model.addAttribute("selectParam",selectParam);
        model.addAttribute("pageInfo",pageInfo);
        return "admin-comment-list";
    }

    @RequestMapping("/admin-comment-list2.html")
    public String commentList2(@RequestParam(defaultValue = "1") int pageNum,
                              @RequestParam(defaultValue = "10") int pageSize,
                              @RequestParam(defaultValue = "0") int deleted,
                              @RequestParam(defaultValue = "") String keyword,
                              @RequestParam(defaultValue = "") String createtime1,
                              @RequestParam(defaultValue = "") String createtime2,HttpSession session,Model model){
        User user = (User)session.getAttribute("user");
        SelectParam selectParam = new SelectParam(user.getId(),pageNum,pageSize,0,keyword,createtime1,createtime2);
        PageInfo<List<Map<String,Object>>> pageInfo = commentService.PageComment2(selectParam);
        model.addAttribute("selectParam",selectParam);
        model.addAttribute("pageInfo",pageInfo);
        return "admin-comment-list2";
    }


    @RequestMapping("/admin-message1-list.html")
    public String adminMessage(@RequestParam(defaultValue = "1") int pageNum,
                               @RequestParam(defaultValue = "10") int pageSize,Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        SelectParam selectParam = new SelectParam(user.getId(),pageNum,pageSize,0,null,null,null);
        PageInfo<List<Map<String,Object>>> pageInfo = messageService.PageComment(selectParam);
        model.addAttribute("selectParam",selectParam);
        model.addAttribute("pageInfo",pageInfo);
        return "admin-message1-list";
    }

    @RequestMapping("/admin-message2-list.html")
    public String adminMessage2(@RequestParam(defaultValue = "1") int pageNum,
                               @RequestParam(defaultValue = "10") int pageSize,Model model,HttpSession session){
        User user = (User)session.getAttribute("user");
        SelectParam selectParam = new SelectParam(user.getId(),pageNum,pageSize,0,null,null,null);
        PageInfo<List<Map<String,Object>>> pageInfo = messageService.getMessage2(selectParam);
        model.addAttribute("selectParam",selectParam);
        model.addAttribute("pageInfo",pageInfo);
        return "admin-message2-list";
    }




}
