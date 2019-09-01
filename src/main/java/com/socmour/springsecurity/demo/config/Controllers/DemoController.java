package com.socmour.springsecurity.demo.config.Controllers;

import com.socmour.springsecurity.demo.config.Entities.StudentFirstLastName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showLanding() {
        return "homepage";
    }

    @GetMapping("/general")
    public String showHome(Model theModel) {

        theModel.addAttribute("student", new StudentFirstLastName());
        return "home";
    }

    @GetMapping("/bookAppointment")
    public String bookNewAppointment(Model theModel) {

        theModel.addAttribute("student", new StudentFirstLastName());
        return "appointmentsPage";
    }


    @GetMapping("/students")
    public String showLeadersPage() {
        return "students-page";
    }

    @GetMapping("/teachers")
    public String showAdminsPage() {
        return "teachers-page";
    }

}
