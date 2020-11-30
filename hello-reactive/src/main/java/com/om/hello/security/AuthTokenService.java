package com.om.hello.security;

import java.util.Map;

import reactor.core.publisher.Mono;

public interface AuthTokenService {

    Mono<String> sign(final Map<String, Object> claims);

    Mono<Map<String, Object>> verify(final String token);

}
