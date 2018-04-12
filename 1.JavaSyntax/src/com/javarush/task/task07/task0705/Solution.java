package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrayInt = new int[20];
        int[] arrayInt10 = new int[10];
        int[] arrayInt11 = new int[10];

        for (int i = 0; i < arrayInt.length ; i++) {
            String s = reader.readLine();
            arrayInt[i] = Integer.parseInt(s);
        }

        System.arraycopy(arrayInt, 0, arrayInt10, 0, 10);
        System.arraycopy(arrayInt, 10, arrayInt11, 0, 10);

        for (int i=0; i < arrayInt11.length; i++) {
            System.out.println(arrayInt11[i]);
        }
    }
}
