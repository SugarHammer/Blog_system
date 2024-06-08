package com.example.admin.controller;

import com.example.admin.service.Admin_userService;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/admin/user")
public class Admin_userController {

    @Autowired
    private Admin_userService userService;

    @RequestMapping("/update")
    public String update(HttpSession session, int id, String uname, String phone, String pwd, String email, String address, String profession, MultipartFile img){
        User user = null;
        String fileName = "";
        if (!img.isEmpty()) {                  //如果文件不为空
            fileName = img.getOriginalFilename();//获取文件名
            fileName = getFileName(fileName);          //添加时间戳后的文件名
            String filepath = getUploadPath();     //获取当前系统路径

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
            user= new User(id,uname,phone,pwd,fileName,email,address,profession,0,null,null);
        } else {
            user= new User(id,uname,phone,pwd,null,email,address,profession,0,null,null);
        }
        userService.updateUser(user);
        //修改成功后更新session
        session.setAttribute("user",userService.getUser(id));
        return "redirect:/admin-user-update.html";
    }



    private String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        final SimpleDateFormat sDateFormate = new SimpleDateFormat("yyyymmddHHmmss");  //设置时间格式
        String nowTimeStr = sDateFormate.format(new Date()); // 当前时间
        fileName = fileName.substring(0, index) + "_" + nowTimeStr + fileName.substring(index);
        return fileName;
    }


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
