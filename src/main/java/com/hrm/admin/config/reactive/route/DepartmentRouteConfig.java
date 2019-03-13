package com.hrm.admin.config.reactive.route;

import com.hrm.admin.handler.DepartmentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author LIULE9
 * @create 13/03/2019
 */
@Configuration
public class DepartmentRouteConfig {
  @Autowired private DepartmentHandler departmentHandler;

//  @Bean
//  public RouterFunction<ServerResponse> departmentRoute() {
//      return route(GET("department/{id}"),departmentHandler::getOne);
//  }
}
