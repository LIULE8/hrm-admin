package com.hrm.admin.services;

import com.hrm.admin.entities.Employee;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
public interface EmployeeService {

    Mono<Employee> getOne(String id);

    Flux<Employee> findAll();

    Mono<Employee> save(Employee employee);

    Mono<Void> deleteById(String id);
}