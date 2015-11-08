package ru.kpfu.itis.service;

import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.model.Subject;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    void addStudent(Student student);

    Student getStudent(Integer id);

    List<Subject> getStudentSubjects(Integer id);

}
