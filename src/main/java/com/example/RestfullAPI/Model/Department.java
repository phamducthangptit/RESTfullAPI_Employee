package com.example.RestfullAPI.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "departments")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department {
    @Column(name = "dept_no")
    @Id
    private String deptNo;
    @Column(name = "dept_name")
    private String deptName;

    @OneToMany(mappedBy = "department")
    private Set<Department_Manager> departmentManagers;

    @OneToMany(mappedBy = "department")
    private Set<Department_Employee> departmentEmployees;
    public Department() {
    }

    public Department(String deptNo, String deptName) {
        this.deptNo = deptNo;
        this.deptName = deptName;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Set<Department_Manager> getDepartmentManagers() {
        return departmentManagers;
    }

    public Set<Department_Employee> getDepartmentEmployees() {
        return departmentEmployees;
    }
}
