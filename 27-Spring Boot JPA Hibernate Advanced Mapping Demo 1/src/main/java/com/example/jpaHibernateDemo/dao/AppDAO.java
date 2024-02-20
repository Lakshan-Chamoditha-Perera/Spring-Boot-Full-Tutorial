package com.example.jpaHibernateDemo.dao;

import com.example.jpaHibernateDemo.entity.Instructor;


import java.util.Optional;


public interface AppDAO {
    void save (Instructor instructor);
    Optional<Instructor> findById(Integer id);
    void deleteById(Integer id);
}
