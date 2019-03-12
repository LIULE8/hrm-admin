package com.hrm.admin.services.impl;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;
import com.hrm.admin.convert.DepartmentConverter;
import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.entities.Department;
import com.hrm.admin.repositories.DepartmentRepository;
import com.hrm.admin.services.DepartmentService;
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

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Slf4j
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
  @Autowired private DepartmentRepository departmentRepository;
  @Autowired private DepartmentConverter departmentConverter;

  @Override
  public DepartmentDTO getOne(Long departmentId) {
    return departmentRepository
        .findById(departmentId)
        .map(department -> departmentConverter.convert2DTO(department))
        .orElse(null);
  }

  @Override
  public List<DepartmentDTO> findAll() {
    List<Department> departments = departmentRepository.findAll();
    return departmentConverter.convert2DTOS(departments);
  }

  @Override
  public void save(DepartmentDTO departmentDTO) {
    Department department = departmentConverter.convertEntity(departmentDTO);
    departmentRepository.save(department);
  }

  @Override
  public void deleteById(Long id) {
    departmentRepository.deleteById(id);
  }

  @Override
  public Page<DepartmentDTO> findByCriteria(
      DepartmentDTO departmentDTO, Integer curPage, Integer pageSize) {
    PageRequest pageRequest = PageRequest.of(curPage, pageSize);
    Specification<Department> specification = buildCriteria(departmentDTO);
    Page<Department> page = departmentRepository.findAll(specification, pageRequest);
    return new PageImpl<>(
        departmentConverter.convert2DTOS(page.getContent()), pageRequest, page.getTotalElements());
  }

  @Override
  public void update(Long id, DepartmentDTO departmentDTO) {
    departmentRepository
        .findById(id)
        .ifPresent(
            dbDepartment -> {
              Department department = departmentConverter.convertEntity(departmentDTO);
              dbDepartment.setName(department.getName());
            });
  }

  private Specification<Department> buildCriteria(DepartmentDTO departmentDTO) {
    return (root, criteriaQuery, criteriaBuilder) -> {
      List<Predicate> list = Lists.newArrayList();
      if (StringUtils.isNotBlank(departmentDTO.getName())) {
        list.add(criteriaBuilder.like(root.get("name"), "%" + departmentDTO.getName() + "%"));
      }
      Predicate[] predicates = new Predicate[list.size()];
      return criteriaQuery.where(predicates).getRestriction();
    };
  }
}
