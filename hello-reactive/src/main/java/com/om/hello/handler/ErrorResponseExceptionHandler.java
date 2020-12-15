package com.om.hello.handler;

import com.om.hello.model.ErrorResponse;

import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

public interface ErrorResponseExceptionHandler<E extends Throwable> {

    Class<E> getTypeClass();

    Mono<ErrorResponse> handle(final ServerWebExchange exchange, final E e);

}
