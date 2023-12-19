package com.example.RestfullAPI.DTO;

import com.example.RestfullAPI.Model.Gender;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class EmployeeDTO {
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date birthDate;
    private String firstName;
    private String lastName;
    private Gender gender;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date hireDate;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Date birthDate, String firstName, String lastName, Gender gender, Date hireDate) {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hireDate = hireDate;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}
