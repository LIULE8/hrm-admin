package com.hrm.admin.handler;

import com.hrm.admin.entities.Employee;
import com.hrm.admin.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.util.annotation.NonNull;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * @author LIULE9
 * @create 11/03/2019
 */
//@RestController
//@RequestMapping("employees")
@SuppressWarnings("all")
@Component
public class EmployeeHandler {
    @Autowired
    private EmployeeService employeeService;

    @NonNull
    public Mono<ServerResponse> getOne(ServerRequest serverRequest) {
        return employeeService.getOne(serverRequest.pathVariable("id"))
                .flatMap(person -> ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                .switchIfEmpty(notFound().build());
    }

    @NonNull
    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return ok().body(employeeService.findAll(), Employee.class);
    }

    @NonNull
    public Mono save(ServerRequest serverRequest) {
        Mono<Employee> employeeMono = serverRequest.bodyToMono(Employee.class);
        employeeService.save(employeeMono.block());
        return ServerResponse.status(HttpStatus.CREATED).build();
    }

    @NonNull
    public Mono delete(ServerRequest serverRequest) {
        employeeService.deleteById(serverRequest.pathVariable("id"));
        return ServerResponse.status(HttpStatus.NO_CONTENT).build();
    }
}
