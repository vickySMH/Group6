package com.example.nordicmotorhome.service;

import com.example.nordicmotorhome.model.Bookings;
import com.example.nordicmotorhome.repository.BookingsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingsService {
    @Autowired
    BookingsRepo repo;

    public List<Bookings> fetchAll()
    {
        return repo.fetchAll();
    }
}
