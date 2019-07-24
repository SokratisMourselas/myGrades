package com.socmour.springsecurity.demo.config.HelperClasses;

import com.socmour.springsecurity.demo.config.Entities.Student;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class MockEntities {


    // return a list of fake Student entities
    public static List<Student> mockStudentsList(){
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
        Student newStudent2 = new Student(2, "Bob", "Builder", "passwordPlaceholder", dateOfBirthMock);
        Student newStudent3 = new Student(3, "Dora", "Explorer", "passwordPlaceholder", dateOfBirthMock);

        studentsList.add(newStudent1);
        studentsList.add(newStudent2);
        studentsList.add(newStudent3);

        return studentsList;
    }

}
