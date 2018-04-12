package com.javarush.task.task05.task0522;

/* 
Максимум конструкторов
*/

public class Circle {
    public double x;
    public double y;
    public double radius;

    //напишите тут ваш код
    public Circle ()
    {
        this.x = 10;
        this.y = 10;
        this.radius = 20;
    }

    public Circle (double x, double radius)
    {
        this.x = x;
        this.radius = radius;
    }

    public Circle (double radius, double y, double x)
    {
        this.radius = radius;
        this.x = x;
        this.y = y;
    }

    public Circle (double radius)
    {
        this.radius = radius;
        this.x = 44;
        this.y = 55;
    }

    public static void main(String[] args) {

    }
}