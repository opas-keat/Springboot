package com.om.hello.model;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class LoginRequest {

    @NotBlank(message = "Required")
    @Length(max = 50, message = "More than {max} characters")
    private String username;

    @NotBlank(message = "Required")
    @Length(min = 8, max = 50, message = "Must between {min} to {max} characters")
    private String password;

}