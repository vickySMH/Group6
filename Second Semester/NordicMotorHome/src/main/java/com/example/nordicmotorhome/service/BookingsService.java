package com.example.nordicmotorhome.service;

import com.example.nordicmotorhome.model.Booking;
import com.example.nordicmotorhome.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {
    @Autowired
    BookingRepo repo;

    public List<Booking> fetchAll()
    {
        return repo.fetchAll();
    }
}
