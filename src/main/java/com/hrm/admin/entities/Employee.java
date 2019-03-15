package com.hrm.admin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
public class Employee {
  private static final long serialVersionUID = -3894079727069874921L;

  @Id private String id;
  @Field("name")
  private String name;
  @Field("birthday")
  private LocalDate birthday;
  @Field("mobilePhone")
  private Long mobilePhone;
  @Field("idCard")
  private String idCard;
  @Field("englishName")
  private String englishName;
  @Field("nationality")
  private String nationality;
  @Field("birthplace")
  private String birthplace;
  @Field("monthlySalary")
  private String monthlySalary;
}
