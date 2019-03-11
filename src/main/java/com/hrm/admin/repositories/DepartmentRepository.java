package com.hrm.admin.repositories;

import com.hrm.admin.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author LIULE9
 * @create 2019-03-11 2:10 PM
 */
public interface DepartmentRepository
    extends JpaRepository<Department, Long>, JpaSpecificationExecutor<Department> {}
