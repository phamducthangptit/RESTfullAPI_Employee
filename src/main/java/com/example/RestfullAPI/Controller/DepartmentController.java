package com.example.RestfullAPI.Controller;

import com.example.RestfullAPI.Model.Department;
import com.example.RestfullAPI.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/get-all-department", method = RequestMethod.GET)
    public ResponseEntity<List<Department>> GetAllDepartment(){
        List<Department> listDepartment = departmentService.findAll();
        if(listDepartment.isEmpty()){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Department>>(listDepartment, HttpStatus.OK);
    }

    @RequestMapping(value = "/get-department/{deptNo}", method = RequestMethod.GET)
    public ResponseEntity<?> GetDepartment(@PathVariable("deptNo") String deptNo){
        Department department = departmentService.findBydeptNo(deptNo);
        if(department == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(department);
    }

    @RequestMapping(value = "/add-department", method = RequestMethod.POST)
    public ResponseEntity<?> AddDepartment(@Validated @RequestBody Department department){
        if(departmentService.findBydeptNo(department.getDeptNo()) == null){ // trường hợp chưa có mã cần thêm trong db
            departmentService.save(department);
            return ResponseEntity.ok().build();
        }
        else{ // trường hợp đã tồn tại mã trong db
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/update-department/{deptNo}", method = RequestMethod.PUT)
    public ResponseEntity<?> RepairDepartment(@PathVariable("deptNo") String deptNo, @Validated @RequestBody Map<String, String> requestBody){
        Department department = departmentService.findBydeptNo(deptNo);
        if(requestBody.containsKey("deptName")){
            String deptName = requestBody.get("deptName");
            if(department != null){
                department.setDeptName(deptName);
                Department departmentUpdate = departmentService.save(department);
                return ResponseEntity.ok(departmentUpdate);
            }
            else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().body("Missing Department Name");
        }
    }

    @RequestMapping(value = "/delete-department/{deptNo}", method = RequestMethod.DELETE)
    public ResponseEntity<?> DeleteDepartment(@PathVariable("deptNo") String deptNo){
        Department department = departmentService.findBydeptNo(deptNo);
        if(department != null){ // tồn tại deptNo
            if(department.getDepartmentEmployees().isEmpty() && department.getDepartmentManagers().isEmpty()){ //nếu chưa có ai trong dept thì mới xóa được
                departmentService.delete(department);
                return ResponseEntity.ok().build();
            } else{
                return ResponseEntity.badRequest().build();
            }
        } else { // không tồn tại deptNo
            return ResponseEntity.notFound().build();
        }
    }
}
