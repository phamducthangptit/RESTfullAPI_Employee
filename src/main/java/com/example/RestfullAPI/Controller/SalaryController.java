package com.example.RestfullAPI.Controller;


import com.example.RestfullAPI.DTO.SalaryDTO;
import com.example.RestfullAPI.Model.Salary;
import com.example.RestfullAPI.Service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/salary")
public class SalaryController {
    @Autowired
    SalaryService salaryService;
    @RequestMapping(value = "/add-salary-to-employee", method = RequestMethod.POST)
    public ResponseEntity<?> AddSalary(@Validated @RequestBody SalaryDTO salaryDTO){
        if(salaryService.findByid(salaryDTO.getId()) == null){
            Salary salary = new Salary();
            salary.setId(salaryDTO.getId());
            salary.setSalary(salaryDTO.getSalary());
            salary.setToDate(salaryDTO.getToDate());
            salaryService.save(salary);
            return ResponseEntity.ok(salary);
        }
        return ResponseEntity.badRequest().build();
    }

    @RequestMapping(value = "/get-salary-by-empno/{empNo}", method = RequestMethod.GET)
    public ResponseEntity<List<Salary>> GetSalaryByEmpNo(@PathVariable("empNo") int empNo){
        List<Salary> salaryList = salaryService.findAll()
                .stream()
                .filter(salary -> salary.getId().getEmpNo() == empNo)
                .collect(Collectors.toList());

        return ResponseEntity.ok(salaryList);
    }
}
