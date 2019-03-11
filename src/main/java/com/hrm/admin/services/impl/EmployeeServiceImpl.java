package com.hrm.admin.services.impl;

import com.hrm.admin.convert.EmployeeConverter;
import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.entities.Employee;
import com.hrm.admin.repositories.EmployeeRepository;
import com.hrm.admin.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Slf4j
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired private EmployeeRepository employeeRepository;
  @Autowired private EmployeeConverter employeeConverter;

  @Override
  public EmployeeDTO getOne(Long employeeId) {
    return employeeRepository
        .findById(employeeId)
        .map(employee -> employeeConverter.convert2DTO(employee))
        .orElse(null);
  }

  @Override
  public List<EmployeeDTO> findAll() {
    List<Employee> employees = employeeRepository.findAll();
    return employeeConverter.convert2DTOS(employees);
  }

  @Override
  public void save(EmployeeDTO employeeDTO) {
    Employee employee = employeeConverter.convertEntity(employeeDTO);
    employeeRepository.save(employee);
  }

  @Override
  public void deleteById(Long id) {
    employeeRepository.deleteById(id);
  }
}
