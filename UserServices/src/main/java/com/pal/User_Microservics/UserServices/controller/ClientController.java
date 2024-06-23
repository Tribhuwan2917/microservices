package com.pal.User_Microservics.UserServices.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${UserServices.client.base.URL}")
public class ClientController {
    @GetMapping("${UserServices.Get_All_Clients}")
    public ResponseEntity<List<String>> getAllClinets()
    {
        List<String> listOfClinets=List.of("Ram","Shyam","Mohan","Sohan","Rohan");
        return new ResponseEntity<>(listOfClinets, HttpStatus.OK);
    }
}
