package com.socmour.springsecurity.demo.config.Entities;

import javax.persistence.*;

@Entity
@Table(name = "lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uniqueId")
    private Long id;

    @Column(name = "courseName")
    private String courseName;

    @Column(name = "grade")
    private int grade;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacherId", referencedColumnName = "id")
    private User teacher;

    public Lesson() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public User getTeacher() {
        return teacher;
    }

    public void setTeacher(User teacher) {
        this.teacher = teacher;
    }
}
