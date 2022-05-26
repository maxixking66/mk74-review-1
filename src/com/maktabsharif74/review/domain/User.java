package com.maktabsharif74.review.domain;

import com.maktabsharif74.review.base.domain.BaseDomain;

public class User extends BaseDomain<Long> {

    public static final String TABLE_NAME = "tbl_user";

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Integer age;

    public User() {
    }

    public User(Long id, String firstName, String lastName,
                String username, String password, Integer age) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
