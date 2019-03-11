package com.hrm.admin.controllers;

import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
