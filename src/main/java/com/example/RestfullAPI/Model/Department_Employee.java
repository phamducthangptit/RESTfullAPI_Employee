package com.example.RestfullAPI.Model;

import com.example.RestfullAPI.IDModel.DeptEmployeeID;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "dept_emp")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department_Employee {
    @Id
    private DeptEmployeeID id;
    @Column(name = "from_date")
    private Date fromDate;
    @Column(name = "to_date")
    private Date toDate;

    @ManyToOne
    @JoinColumn(name = "dept_no", insertable = false, updatable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "emp_no", insertable = false, updatable = false)
    private Employee employee;

    public Department_Employee() {
    }

    public Department_Employee(DeptEmployeeID id, Date fromDate, Date toDate) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public DeptEmployeeID getId() {
        return id;
    }

    public void setId(DeptEmployeeID id) {
        this.id = id;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
