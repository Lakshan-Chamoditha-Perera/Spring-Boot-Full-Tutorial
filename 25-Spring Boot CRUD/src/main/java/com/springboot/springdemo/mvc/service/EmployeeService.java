package com.springboot.springdemo.mvc.service;

import com.springboot.springdemo.mvc.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

}
