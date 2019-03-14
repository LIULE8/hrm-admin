package com.hrm.admin.services;

import com.hrm.admin.entities.Department;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 *
 * @author LIULE9
 * @create 2019-03-11 7:28 PM
 */
public interface DepartmentService {
    Mono<Department> getOne(String id);

    Flux<Department> findAll();

    Mono<Department> save(Department department);

    Mono<Void> deleteById(String id);

    Mono<Department> update(Department department);
}