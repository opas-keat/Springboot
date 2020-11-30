package com.om.hello.model;

import javax.validation.constraints.NotBlank;

import com.om.hello.validator.AtLeastPassword;
import com.om.hello.validator.Email;
import com.om.hello.validator.PasswordEqualsConfirmPassword;
import com.om.hello.validator.PasswordNotEqualsEmail;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
@PasswordEqualsConfirmPassword
@PasswordNotEqualsEmail
public class RegisterForm implements PasswordEqualsConfirmPassword.Model, PasswordNotEqualsEmail.Model {

    @NotBlank(message = "Required")
    @Email(message = "Invalid format")
    private String email;

    @NotBlank(message = "Required")
    @AtLeastPassword
    @Length(min = 8, max = 50, message = "At least {min} characters")
    private String password;

    @NotBlank(message = "Required")
    @Length(min = 8, max = 50, message = "At least {min} characters")
    private String confirmPassword;

}
