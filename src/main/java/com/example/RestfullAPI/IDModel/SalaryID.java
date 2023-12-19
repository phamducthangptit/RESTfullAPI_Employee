package com.example.RestfullAPI.IDModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.sql.Date;
import java.util.Objects;

@Embeddable
public class SalaryID {
    @Column(name = "emp_no")
    private int empNo;

    @Column(name = "from_date")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date fromDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalaryID salaryID = (SalaryID) o;
        return empNo == salaryID.empNo && Objects.equals(fromDate, salaryID.fromDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, fromDate);
    }

    // constructors

    public SalaryID() {
    }

    public SalaryID(int empNo, Date fromDate) {
        this.empNo = empNo;
        this.fromDate = fromDate;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
}
