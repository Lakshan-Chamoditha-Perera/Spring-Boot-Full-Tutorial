package com.springboot.springdemo.mvc.service.custom;

import com.springboot.springdemo.mvc.dao.EmployeeRepository;
import com.springboot.springdemo.mvc.entity.Employee;
import com.springboot.springdemo.mvc.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }
}
