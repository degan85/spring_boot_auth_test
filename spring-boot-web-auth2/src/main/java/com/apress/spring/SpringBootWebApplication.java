package com.apress.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication {
  private static final Logger log = LoggerFactory.getLogger(SpringBootWebApplication.class);
  
  public static void main(String[] args) {
    SpringApplication.run(SpringBootWebApplication.class, args);
  }

}