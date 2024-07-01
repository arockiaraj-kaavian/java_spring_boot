package com.example.crud.model;


import org.springframework.data.annotation.Transient;
//import java.util.Date;
import org.springframework.data.mongodb.core.mapping.Document;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;


@Entity
@Document
@Data
@NoArgsConstructor
@AllArgsConstructor


public class Employees {

    @Transient
    public static final String SEQUENCE_NAME = "employees_sequence";

    @Id
    private Integer id;

    private String name;
    private String city;
    private String role;
    private String dateofjoined;
    
}
