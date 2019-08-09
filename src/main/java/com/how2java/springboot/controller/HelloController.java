package com.how2java.springboot.controller;

import com.how2java.springboot.mapper.MaydayMapper;
import com.how2java.springboot.model.Mayday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

//import com.how2java.springboot.model.Mayday;
//import com.how2java.springboot.model.MaydayService;

@Controller

//@EnableutoConfiguration
//@RequestMapping("/admin")

public class HelloController {

    @Autowired
    private MaydayMapper maydayMapper;
 
    @RequestMapping("/")
    public String hello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/index")
    public String index(){
        //System.out.println(1);
        return "home";
    }
    @RequestMapping("/info/more")
    public String page2(){
        return "test";
    }

    @RequestMapping("/show_page")
    public String page3(){
        return "show_page";
    }

    @RequestMapping("/Mayday/{keyword}")
    public String search(@PathVariable("keyword") String search, Model model){
        Mayday mayday = new Mayday();
        mayday.setContent(search);
        mayday.setTitle(search);
        List contents = maydayMapper.findByNameAndPassword(mayday);
        model.addAttribute("contents", contents);
        return "show_page";
    }

 
}