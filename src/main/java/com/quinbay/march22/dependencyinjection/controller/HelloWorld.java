package com.quinbay.march22.dependencyinjection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/Greet")
    public String Greet(){
        return "Hello";
    }
}
