package com.example.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Employees;
import com.example.crud.repository.UserRepository;

@Service
public class Customservice {

    
    @Autowired
    private UserRepository repository;

    @Autowired
    NextSequenceService nextSequenceService;


    public boolean saveUser(Employees data) {
        Employees employeetemp = new Employees();
        employeetemp.setId(nextSequenceService.getNextSequence("DatabaseSequence"));
        employeetemp.setName(data.getName());
        employeetemp.setCity(data.getCity());
        employeetemp.setRole(data.getRole());
        employeetemp.setDateofjoined(data.getDateofjoined());        
        repository.save(employeetemp);
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

