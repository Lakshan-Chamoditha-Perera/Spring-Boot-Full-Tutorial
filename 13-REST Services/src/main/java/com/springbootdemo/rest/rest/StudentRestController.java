package com.springbootdemo.rest.rest;

import com.springbootdemo.rest.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @GetMapping("/students")
    public List<Student> getStudents() {
        return List.of(new Student("John", "Doe"), new Student("Jane", "Doe"), new Student("Tom", "Doe"), new Student("Jerry", "Doe"), new Student("Jerry", "Doe"), new Student("Jerry", "Doe"));
    }

}
