package com.example.nordicmotorhome.service;

import com.example.nordicmotorhome.model.Booking;

import com.example.nordicmotorhome.model.Customer;

import com.example.nordicmotorhome.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService
{
    @Autowired
    CustomerRepo CustomerRepo;

    public List<Customer> fetchAll()
    {
        return CustomerRepo.fetchAll();
    }

}