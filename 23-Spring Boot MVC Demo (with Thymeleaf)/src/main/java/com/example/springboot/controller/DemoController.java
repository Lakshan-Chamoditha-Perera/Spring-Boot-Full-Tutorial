package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class DemoController {

    @GetMapping
    public String get(Model model){
        model.addAttribute("theDate",new Date());
        return "hello"; //html name
    }

    @RequestMapping("/showForm")
    public String showForm(Model model){
        return "my_form"; //html name
    }
}
