package com.om.fileattach.handler;

import com.om.fileattach.model.ErrorResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class ErrorResponseRootErrorHandler extends ErrorResponseExceptionHandlerAdapter<Error> {

    @Override
    public Class<Error> getTypeClass() {
        return Error.class;
    }

    @Override
    protected Mono<ErrorResponse> buildError(final ServerWebExchange exchange, final Error e) {
        return Mono.fromCallable(() -> {
            return ErrorResponse.serverError();
        });
    }
}
