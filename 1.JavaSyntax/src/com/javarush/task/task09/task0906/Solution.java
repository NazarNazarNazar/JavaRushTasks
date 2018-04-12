package com.javarush.task.task09.task0906;

/* 
Логирование стек трейса
Реализовать метод log.
Он должен выводить на экран имя класса и имя метода (в котором вызывается метод log), а также переданное сообщение.
Имя класса, имя метода и сообщение разделить двоеточием с пробелом.
Пример вывода:
com.javarush.task.task09.task0906.Solution: main: In main method
*/

public class Solution {
    public static void main(String[] args) {
        log("In main method");
    }

    public static void log(String s) {
        //напишите тут ваш код
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        StackTraceElement element = ste[2];
        String name = element.getClassName();
        String name2 = element.getMethodName();
        System.out.println(name+": "+name2+": "+s);
    }
}
