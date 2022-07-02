package com.webdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan(basePackages = "com.webdev")
@SpringBootApplication
public class WebdevDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebdevDemoApplication.class, args);
    }

}
