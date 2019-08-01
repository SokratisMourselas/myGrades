package com.socmour.springsecurity.demo.config.Services;

import com.socmour.springsecurity.demo.config.DAO.StudentDao;
import com.socmour.springsecurity.demo.config.Entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;

    @Override
    @Transactional
    public List<Student> getAllStudents() {
        return studentDao.getAllStudents();
    }

    @Override
    @Transactional
    public Student getStudentWithId(int studentId){
        return studentDao.getStudentWithId(studentId);
    }


}
