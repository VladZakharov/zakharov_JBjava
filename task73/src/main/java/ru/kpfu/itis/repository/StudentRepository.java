package ru.kpfu.itis.repository;

import ru.kpfu.itis.model.Student;
import ru.kpfu.itis.model.Subject;

import java.util.List;

public interface StudentRepository {

    List<Student> getAllStudents();

    void addStudent(Student student);

    Student getStudent(Integer id);

    List<Subject> getStudentSubjects(Integer id);
}
