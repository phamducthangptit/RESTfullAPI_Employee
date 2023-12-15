package com.example.RestfullAPI.Model;

import com.example.RestfullAPI.IDModel.SalaryID;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "salaries")
public class Salary {
    @Id
    private SalaryID id;

    @Column(name = "salary")
    private Double salary;
    @Column(name = "to_date")
    private Date toDate;

    @ManyToOne
    @JoinColumn(name = "emp_no", insertable = false, updatable = false)
    private Employee employee;

    public Salary() {
    }

    public Salary(SalaryID id, Double salary, Date toDate) {
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
