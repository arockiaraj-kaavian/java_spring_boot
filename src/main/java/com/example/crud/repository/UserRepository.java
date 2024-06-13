package com.example.crud.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.crud.Users;

public interface UserRepository extends MongoRepository<Users, String> {
    List<Users> findByid(String id);
}
