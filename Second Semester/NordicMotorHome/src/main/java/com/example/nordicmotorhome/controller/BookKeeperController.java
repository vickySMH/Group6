package com.example.nordicmotorhome.controller;

import com.example.nordicmotorhome.model.Motorhome;
import com.example.nordicmotorhome.service.MotorhomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.util.List;

@Controller
public class BookKeeperController
{
    @Autowired
    MotorhomeService service;

    @GetMapping("/add")
    public String add(Model model)
    {
        return "home/add";
    }

    @PostMapping("/addContinue")
    public String addContinue(Model model, WebRequest webRequest)
    {
        Date startDate = Date.valueOf(webRequest.getParameter("startDate"));
        Date endDate = Date.valueOf(webRequest.getParameter("endDate"));
        List<Motorhome> motorhomeList = service.fetchAll(startDate, endDate);
        model.addAttribute("motorhomes", motorhomeList);
        return "home/addContinue";
    }

    @GetMapping("/remove")
    public String remove(Model model) {return "home/removeBooking";}

}
