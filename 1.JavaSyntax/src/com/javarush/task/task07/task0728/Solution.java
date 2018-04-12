package com.javarush.task.task07.task0728;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/* 
В убывающем порядке
Задача: Написать программу, которая вводит с клавиатуры 20 чисел
и выводит их в убывающем порядке.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[20];
        for (int i = 0; i < 20; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        sort(array);

        for (int x : array) {
            System.out.println(x);
        }
    }

    public static void sort(int[] array) {
        //напишите тут ваш код
        /*for (int i = 0; array.length/2 > i ; i++) {
            int tmp = array[i];
            array[i]= array[array.length-i-1];
            array[array.length-i-1] = tmp;
        }*/

        int[] newArray=new int[array.length];
        System.arraycopy(array, 0, newArray, 0, array.length);
        Arrays.sort(newArray);
        int j=0;
        for (int i=array.length-1; i>=0; i--, j++)
        { array[j]=newArray[i]; }
    }
}
