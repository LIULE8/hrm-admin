package com.hrm.admin.services;

import com.hrm.admin.dto.EmployeeDTO;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
public interface EmployeeService {

    EmployeeDTO getOne(Long employeeId);
}