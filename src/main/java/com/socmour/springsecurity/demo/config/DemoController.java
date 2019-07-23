package com.socmour.springsecurity.demo.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showLanding() {
        return "homepage";
    }

    @GetMapping("/employees")
    public String showHome() {
        return "home";
    }

    @GetMapping("/leaders")
    public String showLeadersPage() {
        return "leaders-page";
    }

    @GetMapping("/systems")
    public String showAdminsPage() {
        return "systems-page";
    }

}
