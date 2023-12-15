package com.example.RestfullAPI.Service;

import com.example.RestfullAPI.Model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentService extends JpaRepository<Department, String> {
    Department findBydeptNo(String deptNo);
}
