package com.udemy1.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/")
    public String sayHello(){
        return "hello world";
    }


    @GetMapping("/workout")
    public String getWorkout(){
        return "working out new";
    }






}
