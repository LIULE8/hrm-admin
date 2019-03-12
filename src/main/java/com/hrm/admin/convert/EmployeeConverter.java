package com.hrm.admin.convert;

import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.entities.Department;
import com.hrm.admin.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Slf4j
@Component
public class EmployeeConverter {

  public EmployeeDTO convert2DTO(Employee employee) {
    EmployeeDTO employeeDTO = new EmployeeDTO();
    BeanUtils.copyProperties(employee, employeeDTO);
    Department department = employee.getDepartment();
    if (Objects.nonNull(department)) {
      employeeDTO.setDepartment(new DepartmentDTO(department.getId(), department.getName()));
    }
    return employeeDTO;
  }

  public List<EmployeeDTO> convert2DTOS(List<Employee> employees) {
    return employees.stream().map(this::convert2DTO).collect(toList());
  }

  public Employee convert2Entity(EmployeeDTO employeeDTO) {
    Employee employee = new Employee();
    BeanUtils.copyProperties(employeeDTO, employee);
    return employee;
  }
}
