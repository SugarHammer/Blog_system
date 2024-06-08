package com.example.blog.controller;

import com.example.blog.utils.RandomNumUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class Randoms {

    private ByteArrayInputStream inputStream;

    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(ByteArrayInputStream inputStream) {
        this.inputStream = inputStream;
    }

    @RequestMapping("/randoms")
    public void randoms(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        RandomNumUtil rdnu=RandomNumUtil.Instance();
        request.getSession().setAttribute("random", rdnu.getStr());
        BufferedInputStream bis = null;
        OutputStream os = null;
        bis = new BufferedInputStream(rdnu.getImage());
        byte[] buffer = new byte[512];
        response.setCharacterEncoding("UTF-8");
        response.setContentType("image/*");
        response.setContentLength(bis.available());

        os = response.getOutputStream();
        int n;
        while ((n = bis.read(buffer)) != -1) {
            os.write(buffer, 0, n);
        }
        bis.close();
        os.flush();
        os.close();
    }

}
