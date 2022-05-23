package com.example.nordicmotorhome.service;

import com.example.nordicmotorhome.model.Booking;
import com.example.nordicmotorhome.repository.BookingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService
{
    @Autowired
    BookingRepo repo;

    public List<Booking> fetchAll()
    {
        return repo.fetchAll();
    }

    public Booking addBooking(Booking booking)
    {
        return repo.addBooking(booking);
    }

    public List<Booking> findByPhoneNumber(String phoneNumber)
    {
        return repo.findByPhoneNumber(phoneNumber);
    }

    public Boolean deleteBooking(int id){return repo.deleteBooking(id);}


}
