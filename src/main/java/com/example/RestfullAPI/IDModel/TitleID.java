package com.example.RestfullAPI.IDModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.sql.Date;
import java.util.Objects;

@Embeddable
public class TitleID {
    @Column(name = "emp_no")
    private int empNo;
    @Column(name = "title")
    private String title;

    @JsonFormat(pattern = "yyyy/MM/dd")
    @Column(name = "from_date")
    private Date fromDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TitleID titleID = (TitleID) o;
        return empNo == titleID.empNo && Objects.equals(title, titleID.title) && Objects.equals(fromDate, titleID.fromDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, title, fromDate);
    }

    public TitleID() {
    }

    public TitleID(int empNo, String title, Date fromDate) {
        this.empNo = empNo;
        this.title = title;
        this.fromDate = fromDate;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
}
