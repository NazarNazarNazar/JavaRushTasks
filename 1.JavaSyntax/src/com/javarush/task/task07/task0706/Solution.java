package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] arrayInt = new int[15];
        int sumChet = 0;
        int sumNechet = 0;

        for (int i = 0; i < arrayInt.length ; i++) {
            String s = reader.readLine();
            arrayInt[i] = Integer.parseInt(s);
        }

        for (int i = 0; i < arrayInt.length ; i++) {
            if ((i % 2) == 0 || (i == 0))
                sumChet = sumChet + arrayInt[i];
            else if ((i % 2) != 0)
                sumNechet = sumNechet + arrayInt[i];
        }

        if(sumChet>sumNechet)
            System.out.println("В домах с четными номерами проживает больше жителей.");
        else if(sumNechet>sumChet)
            System.out.println("В домах с нечетными номерами проживает больше жителей.");
        else System.out.println();

    }
}
