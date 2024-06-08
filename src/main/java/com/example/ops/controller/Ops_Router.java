package com.example.ops.controller;

import com.example.ops.entity.Ops_user;
import com.example.ops.entity.SelectArticle;
import com.example.ops.mapper.Ops_userMapper;
import com.example.ops.service.*;
import com.example.pojo.Article;
import com.example.pojo.Lable;
import com.example.pojo.Mood;
import com.example.pojo.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Ops_Router {

    @Autowired
    private Ops_articleService opsArticleService;
    @Autowired
    private Ops_lableService lableService;
    @Autowired
    private Ops_userService userService;
    @Autowired
    private Ops_commentService commentService;
    @Autowired
    private Ops_moodService moodService;
    @Autowired
    private Ops_messageService messageService;


    /*
     * OPS首页  模拟管理员登录
     * */
    @RequestMapping({"ops-index.html","ops-index"})
    public String ops_index(HttpSession session, Model model){
        //模拟管理员登录
        session.setAttribute("user",new Ops_user(1,"系统管理员1号","admin","admin","img/moren.jpg","adminemail","adminaddress","系统管理员",0,null,null));
        Ops_user user = (Ops_user) session.getAttribute("user");


        Map<String,Object> map = new HashMap<>();
        map.put("user",user);

        model.addAttribute("map",map);
        return "ops-index";
    }

    /*
    * 文章列表
    * */
    @RequestMapping("/ops-article-list.html")
    public  String  ops_article_list(Model model,
                                   @RequestParam(defaultValue = "1") int pageNum,
                                   @RequestParam(defaultValue = "6") int pageSize,
                                     @RequestParam(defaultValue = "0") int deleted,
                                                                 @RequestParam(defaultValue = "") String keyword,
                                                                 @RequestParam(defaultValue = "") String createtime1,
                                                                 @RequestParam(defaultValue = "") String createtime2){
        SelectArticle selectArticle = new SelectArticle(pageNum,pageSize,deleted, keyword, createtime1, createtime2);
        //获取分页后的 插画教程 列表
        PageInfo<List<Map<String,Object>>> page = opsArticleService.pageQueryArticleList(selectArticle);
        Map<String,Object> map = new HashMap<>();
        map.put("pageinfo",page);
        map.put("selectParam",selectArticle);
        model.addAttribute("map",map);
        return "ops-article-list.html";
    }


    /*
     * 文章已删除列表
     * */
    @RequestMapping("/ops-article-list-deleted.html")
    public  String  ops_article_list_deleted(Model model,
                                     @RequestParam(defaultValue = "1") int pageNum,
                                     @RequestParam(defaultValue = "6") int pageSize,
                                     @RequestParam(defaultValue = "1") int deleted,
                                     @RequestParam(defaultValue = "") String keyword,
                                     @RequestParam(defaultValue = "") String createtime1,
                                     @RequestParam(defaultValue = "") String createtime2){
        SelectArticle selectArticle = new SelectArticle(pageNum,pageSize,deleted, keyword, createtime1, createtime2);
        //获取分页后的 插画教程 列表
        PageInfo<List<Map<String,Object>>> page = opsArticleService.pageQueryArticleList(selectArticle);
        Map<String,Object> map = new HashMap<>();
        map.put("pageinfo",page);
        map.put("selectParam",selectArticle);
        model.addAttribute("map",map);
        return "ops-article-list-deleted";
    }




    /*
    * 文章修改列表
    * */
    @RequestMapping("/ops-article-update.html")
    public String articleUpdate(@RequestParam(defaultValue = "1") int aid,Model model){
        //单个查询这个article
        Map<String,Object> article = opsArticleService.queryOneById(aid);
        //查询标签列表
        List<Lable> lableList = lableService.getLableList();
        model.addAttribute("article",article);
        model.addAttribute("lableList",lableList);
        return "ops-article-update";
    }

    /*
    * 用户列表
    * */
    @RequestMapping("ops-user-list.html")
    public String ops_user_list(@RequestParam(defaultValue = "1") int pageNum,
                                @RequestParam(defaultValue = "6") int pageSize,
                                @RequestParam(defaultValue = "0") int deleted,
                                @RequestParam(defaultValue = "") String keyword,
                                @RequestParam(defaultValue = "") String createtime1,
                                @RequestParam(defaultValue = "") String createtime2,Model model){
        SelectArticle selectParam = new SelectArticle(pageNum,pageSize,deleted, keyword, createtime1, createtime2);
        PageInfo<List<User>> pageInfo = userService.PageUserList(selectParam);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("selectParam",selectParam);
        return "ops-user-list";
    }

    /*
    * 用户列表 逻辑删除
    * */
    @RequestMapping("ops-user-list-deleted.html")
    public String ops_user_list_deleted(@RequestParam(defaultValue = "1") int pageNum,
                                @RequestParam(defaultValue = "6") int pageSize,
                                @RequestParam(defaultValue = "0") int deleted,
                                @RequestParam(defaultValue = "") String keyword,
                                @RequestParam(defaultValue = "") String createtime1,
                                @RequestParam(defaultValue = "") String createtime2,Model model){
        SelectArticle selectParam = new SelectArticle(pageNum,pageSize,1, keyword, createtime1, createtime2);
        PageInfo<List<User>> pageInfo = userService.PageUserList(selectParam);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("selectParam",selectParam);
        return "ops-user-list-deleted";
    }


    /*
    * 用户表添加
    * */
    @RequestMapping("/ops-user-add.html")
    public String ops_user_add(){
        return "ops-user-add";
    }

    /*
    * 用户表修改
    * */
    @RequestMapping("/ops-user-update.html")
    public String ops_user_update(@RequestParam(defaultValue = "1") int id,Model model){
        User user = userService.queryOneById(id);
        model.addAttribute("user",user);
        return "ops-user-update";
    }


    @RequestMapping("/ops-comment-list.html")
    public String ops_comment_list(@RequestParam(defaultValue = "1") int pageNum,
                                   @RequestParam(defaultValue = "10") int pageSize,
                                   @RequestParam(defaultValue = "0") int deleted,
                                   @RequestParam(defaultValue = "") String keyword,
                                   @RequestParam(defaultValue = "") String createtime1,
                                   @RequestParam(defaultValue = "") String createtime2,Model model){
        SelectArticle selectArticle = new SelectArticle(pageNum,pageSize,deleted,keyword,createtime1,createtime2);
        PageInfo<List<Map<String,Object>>> pageInfo = commentService.PageComment(selectArticle);
        model.addAttribute("selectParam",selectArticle);
        model.addAttribute("pageInfo",pageInfo);
        return "ops-comment-list";
    }
    @RequestMapping("/ops-comment-list2.html")
    public String ops_comment_list2(@RequestParam(defaultValue = "1") int pageNum,
                                   @RequestParam(defaultValue = "10") int pageSize,
                                   @RequestParam(defaultValue = "0") int deleted,
                                   @RequestParam(defaultValue = "") String keyword,
                                   @RequestParam(defaultValue = "") String createtime1,
                                   @RequestParam(defaultValue = "") String createtime2,Model model){
        SelectArticle selectArticle = new SelectArticle(pageNum,pageSize,deleted,keyword,createtime1,createtime2);
        PageInfo<List<Map<String,Object>>> pageInfo = commentService.PageComment2(selectArticle);
        model.addAttribute("selectParam",selectArticle);
        model.addAttribute("pageInfo",pageInfo);
        return "ops-comment-list2";
    }

    @RequestMapping("/ops-comment-list-deleted.html")
    public String ops_comment_list_deleted(@RequestParam(defaultValue = "1") int pageNum,
                                   @RequestParam(defaultValue = "10") int pageSize,
                                   @RequestParam(defaultValue = "0") int deleted,
                                   @RequestParam(defaultValue = "") String keyword,
                                   @RequestParam(defaultValue = "") String createtime1,
                                   @RequestParam(defaultValue = "") String createtime2,Model model){
        SelectArticle selectArticle = new SelectArticle(pageNum,pageSize,1,keyword,createtime1,createtime2);
        PageInfo<List<Map<String,Object>>> pageInfo = commentService.PageComment(selectArticle);
        model.addAttribute("selectParam",selectArticle);
        model.addAttribute("pageInfo",pageInfo);
        return "ops-comment-list-deleted";
    }


    @RequestMapping("ops-mood-list.html")
    public String ops_mood_list(@RequestParam(defaultValue = "1") int pageNum,
                                @RequestParam(defaultValue = "10") int pageSize,Model model){
        SelectArticle selectArticle = new SelectArticle(pageNum,pageSize,0,null,null,null);
        PageInfo<List<Mood>> pageInfo = moodService.moodList(pageNum,pageSize);
        model.addAttribute("selectParam",selectArticle);
        model.addAttribute("pageInfo",pageInfo);
        return "ops-mood-list";
    }

    @RequestMapping("/ops-mood-add.html")
    public String moodAdd(){
        return "ops-mood-add";
    }

    @RequestMapping("/ops-mood-update.html")
    public String moodUpdate(int id,Model model){
        Mood mood = moodService.moodOneById(id);
        model.addAttribute("mood",mood);
        return "ops-mood-update";
    }

    @RequestMapping("/ops-message1-list.html")
    public String message1(@RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "10") int pageSize,Model model){
        SelectArticle selectArticle = new SelectArticle(pageNum,pageSize,1,null,null,null);
        PageInfo<List<Map<String,Object>>> pageInfo = messageService.message1List(pageNum,pageSize,0);
        model.addAttribute("selectParam",selectArticle);
        model.addAttribute("pageInfo",pageInfo);
        return "ops-message1-list";
    }

    @RequestMapping("/ops-message1-list-deleted.html")
    public String message1deleted(@RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "10") int pageSize,Model model){
        SelectArticle selectArticle = new SelectArticle(pageNum,pageSize,1,null,null,null);
        PageInfo<List<Map<String,Object>>> pageInfo = messageService.message1List(pageNum,pageSize,1);
        model.addAttribute("selectParam",selectArticle);
        model.addAttribute("pageInfo",pageInfo);
        return "ops-message1-list-deleted";
    }

    @RequestMapping("/ops-message2-list.html")
    public String message2(@RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "10") int pageSize,Model model){
        SelectArticle selectArticle = new SelectArticle(pageNum,pageSize,1,null,null,null);
        PageInfo<List<Map<String,Object>>> pageInfo = messageService.message2List(pageNum,pageSize,0);
        model.addAttribute("selectParam",selectArticle);
        model.addAttribute("pageInfo",pageInfo);
        return "ops-message2-list";
    }

    @RequestMapping("/ops-message2-list-deleted.html")
    public String message2deleted(@RequestParam(defaultValue = "1") int pageNum,
                           @RequestParam(defaultValue = "10") int pageSize,Model model){
        SelectArticle selectArticle = new SelectArticle(pageNum,pageSize,1,null,null,null);
        PageInfo<List<Map<String,Object>>> pageInfo = messageService.message2List(pageNum,pageSize,1);
        model.addAttribute("selectParam",selectArticle);
        model.addAttribute("pageInfo",pageInfo);
        return "ops-message2-list-deleted";
    }


    @RequestMapping("/welcome.html")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping({"/close.html","/close"})
    public String close(){
        return "close";
    }

}
