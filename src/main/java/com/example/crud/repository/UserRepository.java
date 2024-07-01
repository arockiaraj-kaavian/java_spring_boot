package com.example.crud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crud.model.Employees;

public interface UserRepository extends MongoRepository<Employees, Integer> {
     List<Employees> findByid(Integer id);
}
