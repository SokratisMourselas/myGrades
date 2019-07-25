package com.socmour.springsecurity.demo.config.APIs;

import com.socmour.springsecurity.demo.config.Entities.Student;
import com.socmour.springsecurity.demo.config.ExceptionHandlers.StudentErrorResponse;
import com.socmour.springsecurity.demo.config.ExceptionHandlers.StudentNotFoundException;
import com.socmour.springsecurity.demo.config.HelperClasses.MockEntities;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    public List<Student> studentList;

    @PostConstruct
    public void retrieveStudents(){
       studentList = MockEntities.mockStudentsList();
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        return studentList;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check studentId against size of list
        if ((studentId>= studentList.size() || (studentId<0))){
            throw new StudentNotFoundException("Student Id not found - " + studentId);
        }

        //id = index-1
        return studentList.get(studentId-1);
    }
}
