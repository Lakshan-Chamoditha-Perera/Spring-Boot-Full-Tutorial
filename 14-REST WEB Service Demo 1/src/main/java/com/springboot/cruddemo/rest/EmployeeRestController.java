package com.springboot.cruddemo.rest;

import com.springboot.cruddemo.dao.EmployeeDAO;
import com.springboot.cruddemo.payloads.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeRestController {
    private final EmployeeDAO employeeDAO;

    @GetMapping("/employees")
    public ResponseEntity<StandardResponse> findAll() {
        return ResponseEntity.ok(
                StandardResponse.builder()
                        .data(employeeDAO.findAll())
                        .status(200)
                        .timeStamp(System.currentTimeMillis())
                        .build());
    }

}

