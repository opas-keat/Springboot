package com.om.fileattach.model;

import javax.validation.constraints.NotBlank;

import com.om.fileattach.validator.AtLeastPassword;
import com.om.fileattach.validator.Email;
import com.om.fileattach.validator.PasswordEqualsConfirmPassword;
import com.om.fileattach.validator.PasswordNotEqualsEmail;

import org.hibernate.validator.constraints.Length;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@PasswordEqualsConfirmPassword
@PasswordNotEqualsEmail
public class RegisterForm implements PasswordEqualsConfirmPassword.Model, PasswordNotEqualsEmail.Model {

    private String firstName;

    private String lastName;

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
