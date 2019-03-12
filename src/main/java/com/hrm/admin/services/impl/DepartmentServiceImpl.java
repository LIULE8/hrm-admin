package com.hrm.admin.services.impl;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;
import com.hrm.admin.convert.DepartmentConverter;
import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.entities.Department;
import com.hrm.admin.repositories.DepartmentRepository;
import com.hrm.admin.services.DepartmentService;
import lombok.NonNull;
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
import java.util.Random;

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
    departmentRepository
        .findById(id)
        .ifPresent(department -> departmentRepository.delete(department));
  }

  @Override
  public void update(DepartmentDTO departmentDTO) {
    departmentRepository
        .findById(departmentDTO.getId())
        .ifPresent(department -> department.setName(departmentDTO.getName()));
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

  //定义一个ThreadLocal
  private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

  public static void main(String[] args) {
    for(int i = 0; i < 2; i ++) {
      new Thread(() -> {
        int data = new Random().nextInt();
        System.out.println(Thread.currentThread().getName() + " has put a data: " + data);
        threadLocal.set(data);//直接往threadLocal里面里面扔数据即可
        new TestA().getData();
        new TestB().getData();
      }).start();
    }
  }

  static class TestA {
    public void getData() {
      System.out.println("A get data from " + Thread.currentThread().getName() + ": " + threadLocal.get());//直接取，不用什么关键字，它直接从当前线程中取
    }
  }

  static class TestB {
    public void getData() {
      System.out.println("B get data from " + Thread.currentThread().getName() + ": " + threadLocal.get());//直接取，不用什么关键字，它直接从当前线程中取
    }
  }



}
