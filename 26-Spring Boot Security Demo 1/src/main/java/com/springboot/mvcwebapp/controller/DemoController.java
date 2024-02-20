package com.springboot.mvcwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    @GetMapping("/")
    public String showHome() {
        return "home";
    }
    //    add request for /admin
    @GetMapping("/manager")
    public String showManager() {
        return "manager";
    }
    @GetMapping("/system")
    public String showAdmin() {
        return "admin";
    }
}
