package com.hrm.admin.handler;

import org.checkerframework.checker.nullness.qual.NonNull;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/** @author LIULE9 */
@Component
public class TimeHandler {

  private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
  private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  @NonNull
  public Mono<ServerResponse> getTime(ServerRequest serverRequest) {
    return ok().contentType(MediaType.TEXT_PLAIN)
        .body(Mono.just("Now is " + LocalDateTime.now().format(TIME_FORMATTER)), String.class);
  }

  @NonNull
  public Mono<ServerResponse> getDate(ServerRequest serverRequest) {
    return ok().contentType(MediaType.TEXT_PLAIN)
        .body(Mono.just("Today is " + LocalDateTime.now().format(DATE_FORMATTER)), String.class);
  }

  @NonNull
  public Mono<ServerResponse> sendTimePerSec(ServerRequest serverRequest) {
    // MediaType.TEXT_EVENT_STREAM 表示Content-Type 为text/event-stream，即SSE
    return ok().contentType(MediaType.TEXT_EVENT_STREAM)
        .body(
            Flux.interval(Duration.ofSeconds(1))
                .map(l -> LocalDateTime.now().format(TIME_FORMATTER)),
            String.class);
  }
}
