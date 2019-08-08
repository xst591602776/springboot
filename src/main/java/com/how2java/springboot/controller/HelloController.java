package com.how2java.springboot.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.how2java.springboot.model.Mayday;
//import com.how2java.springboot.model.MaydayService;

@Controller

//@EnableutoConfiguration
//@RequestMapping("/admin")

public class HelloController {
 
    @RequestMapping("/")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/index")
    public String index(){
        return "hello";
    }

 
}