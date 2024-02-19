package com.example.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class DemoController {

    @GetMapping
    public String get(Model model) {
        model.addAttribute("theDate", new Date());
        return "hello2"; //html name
    }

    //    need a controller to show initial HTML form
    @RequestMapping("/showForm")
    public String showForm(Model model) {
        return "my_form"; //html name
    }

    //    need a controller method to process the HTML form
    @RequestMapping("/processFormV1")
    public String processForm(Model model) {
        return "hello1"; //html name
    }

    // need a controller method to read form data and
// add data to the model
    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest httpServletRequest, Model model) {

//        read the request parameter from the HTML form
        String theName = httpServletRequest.getParameter("studentName");

//        convert the data to all uppercase
        theName = theName.toUpperCase();

//        create the message
        String result = "Yo! " + theName;

//        add message to the model
        model.addAttribute("message", result);

        return "hello3";
    }

    @PostMapping("/processFormV3")
    public String letsShoutDude(@RequestParam("studentName") String theName, Model model) {

        theName = theName.toUpperCase();

//        create the message
        String result = "Hello My Friend From v3! " + theName;

//        add message to the model
        model.addAttribute("message", result);

        return "hello3";
    }
}
