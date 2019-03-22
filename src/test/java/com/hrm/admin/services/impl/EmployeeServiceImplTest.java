package com.hrm.admin.services.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.common.collect.Lists;
import com.hrm.admin.convert.EmployeeConverter;
import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.entities.Employee;
import com.hrm.admin.repositories.DepartmentRepository;
import com.hrm.admin.repositories.EmployeeRepository;

import java.util.List;
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

  @Test
  public void should_get_info_of_all_employees() {
    employeeRepository = mock(EmployeeRepository.class);
    departmentRepository = mock(DepartmentRepository.class);
    EmployeeServiceImpl service = new EmployeeServiceImpl(employeeRepository, departmentRepository, new EmployeeConverter());
    Employee employee1 = new Employee();
    employee1.setName("Tracy");
    Employee employee2 = new Employee();
    employee2.setName("Quinn");
    List<Employee> employees = Lists.newArrayList(employee1, employee2);

    when(employeeRepository.findAll()).thenReturn(employees);
    List<EmployeeDTO> list = service.findAll();

    assertThat(employees.size(), is(list.size()));
  }

  @Test
  public void should_delete_specific_employee_when_give_the_id() {
    employeeRepository = mock(EmployeeRepository.class);
    departmentRepository = mock(DepartmentRepository.class);
    EmployeeServiceImpl service = new EmployeeServiceImpl(employeeRepository, departmentRepository, new EmployeeConverter());
    Employee employee = new Employee();

    when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
    service.deleteById(1L);

    verify(employeeRepository, times(1)).delete(employee);
  }
}