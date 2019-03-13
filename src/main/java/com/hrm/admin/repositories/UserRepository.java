package com.hrm.admin.repositories;

import com.hrm.admin.entities.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author LIULE9
 */
public interface UserRepository extends ReactiveCrudRepository<User, String> {
  Mono<User> findByUsername(String username);

  Mono<Long> deleteByUsername(String username);
}
