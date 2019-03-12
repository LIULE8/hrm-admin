package com.hrm.admin.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * @author Leo Liu
 * @create 11/03/2019
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Employee extends BaseEntity {
  private static final long serialVersionUID = -3894079727069874921L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false, updatable = false, columnDefinition = "员工编号")
  private Long id;

  @Column(name = "NAME", nullable = false, columnDefinition = "员工姓名")
  private String name;

  @Column(name = "BIRTHDAY", nullable = false, columnDefinition = "出生日期")
  private LocalDate birthday;

  @Column(name = "MOBILE_PHONE", nullable = false, columnDefinition = "电话号码")
  private Long mobilePhone;

  @Column(name = "ID_CARD", nullable = false, columnDefinition = "身份证")
  private String idCard;

  @Column(name = "ENGLISH_NAME", nullable = false, columnDefinition = "英文名")
  private String englishName;

  @Column(name = "NATIONALITY", nullable = false, columnDefinition = "民族")
  private String nationality;

  @Column(name = "BIRTHPLACE", nullable = false, columnDefinition = "籍贯")
  private String birthplace;

  @Column(name = "MONTHLY_SALARY", nullable = false, columnDefinition = "月薪")
  private String monthlySalary;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "DEPARTMENT_ID")
  private Department department;
}
