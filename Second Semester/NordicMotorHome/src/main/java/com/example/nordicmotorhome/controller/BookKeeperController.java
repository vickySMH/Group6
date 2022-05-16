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
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookKeeperController
{
    @Autowired
    MotorhomeService service;
    private String startDate, endDate;
    @GetMapping("/add")
    public String add(Model model)
    {
        return "home/add";
    }

    @PostMapping("/addContinue")
    public String addContinue(Model model, WebRequest webRequest)
    {
        startDate = webRequest.getParameter("startDate");
        endDate = webRequest.getParameter("endDate");
        List<Motorhome> motorhomeList = service.fetchAll();
        List<Motorhome> notAvailable = service.fetchNotAvailable(startDate, endDate);
        for (int i = 0; i < motorhomeList.size(); ++i)
        {
            for (int j = 0; j < notAvailable.size(); ++j)
            {
                if(motorhomeList.get(i).getLicenseNumber().equals(notAvailable.get(j).getLicenseNumber()))
                {
                    motorhomeList.remove(i);
                }
            }
        }
        model.addAttribute("motorhomes", motorhomeList);
        return "home/addContinue";
    }

    @PostMapping("/extras")
    public String extras()
    {
        return null;
    }

    @PostMapping("/receipt")
    public String receipt()
    {
        return null;
    }

    @GetMapping("/remove")
    public String remove(Model model) {return "home/removeBooking";}

    @GetMapping("/update")
    public String update(Model model)
    {
        return "home/update";
    }

}
