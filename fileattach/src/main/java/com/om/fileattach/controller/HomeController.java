package com.om.fileattach.controller;

import com.om.fileattach.exception.AuthenticationException;
import com.om.fileattach.exception.InvalidUsernamePasswordException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class HomeController {

    @GetMapping({"","/"})
    public Mono<String> hello() {
        throw new AuthenticationException();
    }

    @GetMapping("/invalidUsernamePassword")
    public Mono<String> invalidUsernamePassword() {
        throw new InvalidUsernamePasswordException();
    }

    @GetMapping("/serverError")
    public Mono<String> serverError() {
        throw new RuntimeException();
    }
}