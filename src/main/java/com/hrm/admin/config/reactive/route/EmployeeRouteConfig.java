package com.hrm.admin.config.reactive.route;

import com.hrm.admin.handler.EmployeeHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author LIULE9
 * @create 13/03/2019
 */
@Configuration
@Slf4j
public class EmployeeRouteConfig {
    @Autowired private EmployeeHandler employeeHandler;

//    @Bean
//    public RouterFunction<ServerResponse> employeeRoute(){
//        return route();
//    }
}