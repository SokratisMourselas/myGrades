package com.socmour.springsecurity.demo.config.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showLanding() {
        return "homepage";
    }

    @GetMapping("/general")
    public String showHome() {
        return "home";
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
