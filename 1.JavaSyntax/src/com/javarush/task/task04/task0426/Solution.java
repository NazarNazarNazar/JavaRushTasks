package com.javarush.task.task04.task0426;

/* 
Ярлыки и числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());

        if ((a%2)==0 && a<0)
            System.out.println("отрицательное четное число");
        else if ((a%1)==0 && a<0)
            System.out.println("отрицательное нечетное число");
        else if ((a%2)==0 && a>0)
            System.out.println("положительное четное число");
        else if ((a%1)==0 && a>0)
            System.out.println("положительное нечетное число");
        else System.out.println("ноль");

    }
}