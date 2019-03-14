package com.hrm.admin.handler;

import com.hrm.admin.entities.Department;
import com.hrm.admin.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@RestController
@RequestMapping("departments")
//@SuppressWarnings("all")
//@Component
public class DepartmentHandler {
  @Autowired private DepartmentService departmentService;

  @GetMapping("/{id}")
  public Mono<Department> getOne(@PathVariable("id") String departmentId) {
    return departmentService.getOne(departmentId);
  }

  @GetMapping
  public Flux<Department> findAll() {
    return departmentService.findAll();
  }

  @PostMapping
  public Mono<Department> save(@RequestBody Department department) {
    return departmentService.save(department);
  }

  @PutMapping
  public Mono<Department> update(@RequestBody Department department) {
    return departmentService.update(department);
  }

  @DeleteMapping("/{id}")
  public Mono delete(@PathVariable("id") String id) {
    departmentService.deleteById(id);
    return ServerResponse.noContent().build();
  }
}
