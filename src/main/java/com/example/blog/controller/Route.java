package com.example.blog.controller;

import com.example.blog.service.*;
import com.example.pojo.Mood;
import com.example.pojo.User;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Route {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private MoodService moodService;

    /*
    * 首页路由
    * */
    @RequestMapping({"/index","/","/index.html"})
    public String index(@RequestParam(defaultValue = "1") int pageNum,
                        @RequestParam(defaultValue = "6") int pageSize,
                        HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        //添加主页发布插画教程
        PageInfo<List<Map<Object,Object>>> articleList = articleService.PageQueryArticleTogether(pageNum,pageSize);
        //添加热门插画教程信息
        List<Map<Object, Object>> heatArticle = articleService.getHeatArticle();
        //获得 站内活跃用户的部分信息
        List<Map<Object, Object>> heatUser = userService.getHeatUser();

        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("articleList",articleList);
        map.put("heatArticle",heatArticle);
        map.put("heatUser",heatUser);

        model.addAttribute("map",map);
        return "index";
    }

    /*
    * about.html
    * */
    @RequestMapping({"/about","/about.html"})
    public String about(HttpSession session, Model model){
        User user = (User)session.getAttribute("user");

        Map<String,Object> map = new HashMap<>();
        map.put("user",user);

        model.addAttribute("map",map);
        return "about";
    }


    /*
    * article.html
    * */
    @RequestMapping({"/article","/article.html"})
    public String article(@RequestParam(defaultValue = "1") int pageNum,
                          @RequestParam(defaultValue = "6") int pageSize,
                          @RequestParam(defaultValue = "0") int lableId,
                          HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        PageInfo<List<Map<Object,Object>>> articleList = null;
        if (lableId==0){//正常访问
            //添加主页发布插画教程
            articleList = articleService.PageQueryArticleTogether(pageNum,pageSize);
        }else{ //通过标签查询访问
            articleList = articleService.PageQueryArticleTogetherByLable(pageNum,pageSize,lableId);
        }

        //添加热门插画教程信息
        List<Map<Object, Object>> heatArticle = articleService.getHeatArticle();
        //添加 随机的几个 标签信息
        List<Map<Object,Object>> lableList = articleService.getRandomLable4();

        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("articleList",articleList);
        map.put("heatArticle",heatArticle);
        map.put("lableList",lableList);

        model.addAttribute("map",map);
        return "article";
    }


    /*
    * article_detail.html
    * */
    @RequestMapping({"/article_detail","/article_detail.html"})
    public String article_detail(@RequestParam(defaultValue = "1") int articleId,
                                 HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        //点进来后该插画教程热度+1
        articleService.updateHeatAdd(articleId);
        //查询单个 article信息
        Map<Object, Object> article = articleService.queryOneArticleById(articleId);
        //添加热门插画教程信息
        List<Map<Object, Object>> heatArticle = articleService.getHeatArticle();
        // 添加 这条插画教程下的留言
        List<Map<Object, Object>> commentList = commentService.queryCommentByAid(articleId);

        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("article",article);
        map.put("heatArticle",heatArticle);
        map.put("commentList",commentList);

        model.addAttribute("map",map);
        return "article_detail";
    }


    /*
    * board.html
    * */
    @RequestMapping({"/board","/board.html"})
    public String board(HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        //获取留言信息
        List<Map<Object, Object>> messageList = messageService.queryMessageAll();
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("messageList",messageList);
        model.addAttribute("map",map);
        return "board";
    }


    /*
    * mood.html
    * */
    @RequestMapping({"/mood","/mood.html"})
    public String mood(HttpSession session, Model model){
        User user = (User)session.getAttribute("user");
        List<Mood> moodList = moodService.queryMoodList();
        Map<String,Object> map = new HashMap<>();
        map.put("user",user);
        map.put("moodList",moodList);

        model.addAttribute("map",map);
        return "mood";
    }


    /*
    * user-login.html
    * */
    @RequestMapping({"/user-login","/user-login.html"})
    public String user_login(){
        return "user-login";
    }



    /*
     * user-register.html
     * */
    @RequestMapping({"/user-register","/user-register.html"})
    public String user_register(){
        return "user-register";
    }


    /*
    * 手机端跳转登录
    * */
    @RequestMapping("/app/qq")
    public String mobileLogin(HttpSession session){
        if (session.getAttribute("user")==null){
            return "user-login";
        }else{
            //后台管理界面
            return "redirect:admin-index.html";
        }
    }




}
