package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        //546 % 10 == 6; 546 / 10 == 54 -> 54 % 10 == 4; 54 / 10 == 5 -> 5 % 10 == 5
        int a = number % 10;
        int b = number /10 % 10;
        int c = number /10/10%10;
        return a+b+c;
    }
}