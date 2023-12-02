package com.ljelectrar.demospringmongodb.services;

import com.ljelectrar.demospringmongodb.domain.User;
import com.ljelectrar.demospringmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();
    }
}
