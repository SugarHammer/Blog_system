package com.example.blog.controller;
import com.example.blog.service.UserService;
import com.example.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/blog/user")
public class UserController {

    @Autowired
    private UserService userService;

   /*
    用户登录
   * */
    @RequestMapping("/login")
    public String userLogin(@RequestParam("username") String username,
                            @RequestParam("password") String password,
                            @RequestParam("captcha") String captcha,
                            HttpServletRequest request,
                            Model model,
                            HttpSession session){
        String random = (String) request.getSession().getAttribute("random");

        //用户名密码，验证码不能为空
        if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(captcha)){
            //判断验证码
            if (captcha.equalsIgnoreCase(random)){
                User u = new User();
                u.setPhone(username);
                u.setPwd(password);
                String a = "admin";
                if (username.equals(a) && password.equals(a)){
                    return "redirect:/ops-index.html";
                }
                User user = userService.login(u);
                if (user!=null){
                    //添加最近登录记录
                    userService.recordLoginTime(user.getId());
                    //保存登录信息
                    session.setAttribute("user",user);
                    return "redirect:/index";  //重定向到这个请求
                }else{
                    model.addAttribute("msg","账户或密码错误");
                    return "user-login";
                }
            }else{
                model.addAttribute("msg","验证码错误");
                return "user-login";
            }
        }else{
            model.addAttribute("msg","用户名，密码，验证码不能为空！");
            return "user-login";
        }
    }

    /*用户注册*/
    @RequestMapping("/register")
    public String register(Model model,String uname,String phone,String email,String pwd,String captcha,HttpServletRequest request){
        String random = (String) request.getSession().getAttribute("random");
        //用户名密码，验证码不能为空
        if (!StringUtils.isEmpty(uname) && !StringUtils.isEmpty(email) && !StringUtils.isEmpty(pwd) && !StringUtils.isEmpty(captcha)) {
            if (captcha.equalsIgnoreCase(random)){
                User user= new User(uname,phone,pwd,null,email,null,null,0,null,null);
                userService.registerUser(user);
                model.addAttribute("msg","注册成功，登陆后请先前往后台完善个人信息！");
                return "user-login";
            }else {
                model.addAttribute("msg","验证码错误！");
                return "user-register";
            }
        }else{
            model.addAttribute("msg","各项输入不能为空！");
            return "user-register";
        }
    }



    /*
    * 退出登录
    * */
    @RequestMapping("/exitLogin")
    public String exitLogin(HttpSession session){
        session.invalidate();
        return "redirect:/index";
    }


    /*
    * 获取登录后用户的信息
    * */
    @RequestMapping("/getLoginUser")
    @ResponseBody
    public User getLoginUser(HttpSession session){
        return (User) session.getAttribute("user");
    }

}

