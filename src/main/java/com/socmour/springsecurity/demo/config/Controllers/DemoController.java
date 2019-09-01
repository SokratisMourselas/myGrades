package com.socmour.springsecurity.demo.config.Controllers;

import com.socmour.springsecurity.demo.config.Entities.Appointment;
import com.socmour.springsecurity.demo.config.Entities.StudentFirstLastName;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.PostConstruct;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class DemoController {

    private Map<String, String> datesAndTimes;

    @PostConstruct
    protected void loadAppointments() {

        // using hashmap, could also read this info from a database
        datesAndTimes = new LinkedHashMap<String, String>();

        // key=the role, value = display to user
        datesAndTimes.put("firstDate", "14/09/2019 20:15");
        datesAndTimes.put("secondDate", "15/09/2019 18:15");
        datesAndTimes.put("thirdDate", "15/09/2019 19:00");
    }

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

        theModel.addAttribute("newAppointment", new Appointment());
        theModel.addAttribute("datesAndTimes", datesAndTimes);
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
