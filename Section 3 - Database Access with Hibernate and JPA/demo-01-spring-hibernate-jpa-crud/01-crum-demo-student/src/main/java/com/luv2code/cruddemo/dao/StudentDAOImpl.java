package com.luv2code.cruddemo.dao;

import java.util.List;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(Integer studentId){
        return entityManager.find(Student.class, studentId);
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("FROM Student").getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = entityManager.createQuery(
                "FROM Student WHERE lastName=:lastName",Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }
}
