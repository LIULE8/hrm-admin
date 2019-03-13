package com.hrm.admin.config.reactive.route;

import com.hrm.admin.handler.DepartmentHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author LIULE9
 * @create 13/03/2019
 */
@Configuration
public class DepartmentRouteConfig {
  @Autowired private DepartmentHandler departmentHandler;

  @Bean
  public RouterFunction<ServerResponse> departmentRoute() {
    return route(
        GET("department/{id}").and(accept(MediaType.APPLICATION_JSON)), departmentHandler::getOne);
  }
}
