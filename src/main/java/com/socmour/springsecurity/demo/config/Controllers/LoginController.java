package com.socmour.springsecurity.demo.config.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {


    @GetMapping("/showLoginForm")
    public String showMyLoginPage(){
        return "plain-login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(){
        return "custom-access-denied-page";
    }

}
