package com.example.learnings.validation;

import antlr.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SuperHumanvalidator implements ConstraintValidator<ValidSuperHuman,SuperHuman> {
    @Override
    public void initialize(ValidSuperHuman constraintAnnotation) {

    }

    @Override
    public boolean isValid(SuperHuman superHuman, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("validating superhuman");
        return superHuman.power!=null&&superHuman.power.length()>2;
    }
}
