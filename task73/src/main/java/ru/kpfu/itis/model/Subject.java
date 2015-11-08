package ru.kpfu.itis.model;

import ru.kpfu.itis.model.enums.SubjectType;

import javax.persistence.*;

/**
 * Created by vlad on 23.10.15.
 */
@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "subject_type", nullable = false)
    private SubjectType subjectType;

    @Column(name = "score")
    private Integer score;

    @JoinColumn(name = "student_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Student studentId;

    public Subject(SubjectType subjectType, Student studentId) {
        this.subjectType = subjectType;
        this.studentId = studentId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SubjectType getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Student getStudentId() {
        return studentId;
    }

    public void setStudentId(Student studentId) {
        this.studentId = studentId;
    }

    public Subject() {
    }
}
