package com.example.RestfullAPI.DTO;

import com.example.RestfullAPI.IDModel.DeptEmployeeID;


import java.util.Date;

public class Department_EmployeeDTO {
    private DeptEmployeeID id;
    private Date fromDate;
    private Date toDate;

    public Department_EmployeeDTO() {
    }

    public Department_EmployeeDTO(DeptEmployeeID id, Date fromDate, Date toDate) {
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
}
