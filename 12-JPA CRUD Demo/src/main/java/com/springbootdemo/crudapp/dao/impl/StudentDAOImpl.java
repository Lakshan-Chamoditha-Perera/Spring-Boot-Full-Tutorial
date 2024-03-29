package com.springbootdemo.crudapp.dao.impl;

import com.springbootdemo.crudapp.dao.StudentDAO;
import com.springbootdemo.crudapp.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private final EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // implement the save method
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student get(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        return entityManager.createQuery(
                "FROM Student",
                Student.class
        ).getResultList();
    }

    @Override
    public List<Student> getStudentsByFirstName(String firstName) {
        return entityManager.createQuery(
                "FROM Student WHERE firstName = :firstName",
                Student.class
        ).setParameter("firstName", firstName).getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        entityManager.remove(entityManager.find(Student.class, id));
    }

    @Override
    @Transactional
    public void deleteAll() {
        entityManager.createQuery("DELETE FROM Student").executeUpdate();
    }


}
