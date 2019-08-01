package com.socmour.springsecurity.demo.config.APIs;

import com.socmour.springsecurity.demo.config.Entities.Student;
import com.socmour.springsecurity.demo.config.ExceptionHandlers.StudentNotFoundException;
import com.socmour.springsecurity.demo.config.HelperClasses.MockEntities;
import com.socmour.springsecurity.demo.config.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    public List<Student> studentList;

    @Autowired
    private StudentService studentService;

    @PostConstruct
    public void retrieveStudents(){
       studentList = studentService.getAllStudents();
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check studentId against size of list
        if ((studentId > studentList.size() || (studentId < 0))) {
            throw new StudentNotFoundException("Student Id not found - " + studentId);
        }

        //id = index-1
        return studentService.getStudentWithId(studentId);
    }
}
