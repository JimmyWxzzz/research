package com.boot.plugintester.controller;


import com.example.customspringbootstarterautoconfigure.helloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloController {

    @Autowired
    helloService helloService;

    @GetMapping("/h")
    public String sayHello() {
        String s = helloService.sayHello("Jim");
        return s;
    }
}
