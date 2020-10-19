package com.example.learnings.reflection;

import java.lang.reflect.Field;

public class ReflectionDemo {

    public static void main(String[] args) {
        Class<?> codeClass=ResponseCode.class;

        Object[]codes= codeClass.getEnumConstants();
        Field[] fields=codeClass.getFields();

//        for (Field field:fields){
//            System.out.println(field.getName());
//        }

        for (Object code:codes){
            System.out.println(((ResponseCode)code).getDescription());
        }

    }
}
