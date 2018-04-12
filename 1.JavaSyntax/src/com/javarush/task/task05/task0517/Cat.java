package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
 Имя,
- Имя, вес, возраст
- Имя, возраст (вес стандартный)
- вес, цвет, (имя, адрес и возраст - неизвестные. Кот - бездомный)
- вес, цвет, адрес (чужой домашний кот)
*/

public class Cat {
    //напишите тут ваш код
    private String name;
    private int age;
    private int weight;
    private String address = null;
    private String color;

    public Cat (String name)
    {
        this.name = name;
        this.age = 18;
        this.weight = 44;
        this.color = "Black";
    }

    public Cat (String surname, int weight, int sage)
    {
        this.name = surname;
        this.weight = weight;
        this.age = sage;
        this.color = "Auburn";
    }

    public Cat (String name, int age)
    {
        this.name = name;
        this.age = age;
        this.weight = 3;
        this.color = "Auburn1";
    }

    public Cat (int weight, String color)
    {
        this.weight = weight;
        this.color = color;
        this.age = 2;
    }

    public Cat (int weight, String color, String address)
    {
        this.weight = weight;
        this.color = color;
        this.address = address;
        this.age = 13;
    }

    public static void main(String[] args) {

    }
}
