package ru.kpfu.itis.repository.impl;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.model.Subject;
import ru.kpfu.itis.repository.StudentRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceContext
    EntityManager em;

    @Override
    public List<Student> getAllStudents() {
        Query query = em.createNativeQuery("SELECT * FROM students", Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
        em.persist(student);
    }

    @Override
    public Student getStudent(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM students WHERE id = ?", Student.class);
        query.setParameter(1, id);
        return (Student) query.getSingleResult();
    }

    @Override
    public List<Subject> getStudentSubjects(Integer id) {
        Query query = em.createNativeQuery("SELECT * FROM subjects WHERE student_id = ?", Subject.class);
        query.setParameter(1, id);
        return query.getResultList();
    }
}
