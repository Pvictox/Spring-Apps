package com.crud.App.dao;

import com.crud.App.entity.Student;

public interface StudentDAO {
    public void save(Student student);

    public Student getStudentbyId(int id);
}
