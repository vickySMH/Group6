package com.example.nordicmotorhome.repository;

import com.example.nordicmotorhome.model.Bookings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookingsRepo {

    @Autowired
    JdbcTemplate template;

    public List<Bookings> fetchAll()
    {
        String sql = "SELECT * FROM heroku_4aa3497124398a6.bookings";
        RowMapper<Bookings> rowMapper = new BeanPropertyRowMapper<>(Bookings.class);
        return template.query(sql, rowMapper);
    }
}
