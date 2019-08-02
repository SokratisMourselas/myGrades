package com.socmour.springsecurity.demo.config.APIs;

import com.socmour.springsecurity.demo.config.Entities.Lesson;
import com.socmour.springsecurity.demo.config.Entities.Student;
import com.socmour.springsecurity.demo.config.Entities.User;
import com.socmour.springsecurity.demo.config.ExceptionHandlers.StudentNotFoundException;
import com.socmour.springsecurity.demo.config.Services.LessonService;
import com.socmour.springsecurity.demo.config.Services.StudentService;
import com.socmour.springsecurity.demo.config.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    public List<Student> studentList;

    @Autowired
    private StudentService studentService;

    @Autowired
    private LessonService lessonService;

    @Autowired
    private UserService userService;

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

    @PostMapping(("/saveStudent?firstName={firstName}&lastName={lastName}"))
    public Student saveStudent(@PathVariable String firstName, @PathVariable String lastName){
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(Calendar.getInstance().getTime());

        User user = userService.findByUserEmail("socmour@hotmail.com");
        student.setUser(user);

        return studentService.saveStudent(student);
    }

    @GetMapping("/lessons")
    public List<Lesson> getAllLessons(){
        return lessonService.getAllLessons();
    }
}
