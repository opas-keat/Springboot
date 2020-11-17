package com.om.fileattach.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import org.springframework.stereotype.Component;

@Target({ ElementType.TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordEqualsConfirmPassword.Validator.class)
public @interface PasswordEqualsConfirmPassword {

    String message() default "Password not equals Confirm password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Component
    public static class Validator implements ConstraintValidator<PasswordEqualsConfirmPassword, Model> {

        private PasswordEqualsConfirmPassword annotation;

        @Override
        public void initialize(final PasswordEqualsConfirmPassword annotation) {
            this.annotation = annotation;
        }

        @Override
        public boolean isValid(final Model model, final ConstraintValidatorContext context) {
            String password = model.getPassword();
            String confirmPassword = model.getConfirmPassword();
            if (password == null) {
                password = "";
            }
            if (confirmPassword == null) {
                confirmPassword = "";
            }
            return FieldNameModifier.of(context)
                    .withMessage(annotation.message())
                    .changeTo("confirmPassword")
                    .valid(password.equals(confirmPassword));
        }

        public PasswordEqualsConfirmPassword getAnnotation() {
            return annotation;
        }

        public void setAnnotation(PasswordEqualsConfirmPassword annotation) {
            this.annotation = annotation;
        }

    }

    public static interface Model {

        String getPassword();

        String getConfirmPassword();

    }

}
