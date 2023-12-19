package com.example.RestfullAPI.DTO;

import com.example.RestfullAPI.IDModel.TitleID;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class TitleDTO {
    private TitleID id;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date toDate;

    public TitleDTO() {
    }

    public TitleDTO(TitleID id, Date toDate) {
        this.id = id;
        this.toDate = toDate;
    }

    public TitleID getId() {
        return id;
    }

    public void setId(TitleID id) {
        this.id = id;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }
}
