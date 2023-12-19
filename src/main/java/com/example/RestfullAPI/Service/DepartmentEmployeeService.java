package com.example.RestfullAPI.Service;

import com.example.RestfullAPI.IDModel.DeptEmployeeID;
import com.example.RestfullAPI.Model.Department_Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentEmployeeService extends JpaRepository<Department_Employee, DeptEmployeeID> {
    Department_Employee findByid(DeptEmployeeID id);
}
