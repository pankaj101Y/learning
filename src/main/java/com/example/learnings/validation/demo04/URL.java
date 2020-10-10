package com.example.learnings.validation.demo04;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER})
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = {URLValidator.class})
public @interface URL {

  String message() default "malformed URL";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};

  String protocol() default "";
  String host() default "";
  int port() default -1;
}
