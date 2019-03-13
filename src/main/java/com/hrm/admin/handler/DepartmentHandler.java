package com.hrm.admin.handler;

import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.services.DepartmentService;
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
public class DepartmentHandler {
  @Autowired private DepartmentService departmentService;

  @GetMapping("/{id}")
  public DepartmentDTO getOne(@PathVariable("id") Long departmentId) {
    return departmentService.getOne(departmentId);
  }

  @GetMapping
  public List<DepartmentDTO> findAll() {
    return departmentService.findAll();
  }

  @PostMapping
  public ResponseEntity save(@RequestBody DepartmentDTO departmentDTO) {
    departmentService.save(departmentDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping
  public ResponseEntity update(@RequestBody DepartmentDTO departmentDTO) {
    departmentService.update(departmentDTO);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    departmentService.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
