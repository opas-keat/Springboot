package com.om.fileattach.controller;

import java.util.UUID;

import com.om.fileattach.model.User;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/users")
public class UserController {

    private final User ME = User.builder()
            .id(UUID.randomUUID().toString())
            .username("opas")
            .password("test")
            .email("opas@gmail.com")
            .build();

    @GetMapping
    public Flux<User> findAll() {
        log.debug("find all users in database...");
        return Flux.just(
                ME,
                User.builder()
                        .id(UUID.randomUUID().toString())
                        .username("test")
                        .password("password")
                        .email("test@example.com")
                        .build()
        );
    }

    @GetMapping("/{id}")
    public Mono<User> findById(@PathVariable("id") final String id) {
        log.debug("find data by id in database...");
        return Mono.just(ME);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> create(@RequestBody final User user){
        log.debug("insert data to database...");
        return Mono.just(user);
    }
    
    @PutMapping("/{id}")
    public Mono<User> update(@PathVariable("id") final String id, @RequestBody final User user){
        log.debug("update data in database...");
        return Mono.just(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteById(@PathVariable("id") final String id) {
        log.debug("delete data in database...");
        return Mono.empty();
    }

    @GetMapping("/me")
    public Mono<User> getUser() {
        return Mono.just(ME);
    }
}
