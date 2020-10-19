package com.example.learnings.java;

import java.lang.reflect.Field;

import static java.lang.reflect.Modifier.FINAL;
import static java.lang.reflect.Modifier.STATIC;

enum Transport{
    PLANE(1,2),TRAIN(2,3),VEHICLE(7);

     private int x,y;

    Transport(int x,int y){
        this.x=x;
        this.y=y;
    }

    Transport(int y){
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class EnumExample {

    public static void main(String[] args) throws IllegalAccessException {
        Class<?> transport=Transport.class;

        Field[] fields=transport.getFields();

        System.out.println("static = "+((transport.getModifiers()&STATIC)!=0));
        System.out.println("final = "+((transport.getModifiers()&FINAL)!=0));
        System.out.println("*********************************************************");

        for (Field field:fields){
            System.out.println(field.isEnumConstant());
            System.out.println(field.getName());
            System.out.println("static = "+((field.getModifiers()&STATIC)!=0));
            System.out.println("final = "+((field.getModifiers()&FINAL)!=0));
            System.out.println(((Transport)field.get(null)).getX());
            System.out.println("########################");
        }

        System.out.println("________________________________________________");

//
//        Object[] objects=transport.getEnumConstants();
//
//        for (Object object:objects){
//            System.out.println(((Transport)object).getX());
//            System.out.println(((Transport)object).getY());
//            System.out.println("########################");
//        }
//
//        System.out.println(Integer.toHexString(7));
//        System.out.println(Integer.toHexString(8));
//        System.out.println(Integer.toHexString(10));
//        System.out.println(Integer.toHexString(14));
//        System.out.println(Integer.toHexString(15));
//        System.out.println(Integer.toHexString(16));
//        System.out.println(Integer.toHexString(17));
    }
}
