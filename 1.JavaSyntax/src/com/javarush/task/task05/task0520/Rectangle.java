package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
заданы 4 параметра: left, top, width, height
- ширина/высота не задана (оба равны 0)
- высота не задана (равно ширине) создаём квадрат
- создаём копию другого прямоугольника (он и передаётся в параметрах)
*/


public class Rectangle {
    //напишите тут ваш код
    private int left;
    private int top;
    private int width;
    private int height;

    public Rectangle (int left, int top)
    {
        this.left = left;
        this.top = top;
    }

    public Rectangle(){
        this.top = 12;
        this.left = 13;
        this.width = 14;
        this.height = 15;
    }

    public Rectangle(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int top, int width, int left){
        this.top = top;
        this.width =width;
        this.left = left;
    }


    public static void main(String[] args) {

    }
}
