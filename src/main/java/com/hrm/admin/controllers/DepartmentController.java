package com.hrm.admin.controllers;

import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.services.DepartmentService;
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
@RequestMapping("departments")
public class DepartmentController {
  @Autowired private DepartmentService departmentService;

  @GetMapping("/{id}")
  public DepartmentDTO getOne(@PathVariable("id") Long departmentId) {
    return departmentService.getOne(departmentId);
  }

  @GetMapping
  public List<DepartmentDTO> findAll() {
    return departmentService.findAll();
  }

  @GetMapping("list")
  public Page<DepartmentDTO> findAll(
      @RequestBody DepartmentDTO departmentDTO,
      @RequestParam(defaultValue = "1", required = false) Integer curPage,
      @RequestParam(defaultValue = "20", required = false) Integer pageSize) {
    return departmentService.findByCriteria(departmentDTO, curPage - 1, pageSize);
  }

  @PostMapping
  public ResponseEntity save(@RequestBody DepartmentDTO departmentDTO) {
    departmentService.save(departmentDTO);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity update(@PathVariable("id") Long id, @RequestBody DepartmentDTO departmentDTO) {
    departmentService.update(id, departmentDTO);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity delete(@PathVariable("id") Long id) {
    departmentService.deleteById(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
  }
}
