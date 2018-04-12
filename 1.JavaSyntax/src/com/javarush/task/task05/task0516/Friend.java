package com.javarush.task.task05.task0516;

/* 
Друзей не купишь
*/

public class Friend {
    //напишите тут ваш код
    private String  name;
    private int age;
    private char sex;

    public Friend(String surname)
    {
        this.name = surname;
        this.age = 30;
        this.sex = 'M';
    }

    public Friend(String yourname, int yourage)
    {
        this.name = yourname;
        this.age = yourage;
        this.sex = 'W';
    }

    public Friend(String name, int age, char sexxx)
    {
        this.name = name;
        this.age = age;
        this.sex = sexxx;
    }

    public static void main(String[] args) {

    }
}
