package com.hrm.admin.convert;

import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.entities.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

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
    return employeeDTO;
  }

  public List<EmployeeDTO> convert2DTOS(List<Employee> employees) {
    return employees.stream().map(this::convert2DTO).collect(toList());
  }
}
