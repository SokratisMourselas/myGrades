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
    private String name;

    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
