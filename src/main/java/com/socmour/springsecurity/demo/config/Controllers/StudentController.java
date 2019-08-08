package com.socmour.springsecurity.demo.config.Controllers;

import com.socmour.springsecurity.demo.config.Entities.Student;
import com.socmour.springsecurity.demo.config.Entities.StudentFirstLastName;
import com.socmour.springsecurity.demo.config.Entities.User;
import com.socmour.springsecurity.demo.config.Services.StudentService;
import com.socmour.springsecurity.demo.config.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;

@Controller
@RequestMapping("/studentManagement")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@Valid @ModelAttribute("crmUser") StudentFirstLastName student,
                               BindingResult result,
                               Model theModel){

        Student newStudent = new Student(student.getFirstName(), student.getLastName(), Calendar.getInstance().getTime());

        User user = userService.findByUserEmail("socmour@hotmail.com");
        newStudent.setUser(user);
        studentService.saveStudent(newStudent);

        return "home";

    }
}
