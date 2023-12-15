package com.example.RestfullAPI.Model;

import com.example.RestfullAPI.IDModel.TitleID;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "titles")
public class Title {
    @Id
    private TitleID id;

    @Column(name = "to_date")
    private Date toDate;

    @ManyToOne
    @JoinColumn(name = "emp_no", insertable = false, updatable = false)
    private Employee employee;

    public Title() {
    }

    public Title(TitleID id, Date toDate) {
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
