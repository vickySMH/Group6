package com.example.nordicmotorhome.service;

import com.example.nordicmotorhome.model.Booking;

import com.example.nordicmotorhome.model.Customer;

import com.example.nordicmotorhome.repository.UpdateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UpdateService
{
    @Autowired
    UpdateRepo UpdateRepo;

    public List<Customer> fetchAll()
    {
        return UpdateRepo.fetchAll();
    }

    public List<Booking> fetchAll2(String PhoneNumber)
    {
        return UpdateRepo.fetchAll2(PhoneNumber);
    }

    public Booking update(Booking booking)
    {
        return UpdateRepo.update(booking);
    }

}