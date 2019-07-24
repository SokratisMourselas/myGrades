package com.socmour.springsecurity.demo.config.Entities;

import java.util.Date;

public class Student implements User {

    private int id;
    private String firstName;
    private String lastName;
    private String password;
    private Date dateOfBirth;

    @Override
    public String isActive() {
        return null;
    }

    public Student() {}

    public Student(int id, String firstName, String lastName, String password, Date dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public void setlastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
