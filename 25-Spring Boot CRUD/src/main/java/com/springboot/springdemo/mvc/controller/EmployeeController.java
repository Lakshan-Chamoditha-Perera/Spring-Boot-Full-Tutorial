package com.springboot.springdemo.mvc.controller;

import com.springboot.springdemo.mvc.entity.Employee;
import com.springboot.springdemo.mvc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
/*
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }*/


    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> theList = employeeService.findAll();
        model.addAttribute("employees", theList);
        return "list-employee";
    }
}
