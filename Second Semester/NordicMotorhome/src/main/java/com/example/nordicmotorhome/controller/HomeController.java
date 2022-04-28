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

}
