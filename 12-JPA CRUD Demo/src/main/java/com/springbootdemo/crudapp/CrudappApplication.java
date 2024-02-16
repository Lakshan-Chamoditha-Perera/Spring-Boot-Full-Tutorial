package com.springbootdemo.crudapp;

import com.springbootdemo.crudapp.dao.StudentDAO;
import com.springbootdemo.crudapp.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudappApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudappApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return args -> {
            createStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating student");
        Student student = new Student("John", "Doe", "johndoe@email.com");

        System.out.println("Saving student");
        studentDAO.save(student);

        System.out.println("Student saved. Generated id: " + student.getId());

    }

}
