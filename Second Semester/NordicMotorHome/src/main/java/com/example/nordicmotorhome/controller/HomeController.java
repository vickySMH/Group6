package com.example.nordicmotorhome.controller;

import com.example.nordicmotorhome.model.User;
import com.example.nordicmotorhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.List;

@Controller
public class HomeController
{
    @Autowired
    UserService service;

    @GetMapping("/")
    public String index(Model model)
    {
        return "home/index";
    }

    @GetMapping("/login")
    public String login(Model model)
    {
        return "home/login";
    }

    @GetMapping("/aboutUs")
    public String aboutUs(Model model)
    {
        return "home/aboutUs";
    }

    @GetMapping("/faqs")
    public String faqs(Model model)
    {
        return "home/faqs";
    }


    @GetMapping("/register")
    public String register(Model model) {return "home/register";}

    @PostMapping("/loggedin")
    public String loggedin(Model model, WebRequest webRequest)
    {
        String username = webRequest.getParameter("username");
        String password = webRequest.getParameter("password");
        List<User> userList = service.fetchAll();
        for (User u:userList)
        {
            if(u.getPassword().equals(password) && u.getUsername().equals(username))
            {
                model.addAttribute("username", username);
                return "home/loggedin";
            }
        }
        return "home/login";
    }

    @GetMapping("/update")
    public String update(Model model)
    {
        return "home/update";
    }

}
