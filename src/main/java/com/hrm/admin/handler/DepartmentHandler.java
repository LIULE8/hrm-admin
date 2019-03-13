package com.hrm.admin.handler;

import com.hrm.admin.entities.Department;
import com.hrm.admin.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@RestController
@RequestMapping("departments")
@SuppressWarnings("all")
//@Component
public class DepartmentHandler {
  @Autowired private DepartmentService departmentService;

  @GetMapping("/{id}")
  public Mono<ServerResponse> getOne(@PathVariable("id") String departmentId) {
    return ok().body(departmentService.getOne(departmentId));
  }

  @GetMapping
  public Flux<Department> findAll() {
    return departmentService.findAll();
  }

  @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
  public Mono<ServerResponse> save(@RequestBody Department department) {
    departmentService.save(department);
    return ServerResponse.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{id}")
  public Mono delete(@PathVariable("id") String id) {
    departmentService.deleteById(id);
    return ServerResponse.status(HttpStatus.NO_CONTENT).build();
  }
}
