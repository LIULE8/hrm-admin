package com.hrm.admin.services.impl;

import com.hrm.admin.entities.Employee;
import com.hrm.admin.repositories.EmployeeRepository;
import com.hrm.admin.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired private EmployeeRepository employeeRepository;

  @Override
  public Mono<Employee> getOne(String id) {
    return employeeRepository
        .findById(id)
        .onErrorResume(
            e -> {
              throw new RuntimeException("can not find employee by this id " + id);
            });
  }

  @Override
  public Flux<Employee> findAll() {
    return employeeRepository.findAll();
  }

  @Override
  public Mono<Employee> save(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return employeeRepository
        .deleteById(id)
        .onErrorResume(
            e -> {
              throw new RuntimeException("can not find employee by this id " + id);
            });
  }
}
