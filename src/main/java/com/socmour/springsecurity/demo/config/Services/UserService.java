package com.socmour.springsecurity.demo.config.Services;

import com.socmour.springsecurity.demo.config.Entities.CrmUser;
import com.socmour.springsecurity.demo.config.Entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User findByUserName(String userName);
    void save(CrmUser crmUser);
}
