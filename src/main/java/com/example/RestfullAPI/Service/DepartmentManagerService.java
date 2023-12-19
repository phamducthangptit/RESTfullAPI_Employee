package com.example.RestfullAPI.Service;

import com.example.RestfullAPI.IDModel.DeptManagerID;
import com.example.RestfullAPI.Model.Department_Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentManagerService extends JpaRepository<Department_Manager, DeptManagerID> {
    Department_Manager findByid(DeptManagerID Id);
}
