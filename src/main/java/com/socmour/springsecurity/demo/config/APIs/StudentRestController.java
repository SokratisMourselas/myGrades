package com.socmour.springsecurity.demo.config.APIs;

import com.socmour.springsecurity.demo.config.Entities.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    @GetMapping("/students")
    public List<Student> getStudents(){

        // initializing list
        List<Student> studentsList = new ArrayList<Student>();

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();

        Date dateOfBirthMock = new Date();

        try {
            dateOfBirthMock = new SimpleDateFormat("dd/MM/yyyy").parse("06/06/1995");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //retrieving student
        Student newStudent1 = new Student(1, "Mad", "Max", "passwordPlaceholder", dateOfBirthMock);
        Student newStudent2 = new Student(1, "Bob", "Builder", "passwordPlaceholder", dateOfBirthMock);
        Student newStudent3 = new Student(1, "Dora", "Explorer", "passwordPlaceholder", dateOfBirthMock);

        studentsList.add(newStudent1);
        studentsList.add(newStudent2);
        studentsList.add(newStudent3);


        return studentsList;
    }

}
