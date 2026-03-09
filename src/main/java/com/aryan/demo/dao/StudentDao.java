package com.aryan.demo.dao;

import com.aryan.demo.entity.Student;

import java.util.List;

public interface StudentDao {
    void save(Student s);

    Student findById(Integer id);

     List<Student> findAll();

     List<Student> findByLastName(String thelastName);

     void update(Student s);

     void delete(Integer id);

     int deleteAll();
}
