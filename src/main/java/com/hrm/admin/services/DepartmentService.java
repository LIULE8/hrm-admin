package com.hrm.admin.services;

import com.hrm.admin.dto.DepartmentDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 *
 * @author LIULE9
 * @create 2019-03-11 7:28 PM
 */
public interface DepartmentService {
    DepartmentDTO getOne(Long departmentId);

    List<DepartmentDTO> findAll();

    void save(DepartmentDTO eepartmentDTO);

    void deleteById(Long id);

    Page<DepartmentDTO> findByCriteria(DepartmentDTO departmentDTO, Integer curPage, Integer pageSize);
}