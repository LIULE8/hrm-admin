package com.hrm.admin.controllers;

import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
  @Autowired private EmployeeService employeeService;

  @GetMapping("/{id}")
  public EmployeeDTO getOne(@PathVariable("id") Long employeeId) {
    return employeeService.getOne(employeeId);
  }

  @GetMapping("list")
  public Page<EmployeeDTO> findAll(
      @RequestBody EmployeeDTO employeeDTO,
      @RequestParam(defaultValue = "1", required = false) Integer curPage,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize) {
    return employeeService.findByCriteria(employeeDTO, curPage - 1, pageSize);
  }

  @GetMapping
  public List<EmployeeDTO> findAll() {
    return employeeService.findAll();
  }

  @PostMapping
  public ResponseEntity save(@RequestBody EmployeeDTO employeeDTO) {
    employeeService.save(employeeDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping
  public ResponseEntity update(@RequestBody EmployeeDTO employeeDTO) {
    employeeService.update(employeeDTO);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    employeeService.deleteById(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
