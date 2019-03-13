package com.hrm.admin.handler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/** @author LIULE9 */
@RestController
public class HelloController {

//  @GetMapping("/hello")
//  public String hello() {
//    return "Welcome to reactive world ~";
//  }

  @GetMapping("/hello")
  public Mono<String> hello() {
    // 【改】返回类型为Mono<String>
    // 【改】使用Mono.just生成响应式数据
    return Mono.just("Welcome to reactive world ~");
  }
}
