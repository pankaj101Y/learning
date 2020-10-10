package com.example.learnings.validation;

import net.bytebuddy.implementation.bind.annotation.RuntimeType;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {PersonValidator.class})
public @interface PersonValidation {
    String message() default "Person is not valid";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
