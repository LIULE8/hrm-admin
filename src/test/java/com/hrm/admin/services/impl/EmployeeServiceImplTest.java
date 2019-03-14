package com.hrm.admin.services.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.hrm.admin.convert.EmployeeConverter;
import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.entities.Employee;
import com.hrm.admin.repositories.DepartmentRepository;
import com.hrm.admin.repositories.EmployeeRepository;
import java.util.Optional;
import org.junit.Test;

public class EmployeeServiceImplTest {

  private EmployeeRepository employeeRepository;
  private DepartmentRepository departmentRepository;

  @Test
  public void should_get_one_employee_by_id(){
    employeeRepository = mock(EmployeeRepository.class);
    departmentRepository = mock(DepartmentRepository.class);
    EmployeeServiceImpl service = new EmployeeServiceImpl(employeeRepository, departmentRepository, new EmployeeConverter());

    Employee employee = new Employee();
    employee.setName("Quinn");
    when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
    EmployeeDTO one = service.getOne(1L);

    assertThat("Quinn",is(one.getName()));
  }
}