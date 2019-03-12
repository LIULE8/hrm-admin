package com.hrm.admin.services.impl;

import com.hrm.admin.convert.DepartmentConverter;
import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.entities.Department;
import com.hrm.admin.repositories.DepartmentRepository;
import com.hrm.admin.services.DepartmentService;
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
public class DepartmentServiceImpl implements DepartmentService {
  @Autowired private DepartmentRepository departmentRepository;
  @Autowired private DepartmentConverter departmentConverter;

  @Override
  public DepartmentDTO getOne(Long departmentId) {
//    return departmentRepository
//        .findById(departmentId)
//        .map(department -> departmentConverter.convert2DTO(department))
//        .orElse(null);
    return null;
  }

  @Override
  public List<DepartmentDTO> findAll() {
//    List<Department> departments = departmentRepository.findAll();
//    return departmentConverter.convert2DTOS(departments);
    return null;
  }

  @Override
  public void save(DepartmentDTO departmentDTO) {
    Department department = departmentConverter.convertEntity(departmentDTO);
    departmentRepository.save(department);
  }

  @Override
  public void deleteById(Long id) {
//    departmentRepository
//        .findById(id)
//        .ifPresent(department -> departmentRepository.delete(department));
  }

  @Override
  public void update(DepartmentDTO departmentDTO) {
//    departmentRepository
//        .findById(departmentDTO.getId())
//        .ifPresent(department -> department.setName(departmentDTO.getName()));
  }
}
