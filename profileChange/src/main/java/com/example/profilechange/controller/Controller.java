package com.example.profilechange.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${person.name: DUDU}")
    private String name;

    @RequestMapping("/")
    public String hello() {
        return "hello" + name;
    }

    @Value("${os.name}")
    private String osName;
    @RequestMapping("/osname")
    public String osName() {
        return osName;
    }
}
