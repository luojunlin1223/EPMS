package com.epms.epms.controller;

import com.epms.epms.model.dao.UserDao;
import com.epms.epms.model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/Authenticate")
    public String authenticate(HttpServletRequest req, Model model){
        String username=req.getParameter("userName").trim();
        String password=req.getParameter("password");
        User user=userDao.findByUserName(username);
        model.addAttribute("test",user.getPassWord());
        return "test";
    }
}
