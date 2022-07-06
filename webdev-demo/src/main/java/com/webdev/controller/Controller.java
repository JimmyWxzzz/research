package com.webdev.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Counter counter;
    public Controller(MeterRegistry meterRegistry) {
       counter =  meterRegistry.counter("controller.count");
    }
    @RequestMapping("/1.png")
    public String hello(){
        return "aaaa";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        counter.increment();
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }


    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }




}
