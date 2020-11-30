package com.om.hello.controller;

import java.util.UUID;

import com.om.hello.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public Flux<User> findAll() {
        log.debug("call findAll method");
        return Flux.just(
                User.builder()
                        .id(UUID.randomUUID())
                        .name("user 1")
                        .build(),
                User.builder()
                        .id(UUID.randomUUID())
                        .name("user 2")
                        .build(),
                User.builder()
                        .id(UUID.randomUUID())
                        .name("user 3")
                        .build()
        );
    }
}
