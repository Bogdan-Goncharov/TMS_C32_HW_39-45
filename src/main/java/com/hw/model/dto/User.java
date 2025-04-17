package com.hw.model.dto;


import jakarta.validation.constraints.*;

import java.sql.Timestamp;

public class User {
    private Long id;
    @NotBlank(message = "Firstname cannot be empty")
    private String firstname;
    @NotBlank(message = "SecondName cannot be empty")
    private String secondName;
    @Min(value = 0, message = "Age cannot be negative")
    @Max(value = 120, message = "Age is not valid")
    private Integer age;
    @Email(message = "Invalid email format")
    private String email;
    @Pattern(regexp = "Male|Female", message = "Sex must be Male or Female")
    private String sex;
    @Pattern(regexp = "\\+?[0-9]{10,15}", message = "Invalid phone number format")
    private String telephoneNumber;
    private java.sql.Timestamp created;
    private Timestamp updated;
    private Boolean isDeleted;
    private Security securityInfo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }


    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }


}