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
//            createStudent(studentDAO);
//            createMultipleStudents(studentDAO);

//            retrieveStudent(studentDAO);
//            retrieveAllStudents(studentDAO);
//            retrieveStudentsByFirstName(studentDAO);

            updateStudent(studentDAO);
        };
    }

    private void updateStudent(StudentDAO studentDAO) {
        System.out.println("Updating student");
        Student student = studentDAO.get(1);

        if (student != null) {
            student.setFirstName("Jane");
            studentDAO.update(student);
            System.out.println("Student updated");
        } else {
            System.out.println("Student not found !");
        }
    }

    private void retrieveStudentsByFirstName(StudentDAO studentDAO) {
        System.out.println("Retrieving students by first name");
        studentDAO.getStudentsByFirstName("John").forEach(System.out::println);
    }

    private void retrieveAllStudents(StudentDAO studentDAO) {
        System.out.println("Retrieving all students");
        studentDAO.getAll().forEach(System.out::println);
    }

    private void retrieveStudent(StudentDAO studentDAO) {
        System.out.println("Retrieving student");
        Student student = studentDAO.get(1-8);

        System.out.println(student != null ?
                "Student retrieved: " + student :
                "Student not found !"
        );
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        System.out.println("Creating multiple students");
        Student student1 = new Student("Jane", "Doe", "jane@email.com");
        Student student2 = new Student("Mary", "Jane", "mary@email.com");
        Student student3 = new Student("John", "Smith", "smith@email.com");

        System.out.println("Saving multiple students");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);

        System.out.println("Multiple students saved");

    }

    private void createStudent(StudentDAO studentDAO) {
        System.out.println("Creating student");
        Student student = new Student("John", "Doe", "johndoe@email.com");

        System.out.println("Saving student");
        studentDAO.save(student);

        System.out.println("Student saved. Generated id: " + student.getId());

    }

}
