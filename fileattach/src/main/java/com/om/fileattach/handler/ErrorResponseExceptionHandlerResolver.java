package com.om.fileattach.handler;

import reactor.core.publisher.Mono;

public interface ErrorResponseExceptionHandlerResolver {

    Mono<ErrorResponseExceptionHandler> resolve(final Throwable e);

}
