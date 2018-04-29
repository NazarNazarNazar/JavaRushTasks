package com.javarush.task.task39.task3902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Биты были биты
Биты были биты
В процессе разработки сложного алгоритма кодирования возникла задача определить четное ли количество единиц в двоичной записи числа.
Реализуй метод boolean isWeightEven(long number), который будет возвращать true или false в зависимости от того,
является ли количество единиц в двоичном представлении числа number четным или нечетным.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Please type in a number: ");

        long l = Long.parseLong(reader.readLine());
        String result = isWeightEven(l) ? "even" : "odd";
        System.out.println("Number of ones in a given number is " + result);

    }

    public static boolean isWeightEven(long number) {
        int count = 0;
        while (number != 0) {
            count++;
            number = number & (number - 1);
        }
        return count % 2 == 0;
    }
}
