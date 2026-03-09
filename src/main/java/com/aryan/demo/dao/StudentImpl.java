package com.aryan.demo.dao;

import com.aryan.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentImpl implements StudentDao {

    private EntityManager em;

    @Autowired
    public StudentImpl(EntityManager em){
          this.em=em;
    }

    @Override
    @Transactional
    public void save(Student s){
          em.persist(s);
    }

    @Override
    public Student findById(Integer id) {
        return em.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> q=em.createQuery("FROM Student order by lastName",Student.class);
        return q.getResultList();
     }

    @Override
    public List<Student> findByLastName(String thelastName) {
        TypedQuery<Student> q=em.createQuery("FROM Student WHERE lastName=:thedata",Student.class);
        q.setParameter("thedata",thelastName);
        return q.getResultList();
    }

    @Override
    @Transactional
    public void update(Student s) {
        em.merge(s);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student s=em.find(Student.class,id);
        em.remove(s);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int rows=em.createQuery("DELETE FROM Student").executeUpdate();
        return rows;
    }


}
