package com.hrm.admin.services.impl;

import com.auth0.jwt.internal.org.apache.commons.lang3.StringUtils;
import com.google.common.collect.Lists;
import com.hrm.admin.convert.EmployeeConverter;
import com.hrm.admin.dto.EmployeeDTO;
import com.hrm.admin.entities.Employee;
import com.hrm.admin.repositories.EmployeeRepository;
import com.hrm.admin.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Slf4j
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
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
        Employee employee = employeeConverter.convertEntity(employeeDTO);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Page<EmployeeDTO> findByCriteria(EmployeeDTO employeeDTO, Integer curPage, Integer pageSize) {
        PageRequest pageRequest = PageRequest.of(curPage, pageSize);
        Specification<Employee> specification = buildCriteria(employeeDTO);
        Page<Employee> page = employeeRepository.findAll(specification, pageRequest);
        return new PageImpl<>(employeeConverter.convert2DTOS(page.getContent()), pageRequest, page.getTotalElements());
    }

    private Specification<Employee> buildCriteria(EmployeeDTO employeeDTO) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            List<Predicate> list = Lists.newArrayList();
            if (StringUtils.isNotBlank(employeeDTO.getName())) {
                list.add(criteriaBuilder.like(root.get("name"), "%" + employeeDTO.getName() + "%"));
            }
            Predicate[] predicates = new Predicate[list.size()];
            return criteriaQuery.where(predicates).getRestriction();
        };
    }
}
