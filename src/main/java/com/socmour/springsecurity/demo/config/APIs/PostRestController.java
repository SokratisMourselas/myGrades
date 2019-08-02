package com.socmour.springsecurity.demo.config.APIs;

import com.socmour.springsecurity.demo.config.Entities.Student;
import com.socmour.springsecurity.demo.config.Entities.User;
import com.socmour.springsecurity.demo.config.Services.StudentService;
import com.socmour.springsecurity.demo.config.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
@RequestMapping("/post")
public class PostRestController {


    @Autowired
    private StudentService studentService;


    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/saveStudent")
    public Student saveStudent(@RequestBody Student student){

        student.setDateOfBirth(Calendar.getInstance().getTime());

        User user = userService.findByUserEmail("socmour@hotmail.com");
        student.setUser(user);

        return studentService.saveStudent(student);
    }

    // Dummy POST method with GET for testing
    @GetMapping(("/saveStudent/firstName={firstName}/lastName={lastName}"))
    public Student saveAsStudent(@PathVariable String firstName, @PathVariable String lastName){
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setDateOfBirth(Calendar.getInstance().getTime());

        User user = userService.findByUserEmail("socmour@hotmail.com");
        student.setUser(user);

        return studentService.saveStudent(student);
    }


}
