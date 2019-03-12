package com.hrm.admin.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Data
public class DepartmentDTO implements Serializable {

  private static final long serialVersionUID = 532746296155084560L;

  private Long id;
  private String name;

  @JsonIgnore
  private List<EmployeeDTO> employees = Lists.newArrayList();
}
