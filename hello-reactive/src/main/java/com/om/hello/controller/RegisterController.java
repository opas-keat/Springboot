package com.om.hello.controller;

import com.om.hello.model.RegisterForm;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RegisterController {

    @PostMapping("/register")
    public void register(@RequestBody @Validated RegisterForm req) {
        log.debug("email => {}", req.getEmail());
        log.debug("password => {}", req.getPassword());
    }

}
