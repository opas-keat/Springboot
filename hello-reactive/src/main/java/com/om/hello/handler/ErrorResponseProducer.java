package com.om.hello.handler;

import com.om.hello.model.ErrorResponse;

import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public interface ErrorResponseProducer {
    Mono<Void> produce(final ErrorResponse err, final ServerWebExchange exchange);
}
