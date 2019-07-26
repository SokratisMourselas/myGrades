package com.socmour.springsecurity.demo.config.Services;

import com.socmour.springsecurity.demo.config.DAO.UserDao;
import com.socmour.springsecurity.demo.config.Entities.CrmUser;
import com.socmour.springsecurity.demo.config.Entities.Role;
import com.socmour.springsecurity.demo.config.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    // need to inject user dao
    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public User findByUserName(String userName) {// check the database if the user already exists
        return userDao.findByUserName(userName);
    }


    @Override
    @Transactional
    public void save(CrmUser crmUser) {
        User user = new User();
// assign user details to the user object
        user.setUsername(crmUser.getUserName());
        user.setPassword(passwordEncoder.encode(crmUser.getPassword()));
        user.setFirstName(crmUser.getFirstName());
//        user.setLastName(crmUser.getLastName());
//        user.setEmail(crmUser.getEmail());
// give user default role of "employee"
        user.setRoles(Arrays.asList(new Role("ROLE_EMPLOYEE")));
// save user in the database
        userDao.save(user);
    }


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String userName) throws
            UsernameNotFoundException {
        User user = userDao.findByUserName(userName);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new
                org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }


    private Collection<? extends GrantedAuthority>
    mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream().map(role -> new
                SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}


