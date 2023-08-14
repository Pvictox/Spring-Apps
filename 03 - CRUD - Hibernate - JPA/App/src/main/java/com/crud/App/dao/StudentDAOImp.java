package com.crud.App.dao;

import com.crud.App.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

/*
* This class is responsible for the implementation of the methods on th StudentDAO interface
* */
@Repository //One of the branches of the @Component annotation. Specific to DAO's
public class StudentDAOImp implements StudentDAO{

    private EntityManager entityManager; //Attribute responsible for dealing with persistence.

    @Autowired
    public StudentDAOImp(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    @Transactional //Annotation that will handle the transaction procedures. (Start and end a transaction)
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student getStudentbyId(int id) {
        return entityManager.find(Student.class, id);
    }


    @Override
    public List<Student> returnAllStudents() { //No need to use @Transactional because it's not modifying the DB.
        TypedQuery<Student> entityQuery = entityManager.createQuery("FROM Student", Student.class); //Return all
        return  entityQuery.getResultList();
    }

    @Override
    public List<Student> getStudentByFirstName(String parameter) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE firstName=:param", Student.class);
        theQuery.setParameter("param", parameter);
        return theQuery.getResultList();
    }
}
