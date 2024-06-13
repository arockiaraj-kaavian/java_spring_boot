package com.example.crud.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class Filereader {

    
public ResponseEntity<String> FileUpload(@RequestParam("file") MultipartFile file) throws IOException  {

     List <String> lines = new ArrayList<String>();
     InputStream inputStream = file.getInputStream(); 
     BufferedReader bufferReader =   new BufferedReader(new InputStreamReader(inputStream));

     String numberLine;
     while ((numberLine = bufferReader.readLine()) != null) {
    lines.add(numberLine);
     }

     bufferReader.close();

     for ( String line : lines) {
        System.out.println(line);
    }
     
    
    String result = String.join(",", lines);
     return new ResponseEntity<String>(result, HttpStatus.OK);
}

public String jsonArray(){
     List<String> list = Arrays.asList("Arockiaraj", "Bhoopesh", "Mohammed");
     // String expectedJsonArray = "[\"Arockiaraj 1\",\" Bhoopesh 2\",\"Mohammed 3\"]";


    Gson gson = new Gson();
    String jsonArray = gson.toJson(list);
    // Assert.assertEquals(expectedJsonArray, jsonArray);
    

    return  jsonArray;
    
}
}




    



