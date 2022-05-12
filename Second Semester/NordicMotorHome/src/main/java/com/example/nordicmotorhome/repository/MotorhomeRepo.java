package com.example.nordicmotorhome.repository;

import com.example.nordicmotorhome.model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class MotorhomeRepo
{
    @Autowired
    JdbcTemplate template;
    public List<Motorhome> fetchAllPossible(Date startDate, Date endDate)
    {
        String sql = "SELECT vehicle.LicenseNumber FROM vehicle, bookings WHERE vehicle.LicenseNumber = bookings.LicenseNumber AND ('?' BETWEEN StartDate AND EndDate OR '?' BETWEEN StartDate AND EndDate)";
        template.update(sql, startDate, endDate);
        RowMapper<Motorhome> rowMapper  = new BeanPropertyRowMapper<>(Motorhome.class);
        List<Motorhome> notAvailable = template.query(sql, rowMapper);
        String sql2 = "SELECT * FROM vehicle WHERE LicenseNumber != ?";
        RowMapper<Motorhome> rowMapper2 = null;
        for (Motorhome m: notAvailable)
        {
            template.update(sql2, m.getLicenseNumber());
            rowMapper2  = new BeanPropertyRowMapper<>(Motorhome.class);
        }
        return template.query(sql, rowMapper2);
    }

}
