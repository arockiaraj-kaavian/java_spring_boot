package com.example.crud.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.crud.Employees;
import com.example.crud.services.Customservice;
import com.example.crud.services.Filereader;

@RestController
@RequestMapping("/api")
public class crudcontroller {
    
    @Autowired
    Customservice customservice;

     @Autowired
    
     Filereader filereader;
    @GetMapping("/getData")
    public List<Employees> getAllUsers(){
        System.out.println("Welcome to all to in java Spring");


         return customservice.getAllUsers();

    }

    @GetMapping("/gsondata")
    public String jsonArray(){
        return filereader.jsonArray();
    }


    @PostMapping("/readfile")
    public ResponseEntity<String> FileUpload(@RequestBody MultipartFile file) {
        try {
             
            return filereader.FileUpload(file);
            
        } 
        catch (IOException e) {
            return new ResponseEntity<>("Error reading file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/addData")
    public String saveUser(@RequestBody Employees data){
        System.out.println(data);
        boolean created = customservice.saveUser(data);

        if(created) {
            return "user added successfully";
        }
        else {
            return "operation failed";
        }
    }
    @PutMapping("/editData")
    public String updateUser(@RequestBody Employees data){
        System.out.println(data);
        boolean updated = customservice.updateUser(data);
        if(updated) {
            return "user updated successfully";
        }
        else {
            return " operation failed";
        }
    }

    @DeleteMapping("/deleteData")
    public String deleteUser(@RequestParam("id") Integer id){
        boolean deleted = customservice.deleteUser(id);
        if(deleted){
            return "user deleted successfully";
        }else{
            return "operation failed";
        }
    }

}
