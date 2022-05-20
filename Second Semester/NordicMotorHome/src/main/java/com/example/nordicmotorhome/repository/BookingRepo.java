package com.example.nordicmotorhome.repository;

import com.example.nordicmotorhome.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingRepo
{

    @Autowired
    JdbcTemplate template;

    public List<Booking> fetchAll()
    {
        String sql = "SELECT * FROM heroku_4aa3497124398a6.bookings";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return template.query(sql, rowMapper);
    }

    public Booking addBooking(Booking booking)
    {
        String sql = "INSERT INTO heroku_4aa3497124398a6.bookings(StartDate, EndDate, LicenseNumber, PhoneNumber, Price) VALUES (?, ?, ?, ?, ?)";
        template.update(sql, booking.getStartDate(), booking.getEndDate(), booking.getLicenseNumber(), booking.getPhoneNumber(), booking.getPrice());
        return null;
    }


}
