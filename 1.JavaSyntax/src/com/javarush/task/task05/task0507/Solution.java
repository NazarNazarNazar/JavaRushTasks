package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/
import java.io.*;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int a = 0;
        double b = 0;


        while(a != -1)
        {
            a = Integer.parseInt(reader.readLine());
            if (a != -1){
                sum = sum+a;
                b++;
                }
        }
        System.out.println(sum/b);


    }
}

