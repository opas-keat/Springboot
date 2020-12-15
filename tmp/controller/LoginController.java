package com.om.hello.controller;

import java.util.Arrays;
import java.util.Map;
import java.util.UUID;

import com.om.hello.model.LoginRequest;
import com.om.hello.model.LoginResponse;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
// @RequiredArgsConstructor
public class LoginController {

    // private final ManualValidator manualValidator;

    //Move to application.properties
    private final int AUTH_TOKEN_EXPIRES_MINUTES = 60 * 1; //10 Hr

    // private final AuthTokenService authTokenService;

    // private final DefaultUserDetailsJwtClaimsConverter defaultUserDetailsJwtClaimsConverter;

    // @PostMapping("/login")
    // public void login(@RequestBody LoginRequest req) {
    //     manualValidator.validate(req);
        
    //     log.debug("username => {}", req.getUsername());
    //     log.debug("password => {}", req.getPassword());
    // }

    // @PostMapping("/login")
    // public Mono<LoginResponse> login(@RequestBody @Validated LoginRequest request) {

    //     // manualValidator.validate(request);
    //     log.debug("username => {}", request.getUsername());
    //     log.debug("password => {}", request.getPassword());
    //     // throw new InvalidUsernamePasswordException();
        
    //     final DefaultUserDetails userDetails = DefaultUserDetails.builder()
    //             .id(UUID.randomUUID())
    //             .authorities(Arrays.asList("ADMIN"))
    //             .build();
    //     final Map<String, Object> claims = defaultUserDetailsJwtClaimsConverter.convert(userDetails);

    //     return authTokenService.sign(claims)
    //             .map(token -> {
    //                 return LoginResponse.builder()
    //                         .expiresIn(AUTH_TOKEN_EXPIRES_MINUTES * 60L)
    //                         .tokenType("bearer")
    //                         .accessToken(token)
    //                         .build();
    //             });
    // }

    @PostMapping("/login")
    public void login(@RequestBody @Validated LoginRequest req) {
        log.debug("username => {}", req.getUsername());
        log.debug("password => {}", req.getPassword());
    }

    
}
