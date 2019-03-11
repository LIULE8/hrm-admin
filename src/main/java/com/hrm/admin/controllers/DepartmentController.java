package com.hrm.admin.controllers;

import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
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

  @PostMapping
  public void save(@RequestBody DepartmentDTO departmentDTO) {
    departmentService.save(departmentDTO);
  }

  @PutMapping("/{id}")
  public void update(@RequestBody DepartmentDTO departmentDTO) {
    departmentService.save(departmentDTO);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") Long id) {
    departmentService.deleteById(id);
  }
}
