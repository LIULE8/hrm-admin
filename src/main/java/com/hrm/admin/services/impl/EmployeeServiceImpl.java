package com.hrm.admin.services.impl;

import com.hrm.admin.convert.EmployeeConverter;
import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.entities.Employee;
import com.hrm.admin.repositories.DepartmentRepository;
import com.hrm.admin.repositories.EmployeeRepository;
import com.hrm.admin.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired private EmployeeRepository employeeRepository;
  @Autowired private DepartmentRepository departmentRepository;
  @Autowired private EmployeeConverter employeeConverter;

  @Override
  public EmployeeDTO getOne(Long employeeId) {
//    return employeeRepository
//        .findById(employeeId)
//        .map(employee -> employeeConverter.convert2DTO(employee))
//        .orElse(null);
      return null;
  }

  @Override
  public List<EmployeeDTO> findAll() {
//    List<Employee> employees = employeeRepository.findAll();
//    return employeeConverter.convert2DTOS(employees);
      return null;
  }

  @Override
  public void save(EmployeeDTO employeeDTO) {
    Employee employee = employeeConverter.convert2Entity(employeeDTO);
    DepartmentDTO department = employeeDTO.getDepartment();
//    departmentRepository.save(department);
    employeeRepository.save(employee);
  }

  @Override
  public void deleteById(Long id) {
//    employeeRepository.findById(id).ifPresent(employee -> employeeRepository.delete(employee));
  }

  @Override
  public void update(EmployeeDTO employeeDTO) {
//    employeeRepository
//        .findById(employeeDTO.getId())
//        .ifPresent(
//            dbEmployee -> {
//              Employee employee = employeeConverter.convert2Entity(employeeDTO);
//              dbEmployee.setName(employee.getName());
//              dbEmployee.setBirthday(employee.getBirthday());
//              dbEmployee.setBirthplace(employee.getBirthplace());
//              dbEmployee.setEnglishName(employee.getEnglishName());
//              dbEmployee.setIdCard(employee.getIdCard());
//              dbEmployee.setMobilePhone(employee.getMobilePhone());
//              dbEmployee.setNationality(employee.getNationality());
//              dbEmployee.setMonthlySalary(employee.getMonthlySalary());
//            });
  }
}
