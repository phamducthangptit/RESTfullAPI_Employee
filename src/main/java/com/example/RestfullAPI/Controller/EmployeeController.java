package com.example.RestfullAPI.Controller;

import com.example.RestfullAPI.DTO.Department_EmployeeDTO;
import com.example.RestfullAPI.DTO.Department_ManagerDTO;
import com.example.RestfullAPI.DTO.EmployeeDTO;
import com.example.RestfullAPI.IDModel.DeptEmployeeID;
import com.example.RestfullAPI.IDModel.DeptManagerID;
import com.example.RestfullAPI.Model.Department_Employee;
import com.example.RestfullAPI.Model.Department_Manager;
import com.example.RestfullAPI.Model.Employee;
import com.example.RestfullAPI.Service.DepartmentEmployeeService;
import com.example.RestfullAPI.Service.DepartmentManagerService;
import com.example.RestfullAPI.Service.EmployeeService;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    DepartmentManagerService departmentManagerService;

    @Autowired
    DepartmentEmployeeService departmentEmployeeService;

    @RequestMapping(value = "/add-employee", method = RequestMethod.POST)
    public ResponseEntity<?> AddEmployee(@Validated @RequestBody EmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setBirthDate(employeeDTO.getBirthDate());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setGender(employeeDTO.getGender());
        employee.setHireDate(employeeDTO.getHireDate());
        employeeService.save(employee);
        return ResponseEntity.ok(employee);
    }

    @RequestMapping(value = "/get-all-employee", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> GetAllEmployee(){
        List<Employee> employees = employeeService.findAll();
        if(employees.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }

    @RequestMapping(value = "/get-employee/{empNo}", method = RequestMethod.GET)
    public ResponseEntity<?> GetEmployeeByEmpNo(@PathVariable("empNo") int empNo){
        Employee employee = employeeService.findByempNo(empNo);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }

    @RequestMapping(value = "/update-employee/{empNo}", method = RequestMethod.PUT)
    public ResponseEntity<?> UpdateEmployee(@PathVariable("empNo") int empNo, @Validated @RequestBody EmployeeDTO employeeDTO){
        Employee employee = employeeService.findByempNo(empNo);
        if(employee != null){
            employee.setBirthDate(employeeDTO.getBirthDate());
            employee.setFirstName(employeeDTO.getFirstName());
            employee.setLastName(employeeDTO.getLastName());
            employee.setGender(employeeDTO.getGender());
            employee.setHireDate(employeeDTO.getHireDate());

            Employee employeeUpdate = employeeService.save(employee);
            return ResponseEntity.ok(employeeUpdate);
        }
        return ResponseEntity.notFound().build();
    }

    @RequestMapping(value = "/add-employee-to-manager", method = RequestMethod.POST)
    public ResponseEntity<?> AddEmployeeToManager(@Validated @RequestBody Department_ManagerDTO departmentManagerDTO){
        DeptEmployeeID deptEmployeeID = new DeptEmployeeID(departmentManagerDTO.getId().getDeptNo(), departmentManagerDTO.getId().getEmpNo());
        // thêm vào manager thif check trong bảng manager đã có chưa, chưa có thì mới thêm
        // check tiếp trong bảng department, nếu chưa có thì mới được thêm
        if(departmentManagerService.findByid(departmentManagerDTO.getId()) == null && departmentEmployeeService.findByid(deptEmployeeID) == null){
            Department_Manager departmentManager = new Department_Manager();
            departmentManager.setId(departmentManagerDTO.getId());
            departmentManager.setFromDate(departmentManager.getFromDate());
            departmentManager.setToDate(departmentManager.getToDate());
            departmentManagerService.save(departmentManager);
            return ResponseEntity.ok(departmentManager);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/delete-employee-manager", method = RequestMethod.DELETE)
    public ResponseEntity<?> DeleteEmployeeManager(@Validated @RequestBody DeptManagerID deptManagerID){
        if(departmentManagerService.findByid(deptManagerID) != null){
            departmentManagerService.deleteById(deptManagerID);
            return ResponseEntity.ok().build();
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/add-employee-to-department", method = RequestMethod.POST)
    public ResponseEntity<?> AddEmployeeToDepartment(@Validated @RequestBody Department_EmployeeDTO departmentEmployeeDTO){
        DeptManagerID deptManagerID = new DeptManagerID(departmentEmployeeDTO.getId().getDeptNo(), departmentEmployeeDTO.getId().getEmpNo());
        if(departmentEmployeeService.findByid(departmentEmployeeDTO.getId()) == null && departmentManagerService.findByid((deptManagerID)) == null){
            Department_Employee departmentEmployee = new Department_Employee();
            departmentEmployee.setId(departmentEmployeeDTO.getId());
            departmentEmployee.setFromDate(departmentEmployeeDTO.getFromDate());
            departmentEmployee.setToDate(departmentEmployeeDTO.getToDate());
            departmentEmployeeService.save(departmentEmployee);
            return ResponseEntity.ok(departmentEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/delete-employee-department", method = RequestMethod.DELETE)
    public ResponseEntity<?> DeleteEmployeeDepartment(@Validated @RequestBody DeptEmployeeID deptEmployeeID){
        if(departmentEmployeeService.findByid(deptEmployeeID) != null){
            departmentEmployeeService.deleteById(deptEmployeeID);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
