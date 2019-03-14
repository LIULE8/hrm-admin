package com.hrm.admin.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.admin.dto.DepartmentDTO;
import com.hrm.admin.entities.Department;
import com.hrm.admin.repositories.DepartmentRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.is;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@ComponentScan(basePackages = {"com.hrm.admin"})
@SpringBootTest
@AutoConfigureMockMvc
public class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper mapper;

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

    @Test
    public void should_get_info_of_all_departments() throws Exception {
        Department department1 = new Department();
        Department department2 = new Department();
        department1.setId(1L);department1.setName("IRIS");
        department2.setId(2L);department2.setName("CargoSmart");
        List<Department> departments= Arrays.asList(department1,department2);
        given(repository.findAll()).willReturn(departments);
        mockMvc.perform(get("/departments")).andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(2)))
                .andExpect(jsonPath("$[0].name", is("IRIS")))
                .andExpect(jsonPath("$[1].id", is(2)));
    }

    @Test
    public void should_save_the_given_department() throws Exception {
        Department department1 = new Department();
        department1.setId(1L);department1.setName("IRIS");
        given(repository.save(department1)).willReturn(department1);
        ResultActions result = mockMvc.perform(post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(new DepartmentDTO(1L,"IRIS"))));

        result.andExpect(status().isCreated()).andDo(print());
    }

    @Test
    public void should_delete_the_specific_department_when_give_id() throws Exception {

        Department department1 = new Department();
        department1.setId(1L);department1.setName("IRIS");
        given(repository.findById(1L)).willReturn(Optional.of(department1));
        ResultActions result = mockMvc.perform(delete("/departments/1"));
        result.andExpect(status().isNoContent()).andDo(print());
    }
}