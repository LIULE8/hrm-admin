package com.hrm.admin.handler;

import com.hrm.admin.entities.Department;
import com.hrm.admin.services.DepartmentService;
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
//@RequestMapping("departments")
@SuppressWarnings("all")
@Component
public class DepartmentHandler {
    @Autowired
    private DepartmentService departmentService;

    @NonNull
    public Mono<ServerResponse> getOne(ServerRequest serverRequest) {
        return departmentService.getOne(serverRequest.pathVariable("id"))
                .flatMap(person -> ok().contentType(APPLICATION_JSON).body(fromObject(person)))
                .switchIfEmpty(notFound().build());
//        return ok().body(departmentService.getOne(serverRequest.pathVariable("id")), Department.class);
    }

    @NonNull
    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return ok().body(departmentService.findAll(), Department.class);
    }

    @NonNull
    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        Mono<Department> departmentMono = serverRequest.bodyToMono(Department.class);
        departmentService.save(departmentMono.block());
        return ServerResponse.status(HttpStatus.CREATED).build();
    }

    @NonNull
    public Mono delete(ServerRequest serverRequest) {
        departmentService.deleteById(serverRequest.pathVariable("id"));
        return ServerResponse.status(HttpStatus.NO_CONTENT).build();
    }
}
