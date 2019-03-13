package com.hrm.admin.controllers;

import com.hrm.admin.entities.User;
import com.hrm.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author LIULE9
 */
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired private UserService userService;

  @PostMapping
  public Mono<User> save(User user) {
    return userService.save(user);
  }

  @DeleteMapping("/{username}")
  public Mono<Long> deleteByUsername(@PathVariable String username) {
    return userService.deleteByUsername(username);
  }

  @GetMapping("/{username}")
  public Mono<User> findByUsername(@PathVariable String username) {
    return userService.findByUsername(username);
  }

  @GetMapping
  public Flux<User> findAll() {
    return userService.findAll();
  }
}
