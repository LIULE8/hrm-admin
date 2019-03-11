package com.hrm.admin.controllers;

import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.entities.Employee;
import com.hrm.admin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public EmployeeDTO getOne(@PathVariable("id") Long employeeId) {
        return employeeService.getOne(employeeId);
    }

    @GetMapping("list")
    public Page<EmployeeDTO> findAll(@RequestBody EmployeeDTO employeeDTO,
                                     @RequestParam(defaultValue = "1", required = false) Integer curPage,
                                     @RequestParam(defaultValue = "20", required = false) Integer pageSize) {
        return employeeService.findByCriteria(employeeDTO, curPage - 1, pageSize);
    }

    @GetMapping
    public List<EmployeeDTO> findAll() {
        return employeeService.findAll();
    }

    @PostMapping
    public void save(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.save(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
    }
}