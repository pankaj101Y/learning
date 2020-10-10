package com.example.learnings.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    boolean isTrue() default true;

    String value();

}
