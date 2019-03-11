package com.hrm.admin.services;

import com.hrm.admin.dto.EmployeeDTO;

import java.util.List;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
public interface EmployeeService {

    EmployeeDTO getOne(Long employeeId);

    List<EmployeeDTO> findAll();

    void save(EmployeeDTO employeeDTO);

    void deleteById(Long id);
}