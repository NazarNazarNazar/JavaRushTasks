package com.javarush.task.task03.task0311;

/* 
Печатаем строки
*/

public class Solution {
    public static void main(String[] args) {
        writeToConsole("Hello world!");
    }

    public static void writeToConsole(String s) {
        //напишите тут ваш код
        String s2 = "printing: ";
        System.out.println(s2 + s);
    }
}
