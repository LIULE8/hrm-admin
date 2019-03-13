package com.hrm.admin.controllers;

import com.hrm.admin.entities.Department;
import com.hrm.admin.repositories.DepartmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.hrm.admin"})
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentRepository repository;

    @Test
    public void should_get_info_of_specific_department_when_give_the_id() throws Exception {
        Department department1 = new Department();
        Department department2 = new Department();
        department1.setId(1L);department1.setName("IRIS");
        department2.setId(2L);department2.setName("CargoSmart");
        given(repository.findById(1L)).willReturn(Optional.of(department1));
        mockMvc.perform(get("/departments/1")).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is("IRIS")))
                .andExpect(jsonPath("$.id", is(1)));
    }
}