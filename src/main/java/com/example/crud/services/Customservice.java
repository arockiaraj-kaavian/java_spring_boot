package com.example.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.Users;
import com.example.crud.repository.UserRepository;

@Service
public class Customservice {

    
    @Autowired
    private UserRepository repository;

    public boolean saveUser(Users data) {
        repository.save(data);
        return true;
    }
    public boolean updateUser(Users data){
        repository.save(data);
        return true;
    }
    public Users getUser(String id) {
        return repository.findById(id).orElse(null);
    }
    public List<Users> getAllUsers(){
        return repository.findAll();
    }
    public boolean deleteUser(String id) {
        repository.deleteById(id);
        return true;
    }

   } 

