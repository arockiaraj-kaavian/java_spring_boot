package com.example.crud.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;

@Document(collection = "database_sequences")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class DatabaseSequence {



    @Id
    private String id;

    private int seq;

    
    
    
    //getters and setters omitted


}
