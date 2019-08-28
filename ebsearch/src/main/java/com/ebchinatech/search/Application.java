package com.ebchinatech.search;
 
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
 
@SpringBootApplication
@SpringBootConfiguration
@MapperScan("com.how2java.springboot.mapper")
public class Application {
 
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}