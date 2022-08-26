package com.epms.epms.controller;

import com.epms.epms.model.entity.User;
import com.epms.epms.service.UserSeriviceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserSeriviceImpl userSerivice;

    @RequestMapping("/user")
    public String index(Model model){
        List<User> result= userSerivice.findAll();
        model.addAttribute("tableName","User");
        model.addAttribute("tableData",result);
        model.addAttribute("page","user");
        return "index";
    }

    @RequestMapping("/user/new-user")
    public String newDepartment(Model model){
        model.addAttribute("page","new-user");
        return "index";
    }

    @RequestMapping("/user/new-user/save")
    public String save(Model model,
                       @RequestParam("username") String username,
                       @RequestParam("password") String password)
    {
        var temp=new User();
        temp.setUsername(username);
        temp.setPassword(password);
        userSerivice.save(temp);
        var result=userSerivice.findAll();
        model.addAttribute("tableName","User");
        model.addAttribute("tableData",result);
        model.addAttribute("page","user");
        return "index";
    }
    @RequestMapping("/user/delete")
    public String delete(Model model,@RequestParam("id") Long id){
        userSerivice.deleteById(id);
        var result=userSerivice.findAll();
        model.addAttribute("tableName","User");
        model.addAttribute("tableData",result);
        model.addAttribute("page","user");
        return "index";
    }
}
