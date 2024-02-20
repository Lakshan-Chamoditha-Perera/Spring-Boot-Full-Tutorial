package com.example.jpaHibernateDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private InstructorDetail instructorDetail;

    @OneToMany(mappedBy = "instructor", cascade = {
            CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
    })
    private List<Course> courses =new ArrayList<>();

    public void addCourse(Course course){
        courses.add(course);
        course.setInstructor(this);
    }
}
