package com.hrm.admin.services.impl;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;
import com.hrm.admin.convert.EmployeeConverter;
import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.entities.Employee;
import com.hrm.admin.repositories.DepartmentRepository;
import com.hrm.admin.repositories.EmployeeRepository;
import com.hrm.admin.services.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Objects;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;
  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private EmployeeConverter employeeConverter;

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
    Employee employee = employeeConverter.convert2Entity(employeeDTO);
    DepartmentDTO department = employeeDTO.getDepartment();
    if (Objects.nonNull(department)) {
      departmentRepository.findById(department.getId()).ifPresent(employee::setDepartment);
    }
    employeeRepository.save(employee);
  }

  @Override
  public void deleteById(Long id) {
    employeeRepository.findById(id).ifPresent(employee -> employeeRepository.delete(employee));
  }

  @Override
  public void update(EmployeeDTO employeeDTO) {
    employeeRepository
        .findById(employeeDTO.getId())
        .ifPresent(
            dbEmployee -> {
              Employee employee = employeeConverter.convert2Entity(employeeDTO);
              dbEmployee.setName(employee.getName());
              dbEmployee.setBirthday(employee.getBirthday());
              dbEmployee.setBirthplace(employee.getBirthplace());
              dbEmployee.setEnglishName(employee.getEnglishName());
              dbEmployee.setIdCard(employee.getIdCard());
              dbEmployee.setMobilePhone(employee.getMobilePhone());
              dbEmployee.setNationality(employee.getNationality());
              dbEmployee.setMonthlySalary(employee.getMonthlySalary());
              dbEmployee.setGender(employee.getGender());
              dbEmployee.setDepartment(departmentRepository.findById(employeeDTO.getDepartment().getId()).get());
            });
  }

  @Override
  public Page<EmployeeDTO> findByCriteria(
      EmployeeDTO employeeDTO, Integer curPage, Integer pageSize) {
    PageRequest pageRequest = PageRequest.of(curPage, pageSize);
    Specification<Employee> specification = buildCriteria(employeeDTO);
    Page<Employee> page = employeeRepository.findAll(specification, pageRequest);
    return new PageImpl<>(
        employeeConverter.convert2DTOS(page.getContent()), pageRequest, page.getTotalElements());
  }

  private Specification<Employee> buildCriteria(EmployeeDTO employeeDTO) {
    return (root, criteriaQuery, criteriaBuilder) -> {
      List<Predicate> list = Lists.newArrayList();
      if (StringUtils.isNotBlank(employeeDTO.getName())) {
        list.add(criteriaBuilder.or(
            criteriaBuilder.like(root.get("name"), "%" + employeeDTO.getName() + "%"),
            criteriaBuilder.like(root.get("englishName"), "%" + employeeDTO.getName() + "%")
        ));
      }
      if (Objects.nonNull(employeeDTO.getId())) {
        list.add(criteriaBuilder.equal(root.get("id"), employeeDTO.getId()));
      }
      if (Objects.nonNull(employeeDTO.getBirthday())) {
        list.add(criteriaBuilder.equal(root.get("birthday"), employeeDTO.getBirthday()));
      }
      if (Objects.nonNull(employeeDTO.getMobilePhone())) {
        list.add(criteriaBuilder.like(root.get("mobilePhone"), "%" + employeeDTO.getMobilePhone() + "%"));
      }
      if (Objects.nonNull(employeeDTO.getDepartment())) {
        list.add(criteriaBuilder.equal(root.get("department"), employeeDTO.getDepartment().getId()));
      }
      Predicate[] predicates = new Predicate[list.size()];
      return criteriaQuery.where(list.toArray(predicates)).getRestriction();
    };
  }
}
