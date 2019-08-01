package com.socmour.springsecurity.demo.config.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "authorities")
public class Role implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "authority")
    private String authority;

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role() {
    }

    public Role(String username, String name) {
        this.username = username;
        this.authority = name;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String name) {
        this.authority = name;
    }

    public Long getId() {
        return id;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
