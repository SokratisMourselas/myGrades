package com.socmour.springsecurity.demo.config.Controllers;

import com.socmour.springsecurity.demo.config.Entities.CrmUser;
import com.socmour.springsecurity.demo.config.Entities.User;
import com.socmour.springsecurity.demo.config.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private Map<String, String> roles;

    @PostConstruct
    protected void loadRoles() {
// using hashmap, could also read this info from a database
        roles = new LinkedHashMap<String, String>();
// key=the role, value=display to user
        roles.put("ROLE_EMPLOYEE", "Employee");
        roles.put("ROLE_MANAGER", "Manager");
        roles.put("ROLE_ADMIN", "Admin");
    }

    @Autowired
    private UserService userService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showRegistrationForm")
    public String showMyLoginPage(Model theModel) {
        theModel.addAttribute("crmUser", new CrmUser());

        // add roles to the model for form display
        theModel.addAttribute("roles", roles);

        return "registration-form";
    }

    @PostMapping("/processRegistrationForm")
    public String processRegistrationForm(
            @Valid @ModelAttribute("crmUser") CrmUser theCrmUser,
            BindingResult result,
            Model theModel) {

            // form validation
            if (result.hasErrors()) {
                theModel.addAttribute("roles", roles);
                theModel.addAttribute("registrationError", "Errors found during registration process.");
                return "registration-form";
            }
    // check the database if user already exists
            User existing = userService.findByUserName(theCrmUser.getUserName());
            if (existing != null) {
                theModel.addAttribute("crmUser", new CrmUser());
                theModel.addAttribute("roles", roles);
                theModel.addAttribute("registrationError", "Username already exists.");
                return "registration-form";
            }

        // give user default role of "employee"
        List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList();
        authorities.add(new SimpleGrantedAuthority("ROLE_EMPLOYEE"));

        // if the user selected role other than employee
        // then add that one too (multiple roles)
        String formRole = theCrmUser.getFormRole();

        if (!formRole.equals("ROLE_EMPLOYEE")) {
            authorities.add(new SimpleGrantedAuthority(formRole));
        }


        // create user account
        userService.save(theCrmUser);

        return "registration-confirmation";
    }
}
