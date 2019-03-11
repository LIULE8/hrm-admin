package com.hrm.admin.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Data
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = -7229588852420224446L;
    private String name;
    private DepartmentDTO department;
}