package com.example.nordicmotorhome.service;

import com.example.nordicmotorhome.model.User;
import com.example.nordicmotorhome.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{

    @Autowired
    UserRepo repo;

    public List<User> fetchAll()
    {
        return repo.fetchAll();
    }

}
