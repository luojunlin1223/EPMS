package com.epms.epms.controller;

import com.epms.epms.model.entity.User;
import com.epms.epms.service.UserSeriviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
public class LoginController {
    @Autowired
    private UserSeriviceImpl userSerivice;

    @RequestMapping("/Authenticate")
    public String authenticate(HttpServletRequest req, Model model){
        String username=req.getParameter("userName").trim();
        String password=req.getParameter("password");
        if(password.length()==0||username.length()==0)
        {
            model.addAttribute("msg","用户输入的内容有部分为空");
            return "login";
        }
        User user=userSerivice.findByUserName(username);
        if(user==null)
        {
            model.addAttribute("msg","没有这个用户");
            return "login";
        }
        if(Objects.equals(password, user.getPassword()))
        {
            model.addAttribute("page","dash");
            return "index";
        }
        else{
            model.addAttribute("msg","密码错误");
            return "login";
        }
    }
}
