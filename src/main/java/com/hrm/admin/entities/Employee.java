package com.hrm.admin.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

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
@DynamicUpdate
@DynamicInsert
public class Employee extends BaseEntity {
  private static final long serialVersionUID = -3894079727069874921L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID", nullable = false, updatable = false)
  private Long id;

  @Column(name = "NAME", nullable = false)
  private String name;

  @Column(name = "BIRTHDAY", nullable = false)
  private LocalDate birthday;

  @Column(name = "MOBILE_PHONE", nullable = false)
  private String mobilePhone;

  @Column(name = "ID_CARD", nullable = false)
  private String idCard;

  @Column(name = "ENGLISH_NAME", nullable = false)
  private String englishName;

  @Column(name = "NATIONALITY", nullable = false)
  private String nationality;

  @Column(name = "BIRTHPLACE", nullable = false)
  private String birthplace;

  @Column(name = "MONTHLY_SALARY", nullable = false)
  private String monthlySalary;

  @Column(name = "GENDER", nullable = false)
  private String gender;

  @JsonManagedReference
  @JsonBackReference
  @ManyToOne
  @JoinColumn(name = "DEPARTMENT_ID")
  private Department department;
}
