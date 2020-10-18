package com.example.learnings.java;

enum Transport{
    PLANE(1,2),TRAIN(2,3),VEHICLE(7);

     private int x,y;

    Transport(int x,int y){

    }

    Transport(int y){

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

public class EnumExample {

    public static void main(String[] args) {
        Transport[] transports=Transport.values();

        Transport plane=Transport.PLANE;

//        plane.y=10; //works when y is public
        System.out.println("plane y= "+plane.getY());



        for (Transport transport : transports){
            System.out.println("name= " + transport.name() + " ordinal= " + transport.ordinal() + " toString= " + transport.toString());
        }
    }
}
