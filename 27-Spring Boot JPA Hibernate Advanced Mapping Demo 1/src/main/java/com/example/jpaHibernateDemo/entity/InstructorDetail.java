package com.example.jpaHibernateDemo.entity;

import jakarta.persistence.*;
import lombok.*;

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

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    @ToString.Exclude
    private Instructor instructor;
}

