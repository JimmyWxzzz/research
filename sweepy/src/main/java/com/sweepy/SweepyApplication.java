package com.sweepy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;

@SpringBootApplication
public class SweepyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SweepyApplication.class, args);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","wangxuzhu354BJDX");
            if (con.isValid(1000)){
                System.out.println("Connected");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
