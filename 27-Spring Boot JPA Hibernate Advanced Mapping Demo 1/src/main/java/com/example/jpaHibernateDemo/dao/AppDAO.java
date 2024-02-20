package com.example.jpaHibernateDemo.dao;

import com.example.jpaHibernateDemo.entity.Course;
import com.example.jpaHibernateDemo.entity.Instructor;
import com.example.jpaHibernateDemo.entity.InstructorDetail;


import java.util.List;
import java.util.Optional;


public interface AppDAO {
    void save (Instructor instructor);
    Optional<Instructor> findById(Integer id);
    void deleteById(Integer id);
    Optional<InstructorDetail>findInstructorDetailById(Integer id);
    void deleteInstructorDetailById(Integer id);
    List<Course> findCoursesByInstructorId(Integer id);
    Optional<Instructor> findInstructor(Integer id);

    Instructor findInstructorByIdJoinFetch(Integer id);
}
