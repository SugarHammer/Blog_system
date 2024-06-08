package com.example.ops.controller;

import com.example.blog.service.ArticleService;
import com.example.ops.service.Ops_articleService;
import com.example.pojo.Article;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/ops/article")
public class Ops_articleController {

    @Autowired
    private Ops_articleService articleService;

    @RequestMapping("/update")
    public String articleUpdate(HttpServletRequest request, HttpServletResponse response
            , int id, String title, int lid, String content, int heat, MultipartFile imgFile) throws IOException {

        Article article = null;
        String fileName = "";
        String filepath = getUploadPath();     //获取当前系统路径
        if (!imgFile.isEmpty()) {                  //如果文件不为空
            fileName=imgFile.getOriginalFilename();//获取文件名
            fileName = getFileName(fileName);         //添加时间戳后的文件名
            try (BufferedOutputStream out = new BufferedOutputStream(   //上传
                    new FileOutputStream(new File(filepath + File.separator + fileName)))) {
                out.write(imgFile.getBytes());
                out.flush();
            } catch (FileNotFoundException e) {
                System.out.println("上传文件失败 FileNotFoundException：" + e.getMessage());
            } catch (IOException e) {
                System.out.println("上传文件失败 IOException：" + e.getMessage());
            }

            fileName="img/blog/"+fileName;  //拼接存入数据库的路径
            article = new Article(id,fileName,0,title,lid,content,heat,0,null);
        } else {
            article = new Article(id,null,0,title,lid,content,heat,0,null);
        }
        articleService.update(article);
        return "close";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String deleteArticle(int id){
        articleService.deleteArticle(id);
        return "200";
    }

    @RequestMapping("/deleted")
    @ResponseBody
    public String deletedArticle(int id){
        articleService.deletedArticle(id);
        return "200";
    }

    @RequestMapping("/start")
    @ResponseBody
    public String startArticle(int id){
        articleService.startArticle(id);
        return "200";
    }

    /**
     * 文件名后缀前添加一个时间戳
     */
    private String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        final SimpleDateFormat sDateFormate = new SimpleDateFormat("yyyymmddHHmmss");  //设置时间格式
        String nowTimeStr = sDateFormate.format(new Date()); // 当前时间
        fileName = fileName.substring(0, index) + "_" + nowTimeStr + fileName.substring(index);
        return fileName;
    }

    /**
     * 获取当前系统路径
     */
    private String getUploadPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath(), "static/img/blog/");
        if (!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }

}
