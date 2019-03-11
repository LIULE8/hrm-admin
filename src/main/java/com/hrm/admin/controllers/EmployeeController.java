package com.hrm.admin.controllers;

import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.entities.Employee;
import com.hrm.admin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@RestController
@CrossOrigin
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{id}")
    public EmployeeDTO getOne(@PathVariable("id") Long employeeId){
        return employeeService.getOne(employeeId);
    }

//    @GetMapping
//    public ResponseEntity<List<Employee>> findAllEmployee() {
//        return ResponseEntity.ok(employeeService.findAll());
//    }
//
//    @PostMapping
//    public ResponseEntity save(@RequestBody Employee employee) {
//        employeeService.save(employee);
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity update(@RequestBody Employee employee) {
//        employeeService.save(employee);
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity delete(@PathVariable("id") Integer id) {
//        try {
//            employeeService.deleteById(id);
//            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }
}