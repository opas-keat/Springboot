package com.om.fileattach.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class HomeController {

    @GetMapping({"", "/"})
    public Mono<String> hello() {
        log.debug("call hello method");
        return Mono.just("Hello world.");
    }
}