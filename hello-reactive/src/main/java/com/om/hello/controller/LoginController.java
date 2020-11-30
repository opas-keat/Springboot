package com.om.hello.controller;

import com.om.hello.model.LoginRequest;
import com.om.hello.validator.ManualValidator;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final ManualValidator manualValidator;

    @PostMapping("/login")
    public void login(@RequestBody LoginRequest req) {
        manualValidator.validate(req);
        
        log.debug("username => {}", req.getUsername());
        log.debug("password => {}", req.getPassword());
    }

    
}
