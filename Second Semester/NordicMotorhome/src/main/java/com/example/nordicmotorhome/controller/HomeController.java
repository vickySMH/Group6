package com.example.nordicmotorhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController
{
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


    @GetMapping("/register")
    public String register(Model model) {return "home/register";}
}
