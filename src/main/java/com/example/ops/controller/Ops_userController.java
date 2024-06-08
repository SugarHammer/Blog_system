package com.example.ops.controller;

import com.example.ops.service.Ops_userService;
import com.example.pojo.Article;
import com.example.pojo.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/ops/user")
public class Ops_userController {

    @Autowired
    private Ops_userService userService;

    @RequestMapping("/add")
    public String addUser(HttpServletRequest request, HttpServletResponse response,
                          String uname,String phone,String pwd,String email,String address,String profession,
                          MultipartFile file) throws IOException {

        User user=null;
        String fileName = file.getOriginalFilename();//获取文件名
        fileName = getFileName(fileName);          //添加时间戳后的文件名
        String filepath = getUploadPath();     //获取当前系统路径
        if (!file.isEmpty()) {                  //如果文件不为空
            try (BufferedOutputStream out = new BufferedOutputStream(   //上传
                    new FileOutputStream(new File(filepath + File.separator + fileName)))) {
                out.write(file.getBytes());
                out.flush();
            } catch (FileNotFoundException e) {
                System.out.println("上传文件失败 FileNotFoundException：" + e.getMessage());
            } catch (IOException e) {
                System.out.println("上传文件失败 IOException：" + e.getMessage());
            }

            fileName="img/heatimg/"+fileName;  //拼接存入数据库的路径
            user =  new User(uname,phone,pwd,fileName,email,address,profession,0,null,null);
        } else {
            user =  new User(uname,phone,pwd,"img/moren.jpg",email,address,profession,0,null,null);
        }
        userService.add(user);
        return "close";
    }

    @RequestMapping("/update")
    public String userUpdate(int id, String uname, String phone, String pwd, String email, String address, String profession,
                             MultipartFile img, Model model){
        User user=null;
        String fileName = "";
        String filepath = getUploadPath();     //获取当前系统路径
        if (!img.isEmpty()) {                  //如果文件不为空
            fileName =  img.getOriginalFilename();//获取文件名
            fileName = getFileName(fileName);          //添加时间戳后的文件名
            try (BufferedOutputStream out = new BufferedOutputStream(   //上传
                    new FileOutputStream(new File(filepath + File.separator + fileName)))) {
                out.write(img.getBytes());
                out.flush();
            } catch (FileNotFoundException e) {
                System.out.println("上传文件失败 FileNotFoundException：" + e.getMessage());
            } catch (IOException e) {
                System.out.println("上传文件失败 IOException：" + e.getMessage());
            }

            fileName="img/heatimg/"+fileName;  //拼接存入数据库的路径
            user =  new User(uname,phone,pwd,fileName,email,address,profession,0,null,null);
        } else {
            user =  new User(uname,phone,pwd,null,email,address,profession,0,null,null);
        }
        userService.updateUser(user);
        return "close";
    }

    @RequestMapping("/deleted")
    @ResponseBody
    public String updateDeleted(int id){
        userService.updateDeleted(id);
        return "200";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String updateDelete(int id){
        userService.updateDelete(id);
        return "200";
    }

    @RequestMapping("/start")
    @ResponseBody
    public String startUser(int id){
        userService.startUser(id);
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
        File upload = new File(path.getAbsolutePath(), "static/img/heatimg/");
        if (!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }


}
