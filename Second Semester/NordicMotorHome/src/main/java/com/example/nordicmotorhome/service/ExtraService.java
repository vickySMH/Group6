package com.example.nordicmotorhome.service;

import com.example.nordicmotorhome.model.Extra;
import com.example.nordicmotorhome.repository.ExtraRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExtraService
{
    @Autowired
    ExtraRepo extraRepo;

    public List<Extra> fetchAll()
    {
         return extraRepo.fetchAll();
    }

}
