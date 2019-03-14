package com.hrm.admin.services.impl;

import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.services.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void should_save_the_given_department() {
        DepartmentDTO departmentDTO = new DepartmentDTO(1L, "IRIS");
        departmentService.save(departmentDTO);
    }

    @Test
    public void should_get_info_of_specific_department_when_give_the_id() {
        departmentService.getOne(1L);
    }

    @Test
    public void should_get_info_of_all_departments() {
        List<DepartmentDTO> departmentDTOS = departmentService.findAll();
        for (DepartmentDTO departmentDTO : departmentDTOS) {
            System.out.println(departmentDTO.getId() + " " + departmentDTO.getName());
        }
    }
}