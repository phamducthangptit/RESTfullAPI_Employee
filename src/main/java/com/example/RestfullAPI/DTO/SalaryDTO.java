package com.example.RestfullAPI.DTO;

import com.example.RestfullAPI.IDModel.SalaryID;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class SalaryDTO {
    private SalaryID id;

    private Double salary;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date toDate;

    public SalaryDTO() {
    }

    public SalaryDTO(SalaryID id, Double salary, Date toDate) {
        this.id = id;
        this.salary = salary;
        this.toDate = toDate;
    }

    public SalaryID getId() {
        return id;
    }

    public void setId(SalaryID id) {
        this.id = id;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
