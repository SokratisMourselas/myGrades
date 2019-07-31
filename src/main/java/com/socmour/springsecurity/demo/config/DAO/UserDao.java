package com.socmour.springsecurity.demo.config.DAO;

import com.socmour.springsecurity.demo.config.Entities.User;

public interface UserDao {

    User findByUserName(String userName);
    void save(User user);

    User findByUserEmail(String email);
}
