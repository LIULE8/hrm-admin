package com.hrm.admin.handler;

import com.hrm.admin.entities.Department;
import com.hrm.admin.services.DepartmentService;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_STREAM_JSON;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Component
@SuppressWarnings("all")
public class DepartmentHandler {
  @Autowired private DepartmentService departmentService;

  @GetMapping("/{id}")
  @NonNull
  public Mono<Department> getOne(@PathVariable("id") String departmentId) {
    return departmentService.getOne(departmentId);
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
  public Mono<ServerResponse> delete(@PathVariable("id") String id) {
    departmentService.deleteById(id);
    return ServerResponse.status(HttpStatus.NO_CONTENT).build();
  }
}
