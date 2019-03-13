package com.hrm.admin.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/** @author LIULE9 */
@Document
@Data
public class User {
  @Id private String id;

  @Indexed(unique = true)
  private String username;

  private String phone;
  private String email;
  private String name;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date birthday;
}
