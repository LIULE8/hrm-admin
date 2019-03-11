package com.hrm.admin.controllers;

import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public EmployeeDTO getOne(@PathVariable("id") Long employeeId) {
        return employeeService.getOne(employeeId);
    }
}