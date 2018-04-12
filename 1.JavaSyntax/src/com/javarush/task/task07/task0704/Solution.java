package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrayInt = new int[10];

        for (int i = 0; i < arrayInt.length ; i++) {
            String s = reader.readLine();
            arrayInt[i] = Integer.parseInt(s);
        }
        for (int i = arrayInt.length-1; i >= 0 ; i--) {
            System.out.println(arrayInt[i]);
        }
    }
}

