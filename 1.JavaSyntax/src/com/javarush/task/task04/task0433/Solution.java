package com.javarush.task.task04.task0433;


/* 
Гадание на долларовый счет
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int c = 1;

        while (c <= 10) {
            int c2 = 2;
            while (c2 <= 10) {
                System.out.print("S");
                c2++;
            }
            System.out.println("S");
            c++;

        }
    }
}

