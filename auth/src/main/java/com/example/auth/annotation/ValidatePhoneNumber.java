package com.example.auth.annotation;

import com.example.auth.annotation.validatorClass.PhoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
public @interface ValidatePhoneNumber {
    public String message() default "Invalid phoneNumber";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
