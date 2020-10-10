package com.example.learnings.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = {SuperHumanvalidator.class})
public @interface ValidSuperHuman {
    String message() default "Not Valid SuperHuman";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
