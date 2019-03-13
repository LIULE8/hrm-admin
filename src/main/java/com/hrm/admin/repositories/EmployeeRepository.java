package com.hrm.admin.repositories;

import com.hrm.admin.entities.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

/**
 * @author LIULE9
 * @create 2019-03-11 2:09 PM
 */
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {}
