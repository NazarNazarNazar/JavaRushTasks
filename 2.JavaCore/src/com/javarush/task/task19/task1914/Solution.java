package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(baos);
        System.setOut(stream);
        testString.printSomething();
        String s = baos.toString().replace("\n", "");
        String[] elements = s.split(" ");
        int a = Integer.parseInt(elements[0]);
        int b = Integer.parseInt(elements[2]);
        int result = 0;
        switch (elements[1]) {
            case"+" : result = a + b;break;
            case"-" : result = a - b;break;
            case"*" : result = a * b;break;
        }
        System.setOut(console);
        System.out.println(s+result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

