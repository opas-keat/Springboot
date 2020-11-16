package com.om.fileattach.handler;

import com.om.fileattach.exception.InvalidUsernamePasswordException;
import com.om.fileattach.model.ErrorResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class ErrorResponseInvalidUsernamePasswordExceptionHandler extends ErrorResponseExceptionHandlerAdapter<InvalidUsernamePasswordException> {

    @Override
    public Class<InvalidUsernamePasswordException> getTypeClass() {
        return InvalidUsernamePasswordException.class;
    }

    @Override
    protected Mono<ErrorResponse> buildError(final ServerWebExchange exchange, final InvalidUsernamePasswordException e) {
        return Mono.fromCallable(() -> {
            return ErrorResponse.builder()
                    .error("invalid_username_password")
                    .errorDescription("invalid username or password")
                    .errorStatus(HttpStatus.BAD_REQUEST.value())
                    .build();
        });
    }
}