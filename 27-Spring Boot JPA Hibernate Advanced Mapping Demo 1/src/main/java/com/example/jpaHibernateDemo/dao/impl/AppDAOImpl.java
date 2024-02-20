package com.example.jpaHibernateDemo.dao.impl;

import com.example.jpaHibernateDemo.dao.AppDAO;
import com.example.jpaHibernateDemo.entity.Instructor;
import com.example.jpaHibernateDemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AppDAOImpl implements AppDAO {
    private final EntityManager entityManager;

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Optional<Instructor> findById(Integer id) {
        return Optional.ofNullable(
                entityManager.find(Instructor.class, id)
        );
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        Optional<Instructor> byId = findById(id);
        if(!byId.isPresent()){
            throw new RuntimeException("Instructor not found");
        }
        entityManager.remove(byId.get());
    }

    @Override
    public Optional<InstructorDetail> findInstructorDetailById(Integer id) {
        return Optional.ofNullable(
                entityManager.find(InstructorDetail.class, id)
        );
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(Integer id) {
        Optional<InstructorDetail> byId = findInstructorDetailById(id);
        if(!byId.isPresent()){
            throw new RuntimeException("Instructor Detail not found");
        }
        byId.get().getInstructor().setInstructorDetail(null);
        entityManager.remove(byId.get());
    }
}
