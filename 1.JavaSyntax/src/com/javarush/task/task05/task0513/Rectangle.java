package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height
*/

public class Rectangle {
    //напишите тут ваш код
    private int top;
    private int left;
    private int width;
    private int height;

    public void initialize(int top, int left){
        this.top = top;
        this.left = left;
    }

    public void initialize(){
        this.top = 12;
        this.left = 13;
        this.width = 14;
        this.height = 15;
    }

    public void initialize(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }

    public void initialize(int top, int width, int left){
        this.top = top;
        this.width =width;
        this.left = left;
    }

    public static void main(String[] args) {

    }
}
