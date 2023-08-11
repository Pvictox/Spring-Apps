package com.crud.App.dao;

import com.crud.App.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
}
