package com.example.learnings.validation;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Person{


    @Size(min = 3)
    String name;

    int age;

    public Person(){

    }

//    @Valid
    public Person(String name){
        this.name=name;
        age=5;// PersonValidation passes always
    }
}
