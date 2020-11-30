package com.om.hello.controller;

import java.util.Arrays;
import java.util.List;

import com.om.hello.exception.InvalidUsernamePasswordException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class HomeController {

    @GetMapping({"", "/"})
    public Mono<String> hello() {
        log.debug("call hello method");
        return Mono.just("Hello world.");
    }

    @GetMapping("/days")
    public Flux<String> days() {
        log.debug("call days method");
        return Flux.fromIterable(Arrays.asList(
                "Sunday",
                "Monday",
                "Tuesday",
                "Wednesday",
                "Thursday",
                "Friday",
                "Saturday"
        ));
    }

    @GetMapping("/months")
    public Mono<List<String>> months() {
        return Mono.just(Arrays.asList(
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        ));
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
