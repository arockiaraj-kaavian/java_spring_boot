package com.example.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.Employees;
import com.example.crud.repository.UserRepository;

@Service
public class Customservice {

    
    @Autowired
    private UserRepository repository;

    public boolean saveUser(Employees data) {
        repository.save(data);
        return true;
    }
    public boolean updateUser(Employees data){
        repository.save(data);
        return true;
    }
    public Employees getUser(Integer id) {
        return repository.findById(id).orElse(null);
    }
    public List<Employees> getAllUsers(){
        return repository.findAll();
    }
    public boolean deleteUser(Integer id) {
        repository.deleteById(id);
        return true;
    }

   } 

