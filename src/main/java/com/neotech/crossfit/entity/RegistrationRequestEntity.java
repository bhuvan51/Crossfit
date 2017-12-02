package com.neotech.crossfit.entity;

import javax.persistence.*;

/**
 * Created by vinna on 11/8/2017.
 */
@Entity
@Table(name = "UserRegistration")
public class RegistrationRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registration_id", unique = true, nullable = false)
    private Integer registration_id;
    @Column(name="username", length = 20, nullable = true, unique = true)
    private String userName;
    @Column(name="password", length = 20, nullable = true, unique = true)
    private String password;
    @Column(name="sex", length = 20)
    private String Sex;
    @Column(name="type", length = 20)
    private String type;
    @Column(name="age", length = 20)
    private Integer age;

    public Integer getRegistration_id() {
        return registration_id;
    }

    public void setRegistration_id(Integer registration_id) {
        this.registration_id = registration_id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        Sex = sex;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}

