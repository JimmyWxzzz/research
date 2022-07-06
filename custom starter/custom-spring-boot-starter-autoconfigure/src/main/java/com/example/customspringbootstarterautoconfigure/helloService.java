package com.example.customspringbootstarterautoconfigure;

import com.example.customspringbootstarterautoconfigure.service.bean.helloProperties;
import org.springframework.beans.factory.annotation.Autowired;



public class helloService {
    @Autowired
    helloProperties helloProperties;

    public String sayHello(String username) {
        return helloProperties.getPrefix() + ": " + username + helloProperties.getSuffix();
    }
}
