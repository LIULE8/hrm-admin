package com.hrm.admin.handler;

import com.hrm.admin.entities.Employee;
import com.hrm.admin.services.EmployeeService;
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

  @RequestMapping(method = {RequestMethod.POST, RequestMethod.PUT})
  public Mono save(@RequestBody Employee employee) {
    employeeService.save(employee);
    return ServerResponse.status(HttpStatus.CREATED).build();
  }

  @DeleteMapping("/{id}")
  public Mono delete(@PathVariable("id") String id) {
    employeeService.deleteById(id);
    return ServerResponse.noContent().build();
  }
}
