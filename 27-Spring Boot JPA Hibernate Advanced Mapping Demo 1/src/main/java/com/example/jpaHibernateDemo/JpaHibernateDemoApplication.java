package com.example.jpaHibernateDemo;

import com.example.jpaHibernateDemo.dao.AppDAO;
import com.example.jpaHibernateDemo.entity.Instructor;
import com.example.jpaHibernateDemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class JpaHibernateDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaHibernateDemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO) {

        return runner -> {
//            saveInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteInstructor(appDAO);

        };

    }

    private void findInstructor(AppDAO appDAO) {
        Optional<Instructor> byId = appDAO.findById(8);
        System.out.println(byId.isPresent() ? byId.get() : "Instructor not found !");
    }

    private void saveInstructor(AppDAO appDAO) {
        Instructor instructor = new Instructor();

        instructor.setFirstName("John");
        instructor.setLastName("Doe");
        instructor.setEmail("john@gmail.com");

        InstructorDetail instructorDetail = new InstructorDetail();
        instructorDetail.setHobby("Coding");
        instructorDetail.setYoutube_channel("youtube.com");
        instructor.setInstructorDetail(instructorDetail);

        appDAO.save(instructor);
        System.out.println("Instructor saved");

    }

    private void deleteInstructor(AppDAO appDAO) {
        try{
            appDAO.deleteById(8);
            System.out.println("Instructor deleted");
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
