package com.socmour.springsecurity.demo.config.DAO;

import com.socmour.springsecurity.demo.config.Entities.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAllStudents();

    Student getStudentWithId(int studentId);

    Student saveStudent(Student student);
}
