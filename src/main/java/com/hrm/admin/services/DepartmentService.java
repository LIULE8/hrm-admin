package com.hrm.admin.services;

import com.hrm.admin.dto.DepartmentDTO;

/**
 *
 * @author LIULE9
 * @create 2019-03-11 7:28 PM
 */
public interface DepartmentService {
    DepartmentDTO getOne(Long departmentId);
}