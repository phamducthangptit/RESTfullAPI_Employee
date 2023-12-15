package com.example.RestfullAPI.Service;

import com.example.RestfullAPI.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeService extends JpaRepository<Employee, Integer> {
    Employee findByempNo(int empNo);
}
