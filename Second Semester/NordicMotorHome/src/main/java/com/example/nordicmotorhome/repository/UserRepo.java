package com.example.nordicmotorhome.repository;

import com.example.nordicmotorhome.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserRepo
{

    @Autowired
    JdbcTemplate template;

    public List<User> fetchAll()
    {
        String sql = "SELECT username, password from heroku_4aa3497124398a6.user";
        RowMapper<User> rowMapper  = new BeanPropertyRowMapper<>(User.class);
        return template.query(sql, rowMapper);
    }


}
