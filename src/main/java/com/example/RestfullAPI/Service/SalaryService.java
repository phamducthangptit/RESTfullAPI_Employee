package com.example.RestfullAPI.Service;

import com.example.RestfullAPI.IDModel.SalaryID;
import com.example.RestfullAPI.Model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaryService extends JpaRepository<Salary, SalaryID> {
    Salary findByid(SalaryID id);
}
