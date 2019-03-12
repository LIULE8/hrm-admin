package com.hrm.admin.entities;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Department extends BaseEntity {
  private static final long serialVersionUID = 1284320637506589123L;
  @Id private Long id;
  private String name;
  private List<Employee> employees = Lists.newArrayList();
}
