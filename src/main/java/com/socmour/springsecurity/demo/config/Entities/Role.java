package com.socmour.springsecurity.demo.config.Entities;

import javax.persistence.*;

@Entity
@Table(name = "authority")
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "authority")
    private String authority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private User user;

    public Role() {
    }

    public Role(String name) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
