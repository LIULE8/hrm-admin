package com.hrm.admin.services.impl;

import com.hrm.admin.entities.User;
import com.hrm.admin.repositories.UserRepository;
import com.hrm.admin.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/** @author LIULE9 */
@Service
public class UserServiceImpl implements UserService {
  @Autowired private UserRepository userRepository;

  /** 保存或更新。 如果传入的user没有id属性，由于username是unique的，在重复的情况下有可能报错， 这时找到以保存的user记录用传入的user更新它。 */
  @Override
  public Mono<User> save(User user) {
    return userRepository
        .save(user)
        .onErrorResume(
            e ->
                userRepository
                    .findByUsername(user.getUsername())
                    .flatMap(
                        originalUser -> {
                          user.setId(originalUser.getId());
                          return userRepository.save(user);
                        }));
  }
  @Override
  public Mono<Long> deleteByUsername(String username) {
    return userRepository.deleteByUsername(username);
  }
  @Override
  public Mono<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }
  @Override
  public Flux<User> findAll() {
    return userRepository.findAll();
  }
}
