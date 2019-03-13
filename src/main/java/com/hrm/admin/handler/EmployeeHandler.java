package com.hrm.admin.handler;

import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Component
public class EmployeeHandler {
  @Autowired private EmployeeService employeeService;

  @GetMapping("/{id}")
  public EmployeeDTO getOne(@PathVariable("id") Long employeeId) {
    return employeeService.getOne(employeeId);
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
