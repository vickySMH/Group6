package com.example.nordicmotorhome.repository;

import com.example.nordicmotorhome.model.Extra;
import com.example.nordicmotorhome.model.Motorhome;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExtraRepo
{
    @Autowired
    JdbcTemplate template;

    public List<Extra> fetchAll()
    {
        String sql = "SELECT * FROM heroku_4aa3497124398a6.extras";
        RowMapper<Extra> rowMapper = new BeanPropertyRowMapper<>(Extra.class);
        return template.query(sql, rowMapper);
    }

}
