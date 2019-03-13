package com.hrm.admin.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/** @author LIULE9 */
@Component
public class TimeHandler {

  private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
    return ok().contentType(MediaType.TEXT_PLAIN)
        .body(Mono.just("Now is " + LocalDateTime.now().format(TIME_FORMATTER)), String.class);
  }

  public Mono<ServerResponse> getDate(ServerRequest serverRequest) {
    return ok().contentType(MediaType.TEXT_PLAIN)
        .body(Mono.just("Today is " + LocalDateTime.now().format(DATE_FORMATTER)), String.class);
  }
}
