package com.hrm.admin.config;

import com.hrm.admin.handler.DepartmentHandler;
import com.hrm.admin.handler.EmployeeHandler;
import com.hrm.admin.handler.TimeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author LIULE9
 * @create 13/03/2019
 */
@Configuration
public class RouteConfig {

  @Autowired private DepartmentHandler departmentHandler;
  @Autowired private EmployeeHandler employeeHandler;
  @Autowired private TimeHandler timeHandler;

  @Bean
  public RouterFunction<ServerResponse> timerRouter() {
    return route(GET("/time"), req -> timeHandler.getTime(req))
        .andRoute(GET("/date"), timeHandler::getDate);
  }
}
