package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.rep.*;
import com.example.demo.service.ACMLoanService;

@RestController
@RequestMapping("/apis")
public class ACMLoanController {

@Autowired
public ACMLoanService s;
public LoanRepository rep;

    

    @GetMapping("/user")
    public <T> void indexation() {
    	return;
		}
}
