package com.webdev.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@Slf4j
//@WebListener
public class listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("listener is working");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("Listener is destroyed");
    }
}
