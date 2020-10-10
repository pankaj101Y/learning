package com.example.learnings.validation;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class BaseClass {

    public static Set<ConstraintViolation<Object>> validate(Object o){
        System.out.println("starting validating");
        Validator validator=Validation.buildDefaultValidatorFactory().getValidator();
        return validator.validate(o);
    }
}
