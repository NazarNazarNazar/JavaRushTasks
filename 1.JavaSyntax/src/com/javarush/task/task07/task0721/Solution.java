package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
Минимаксы в массивах
Создать массив на 20 чисел.
Заполнить его числами с клавиатуры.
Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
            if(array[i] > maximum) maximum = array[i];
            if(array[i] < minimum) minimum = array[i];
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код

        int[] array = new int[20];

        int maximum = 0;
        int minimum = 0;
        for (int i = 0; i < array.length ; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(array);
        minimum = array[0];
        maximum = array[19];

        System.out.println(maximum+" "+minimum);
    }
}
