package com.om.fileattach.controller;

import com.om.fileattach.model.LoginRequest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LoginController {

    @PostMapping("/login")
    public void login(@RequestBody @Validated LoginRequest req) {
        log.debug("username => {}", req.getUsername());
        log.debug("password => {}", req.getPassword());
    }

}