package com.hrm.admin.services;

import com.hrm.admin.entities.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LIULE9
 * @create 2019-03-13 10:29 AM
 */
public interface UserService {
    Mono<User> save(User user);

    Mono<Long> deleteByUsername(String username);

    Mono<User> findByUsername(String username);

    Flux<User> findAll();
}
