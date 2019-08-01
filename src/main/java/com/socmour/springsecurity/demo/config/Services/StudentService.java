package com.socmour.springsecurity.demo.config.Services;

import com.socmour.springsecurity.demo.config.Entities.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentWithId(int userId);
}
