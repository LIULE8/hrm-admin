package com.hrm.admin.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Data
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = -7229588852420224446L;
    private Long id;
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    private String mobilePhone;

    private String idCard;

    private String englishName;

    private String nationality;

    private String birthplace;

    private String monthlySalary;

    private String gender;

    private DepartmentDTO department;
}