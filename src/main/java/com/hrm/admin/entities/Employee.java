package com.hrm.admin.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

/**
 * @author Leo Liu
 * @create 11/03/2019
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employee extends BaseEntity {
  private static final long serialVersionUID = -3894079727069874921L;

  @Id private Long id;

  private String name;

  private LocalDate birthday;

  private Long mobilePhone;

  private String idCard;

  private String englishName;

  private String nationality;

  private String birthplace;

  private String monthlySalary;

  @JsonIgnore private Department department;
}
