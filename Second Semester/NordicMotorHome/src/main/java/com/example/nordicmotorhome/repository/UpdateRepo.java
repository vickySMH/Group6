package com.example.nordicmotorhome.repository;

import com.example.nordicmotorhome.model.Booking;

import com.example.nordicmotorhome.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UpdateRepo
{
    @Autowired
    JdbcTemplate template;

    public List<Customer> fetchAll()
    {
        String sql = "SELECT FirstName, LastName, PhoneNumber FROM heroku_4aa3497124398a6.customer";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return template.query(sql, rowMapper);
    }

    public List<Booking> fetchAll2()
    {
        String sql = "SELECT StartDate, EndDate, LicenseNumber, Price FROM heroku_4aa3497124398a6.bookings";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return template.query(sql, rowMapper);
    }

    public List<Booking> fetchAll3()
    {
        String sql = "SELECT PhoneNumber FROM heroku_4aa3497124398a6.bookings";
        RowMapper<Booking> rowMapper = new BeanPropertyRowMapper<>(Booking.class);
        return template.query(sql, rowMapper);
    }
}
