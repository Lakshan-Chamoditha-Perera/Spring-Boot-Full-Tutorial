package com.springbootdemo.crudapp.dao;

import com.springbootdemo.crudapp.entity.Student;

public interface StudentDAO {
    void save(Student student);
    Student get(int id);
}
