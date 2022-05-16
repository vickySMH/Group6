package com.example.nordicmotorhome.repository;

import com.example.nordicmotorhome.model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MotorhomeRepo
{
    @Autowired
    JdbcTemplate template;

    public List<Motorhome> fetchNotAvailable(String startDate, String endDate)
    {
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("start", startDate).addValue("end", endDate);
        String sql = "SELECT heroku_4aa3497124398a6.vehicle.LicenseNumber FROM heroku_4aa3497124398a6.vehicle, heroku_4aa3497124398a6.bookings WHERE heroku_4aa3497124398a6.vehicle.LicenseNumber = heroku_4aa3497124398a6.bookings.LicenseNumber AND (? BETWEEN StartDate AND EndDate OR ? BETWEEN StartDate AND EndDate)";
        RowMapper<Motorhome> rowMapper  = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(sql, rowMapper, startDate, endDate);
    }
    
    public List<Motorhome> fetchAll()
    {
        String sql = "SELECT * FROM heroku_4aa3497124398a6.vehicle";
        RowMapper<Motorhome> rowMapper = new BeanPropertyRowMapper<>(Motorhome.class);
        return template.query(sql, rowMapper);
    }
    

}
