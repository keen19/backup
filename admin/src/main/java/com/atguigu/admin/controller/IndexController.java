package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    /**
     * 登录页
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){
        if (StringUtils.isEmpty(user.getUserName()) && StringUtils.isEmpty(user.getPassword())){
            //把登录成功的用户保存起来
            session.setAttribute("loginUser",user);
            //成功重定向页面
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","账号密码错误");
            //密码错误回到登录页面
            return "login";
        }
//        return "main";
//        return "redirect:/main.html";
    }

    @GetMapping("/main.html")
    public String mainPage(){

        return "main";
    }
}
