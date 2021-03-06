package com.hrm.admin.services;

import com.hrm.admin.dto.EmployeeDTO;
import org.springframework.data.domain.Page;

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

    Page<EmployeeDTO> findByCriteria(EmployeeDTO employeeDTO, Integer curPage, Integer pageSize);

    void update(EmployeeDTO employeeDTO);
}