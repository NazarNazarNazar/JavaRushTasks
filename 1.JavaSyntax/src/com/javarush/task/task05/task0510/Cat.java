package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String address = null;
    private String color;

    public void initialize(String name){
        this.name = name;
        this.age = 18;
        this.weight = 44;
        this.color = "Black";
    }

    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        this.color = "Green";
    }

    public void initialize(String name, int age){
        this.name = name;
        this.age = age;
        this.weight = 3;
        this.color = "Auburn";
    }

    public void initialize(int weight, String color){
        this.weight = weight;
        this.color = color;
        this.age = 12;
    }

    public void initialize(int weight, String color, String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 13;
    }



    public static void main(String[] args) {

    }
}
