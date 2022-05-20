package com.example.nordicmotorhome.controller;

import com.example.nordicmotorhome.model.Booking;
import com.example.nordicmotorhome.model.Customer;
import com.example.nordicmotorhome.model.Extra;
import com.example.nordicmotorhome.model.Motorhome;
import com.example.nordicmotorhome.service.BookingService;
import com.example.nordicmotorhome.service.ExtraService;
import com.example.nordicmotorhome.service.MotorhomeService;
import com.example.nordicmotorhome.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.sql.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Controller
public class BookKeeperController
{
    @Autowired
    MotorhomeService service;

    @Autowired
    UpdateService updateService;

    @Autowired
    ExtraService extraService;

    @Autowired
    BookingService bookingService;

    private String startDate, endDate, phoneNumber;
    private Motorhome picked;

    @GetMapping("/viewBooking")
    public String viewBooking(Model model) {
        return "home/viewBooking";
    }

    @PostMapping("/viewBookingContinue")
    public String viewBookingContinue(Model model, WebRequest webRequest) {
        phoneNumber = webRequest.getParameter("phoneNumber");
        List<Booking> bookingsList = bookingService.fetchAll();
        for (int i = 0; i < bookingsList.size(); i++)
        {
            if((bookingsList.get(i).getPhoneNumber().equals(phoneNumber)));
            {
                model.addAttribute(phoneNumber);
            }
        }
        model.addAttribute("bookings", bookingsList);
        return "home/viewBookingContinue";
    }

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
        phoneNumber = webRequest.getParameter("phoneNumber");

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
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("startDate" ,startDate);
        model.addAttribute("endDate" ,endDate);
        model.addAttribute(picked);
        model.addAttribute("extraList", extras);
        Booking booking = new Booking();
        booking.setStartDate(Date.valueOf(startDate));
        booking.setEndDate(Date.valueOf(endDate));
        booking.setLicenseNumber(picked.getLicenseNumber());
        booking.setPhoneNumber(phoneNumber);
        TimeUnit time = TimeUnit.DAYS;
        long difference = time.convert(Date.valueOf(endDate).getTime() - Date.valueOf(startDate).getTime(), TimeUnit.MILLISECONDS);
        float bookingPrice = difference * picked.getPrice();
        booking.setPrice(bookingPrice);
        model.addAttribute("bookingPrice",difference * picked.getPrice());
        float extrasPrice = 0;
        for(int i = 0; i < extras.size(); ++i)
        {
            if(extras.get(i).getQuantity() != 0)
            {
                extrasPrice += extras.get(i).getQuantity()*extras.get(i).getPrice();
            }
        }
        model.addAttribute("extrasPrice", extrasPrice);
        model.addAttribute("fullPrice", extrasPrice+bookingPrice);
        bookingService.addBooking(booking);

        return "home/receipt";
    }

    @GetMapping("/remove")
    public String remove(Model model) {return "home/removeBooking";}

    @GetMapping("/update")
    public String update(Model model)
    {
        List<Customer> bookings = updateService.fetchAll();
        model.addAttribute("bookings", bookings);
        return "home/update";
    }

    @PostMapping("/updateContinue")
    public String findUser(Model model, WebRequest webRequest)
    {
        String phoneNumber = webRequest.getParameter("phoneNumber");
        List<Booking> bookingsList = updateService.fetchAll3();
        for (Booking c: bookingsList)
        {
            if (c.getPhoneNumber().equals(phoneNumber))
            {
                return "home/updateContinue";
            }
        }
        return  "redirect:/update";
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