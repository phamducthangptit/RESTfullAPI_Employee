package com.example.RestfullAPI.DTO;

import com.example.RestfullAPI.IDModel.DeptManagerID;

import java.util.Date;

public class Department_ManagerDTO {
    private DeptManagerID id;
    private Date fromDate;
    private Date toDate;

    public Department_ManagerDTO() {
    }

    public Department_ManagerDTO(DeptManagerID id, Date fromDate, Date toDate) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public DeptManagerID getId() {
        return id;
    }

    public void setId(DeptManagerID id) {
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
