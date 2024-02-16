package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.entity.Employee;
import com.springboot.cruddemo.payloads.StandardResponse;
import com.springboot.cruddemo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<StandardResponse> findAll() {
        return ResponseEntity.ok(
                StandardResponse.builder()
                        .data(employeeService.findAll())
                        .status(200)
                        .timeStamp(System.currentTimeMillis())
                        .build());
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<StandardResponse> findById(@PathVariable int id) {
        return ResponseEntity.ok(
                StandardResponse.builder()
                        .data(employeeService.findById(id))
                        .status(200)
                        .timeStamp(System.currentTimeMillis())
                        .build());
    }

    @PostMapping()
    @RequestMapping(value = "/employees",consumes = "application/json")
    public ResponseEntity<StandardResponse> save(@RequestBody Employee employee) {
        return ResponseEntity.ok(
                StandardResponse.builder()
                        .data(employeeService.save(employee))
                        .status(200)
                        .timeStamp(System.currentTimeMillis())
                        .build());
    }

}

