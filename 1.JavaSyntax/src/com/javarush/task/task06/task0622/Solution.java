package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;


/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] array = new int[5];
        for (int i = 0; i < array.length; i++) {
            int a = Integer.parseInt(reader.readLine());
            array[i] = a;
        }

        Arrays.sort(array);
        for (int i = 0; i < array.length ; i++) {
            System.out.println(array[i]);
        }
    }
}
