package com.hrm.admin.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = -4174182924953793963L;

  @CreatedDate private ZonedDateTime createTime = ZonedDateTime.now();

  @CreatedBy private String createBy;

  @LastModifiedDate private ZonedDateTime updateTime;

  @LastModifiedBy private String updateBy;

  @Version private Long version;
}
