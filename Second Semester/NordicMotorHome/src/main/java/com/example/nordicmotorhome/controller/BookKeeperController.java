package com.example.nordicmotorhome.controller;

import com.example.nordicmotorhome.model.Extra;
import com.example.nordicmotorhome.model.Motorhome;
import com.example.nordicmotorhome.service.ExtraService;
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

    @Autowired
    ExtraService extraService;

    private String startDate, endDate;
    private Motorhome picked;

    @GetMapping("/add")
    public String add(Model model)
    {
        return "home/add";
    }

    @PostMapping("/addContinue")
    public String addContinue(Model model, WebRequest webRequest)
    {
        String placeHolder;
        startDate = webRequest.getParameter("startDate");
        endDate = webRequest.getParameter("endDate");

        if(Date.valueOf(startDate).compareTo(Date.valueOf(endDate)) > 0)
        {
            placeHolder = startDate;
            startDate = endDate;
            endDate = placeHolder;
        }

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
    public String extras(Model model, WebRequest webRequest)
    {
        picked = new Motorhome();
        String licensePlate = webRequest.getParameter("licensePlate");
        picked.setLicenseNumber(licensePlate);
        List<Motorhome> motorhomes = service.fetchAll();
        for(int i = 0; i < motorhomes.size(); ++i)
        {
            if(picked.getLicenseNumber().equals(motorhomes.get(i).getLicenseNumber()))
            {
                picked = motorhomes.get(i);
            }
        }
        return "home/extras";
    }

    @PostMapping("/receipt")
    public String receipt(Model model, WebRequest webRequest)
    {
        final int capacity = 8;
        Extra extra;
        List<Extra> extras = extraService.fetchAll();
        extras.get(0).setQuantity(cast(webRequest.getParameter("bikeRackField")));
        extras.get(1).setQuantity(cast(webRequest.getParameter("bedLinenField")));
        extras.get(2).setQuantity(cast(webRequest.getParameter("childSeatField")));
        extras.get(3).setQuantity(cast(webRequest.getParameter("picnicTableField")));
        extras.get(4).setQuantity(cast(webRequest.getParameter("chairField")));
        extras.get(5).setQuantity(cast(webRequest.getParameter("smallAwningField")));
        extras.get(6).setQuantity(cast(webRequest.getParameter("mediumAwningField")));
        extras.get(7).setQuantity(cast(webRequest.getParameter("tableUmbrellaField")));
        model.addAttribute("startDate" ,startDate);
        model.addAttribute("endDate" ,endDate);
        model.addAttribute(picked);
        model.addAttribute("extraList", extras);


        return "home/receipt";
    }

    @GetMapping("/remove")
    public String remove(Model model) {return "home/removeBooking";}

    @GetMapping("/update")
    public String update(Model model)
    {
        return "home/update";
    }

    public int cast(String integer)
    {
        try
        {
            return Integer.parseInt(integer);
        }
        catch (Exception e)
        {
            return 0;
        }
    }

}
