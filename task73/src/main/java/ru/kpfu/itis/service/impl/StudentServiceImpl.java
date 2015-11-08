package ru.kpfu.itis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.model.Subject;
import ru.kpfu.itis.repository.StudentRepository;
import ru.kpfu.itis.service.StudentService;

import java.util.List;

/**
 * Created by vlad on 21.10.15.
 */

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public List<Student> getAllStudents() {
        return repository.getAllStudents();
    }

    @Override
    public void addStudent(Student student) {
        if (student == null) {
            return;
        }
        repository.addStudent(student);
    }

    @Override
    public Student getStudent(Integer id) {
        return repository.getStudent(id);
    }

    @Override
    public List<Subject> getStudentSubjects(Integer id) {
        return repository.getStudentSubjects(id);
    }
}
