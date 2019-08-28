package com.ebchinatech.search.controller;

import com.ebchinatech.search.service.MaydayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//import Mayday;
//import com.how2java.springboot.model.MaydayService;

@Controller

//@EnableutoConfiguration
//@RequestMapping("/admin")

public class HelloController {

    @Autowired
    @Qualifier("MaydayService")
    private MaydayService maydayService;
 
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

    @RequestMapping("/Mayday/{keyword}/{page}")
    public String search(@PathVariable("keyword") String search,@PathVariable("page") int page, Model model){
        model.addAttribute("contents", maydayService.search(search, page));
        model.addAttribute("page", page);
        model.addAttribute("search", search);
        model.addAttribute("totalpages",maydayService.totalPages(search));
        return "show_page";
    }



 
}