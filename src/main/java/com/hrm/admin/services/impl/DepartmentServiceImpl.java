package com.hrm.admin.services.impl;

import com.hrm.admin.entities.Department;
import com.hrm.admin.repositories.DepartmentRepository;
import com.hrm.admin.services.DepartmentService;
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
public class DepartmentServiceImpl implements DepartmentService {
  @Autowired private DepartmentRepository departmentRepository;

  @Override
  public Mono<Department> getOne(String id) {
    return departmentRepository
        .findById(id)
        .onErrorResume(
            e -> {
              throw new RuntimeException("can not find any department by this id " + id);
            });
  }

  @Override
  public Flux<Department> findAll() {
    return departmentRepository.findAll();
  }

  @Override
  public Mono<Department> save(Department department) {
    return departmentRepository
        .save(department)
        .onErrorResume(
            e ->
                departmentRepository
                    .findByNameEquals(department.getName())
                    .flatMap(
                        dbDepartment -> {
                          department.setId(dbDepartment.getId());
                          return departmentRepository.save(department);
                        }));
  }

  @Override
  public Mono<Void> deleteById(String id) {
    return departmentRepository
        .deleteById(id)
        .onErrorResume(
            e -> {
              throw new RuntimeException("can not find this department by " + id);
            });
  }
}
