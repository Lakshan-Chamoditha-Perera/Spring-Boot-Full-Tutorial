package com.springboot.cruddemo.dao;

import com.springboot.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private final EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> fromEmployee = entityManager.createQuery(
                "FROM Employee", Employee.class
        );
        return fromEmployee.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee = entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        entityManager.remove(
                entityManager.find(Employee.class, id)
        );
    }
}
