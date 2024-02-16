package com.springbootdemo.rest.rest;

import com.springbootdemo.rest.entity.Student;
import com.springbootdemo.rest.rest.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> students;

    @PostConstruct
    public void loadData() {
        students = List.of(new Student("John", "Doe"), new Student("Jane", "Doe"), new Student("Mary", "Doe"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) throws StudentNotFoundException {
        if (students.size() <= id || id < 0) {
            throw new StudentNotFoundException("Student id not found - " + id);
        }
        return students.get(id);
    }

}
