package com.example.RestfullAPI.Controller;

import com.example.RestfullAPI.DTO.EmployeeDTO;
import com.example.RestfullAPI.Model.Employee;
import com.example.RestfullAPI.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/employee/add-employee", method = RequestMethod.POST)
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

    @RequestMapping(value = "/employee/get-all-employee", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> GetAllEmployee(){
        List<Employee> employees = employeeService.findAll();
        if(employees.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employees);
    }

    @RequestMapping(value = "/employee/get-employee/{empNo}", method = RequestMethod.GET)
    public ResponseEntity<?> GetEmployeeByEmpNo(@PathVariable("empNo") int empNo){
        Employee employee = employeeService.findByempNo(empNo);
        if(employee == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(employee);
    }
}
