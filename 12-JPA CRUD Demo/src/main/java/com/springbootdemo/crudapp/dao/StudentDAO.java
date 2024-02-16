package com.springbootdemo.crudapp.dao;

import com.springbootdemo.crudapp.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);

    Student get(int id);

    List<Student> getAll();

    List<Student> getStudentsByFirstName(String firstName);
}
