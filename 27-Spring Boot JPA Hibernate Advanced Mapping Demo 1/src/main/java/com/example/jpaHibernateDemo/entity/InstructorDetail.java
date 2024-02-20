package com.example.jpaHibernateDemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "instructor_detail")
@AllArgsConstructor
@NoArgsConstructor
public class InstructorDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String youtube_channel;
    private String hobby;

//    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
//    private Instructor instructor;
}

