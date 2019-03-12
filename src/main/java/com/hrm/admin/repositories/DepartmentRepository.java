package com.hrm.admin.repositories;

import com.hrm.admin.entities.Department;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author LIULE9
 * @create 2019-03-11 2:10 PM
 */
public interface DepartmentRepository extends ReactiveMongoRepository<Department, Long> {}
