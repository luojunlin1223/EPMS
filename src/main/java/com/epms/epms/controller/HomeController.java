package com.epms.epms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {
    @RequestMapping("/index")
    String index(Model model){
        model.addAttribute("page","dash");
        return "index";
    }
    @RequestMapping("/")
    public void home(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login");
    }
    @RequestMapping("/login")
    public String login(){return "login";}
}
