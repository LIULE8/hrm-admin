package com.hrm.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO implements Serializable {

  private static final long serialVersionUID = 532746296155084560L;

  private Long id;
  private String name;
}
