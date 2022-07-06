package com.example.profilechange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

@SpringBootApplication
public class ProfileChangeApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ProfileChangeApplication.class, args);
        ConfigurableEnvironment env = run.getEnvironment();
        Map<String, Object> SysEnv = env.getSystemEnvironment();
        Map<String, Object> SysProp = env.getSystemProperties();
        System.out.println(SysEnv);
        System.out.println(SysProp);
    }

}
