package com.hrm.admin.handler;

import com.hrm.admin.entities.Employee;
import com.hrm.admin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@RestController
@RequestMapping("employees")
@SuppressWarnings("all")
// @Component
public class EmployeeHandler {
  @Autowired private EmployeeService employeeService;

  @GetMapping("/{id}")
  public Mono<Employee> getOne(@PathVariable("id") String id) {
    return employeeService.getOne(id);
  }

  @GetMapping
  public Flux<Employee> findAll() {
    return employeeService.findAll();
  }

  @PostMapping
  public Mono<Employee> save(@RequestBody Employee employee) {
    return employeeService.save(employee);
  }

  @PutMapping
  public Mono<Employee> update(@RequestBody Employee employee) {
    return employeeService.update(employee);
  }

  @DeleteMapping("/{id}")
  public Mono delete(@PathVariable("id") String id) {
    employeeService.deleteById(id);
    return ServerResponse.noContent().build();
  }
}
