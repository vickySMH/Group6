package com.example.nordicmotorhome.service;

import com.example.nordicmotorhome.model.Motorhome;
import com.example.nordicmotorhome.model.User;
import com.example.nordicmotorhome.repository.MotorhomeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public class MotorhomeService
{
    @Autowired
    MotorhomeRepo repo;

    public List<Motorhome> fetchAll(Date startDate, Date endDate)
    {
        return repo.fetchAllPossible(startDate, endDate);
    }




}
