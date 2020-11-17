package com.om.fileattach.controller;

import com.om.fileattach.model.RegisterForm;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class RegisterFormController {

    @PostMapping("/register")
    public void register(@RequestBody @Validated RegisterForm req) {
        log.debug("email => {}", req.getEmail());
        log.debug("password => {}", req.getPassword());
    }
    
    @PostMapping(value = "/register1", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Mono<RegisterForm> register1(final RegisterForm form) {
        log.debug("call register1 method");
        return Mono.just(form);
    }

    @PostMapping(value = "/register2", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public Mono<RegisterForm> register2(final ServerWebExchange exchange) {
        log.debug("call register2 method");
        return exchange.getFormData()
                .map(formData -> {
                    return RegisterForm.builder()
                            .firstName(formData.getFirst("firstName"))
                            .lastName(formData.getFirst("lastName"))
                            .email(formData.getFirst("email"))
                            .build();
                });
    }

    @PostMapping(value = "/register3", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public Mono<RegisterForm> register3(final RegisterForm form) {
        log.debug("call register3 method");
        return Mono.just(form);
    }
}
