package com.hrm.admin.config.reactive.route;

import com.hrm.admin.handler.DepartmentHandler;
import com.hrm.admin.handler.EmployeeHandler;
import com.hrm.admin.handler.TimeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @author LIULE9
 * @create 13/03/2019
 */
@Configuration
@Slf4j
public class RouteConfig {

    @Autowired
    private TimeHandler timeHandler;
    @Autowired
    private DepartmentHandler departmentHandler;
    @Autowired
    private EmployeeHandler employeeHandler;

    @Bean
    public RouterFunction<?> routerFunction() {
        return route(GET("/time"), timeHandler::getTime)
                .andRoute(GET("/date"), timeHandler::getDate)
                .andRoute(GET("/times"), timeHandler::sendTimePerSec)

                // department
                .andRoute(GET("departments/{id}"), departmentHandler::getOne)
                .andRoute(GET("departments"), departmentHandler::findAll)
                .andRoute(POST("departments"), departmentHandler::save)
                .andRoute(PUT("departments"), departmentHandler::save)
                .andRoute(DELETE("departments/{id}"), departmentHandler::delete)

                // employee
                .andRoute(GET("employees/{id}"), employeeHandler::getOne)
                .andRoute(GET("employees"), employeeHandler::findAll)
                .andRoute(POST("employees"), employeeHandler::save)
                .andRoute(PUT("employees"), employeeHandler::save)
                .andRoute(DELETE("employees/{id}"), employeeHandler::delete);
    }
}
