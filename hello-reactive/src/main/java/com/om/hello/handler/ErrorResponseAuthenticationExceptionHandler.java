package com.om.hello.handler;

import com.om.hello.exception.AuthenticationException;
import com.om.hello.model.ErrorResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class ErrorResponseAuthenticationExceptionHandler extends ErrorResponseExceptionHandlerAdapter<AuthenticationException> {

    @Override
    public Class<AuthenticationException> getTypeClass() {
        return AuthenticationException.class;
    }

    @Override
    protected Mono<ErrorResponse> buildError(final ServerWebExchange exchange, final AuthenticationException e) {
        return Mono.fromCallable(() -> {
            return ErrorResponse.unauthorized();
        });
    }
}
