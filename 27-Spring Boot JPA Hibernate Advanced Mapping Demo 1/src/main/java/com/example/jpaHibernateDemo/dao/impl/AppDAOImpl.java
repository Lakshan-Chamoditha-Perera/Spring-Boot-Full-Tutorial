package com.example.jpaHibernateDemo.dao.impl;

import com.example.jpaHibernateDemo.dao.AppDAO;
import com.example.jpaHibernateDemo.entity.Course;
import com.example.jpaHibernateDemo.entity.Instructor;
import com.example.jpaHibernateDemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AppDAOImpl implements AppDAO {
    private final EntityManager entityManager;

    @Transactional
    @Override
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Transactional
    @Override
    public Optional<Instructor> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Instructor.class, id));
    }

    @Transactional
    @Override
    public void deleteById(Integer id) {
        Optional<Instructor> byId = findById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Instructor not found");
        }
        entityManager.remove(byId.get());
    }

    @Override
    public Optional<InstructorDetail> findInstructorDetailById(Integer id) {
        return Optional.ofNullable(entityManager.find(InstructorDetail.class, id));
    }

    @Transactional
    @Override
    public void deleteInstructorDetailById(Integer id) {
        Optional<InstructorDetail> byId = findInstructorDetailById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Instructor Detail not found");
        }
        byId.get().getInstructor().setInstructorDetail(null);
        entityManager.remove(byId.get());
    }

    @Override
    public List<Course> findCoursesByInstructorId(Integer id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c where c.instructor.id = :id", Course.class);
        query.setParameter("id", id);
        return query.getResultList();

    }

    @Override
    public Optional<Instructor> findInstructor(Integer id) {
        return Optional.ofNullable(entityManager.find(Instructor.class, id));
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(Integer id) {
        return entityManager.createQuery("SELECT i FROM Instructor i " + "JOIN FETCH i.courses " + "WHERE i.id = :id", Instructor.class).setParameter("id", id).getSingleResult();
    }

    @Transactional
    @Override
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    public Optional<Course> findCourseById(Integer id) {
        return Optional.ofNullable(entityManager.find(Course.class, id));
    }

    @Transactional
    @Override
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Transactional
    @Override
    public void deleteInstructorWithoutDeletingChilds(Integer id) {
        Optional<Instructor> byId = findById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Instructor not found");
        }
        byId.get().getCourses().forEach(course -> course.setInstructor(null));
        entityManager.remove(byId.get());
    }

    @Override
    public void deleteCourse(Integer id) {
        Optional<Course> byId = findCourseById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Course not found");
        }
        entityManager.remove(byId.get());
    }

    @Transactional
    @Override
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Optional<Course> findCourseWithReviewsById(Integer id) {
        List<Course> resultList = entityManager.createQuery(
                "SELECT c FROM Course c " +
                        "JOIN FETCH c.reviews " +
                        "WHERE c.id = :id", Course.class)
                .setParameter("id", id)
                .getResultList();
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));

    }

    @Transactional
    @Override
    public void deleteCourseAndReviews(Integer id) {
        Optional<Course> byId = findCourseWithReviewsById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("Course not found");
        }
        entityManager.remove(byId.get());
    }
}
