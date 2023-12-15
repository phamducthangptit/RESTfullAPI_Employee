package com.example.RestfullAPI.IDModel;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class DeptEmployeeID {
    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "emp_no")
    private int empNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeptEmployeeID that = (DeptEmployeeID) o;
        return empNo == that.empNo && Objects.equals(deptNo, that.deptNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(deptNo, empNo);
    }

    public DeptEmployeeID() {
    }

    public DeptEmployeeID(String deptNo, int empNo) {
        this.deptNo = deptNo;
        this.empNo = empNo;
    }

    public String getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }
}
