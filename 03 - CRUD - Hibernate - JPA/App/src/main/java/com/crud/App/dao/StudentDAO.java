package com.crud.App.dao;

import com.crud.App.entity.Student;

import java.util.List;

public interface StudentDAO {
    public void save(Student student);

    public Student getStudentbyId(int id);

    public List<Student> returnAllStudents();

    public List<Student> getStudentByFirstName(String parameter);

    public int updateStudentbyId(int id);

    public int updateLastName(String param);

    public int deleteStudentFromID(int id);

    public int deleteByFirstName(String parameter);
}
