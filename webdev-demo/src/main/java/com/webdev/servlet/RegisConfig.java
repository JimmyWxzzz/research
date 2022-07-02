package com.webdev.servlet;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class RegisConfig {

    @Bean
    public ServletRegistrationBean myservlet() {
        Servlet serv = new Servlet();
        return new ServletRegistrationBean(serv, "/my");
    }

    @Bean
    public FilterRegistrationBean myfilter() {
        myfilter fil = new myfilter();
//        return new FilterRegistrationBean(fil, myservlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(fil);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my"));
        return filterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean mylistener() {
        listener lis = new listener();
        return new ServletListenerRegistrationBean(lis);
    }
}
