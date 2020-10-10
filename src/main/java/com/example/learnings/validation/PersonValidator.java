package com.example.learnings.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PersonValidator implements ConstraintValidator<PersonValidation, Person> {

    @Override
    public void initialize(PersonValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(Person person, ConstraintValidatorContext constraintValidatorContext) {
        System.out.println("validating person");
        if (person.age<3)return false;
        return true;
    }
}
